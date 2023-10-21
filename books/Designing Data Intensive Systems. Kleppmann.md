Martin Kleppman
Designing data intensive systems

Part I
---------------
CH1 - Reliable, scalable and maintainable applications
---------------
Software systems must be:

1. Reliable - system continues to work correctly even in case of adversity(hardware or software fault)
2. Scalable - system can handle growth(data volume, traffic or complexity) properly.
Vertical scaling - add more power to machines.
Horizontal scaling - add more machines.
3. Maintainable - many people must be able to work on system productively.

CH2 - Data models and query languages
---------------
Data models:
- Relational data model. Uses schema. Was invented to solve many-to-many data relationship.
- Document database. NoSQL DB. Data comes in self contained documents with no structure requirements. 
Join operations are problematic.
- Graph databases. NoSQL DB. Anything can potentially be related to everything.

CH3 - storage and retrieval
---------------
Primary DB index - main entry identified(DB id).
Secondary DB index - additional key-ref data structure that DB maintains to quickly search for certain records.

CH4 - Encoding and evolution
---------------
Encoding formats:
1. Program languages encoding(ex. pickle in python). Works only within one language and certain version ranges.
2. Textual encodings:
CSV - may be problematic when text includes column separators;
XML - old and verbose format
JSON - clean, popular and understandable. Requires no schema. The whole json object is encoded.
3. Binary encoding(ex. Protocol Buffer). Client and server share object schema and only field values are encoded.
It makes encoded messages much smaller and faster to transfer. Messages are encoded in binary format.

Modes of dataflow:
How two systems can exchange data:
1. Through database. One system stores, another queries.
2. Through service calls(REST or RPC).
Two popular web service design philosophy:

REST - design philosophy that uses features of HTTP for cache, authentication and content type negotiations. 
Uses resource oriented semantic URLs. Uses different http methods get, post, put etc.
Uses JSON for responses and JSON and url encoded params for requests. REST is stateless: after request is done, 
server stores no info about the request. In RPC it is not the case.

RPC - older design philosophy that concentrates on executing some function/actions on remote machine, whereas REST concentrates on
manipulating and getting resources.

SOAP - XML based PROTOCOL to make API REQUESTS. This is not design philosophy. Avoids http features. Useful in typed languages and hard to responses read.

3. Through message parsing. Asynchronous messaging pattern: one system produces a message, another system can react to it.
Usually intermediary message brokers are used(like rabbitmq).
Advantages of using message broker over RPC:
- it can be used as message buffer if a consumer is overloaded and cannot consume now.
- messages can be resent to consumers if consumer crashes
- sender does not need to know address and port of the recipient. They just both need to be aware of the broker address.
- message can be sent to several recipients

Part II - Distributed Data
---------------
Reasons to distribute data across machines:
1. Scalability
   - Replication: making more copies of data
   - Partitioning: splitting data into partitions.
2. Fault tolerance/high availability
3. Latency - to be closer to the enduser.

CH5 - Replication
---------------
Synchronous vs Asynchronous Replication.
Synchronous replication - leader node gets post request and gives response only when change was
propagated to all slave nodes.
Asynchronous replication - propagation to slave nodes happens asynchronously after leader got the change.
No need to wait for the slaves.

Replication logs
The best way to avoid all kinds of problems(leader crash, accidental two leader situation, 
network outage when writing to slaves etc) is to write operation logs. Just a file where operations
are appended. That can be done very fast. Logs files are further partitioned and optimized(new operations 
override the old operations to make log file size smaller). Having such logs you can recover state of data
in any case.

CH6 - Partition
---------------
Main motivation for partitioning is scalability and speed. Separate partitions should still be replicated.

Major challenge is how to know in which partition the needed data is stored? This is solved by:
- orchestrator/service that proxies requests knows where is what located.
- send request to a single partition, if it does not have what you need, it will direct you to 
the next partition and so on till you find what is needed.

CH7 - Transactions
---------------
In data systems many things can go wrong: network problems, software problems, crashed applications,
concurrent writes, race conditions etc. Transactions is a tool to avoid these problems. All reads and writes
are executed as one operation: either it succeeds(commits) or it fails(rollback). You do not need to worry
that something was partly written into DB: either full success, or nothing.

ACID - safety guarantees of transactions.
- Atomicity: transaction is one unbreakable operation. Changes are executed in closed context,
and there is no way some other thread can read data from half processed transaction.
- Consistency: no conflicting data. Data is the same.
- Isolation: transactions are running in isolation from each other. Different transactions are separated and
cannot overwrite the same info.
- Durability: promise that once the transaction succeeds, the data is written and will not be forgotten.

Race condition examples(all of these we attempt to solve with transactions):
- dirty reads: one client read another client's writes before they were committed.
- dirty writes: one client overwrites data that one client has written but not committed yet.
- read skew(nonrepeatable reads): client sees different versions of db in different times because it hasn't
synced yet.
- lost updates: two clients write the same entry and one client blindly overwrites changes of the other one.
Without making comparison or anything.
- Write skew: transactions reads condition from the db and based on it makes a decision to make a write. But by
this time the condition has changed already. Only serializable isolation prevents it.
- Phantom reads: you want to raed smth from db according to some search query. You get invalid
result because another transaction writes smth that interferes with your search but later transaction
might not be committed.

Serializability(DB guarantees that transactions can be executed concurrently) levels:
1. Execute one tx at a time: one transaction is executed after another. It is very secure but very slow.
2. Two phase locking - lock the rows that you want to write in the way that noone else can read or write them.
   Others have ti wait till you release the lock. Simple Locking - lock the rows(or indexes or tables) that 
   you want to write. Others can still read these rows.
3. Serializable Snapshot Isolation - CONFUSING: each transaction is executed optimistically and then checked if it can still 
be committed. If not, it is aborted and could be retried.

Other tricks to avoid concurrency problems:
- use db uniqueness keys to avoid concurrent writes.
- to avoid double records: generate a transaction id for the object and save this transaction in the db.
When you write the same transaction in the second time, check if have such transaction id already.

CH8 - The Trouble With Distributed Systems
---------------
Challenges with Distributed Systems:
1. Network: packets might be lost or delayed when transferring.
2. Cloak skew: separate machines might be out of sync.
3. Process pause: some processes might be arbitrary paused for some reason(like garbage collector).

Fault tolerance in system
1. Detect the fault(timeout or specific response from node).
2. Handle the fault: do not route requests there with help of load balancer.
3. Fix the problem: design fail over mechanism.

CH9 - Consistency and Consensus
---------------
Consistency guarantees:
1. Linearizability - system appears so as there is only single copy of data, even though there
some internal TEMPORARY(because of sync between leader and follower) inconsistencies. 
2. Global ordering of events. Consistent ordering of events across data nodes.
3. Atomic commit of distributed transaction - two phase commit(2PC). Before writing a change, get 100% confirmation from
all nodes that they can process the write operation. If one write still fails, it will be retried until it succeeds.

CAP theorem argues that you can only have two items at once:
1. Consistency(linearizability), 
2. Availability(fault tolerance), 
3. Partition tolerance(network outage tolerance).
Theorem is not practical, because you will always have network problems(3). 
So the proper name for the theorem is Consistency OR availability under network 
partitioning.

CH10 - Batch Processing
---------------
MapReduce - computing power allocation framework. It implies that each tasks should 
be processed by concurrent small programs that do once things well and give output to
the next program in pipeline.
Usual execution:
1. Read input file/data and break it down to records.
2. Call mapper function to extract key and value from each record.
3. Sort all key value pairs(optional step)
4. Call reducer function. Reducer takes key-value pairs, collects all values beloning
to the same key and process each value in some way.

CH11 - Stream Processing
---------------
Types of message brokers:
1. AMPQ: broker assigns messages to consumers, consumers aknowladge that they got message
ane then broker deletes message.
2. Log-based broker:writes messages to log partition, assigns to the same consumer and
always delivers in the same order.

Author emphasizes that stram processing is the best way to go. Having all the events
is better than just having one state in DB. Events you can analyze and aggregate in different
ways. Also useful for debugging.
