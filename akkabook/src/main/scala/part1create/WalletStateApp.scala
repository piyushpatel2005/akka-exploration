package part1create

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorSystem, Behavior}
import part1create.WalletState.Command

object WalletStateApp extends App {
  val guardian: ActorSystem[WalletState.Command] = ActorSystem(WalletState(0, 2), "wallet-state")

  guardian ! WalletState.Increase(1)
  guardian ! WalletState.Increase(1)
  guardian ! WalletState.Increase(1)

  println("press enter to terminate")
  scala.io.StdIn.readLine()
  guardian.terminate()
}
