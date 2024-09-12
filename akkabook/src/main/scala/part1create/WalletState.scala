package part1create

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors

object WalletState {

  sealed trait Command
  final case class Increase(amount: Int) extends Command
  final case class Decrease(amount: Int) extends Command

  def apply(total: Int, max: Int): Behavior[Command] =
    Behaviors.receive((context, message) => {
      message match {
        case WalletState.Increase(amount) =>
          val newTotal = total + amount
          if (newTotal <= max) {
            context.log.info(s"Increased wallet by $amount to $newTotal")
            apply(newTotal, max)
          } else {
            context.log.warn(s"Wallet can't exceed $max")
            Behaviors.stopped
          }
        case WalletState.Decrease(amount) =>
          val newTotal = total - amount
          if (newTotal < 0) {
            context.log.warn("Wallet can't go negative")
            Behaviors.stopped
          } else {
            context.log.info(s"Decreased wallet by $amount to $newTotal")
            apply(newTotal, max)
          }
      }
    })

}
