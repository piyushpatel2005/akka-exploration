package part1create

import akka.actor.typed.ActorSystem
import part1create.WalletOnOff.{
  Activate,
  Command,
  Deactivate,
  Increase
}

object WalletOnOffApp extends App {
  val guardian: ActorSystem[Command] =
    ActorSystem(WalletOnOff(), "wallet-on-off")
  guardian ! Increase(1)
  guardian ! Increase(2)
  guardian ! Deactivate
  guardian ! Increase(1)
  guardian ! Activate
  guardian ! Increase(1)

  println("press enter to terminate")
  scala.io.StdIn.readLine()
  guardian.terminate()

}
