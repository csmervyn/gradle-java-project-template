/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.2.1/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    checkstyle
    id("com.github.spotbugs") version "6.0.5"
    id("org.owasp.dependencycheck") version "9.0.8"
    pmd
    jacoco
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    implementation("org.projectlombok:lombok:1.18.30")
    implementation("com.google.guava:guava:33.0.0-jre")
    implementation("org.slf4j:slf4j-api:2.0.10")
    implementation ("org.mapstruct:mapstruct:1.5.5.Final")
    implementation("org.projectlombok:lombok-mapstruct-binding:0.2.0")
    annotationProcessor ("org.projectlombok:lombok-mapstruct-binding:0.2.0")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor ("org.mapstruct:mapstruct-processor:1.5.5.Final")
    annotationProcessor ("org.projectlombok:lombok:1.18.30")
    implementation("ch.qos.logback:logback-classic:1.4.14")

    testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("ch.qos.logback:logback-classic:1.4.14")
    testImplementation("org.mockito:mockito-junit-jupiter:5.8.0")
    testImplementation("org.hamcrest:hamcrest-core:2.2")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    // Define the main class for the application.
    mainClass.set("com.mervyn.learn.gradle.App")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

checkstyle {
    toolVersion = "10.12.1"
}
tasks.withType<Checkstyle>().configureEach {
    reports {
        xml.required.set(false)
        html.required.set(true)
        //html.stylesheet = resources.text.fromFile("config/xsl/checkstyle-custom.xsl")
    }
}

tasks.spotbugsMain {
    reports.create("html") {
        required.set(true)
        outputLocation.set(file("$buildDir/reports/spotbugs.html"))
        setStylesheet("fancy-hist.xsl")
    }
}

pmd {
    isConsoleOutput = true
    toolVersion = "6.55.0"
    rulesMinimumPriority.set(5)
    ruleSets = readRuleSetsFromFile()
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
    finalizedBy(tasks.jacocoTestCoverageVerification)
}
tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
}
tasks.jacocoTestCoverageVerification {
    dependsOn(tasks.test)
    violationRules {
        rule {
            limit {
                minimum = "0.6".toBigDecimal()
            }
        }

        rule {
            isEnabled = false
            element = "CLASS"
            includes = listOf("org.gradle.*")

            limit {
                counter = "LINE"
                value = "TOTALCOUNT"
                maximum = "0.9".toBigDecimal()
            }
        }
    }
}

jacoco {
    toolVersion = "0.8.9"
    reportsDirectory.set(layout.buildDirectory.dir("customJacocoReportDir"))
}

tasks.jacocoTestReport {
    reports {
        xml.required.set(false)
        csv.required.set(false)
        html.outputLocation.set(layout.buildDirectory.dir("jacocoHtml"))
    }
}

tasks.named("build") { finalizedBy("buildMultiplePlatsformImage") }
task<Exec>("buildMultiplePlatsformImage") {
    commandLine ("./scripts/build-multiple-platsform-image.sh")
}
task<Exec>("buildMultiplePlatsformImageInForCICD") {
    commandLine ("./scripts/build-multiple-platsform-image-cicd.sh")
}

fun readRuleSetsFromFile() : List<String> {
    val rulesFile = File(getLayout().getProjectDirectory().asFile.path, "config/pmd/pmd-ruleSets.txt")
    return readRulesFromFile(rulesFile)
}

fun readRulesFromFile(file: File): List<String> {
    val rulesList = mutableListOf<String>()
    try {
        file.forEachLine { line ->
            // Ignore lines starting with #
            if (!line.trim().startsWith("#")) {
                rulesList.add(line.trim())
            }
        }
    } catch (e: Exception) {
        println("Error reading rules from file: ${e.message}")
    }
    return rulesList
}
