plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "dev.trxsson"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.2")
    implementation("dev.trxsson:simple-configs:1.0.1-SNAPSHOT")
    implementation("net.kyori:adventure-api:4.13.0")
    implementation("net.kyori:adventure-text-serializer-legacy:4.13.0")
    implementation("net.kyori:adventure-text-minimessage:4.13.0")
    compileOnly("io.github.waterfallmc:waterfall-api:1.19-R0.1-SNAPSHOT")
    compileOnly("org.jetbrains:annotations:24.0.1")
    annotationProcessor("org.jetbrains:annotations:24.0.1")
    compileOnly("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.projectlombok:lombok:1.18.26")
}

tasks {
    jar {
        dependsOn("shadowJar")
    }
}