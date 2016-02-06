package me.chuwy.example

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.http.scaladsl.Http

import scala.concurrent.duration._

object Main extends App {
  implicit val system = ActorSystem("partio-actor-system")
  implicit val context = system.dispatcher
  implicit val materializer = ActorMaterializer()

  val bindingFuture = Http().bindAndHandle(HttpRoutes.route, "0.0.0.0", 8080)

  println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
  scala.io.StdIn.readLine()

  bindingFuture
    .flatMap(_.unbind())               // trigger unbinding from the port
    .onComplete((_: scala.util.Try[Unit]) => system.shutdown()) // and shutdown when done
}
