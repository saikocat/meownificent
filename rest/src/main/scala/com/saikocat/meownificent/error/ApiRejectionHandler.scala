package com.saikocat.meownificent.error

import spray.routing._
import spray.routing.directives.RouteDirectives._
import spray.http.StatusCodes

trait ApiRejectionHandler {
  implicit val apiRejectionHandler = RejectionHandler {
    case MalformedHeaderRejection(headerName, msg, _) :: _ =>
      complete(StatusCodes.NotAcceptable, msg)
  }
}
