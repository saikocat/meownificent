import sbt._
import Keys._

object Common {
  val settings: Seq[Setting[_]] = Seq(
    organization  := "com.saikocat",
    version       := "0.1.0-SNAPSHOT",
    scalaVersion  := "2.11.6",
    scalacOptions := Seq(
      "-unchecked",
      "-deprecation",
      "-encoding", "utf8",
      "-Ywarn-dead-code",
      "-Ywarn-unused-import"
    )
  )

  val testDependencies = {
    val scalaTestV = "2.2.4"
    Seq(
      "org.scalatest" %% "scalatest" % scalaTestV % "test"
    )
  }

  val logDependencies = {
    val logbackV = "1.1.3"
    Seq(
      "ch.qos.logback" % "logback-classic" % logbackV
    )
  }
}
