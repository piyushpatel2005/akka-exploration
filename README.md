# Akka Actors

- [Akka Tutorials](notes/akka/README.md)

## Introduction

This is a simple example of how to use Akka Actors in Scala.

Set up dependencies in `build.sbt`:

```scala
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.3"
```

## Create actor system

```scala
import akka.actor.ActorSystem

object Playground extends App {
  val actorSystem = ActorSystem("HelloAkka")
  println(actorSystem.name)
}
```
