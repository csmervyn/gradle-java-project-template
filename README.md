# gradle-java-project-template

## Overview

Java project template build by gradle. Default integration some useful plugin.

## Build status

![Gradle Build](https://github.com/csmervyn/gradle-java-project-template/actions/workflows/gradle.yml/badge.svg)

## Prerequisites

- JDK 17
- Gradle

## Build in local

```shell
./gradlew clean build
```

## Framework we use

- Language: Java
- Test framework: Junit 5
- Build Tool: Gradle
- Mock framework: Mockito
- Assert framework: Hamcrest

## Plugins we integrate

- [checkstyle](./documents/plugins-we-integrate.md#checkstyle)
- [com.github.spotbugs](./documents/plugins-we-integrate.md#spotbugs)
- [org.owasp.dependencycheck](./documents/plugins-we-integrate.md#dependencycheck)
- [pmd](./documents/plugins-we-integrate.md#pmd)
- [gitleaks](./documents/plugins-we-integrate.md#gitleaks)
- [jacoco](./documents/plugins-we-integrate.md#Jacoco)
- [com.github.johnrengelman.shadow](./documents/plugins-we-integrate.md#shadow)

## Utils we use
- [MapStruct](./documents/utils-we-use.md#MapStruct)
- lombok

## Build image
- If you want to build single platform image you can directly use `docker build` command.
- If you want to manually build multiple platforms and architecture image , please follow [the steps](./documents/build-multiple-platforms-and-architectures-image.md).
- If you want to automatically build multiple platforms and architecture image, you can directly run `./gradle clean build`. Because our project bound buildx script. **But notes: you need to [prepare your buildx builder](./documents/build-multiple-platforms-and-architectures-image.md), before you run that command**




