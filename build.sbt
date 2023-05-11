ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "PT_Lab2"
  )

libraryDependencies ++= Seq(
  "org.apache.poi" % "poi" % "3.9",
  "org.apache.poi" % "poi-ooxml" % "3.9",
  "au.com.bytecode" % "opencsv" % "2.4"
)

scalacOptions ++= Seq("-unchecked", "-deprecation", "-encoding", "UTF-8")