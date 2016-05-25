/*
 * References:
 * - https://github.com/tanacasino/studyplay2/blob/master/build.sbt
 * - http://qiita.com/seratch@github/items/243e99117429bda5f172
 * - http://qiita.com/erukiti/items/0decc5fe8bf2c61d3b1e
 * - http://qiita.com/bigwheel/items/44cb874ced4be204c09c
 */

val appName = "learn-play2-scala-2.5"

import common.sbt._

lazy val common = Common.project
lazy val api = API.project

lazy val root = Project(
    "learn-play",
    file(".")
  ).settings(
    Base.baseSettings: _*
  ).aggregate(
    common,
    api
  )
