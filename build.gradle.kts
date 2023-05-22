plugins {
    id("java")
    id("maven-publish")
    id("signing")
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
            name = "OSSRH"
            url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
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
            version = "1.0-SNAPSHOT"
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

signing{
    val key = System.getenv("SIGN_KEY")
    val passPhrase = System.getenv("SIGN_PASS_PHRASE")
    useInMemoryPgpKeys(key, passPhrase)
    sign(publishing.publications)
}

tasks.test {
    useJUnitPlatform()
}