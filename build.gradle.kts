plugins {
    id("java")
    id("maven-publish")

}

group = "org.jesp"
version = "1.0-SNAPSHOT"

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

tasks.test {
    useJUnitPlatform()
}