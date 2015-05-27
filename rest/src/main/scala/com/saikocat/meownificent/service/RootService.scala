package com.saikocat.meownificent.service

import akka.actor.{ActorRefFactory, Actor}

import spray.routing.{HttpService, Route}

import com.saikocat.meownificent.configuration.Settings
import com.saikocat.meownificent.directive.AcceptHeaderDirective
import com.saikocat.meownificent.error.ApiRejectionHandler

class RootServiceActor(settings: Settings) extends Actor with RootService {
  val version: Int = settings.version

  def actorRefFactory: ActorRefFactory = context
  def receive = runRoute(rootRoute)
}

trait RootService extends HttpService
  with ApiVersioning with AcceptHeaderDirective
  with ApiRejectionHandler
  with RedditService {

  lazy val rootRoute: Route = {
    accept(versionMediaType) {
      redditRoute
    }
  }
}
