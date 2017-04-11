package com.mientrascompila.validarpoliticas


import akka.http.scaladsl.Http
import com.mientrascompila.validarpoliticas.controller.ValidarPoliticasController

import scala.io.StdIn

/**
 * Clase que inicializa el servicio.
 *
 * Created by abelmeos on 2017/04/11.
 */
object Application extends Api{

  def main (args: Array[String]){


    val routes = new ValidarPoliticasController().route
    val binding = Http().bindAndHandle(routes,"localhost", 8090)

    StdIn.readLine()
    binding.flatMap(_.unbind()).onComplete(_ => system.terminate())




  }

}
