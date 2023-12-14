# Plugins we integrate
## checkstyle

本地运行 checkstyle 检查

```shell
./gradlew clean check
```

上面的命令在运行时，会在命令行给出违法 checkstyle 规则的提示和生成 checkstyle 报告。
生产代码 checkstyle 报告所在位置:

```shell
{项目 root directory}/app/build/reports/checkstyle/main.html
```

test 代码 checkstyle 报告所在位置:

```shell
{项目 root directory}/app/build/reports/checkstyle/test.html
```

### reference

- [The Checkstyle Plugin](https://docs.gradle.org/current/userguide/checkstyle_plugin.html#sec:checkstyle_configuration)
- [release list of checkstyle](https://checkstyle.sourceforge.io/releasenotes.html)

## spotbugs
com.github.spotbugs

本地运行 spotbugs 检查

```shell
./gradlew clean check
```

上面的命令在运行时，会检查潜在的bug 和生成 spotbugs 报告。
spotbugs 报告所在位置:

```shell
{项目 root directory}/app/build/reports/spotbugs.html
```

### reference

- [spotbugs-gradle-plugin Github](https://github.com/spotbugs/spotbugs-gradle-plugin)
- [Gradle plugin portal](https://plugins.gradle.org/plugin/com.github.spotbugs)

## dependencycheck
org.owasp.dependencycheck
本地运行 dependencycheck 的检查

```shell
./gradlew dependencyCheckAnalyze
```

上面的命令在运行时，在命令行检查 dependency 的 vulnerabilities和生成 dependency-check-report 报告。
dependency-check-report 报告所在位置:

```shell
{项目 root directory}/app/build/reports/dependency-check-report.html
```

### reference

- [Gradle dependencycheck plugin](https://plugins.gradle.org/plugin/org.owasp.dependencycheck)
- [Dependencycheck documention](http://jeremylong.github.io/DependencyCheck/dependency-check-gradle/index.html)

## pmd

本地运行 pmd 的检查

```shell
./gradlew clean check
```

上面的命令在运行时，在命令行检查 pmd 和生成 pmd 报告。
生产代码 pmd 报告所在位置:

```shell
{项目 root directory}/app/build/reports/pmd/main.html
```

test 代码 pmd 报告所在位置:

```shell
{项目 root directory}/app/build/reports/pmd/test.html
```

### reference

- [Guide pmd plugin](https://docs.gradle.org/current/userguide/pmd_plugin.html)

## gitleaks

首先需要安装 git hook 脚步：

```shell
pre-commit install
```

测试 gitleaks 是否生效：

```shell
pre-commit run --all-files
```

### reference

- [pre-commit document](https://pre-commit.com/)
- [hooks of pre-commit](https://pre-commit.com/hooks.html)
- [github gitleaks](https://github.com/gitleaks/gitleaks)

## Jacoco

本地运行 jacoco 生成报告的命令：

```shell
./gradlew clean build
# or
./gradlew clean jacocoTestReport
```

jacoco 报告所在位置:

```shell
{项目 root directory}/app/build/jacocoHtml/index.html
```

本地运行 jacoco 检查报告的命令：

```shell
./gradlew clean build
# or
./gradlew clean jacocoTestCoverageVerification
```

### reference

- [Gradle jacoco](https://docs.gradle.org/current/userguide/jacoco_plugin.html)

## shadow
com.github.johnrengelman.shadow

A Gradle plugin for collapsing all dependencies and project code into a single Jar file(fat/uber jar).

run following command to build a uber jar:
```shell
./gradlew clean build
# or
./gradlew shadowJar
```
the location of fat/uber jar
```text
{project root directory}/app/build/libs/app-all.jar
```
verify the fat/uber jar works well:
```shell
java -jar /app/build/libs/app-all.jar
```
the expected output likes this:
```text
14:05:19.356 [main] INFO com.mervyn.learn.gradle.App -- Hello World!
```
### reference
- [gradle plugin com.github.johnrengelman.shadow](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
- [Creating a Fat Jar in Gradle](https://www.baeldung.com/gradle-fat-jar)
- [Gradle Shadow Plugin](https://imperceptiblethoughts.com/shadow/)
