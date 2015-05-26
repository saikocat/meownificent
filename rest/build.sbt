name := "REST on Spray"

Common.settings

lazy val sprayDependencies = {
  val akkaV = "2.3.9"
  val sprayV = "1.3.3"
  Seq(
    "io.spray"          %% "spray-can"     % sprayV,
    "io.spray"          %% "spray-routing" % sprayV,
    "io.spray"          %% "spray-testkit" % sprayV  % "test",
    "com.typesafe.akka" %% "akka-actor"    % akkaV,
    "com.typesafe.akka" %% "akka-slf4j"    % akkaV,
    "com.typesafe.akka" %% "akka-testkit"  % akkaV   % "test"
  )
}

libraryDependencies ++= (
  Common.testDependencies ++ Common.logDependencies ++ sprayDependencies
)

Revolver.settings
