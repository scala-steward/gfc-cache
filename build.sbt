name := "gfc-cache"

organization := "com.gilt"

scalaVersion := "2.12.7"

crossScalaVersions := Seq(scalaVersion.value, "2.11.12", "2.10.7")

scalacOptions += "-target:jvm-1.7"

javacOptions ++= Seq("-source", "1.7", "-target", "1.7")

libraryDependencies ++= Seq(
  "com.gilt" %% "gfc-time" % "0.0.7",
  "com.gilt" %% "gfc-concurrent" % "0.3.7",
  "com.gilt" %% "gfc-logging" % "0.0.8",
  "com.gilt" %% "gfc-util" % "0.2.2",
  "com.gilt" %% "gfc-guava" % "0.3.0",
  "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  "org.mockito" % "mockito-core" % "2.22.0" % Test
)


releaseCrossBuild := true

releasePublishArtifactsAction := PgpKeys.publishSigned.value

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

licenses := Seq("Apache-style" -> url("https://raw.githubusercontent.com/gilt/gfc-cache/master/LICENSE"))

homepage := Some(url("https://github.com/gilt/gfc-cache"))

pomExtra := <scm>
  <url>https://github.com/gilt/gfc-cache.git</url>
  <connection>scm:git:git@github.com:gilt/gfc-cache.git</connection>
</scm>
  <developers>
    <developer>
      <id>gheine</id>
      <name>Gregor Heine</name>
      <url>https://github.com/gheine</url>
    </developer>
  </developers>
