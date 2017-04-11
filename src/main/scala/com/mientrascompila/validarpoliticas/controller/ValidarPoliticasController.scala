package com.mientrascompila.validarpoliticas.controller

import akka.actor.Props
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.{Route, Directives}

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import com.mientrascompila.validarpoliticas.Api
import com.mientrascompila.validarpoliticas.message.Messages._
import com.mientrascompila.validarpoliticas.services.ValidarPoliticasActor
import com.mientrascompila.validarpoliticas.services.ValidarPoliticasActor.ValidarPoliticasMsg
import spray.json.DefaultJsonProtocol._


import akka.pattern.ask

/**
 * Created by abelmeos on 2017/04/11.
 */


class ValidarPoliticasController extends Directives with Api{

  implicit val requestFormat = jsonFormat1(ValidacionRequest)
  implicit val responseFomart = jsonFormat1(ValidacionResponse)

  val validarPoliticasActor = system.actorOf(Props[ValidarPoliticasActor], "validar-politicas")

  val route:Route =
    pathPrefix("mientrascompila"){
      pathPrefix("validador"){
        pathPrefix("politicas"){
          path("validar"){
            pathEnd{
              post{
                entity(as[ValidacionRequest]){
                  validacionRequest =>
                    onSuccess(validarPoliticasActor ? ValidarPoliticasMsg(validacionRequest.idEmpleado)) {
                      case response:ValidacionResponse => complete(response.idValidacion)
                      case _ =>
                        complete(StatusCodes.InternalServerError)
                    }
                }
              }
            }
          }
        }
      }
    }


}
