package com.saikocat.meownificent.configuration

// import scala.collection.JavaConverters._
import com.typesafe.config.Config
import spray.util.SettingsCompanion

case class Settings(
    interface: String,
    port: Int,
    devMode: Boolean,
    version: Int) {

  require(interface.nonEmpty, "interface must not be empty")
  require(0 < port && port < 65536, "illegal port")
}

object Settings extends SettingsCompanion[Settings]("meownificent.rest") {
  def fromSubConfig(config: Config) = apply(
    config getString "interface",
    config getInt "port",
    config getBoolean "dev-mode",
    config getInt "version")
}
