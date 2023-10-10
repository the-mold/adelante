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

# Ch7 Design ID Generator

Requirements:

- IDs must be sortable in time.

Usual solutions:

1. DB autoincremented ids. Easy, but it is a single point of failure and the approach does not work when you need to scale.
2. UUIDs. Easy to implement but not sortable in time.
3. Separate service(Ticket service) to generate IDs. It is again a single point of failure.
4. Twitter snowflake IDs. Make 64bit binary sequence. First n(eg. 42) reserve to hold timestamp data,
   next k bits reserve to hold worker ID and the remaining bits are sequence ID at that milisecond. Every milisecond the sequence counter(last part is reset to 0). Choose a starting epoch to which you will be adding your captured miliseconds in order to make timestamps smaller.
   You will be able to cover so many years with unique IDs:
   2^n - 1 = possible miliseconds in your generator.
   [possible miliseconds] / 1000ms / 60s / 60m / 24h / 365d = number of years that your generator can generate unique IDs.

# Ch 13 Design input field autocompletion

The solution is to use the Trie(pronounced "try") algorithm. This is a tree structure that stored letters of the query in each leaf with a counter how often it was called. For example, the word "beer" is stored:
root: ""
child level 1: "b:1"
child level 2: "be:1"
child level 3: "bee:1"
child level 4: "beer:1"

For every letter that a user writes, you send a query to get n most popular suggestions from the Trie tree:

1. You search for the input string in the tree.
2. You search for all children with the highest number of previous queries.
3. You select top n of them and resolve as response.
