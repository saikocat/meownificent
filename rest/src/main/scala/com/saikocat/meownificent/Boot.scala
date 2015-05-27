package com.saikocat.meownificent

import akka.actor.{ActorSystem, Props}
import akka.event.Logging
import akka.io.IO
import spray.can.Http

import com.saikocat.meownificent.configuration.Settings
import com.saikocat.meownificent.service.RootServiceActor

object Boot extends App {
  implicit val system = ActorSystem("meownificent-rest")
  val log = Logging(system, getClass)
  val settings = Settings(system)

  log.info("Starting service actor and HTTP server...")
  val listener = system.actorOf(
    Props(new RootServiceActor(settings)),
    "meownificent-rest-service")
  IO(Http) ! Http.Bind(listener, settings.interface, settings.port)
}
