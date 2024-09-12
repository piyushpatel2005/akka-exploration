# Creating Actors in Akka

In Akka, actors are objects that encapsulate state and behavior. They communicate with each other by sending messages. Each actor has a mailbox where it receives messages. When an actor receives a message, it processes it and sends a response back to the sender.

In order to create an actor, you first have to define the type of messages it can receive. You define the actor type using this. This is also called actor's protocol.

