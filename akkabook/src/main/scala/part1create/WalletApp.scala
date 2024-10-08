package part1create

import akka.actor.typed.ActorSystem

object WalletApp extends App {
  val guardian: ActorSystem[Int] = ActorSystem(Wallet(), "wallet")
  guardian ! 1
  guardian ! 2

  println("press enter to terminate")
  scala.io.StdIn.readLine()
  guardian.terminate()
}
