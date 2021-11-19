addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.7.1")
addSbtPlugin("com.vmunier" % "sbt-web-scalajs" % "1.2.0")
addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "1.1.0")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.8.1")
addSbtPlugin("io.spray" % "sbt-revolver" % "0.9.1")
addSbtPlugin("org.scalablytyped.converter" % "sbt-converter" % "1.0.0-beta36")

// 1.0.0 (sbt-converter) vs 0.8.0 (sbt-web)
libraryDependencySchemes += "org.scala-lang.modules" %% "scala-java8-compat" % "always"
