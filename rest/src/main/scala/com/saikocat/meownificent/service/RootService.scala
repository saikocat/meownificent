package com.saikocat.meownificent.service

import akka.actor.{ActorRefFactory, Actor}

import spray.routing.{HttpService, Route}

import com.saikocat.meownificent.configuration.Settings
import com.saikocat.meownificent.protocol.ApiMediaType
import com.saikocat.meownificent.directive.AcceptHeaderDirective
import com.saikocat.meownificent.error.ApiRejectionHandler

class RootServiceActor(settings: Settings) extends Actor with RootService {
  def actorRefFactory: ActorRefFactory = context
  def receive = runRoute(rootRoute)
}

trait RootService extends HttpService
  with AcceptHeaderDirective
  with ApiRejectionHandler
  with RedditService {

  lazy val rootRoute: Route = {
    accept(ApiMediaType.versionMediaType) {
      redditRoute
    }
  }
}
