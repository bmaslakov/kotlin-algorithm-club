plugins {
    kotlin("jvm") version "1.3.21"
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
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.21")
    }
}

kotlin {
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
    testImplementation("junit:junit:4.12")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.21")
}

tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
    reports {
        xml.isEnabled = true
        html.isEnabled = false
    }
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}