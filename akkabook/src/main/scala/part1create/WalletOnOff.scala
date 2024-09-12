package part1create

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors

object WalletOnOff {
  sealed trait Command
  final case class Increase(amount: Int) extends Command
  final case object Deactivate extends Command
  final case object Activate extends Command

  def apply(): Behavior[Command] = {
    activated(0)
  }

  def activated(total: Int): Behavior[Command] = {
    Behaviors.receive((context, message) => {
      message match {
        case Increase(amount) =>
          val newTotal = total + amount
          context.log.info(
            s"Increased wallet by $amount to $newTotal")
          activated(newTotal)
        case Deactivate =>
          context.log.info("Deactivating wallet")
          deactivated(total)
        case Activate =>
          context.log.info("Already active!")
          Behaviors.same
      }
    })
  }

  def deactivated(total: Int): Behavior[Command] =
    Behaviors.receive((context, message) => {
      message match {
        case Increase(_) =>
          context.log.warn("Can't increase wallet when deactivated")
          Behaviors.same
        case Deactivate =>
          context.log.info("Wallet is already deactivated")
          Behaviors.same
        case Activate =>
          context.log.info("Activating wallet")
          activated(total)
      }
    })

}
