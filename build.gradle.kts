import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.3"
    id("io.spring.dependency-management") version "1.0.13.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
}

group = "com.wooming"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

object Versions {
//    const val awsIotVersion = "1.12.293"
    const val awsIotDeviceSdkVersion = "1.3.9"
    const val kotlinJdslVersion = "2.0.5.RELEASE"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    implementation("org.springframework.boot:spring-boot-starter-security")
//    testImplementation("org.springframework.security:spring-security-test")

    // Database
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    runtimeOnly("org.postgresql:postgresql")

    // QueryBuilder
    implementation("com.linecorp.kotlin-jdsl:kotlin-jdsl-core:${Versions.kotlinJdslVersion}")
//    implementation("com.linecorp.kotlin-jdsl:hibernate-kotlin-jdsl:${Versions.kotlinJdslVersion}")


    // AWS
//    implementation("com.amazonaws:aws-java-sdk-iot:${Versions.awsIotVersion}")
    implementation("com.amazonaws:aws-iot-device-sdk-java:${Versions.awsIotDeviceSdkVersion}")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
