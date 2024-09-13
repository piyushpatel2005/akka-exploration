package part2actor_hierarchy.errorkernel

import akka.actor.typed.ActorSystem

object ErrorKernelApp extends App {
  val guardian: ActorSystem[Guardian.Command] = ActorSystem(Guardian(), "guardian")
  guardian ! Guardian.Start(List("-one-", "-two-", "-three-"))

  println("Enter to terminate")
  scala.io.StdIn.readLine()
  guardian.terminate()

}
