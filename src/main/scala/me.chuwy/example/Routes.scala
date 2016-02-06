package me.chuwy.example

import akka.http.scaladsl.model._
import akka.http.scaladsl.server.{ Directives, Route }
import akka.stream.Materializer
import de.heikoseeberger.akkahttpjson4s.Json4sSupport

import scala.concurrent.ExecutionContext

object HttpRoutes extends Json4sSupport {

  def route(implicit ec: ExecutionContext, mat: Materializer): Route = {
    import Directives._

    get {
      pathSingleSlash {
        complete {
          HttpEntity(
            """
              |<!DOCTYPE html>
              | <html>
              |   <head>
              |     <title>title</title>
              |   </head>
              |   <body> hello </body>
              | </html>
            """.stripMargin

          )
        }
      }
    }
  }
}
