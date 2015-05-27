package com.saikocat.meownificent.directive

import spray.routing._
import Directives._

trait AcceptHeaderDirective {
  def accept(required: String): Directive0 =
    headerValueByName("Accept").flatMap {
      case actual if actual.split(",").contains(required) => pass
      case _ => reject(MalformedHeaderRejection("Accept", s"Accept must contain '${required}'"))
    }
}
