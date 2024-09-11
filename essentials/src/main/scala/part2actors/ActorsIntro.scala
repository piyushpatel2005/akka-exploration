package part2actors

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

import scala.reflect.ClassTag.Any

object ActorsIntro extends App {
  // start with ActorSystem, one of this system only
  val actorSystem = ActorSystem("firstActorSystem")
  println(actorSystem.name)

  // create actors
  // word count actor
  class WordCountActor extends Actor {
    var totalWords = 0

    override def receive: PartialFunction[Any, Unit] = {
      case message: String =>
        println(s"[word counter] I have received: $message")
        totalWords += message.split(" ").length
      case msg => println(s"[word counter] I cannot understand ${msg.toString}")
    }
  }

  // instantiate actor
  val wordCounter: ActorRef = actorSystem.actorOf(Props[WordCountActor], "wordCounter")
  val anotherWordCounter: ActorRef = actorSystem.actorOf(Props[WordCountActor], "anotherWordCounter")

  // communicate with actor
  wordCounter.!("I am learning Akka and it's pretty damn cool!")
  anotherWordCounter ! "A different message"

  class Person(name: String) extends Actor {
    override def receive: Receive = {
      case "hi" => println(s"Hi, my name is $name")
      case _ =>
    }
  }

  object Person {
    def props(name: String): Props = Props(new Person(name))
  }

  // not recommended
  val person = actorSystem.actorOf(Props(new Person("Bob")))
  person.tell("hi", ActorRef.noSender)

  // recommended
  val anotherPerson = actorSystem.actorOf(Person.props("Alice"))
  anotherPerson ! "hi"
}
