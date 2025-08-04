ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.14"

lazy val root = (project in file("."))
  .settings(
    name := "leetcode"
  )

libraryDependencies += "com.squareup.okhttp3" % "okhttp" % "4.12.0"
