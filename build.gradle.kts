import org.gradle.kotlin.dsl.java

plugins {
    id("java")
    id("maven-publish")
    id("signing")
    id("org.jetbrains.dokka") version "1.4.20"
    id("io.github.gradle-nexus.publish-plugin") version "1.0.0"
}

group = "org.jesp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java{
    withSourcesJar()
    withJavadocJar()
}

signing {
    val signingKey = providers
            .environmentVariable("GPG_SIGNING_KEY")
            .forUseAtConfigurationTime()
    val signingPassphrase = providers
            .environmentVariable("GPG_SIGNING_PASSPHRASE")
            .forUseAtConfigurationTime()
    if (signingKey.isPresent && signingPassphrase.isPresent) {
        useInMemoryPgpKeys(signingKey.get(), signingPassphrase.get())
        val extension = extensions
                .getByName("publishing") as PublishingExtension
        sign(extension.publications)
    }
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
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}

tasks.test {
    useJUnitPlatform()
}