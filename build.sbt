
ThisBuild / organization := "net.ypmania.scadraw"
ThisBuild / scalaVersion := "2.13.6"
ThisBuild / version      := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .aggregate(server, client, shared.jvm, shared.js)

lazy val server = project
  .settings(
    scalaJSProjects := Seq(client),
    Assets / pipelineStages := Seq(scalaJSPipeline),
    // triggers scalaJSPipeline when using compile or continuous compilation
    Compile / compile := ((Compile / compile) dependsOn scalaJSPipeline).value,
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % "10.2.6",
      "com.typesafe.akka" %% "akka-stream" % "2.6.16",
      "com.typesafe.akka" %% "akka-actor" % "2.6.16",
      "com.vmunier" %% "scalajs-scripts" % "1.2.0"
    ),
    Assets / WebKeys.packagePrefix := "public/",
    Runtime / managedClasspath += (Assets / packageBin).value
  )
  .enablePlugins(SbtWeb, JavaAppPackaging, WebScalaJSBundlerPlugin)
  .dependsOn(shared.jvm)

lazy val client = project
  .settings(
    // This is an application with a main method
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "2.0.0",
      "com.raquo" %%% "laminar" % "0.14.2"
    ),
    useYarn := true,
    Compile / npmDependencies ++= Seq(
//      "two.js" -> "0.7.5"
    )
  )
// ScalablyTypedConverterPlugin implies CommonJS modules, which are then merged by the
// scalajs bundler plugin.
// Don't use ScalaJSWeb: https://github.com/scalacenter/scalajs-bundler/pull/288
  .enablePlugins(ScalaJSPlugin, WebScalaJS, ScalaJSBundlerPlugin)
  .dependsOn(shared.js)

lazy val shared = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("shared"))
  .jsConfigure(_.enablePlugins(WebScalaJS))
