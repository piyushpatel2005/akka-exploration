ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.19"

lazy val root = (project in file("."))
  .settings(
    name := "udemy-akka"
  )

val akkaVersion = "2.5.13"
val akkaTypedVersion = "2.6.20"
val logbackVersion = "1.2.3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
  "org.scalatest" %% "scalatest" % "3.0.5" % Test
)

lazy val essentials = project

lazy val akkabook = project
  .in(file("akkabook"))
  .settings(
    scalaVersion := scalaVersion.value,
//    scalafmtOnCompile := true,
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % akkaTypedVersion,
      "com.typesafe.akka" %% "akka-actor-typed" % akkaTypedVersion,
      "ch.qos.logback" % "logback-classic" % logbackVersion,
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaTypedVersion % Test,
      "org.scalatest" %% "scalatest" % "3.0.5" % Test
    )
  )