# Akka Introduction

Akka is a toolkit and runtime for building highly concurrent, distributed, and resilient message-driven applications on the JVM. It is written in Scala, but provides both Java and Scala APIs. Akka is based on actor model and helps make reliable and scalable applications.

## Features of Akka

- **Concurrent**: Akka is designed to be concurrent from the ground up. It is based on the actor model which makes it easy to write concurrent and distributed applications.
- **Distributed**: Akka provides tools to build distributed applications. It provides location transparency which means you can write your application without worrying about where the actor is running, i.e. whether its running locally or on cluster of machines.
- **Resilient**: Akka provides tools to build fault-tolerant applications. It provides supervisor strategy which allows you to define how to handle failures of actors.
- **Elastic**: Akka provides tools to build elastic applications. You can add or remove nodes from the cluster without affecting the application.
- **Message-driven**: Akka is a message-driven toolkit. It is based on the actor model where actors communicate with each other by sending messages. This way each actor is isolated and dthey are not tightly coupled.
- **High Performance**: Akka is designed to be high performance and consumes lot less memory than traditional theading model.
- **Java and Scala APIs**: Akka provides both Java and Scala APIs. You can use the one that you are comfortable with.
- **Open Source**: Akka was open source but now it is now under BSL licence. However, there is open source equivalent called Pekko which is fork of Akka 2.6.

The Akka toolkit consists of several modules, each of which provides a different set of features. The core module is `akka-actor` which provides the actor model. Other modules include `akka-remote`, `akka-cluster`, `akka-http`, `akka-streams`, etc.