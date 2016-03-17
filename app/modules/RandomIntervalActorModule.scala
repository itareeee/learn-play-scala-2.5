package modules

import javax.inject.{Named, Singleton}

import akka.actor.{Props, ActorRef, Actor, ActorSystem}
import com.google.inject.{Provides, Inject, AbstractModule}
import play.api.libs.concurrent.AkkaGuiceSupport
import play.api.{Mode, Logger, Configuration, Environment}
import scala.concurrent.duration._

/**
  * Created by kitaru on 3/16/16.
  */
class RandomIntervalActorModule (
  env: Environment,
  conf: Configuration
) extends AbstractModule with AkkaGuiceSupport {
  val logger = Logger(this.getClass)

  def configure() = {
    env.mode match {
      case Mode.Test =>
        // Nothing
      case _ =>
        //        logger.info("Initializing random interval actor system ...") //TODO(kitaly): setup logger
        println("Initializing random interval actor system ...")

        bindActor[PingActor]("ping")
        bindActor[PongActor]("pong")
    }
  }
}

@Singleton
class PingActor @Inject()(@Named("pong") pongActor: ActorRef) extends Actor {

  implicit val ec = context.dispatcher

  pongActor ! "Ping"

  def receive = {
    case "Pong" =>
      context.system.scheduler.scheduleOnce(1000.millisecond){
        println("Ping!!")
        pongActor ! "Ping"
      }
    case _ =>
      println("Unexpected!!")
  }
}

@Singleton
class PongActor @Inject()(@Named("ping") pingActor: ActorRef) extends Actor {

  implicit val ec = context.dispatcher

  def receive = {
    case "Ping" =>
      context.system.scheduler.scheduleOnce(1000.millisecond) {
        println("Pong!!")
        pingActor ! "Pong"
      }

    case _ =>
      println("Unexpected!!")
  }
}
