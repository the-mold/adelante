# Ch3 Design interview structure

Framework:

1. Ask questions/clarify requirements
2. High level overview of architecture with diagrams
3. Go into details about implementation(error cases, challenges, monotoring, bottlenecks, performance etc)
4. Wrap-up. Summarize everything to the interviewer again.

# Ch4 Rate Limiting

Better to have ratelimiting as a separate service so that it could be used by multiple servers.

Rate limiting strategies:

1. Token bucket. Every request consumes one token from a bucket(of certain size) of tokens. If there are no tokens left,
   request is denied. Tokens are replenished at certains rate(e.g. 100 per second). It is really
   good strategy if you know that you server can process only n requests per second.
2. Leacking bucket. Requests are stored in a bucket of certain size, and consumed by workers. If there
   is no place in bucket, then request is denied.
3. Fixed window counter. Every round interval(eg. 1 minute) only n requests are allowed.
4. Sliding window counter. The interval is sliding in time and requests WITHIN last interval(1 minute) are counted.

Prevent collisions in distributed environments.
Use lua functions(makes code execution faster) or Reddis data sets(makes collision impossible).
