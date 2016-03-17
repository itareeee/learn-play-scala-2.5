/*
 * References:
 * - https://github.com/tanacasino/studyplay2/blob/master/build.sbt
 * - http://qiita.com/seratch@github/items/243e99117429bda5f172
 * - http://qiita.com/erukiti/items/0decc5fe8bf2c61d3b1e
 * - http://qiita.com/bigwheel/items/44cb874ced4be204c09c
 */

val appName = "learn-play2-scala-2.5"
val appVersion = "1.0.0"

// TODO understad the settings below
val baseSettings = Seq(
  scalaVersion := "2.11.7",
  scalacOptions ++= Seq(
    "-feature",
    "-deprecation",
    "-unchecked",
    "-Xlint",
    "-Ywarn-dead-code",
    //"-Ywarn-unused-import",
    "-language:existentials",
    "-language:higherKinds",
    "-language:implicitConversions"
  ),
  javacOptions in compile ++= Seq(
    "-encoding", "UTF-8",
    "-source", "1.8",
    "-target", "1.8"
  ),
  resolvers ++= Seq(Opts.resolver.sonatypeReleases)
)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  //"org.scalactic" %% "scalactic" % "2.2.6", // TODO: superSafe と併せて検討: http://www.scalatest.org/install
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.scalatestplus" %% "play" % "1.4.0" % "test"
)
resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
routesGenerator := InjectedRoutesGenerator

import play.sbt.PlayImport.PlayKeys._

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    baseSettings: _*
  ).settings(
    version := appVersion,
    playDefaultPort := 9126
  )
