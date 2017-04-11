package com.mientrascompila.validarpoliticas

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import scala.concurrent.duration._
import akka.util.Timeout

/**
 * Trait que define el core de la aplicacion.
 *
 * Created by abelmeos on 2017/04/11.
 */
trait Api {

  implicit val system = ActorSystem("validar-politicas-actor-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher
  implicit val timeout:Timeout = Timeout( 60 seconds )

}
