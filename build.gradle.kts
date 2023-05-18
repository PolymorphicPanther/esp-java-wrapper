plugins {
    id("java")
    id("maven-publish")
    id("signing")
    id("io.github.gradle-nexus.publish-plugin") version "1.0.0"
    id("org.jetbrains.dokka") version "1.4.20"
}


group = "org.jesp"
version = "1.0-SNAPSHOT"

java {
    withJavadocJar()
    withSourcesJar()
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:24.0.0")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.14.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.2")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

signing {
    useGpgCmd()
    setRequired {
        gradle.taskGraph.allTasks.any { it is PublishToMavenRepository }
    }
    val signingKeyId: String? by project
    val signingKey: String? by project
    val signingPassword: String? by project
    useInMemoryPgpKeys(signingKeyId, signingKey, signingPassword)
    sign(publishing.publications)
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/PolymorphicPanther/esp-java-wrapper")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
        maven {
            url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = System.getenv("MAVEN_USERNAME")
                password = System.getenv("MAVEN_PASSWORD")
            }
        }
    }

    publications {
        create<MavenPublication>("Maven") {
            groupId = "org.jesp"
            artifactId = "esp-wrapper"
            version = "0.001-SNAPSHOT"
            from(components["java"])
        }
        withType<MavenPublication> {
            pom {
                packaging = "jar"
                name.set("Esp Wrapper")
                description.set("A Java wrapper for the Eskom Se Push API")
                licenses {
                    license {
                        name.set("MIT license")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                issueManagement {
                    system.set("Github")
                    url.set("https://github.com/PolymorphicPanther/esp-java-wrapper/issues")
                }
                scm {
                    connection.set("scm:git:git://github.com/PolymorphicPanther/esp-java-wrapper.git")
                    developerConnection.set("scm:git:git@github.com:PolymorphicPanther/esp-java-wrapper.git")
                    url.set("https://github.com/PolymorphicPanther/esp-java-wrapper")
                }
                developers {
                    developer {
                        id.set("luvip")
                        name.set("Luveshen Pillay")
                        email.set("luveshen.pillay@gmail.com")
                    }
                }
            }
        }
    }
}

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))

            username.set(System.getenv(""))

            val ossrhUsername = providers
                    .environmentVariable("OSSRH_USERNAME")
                    .forUseAtConfigurationTime()
            val ossrhPassword = providers
                    .environmentVariable("OSSRH_PASSWORD")
                    .forUseAtConfigurationTime()
            if (ossrhUsername.isPresent && ossrhPassword.isPresent) {
                username.set(ossrhUsername.get())
                password.set(ossrhPassword.get())
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}