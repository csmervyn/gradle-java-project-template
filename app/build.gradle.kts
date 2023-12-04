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
    id("com.github.spotbugs") version "5.2.4"
    id("org.owasp.dependencycheck") version "9.0.2"
    pmd
    jacoco
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    implementation("org.projectlombok:lombok:1.18.30")
    implementation("com.google.guava:guava:32.1.3-jre")
    implementation("org.slf4j:slf4j-api:2.0.9")
    implementation ("org.mapstruct:mapstruct:1.5.5.Final")
    implementation("org.projectlombok:lombok-mapstruct-binding:0.2.0")
    annotationProcessor ("org.projectlombok:lombok-mapstruct-binding:0.2.0")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor ("org.mapstruct:mapstruct-processor:1.5.5.Final")
    annotationProcessor ("org.projectlombok:lombok:1.18.30")

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
    mainClass.set("gradle.java.project.template.App")
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
    ruleSets = listOf("category/java/errorprone.xml", "category/java/bestpractices.xml/AbstractClassWithoutAbstractMethod",
            "category/java/bestpractices.xml/AccessorClassGeneration",
            "category/java/bestpractices.xml/AccessorMethodGeneration",
            "category/java/bestpractices.xml/ArrayIsStoredDirectly",
            "category/java/bestpractices.xml/AvoidMessageDigestField",
            "category/java/bestpractices.xml/AvoidPrintStackTrace",
            "category/java/bestpractices.xml/AvoidReassigningCatchVariables",
            "category/java/bestpractices.xml/AvoidReassigningLoopVariables",
            "category/java/bestpractices.xml/AvoidReassigningParameters",
            "category/java/bestpractices.xml/AvoidStringBufferField",
            "category/java/bestpractices.xml/AvoidUsingHardCodedIP",
            "category/java/bestpractices.xml/CheckResultSet",
            "category/java/bestpractices.xml/ConstantsInInterface",
            "category/java/bestpractices.xml/DefaultLabelNotLastInSwitchStmt",
            "category/java/bestpractices.xml/DoubleBraceInitialization",
            "category/java/bestpractices.xml/ForLoopCanBeForeach",
            "category/java/bestpractices.xml/ForLoopVariableCount",
            "category/java/bestpractices.xml/GuardLogStatement",
            "category/java/bestpractices.xml/JUnit4SuitesShouldUseSuiteAnnotation",
            "category/java/bestpractices.xml/JUnit4TestShouldUseAfterAnnotation",
            "category/java/bestpractices.xml/JUnit4TestShouldUseBeforeAnnotation",
            "category/java/bestpractices.xml/JUnit4TestShouldUseTestAnnotation",
            "category/java/bestpractices.xml/JUnit5TestShouldBePackagePrivate",
//            "category/java/bestpractices.xml/JUnitAssertionsShouldIncludeMessage",
//            "category/java/bestpractices.xml/JUnitTestContainsTooManyAsserts",
            "category/java/bestpractices.xml/JUnitUseExpected",
            "category/java/bestpractices.xml/LiteralsFirstInComparisons",
            "category/java/bestpractices.xml/LooseCoupling",
            "category/java/bestpractices.xml/MethodReturnsInternalArray",
            "category/java/bestpractices.xml/MissingOverride",
            "category/java/bestpractices.xml/OneDeclarationPerLine",
            "category/java/bestpractices.xml/PreserveStackTrace",
            "category/java/bestpractices.xml/PrimitiveWrapperInstantiation",
            "category/java/bestpractices.xml/ReplaceEnumerationWithIterator",
            "category/java/bestpractices.xml/ReplaceHashtableWithMap",
            "category/java/bestpractices.xml/ReplaceVectorWithList",
            "category/java/bestpractices.xml/SimplifiableTestAssertion",
            "category/java/bestpractices.xml/SwitchStmtsShouldHaveDefault",
            "category/java/bestpractices.xml/SystemPrintln",
            "category/java/bestpractices.xml/UnusedAssignment",
            "category/java/bestpractices.xml/UnusedFormalParameter",
            "category/java/bestpractices.xml/UnusedLocalVariable",
            "category/java/bestpractices.xml/UnusedPrivateField",
            "category/java/bestpractices.xml/UnusedPrivateMethod",
            "category/java/bestpractices.xml/UseCollectionIsEmpty",
            "category/java/bestpractices.xml/UnusedPrivateMethod",
            "category/java/bestpractices.xml/UseStandardCharsets",
            "category/java/bestpractices.xml/UseTryWithResources",
            "category/java/bestpractices.xml/UseVarargs",
            "category/java/bestpractices.xml/WhileLoopWithLiteralBoolean")
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
