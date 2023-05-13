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
    testCompileOnly ("junit:junit:4.12")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.20")
}

tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
    reports {
        xml.required.set(true)
        html.required.set(false)
    }
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}