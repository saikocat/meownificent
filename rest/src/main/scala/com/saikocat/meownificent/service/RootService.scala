package com.saikocat.meownificent.service

import akka.actor.{ActorRefFactory, Actor}

import spray.routing.{HttpService, Route}

import com.saikocat.meownificent.configuration.Settings

class RootServiceActor(settings: Settings) extends Actor with RootService {
  def actorRefFactory: ActorRefFactory = context
  def receive = runRoute(rootRoute)
}

trait RootService extends HttpService
  with RedditService {
  val rootRoute: Route = {
    redditRoute
  }
}
