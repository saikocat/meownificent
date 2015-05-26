name := "Meownificent Project"

Common.settings

lazy val rest = project in file("rest")

lazy val main = project.in(file("."))
  .aggregate(rest)
