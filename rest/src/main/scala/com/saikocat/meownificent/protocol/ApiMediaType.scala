package com.saikocat.meownificent.protocol

import spray.http.MediaType
import spray.http.MediaTypes.register

object ApiMediaType {
  val version = 1
  lazy val versionMediaType: String =
    s"application/vnd.meownificent.v${version}+json"
  // mainType: application, subType: json, compressible, binary
  lazy val MeownificentJsonMediaType =
    register(MediaType.custom("application", s"vnd.meownificent.v${version}+json", true, true))
}
