import net.minecraftforge.gradle.common.util.RunConfig
import net.minecraftforge.gradle.userdev.UserDevExtension
import org.gradle.api.JavaVersion
import org.gradle.api.plugins.JavaPluginConvention
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "dev.defazomb.atymic"
version = "0.1.0"

buildscript {
    repositories {
        mavenCentral()
        maven {
            name = "Forge Maven"
            url = uri("https://files.minecraftforge.net/maven")
        }
    }
    dependencies {
        classpath("net.minecraftforge.gradle:ForgeGradle:3.0.178")
    }
}

plugins {
    kotlin("jvm") version "1.3.72"
    kotlin("kapt") version "1.3.72"

    java
    idea
    maven
}

apply(plugin = "net.minecraftforge.gradle")

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

configure<BasePluginConvention> {
    archivesBaseName = "atymic"
}

configure<UserDevExtension> {
    mappings(mapOf(
        "channel" to "snapshot",
        "version" to "20200514-1.15.1"
    ))

    runs {
        val runConfig = Action<RunConfig> {
            properties(mapOf(
                    "forge.logging.markers" to "SCAN,REGISTRIES,REGISTRYDUMP",
                    "forge.logging.console.level" to "debug"
            ))
            workingDirectory = project.file("run").canonicalPath
            source(sourceSets["main"])
        }

        create("client", runConfig)
        create("server", runConfig)
    }
}

dependencies {
    "minecraft"("net.minecraftforge:forge:1.15.2-31.2.21")

    implementation(kotlin("stdlib-jdk8"))

    implementation("com.google.auto.service:auto-service:1.0-rc4")
    kapt("com.google.auto.service:auto-service:1.0-rc4")
}

tasks.register<Jar>("deobfJar") {
    from(sourceSets["main"].output)
}

artifacts {
    add("archives", tasks.named("deobfJar"))
}
