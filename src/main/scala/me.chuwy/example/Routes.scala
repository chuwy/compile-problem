package me.chuwy.example

import akka.http.scaladsl.model._
import akka.http.scaladsl.server.{ Directives, Route }
import akka.stream.Materializer
import de.heikoseeberger.akkahttpcirce.CirceSupport

import scala.concurrent.ExecutionContext

// with "extends CirceSupport" or "import CirceSupport._" it will take >100s to compile
object HttpRoutes extends CirceSupport {

  def route(implicit ec: ExecutionContext, mat: Materializer): Route = {
    import Directives._
    import io.circe.generic.auto._

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
