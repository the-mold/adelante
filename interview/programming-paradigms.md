# Programming Paradigms(style of approach of designing software)

## Functional programming - is the process of building software by composing:
1. pure functions(inputs and outputs values. no side effects)
2. avoiding shared state(some objects are shared in scope of the whole app or some component)
3. mutable data
4. side-effects(when function is impure: in addition to returnng a value it does some other stuff like
   calling api or posting data to db).
5. Function compositions. When many simple functions are combined in a larger function.
6. It is declarative.

## Object-oriented programming - using objects to model real world things that we want to represent
inside our programs, and/or provide a simple way to access functionality that would otherwise be hard or
impossible to make use of.  It emphasizes concepts such as classes, inheritance, polymorphism, and 
encapsulation. OOP promotes modularity, code reuse, and modeling real-world entities as 
objects.

## Imperative Programming - focuses on describing a sequence of 
statements or instructions to be executed by the computer. It emphasizes explicit 
control flow, mutable state, and detailed manipulation of variables and data structures.

#----------
# Imperative vs declarative programming
Imperative programming is about controlling the flow of a program. It focuses on details of steps, 
tasks and controlling program flow. It uses a lot statements, like `loop`, `while`, `break`.
Declarative programming is all about rescribing the result. It specifies how the rsult should
look like and does not concern with control flow. Example is JS `map` or `filter` function.

#----------
# Reactive manifesto - approach to create systems according to which systems are:
1. Responsive - systems provide quick response times and problems are quick to detect and deal with.
2. Resilient - in case of failure the system stays responsive. Errors must be properly contained and limited
   in scope and properly handled.
3. Elastic - proper resource allocation to the system. Scalability
4. Message Driven - async messaging between components to ensure isolation(?)
