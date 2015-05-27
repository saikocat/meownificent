package com.saikocat.meownificent.service

import spray.routing.{HttpService, Route}
import spray.http.MediaTypes.`application/json`

trait RedditService extends HttpService {
  val redditRoute: Route = {
    pathPrefix("reddit") {
      path("") {
        get {
          respondWithMediaType(`application/json`) {
            complete {
              """
              {"status": "ok"}
              """.trim.stripMargin.mkString
            }
          }
        }
      }
    }
  }
}
