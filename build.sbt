name := "Meownificent Project"

lazy val restCore = project in file("rest-core")

lazy val main = project.in(file("."))
  .aggregate(restCore)
