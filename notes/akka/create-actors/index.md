# Creating Actors in Akka

In Akka, actors are objects that encapsulate state and behavior. They communicate with each other by sending messages. Each actor has a mailbox where it receives messages. When an actor receives a message, it processes it and sends a response back to the sender.

Actors are created in a hierarchy. The top-level actor is called the *Guardian Actor*. It is the parent of all actors in the system. This top level actor is created when the actor system is created. You can create actors by using the `ActorSystem` object.

## Create an actor system

To create an actor system, you need to import the `ActorSystem` class and create an instance of it. The `ActorSystem` is a heavyweight object that manages the lifecycle of actors and provides a way to create actors.

```scala
import akka.actor.typed.ActorSystem

object Playground extends App {
  val actorSystem = ActorSystem("HelloAkka")
  println(actorSystem.name)
}
```