package com.mientrascompila.validarpoliticas.services

import akka.actor.Actor
import com.mientrascompila.validarpoliticas.message.Messages.ValidacionResponse
import com.mientrascompila.validarpoliticas.services.ValidarPoliticasActor.ValidarPoliticasMsg

import scala.util.Random

/**
 * Created by abelmeos on 2017/04/11.
 */
object ValidarPoliticasActor {

  case class ValidarPoliticasMsg(idEmpleado:String)

}

class ValidarPoliticasActor extends Actor {

  def receive:Receive = {

    case msg:ValidarPoliticasMsg => validarPolitica(msg.idEmpleado)

  }

  /**
   * Metodo que valida las politicas de negocio para el pago a un empleado
   * @param idEmpleado
   */
  def validarPolitica(idEmpleado:String) = {
    // Se simula un proceso de negocio que dura 10 segundos y retorna un id de la validacion.
    Thread.sleep(10000)
    sender() ! ValidacionResponse("Politica Validada " + Random.nextInt()+"--"+idEmpleado)


  }


}
