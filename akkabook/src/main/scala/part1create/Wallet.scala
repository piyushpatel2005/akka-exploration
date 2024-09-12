package part1create

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors

object Wallet {
  def apply(): Behavior[Int] =
    Behaviors.receive{ (context, message) =>
      context.log.info(s"Received '$message' dollar(s)")
      Behaviors.same
    }
}