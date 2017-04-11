package com.mientrascompila.validarpoliticas.message

/**
 * Created by abelmeos on 2017/04/11.
 */
object Messages {

  case class ValidacionRequest(idEmpleado:String)
  case class ValidacionResponse(idValidacion:String)

}
