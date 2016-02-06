// Scala
lazy val akka         = "2.3.14"
lazy val streams      = "2.0.1"
lazy val httpJson     = "1.4.1"
lazy val cats         = "0.3.0"
lazy val circe        = "0.2.1"
lazy val shapeless    = "2.2.5"
lazy val slf4jnop     = "1.6.4"
lazy val specs2       = "3.6.5"

lazy val root = project.in(file("."))
  .settings(
    scalaVersion          :=  "2.11.7",
    name                  :=  "example",
    organization          :=  "me.chuwy",
    version               :=  "0.1.0-SNAPSHOT",
    description           :=  "Compile problem",
    scalacOptions         :=  Seq("-deprecation", "-encoding", "utf8"),

    libraryDependencies += "org.spire-math"             %% "cats"                        % cats,
    libraryDependencies += "io.circe"                   %% "circe-core"                  % circe,
    libraryDependencies += "io.circe"                   %% "circe-generic"               % circe,
    libraryDependencies += "com.typesafe.akka"          %% "akka-actor"                  % akka,
    libraryDependencies += "com.typesafe.akka"          %% "akka-stream-experimental"    % streams,
    libraryDependencies += "com.typesafe.akka"          %% "akka-http-core-experimental" % streams,
    libraryDependencies += "com.typesafe.akka"          %% "akka-http-experimental"      % streams,
    libraryDependencies += "de.heikoseeberger"          %% "akka-http-circe"             % httpJson,
    libraryDependencies += "io.circe"                   %% "circe-jawn"                  % circe,
    // Java
    libraryDependencies += "org.slf4j"                  %  "slf4j-nop"                   % slf4jnop
  )
