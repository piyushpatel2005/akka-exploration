# Traditional Concurrency Model

Before we dive into Akka, let's take a look at the traditional concurrency model in Java and actor model was introduced to overcome the limitations of traditional concurrency model.

The actor model is not new. It was first introduced by Carl Hewitt in 1973. The actor model is a mathematical model of concurrent computation that treats "actors" as the universal primitives of concurrent computation. The actor model tries to solve the problem of shared mutable state which is the root cause of many concurrency issues.

## Hiding State

In OOP, objects encapsulate state and behavior. Objects communicate with each other by calling methods. Encapsulation is a way to hide the internal data of an object from the outside world. Object itself is responsible for managing its state and it must not allow modification of its state from outside. 