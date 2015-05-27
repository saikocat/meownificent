package com.saikocat.meownificent.service

trait ApiVersioning {
  val version: Int
  lazy val versionMediaType: String = s"application/vnd.meownificent.v${version}+json"
}
