plugins {
    kotlin("jvm") version "1.8.20"
    jacoco
    idea
    java
}

repositories {
    mavenCentral()
}


buildscript {

    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.20")
    }
}

kotlin {
    jvmToolchain(11)
    sourceSets {
        main {
            kotlin.setSrcDirs(listOf("src/main"))
        }
        test {
            kotlin.setSrcDirs(listOf("src/test"))
        }
    }
}




dependencies {
    implementation(kotlin(("stdlib")))
    testImplementation(kotlin("test-junit5"))
    testCompileOnly(kotlin("test"))
    testCompileOnly(kotlin("test-annotations-common"))
    testCompileOnly("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
}

tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
    reports {
        xml.required.set(true)
        html.required.set(false)
    }
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}