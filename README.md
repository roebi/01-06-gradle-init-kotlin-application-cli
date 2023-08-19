![Logo of the project](https://raw.githubusercontent.com/jehna/readme-best-practices/master/sample-logo.png)

# 01-06-gradle-init-kotlin-application-cli
> do you want to focus on a java commandline application?

This project is a prepared gradle init kotlin application with added dependency for commandline argument handling. With some renames you are ready to develop.

## Installing / Getting started

please prepare with https://github.com/roebi/01-05-dev-env-setup-basestep-for-jvm
```git bash
curl -s "https://get.sdkman.io" | bash
sdk install java 17.0.8.fx-zulu
sdk install gradle 8.2.1
```

This installs sdkman, the latest zulu java fx LTS version, current version 17 and latest gradle non rc version, current version 8.2.1.

### Initial Configuration / what I have already done

gradle init with: project type **application**, implementation language **Java**, **multiple subprojects**, build script DSL **Kotlin**, Project name (default) **01-06-gradle-init-kotlin-application-cli**, Source package **in.halter.roebi.roebiapplicationcli**, target version of Java **17**, build using **no** new APIs:

```git bash
$ gradle init
Starting a Gradle Daemon, 1 busy Daemon could not be reused, use --status for details

Select type of project to generate:
  1: basic
  2: application
  3: library
  4: Gradle plugin
Enter selection (default: basic) [1..4] 2

Select implementation language:
  1: C++
  2: Groovy
  3: Java
  4: Kotlin
  5: Scala
  6: Swift
Enter selection (default: Java) [1..6] 3

Generate multiple subprojects for application? (default: no) [yes, no] yes

Select build script DSL:
  1: Kotlin
  2: Groovy
Enter selection (default: Kotlin) [1..2] 1

Project name (default: 01-06-gradle-init-kotlin-application-cli):

Source package (default: gradle.init.kotlin.application.cli): in.halter.roebi.roebiapplicationcli

Enter target version of Java (min. 7) (default: 14): 17

Generate build using new APIs and behavior (some features may change in the next minor release)? (default: no) [yes, no] no


> Task :init
To learn more about Gradle by exploring our Samples at https://docs.gradle.org/8.2.1/samples/sample_building_java_applications_multi_project.html

BUILD SUCCESSFUL in 2m
2 actionable tasks: 2 executed
```

- all the git add / git commits
- in intellij import as a gradle project: now you can start all gradle tasks from intellij in the gui

## Structure of this Gradle Kotlin Multi-Project Build

This Multi-Project Build has a **buildSrc** directory with generated Groovy settings and conventions.

The generated **application** structure is:

In the subproject / directory **app* is the main Java application.

Its main class is 'in.halter.roebi.roebiapplicationcli.app.App'.

This **app** use

- implementation of project / directory / library Java **utilities**.
- library org.apache.commons:commons-text

This **utilities** library use api of project / directory / library Java **list**.

More Information about Gradle Kotlin Multi-Project Build: [Executing Multi-Project Builds](https://docs.gradle.org/current/userguide/intro_multi_project_builds.html)

## Developing / what I have already done

before we start development let's run a few typical gradle tasks:

Hint: gradle init installs a gradle wrapper.

This means all the gradle tasks / commands can executed with **./gradlew ...*

```git bash
# shows the installed gradle version
./gradlew -version

# show the dependencies when the application is running
./gradlew app:dependencies --configuration runtimeClasspath

# show the dependencies when the application is running fot unitests (with added junit dependencies)
./gradlew app:dependencies --configuration testRuntimeClasspath

# Gradle 'main' help
./gradlew help 

# list Gradle Tasks grouped by Gradle Task group
./gradlew tasks

# Gradle command-line options
./gradlew --help 

# list detected used Java JDK
./gradlew javaToolChains

# application specific tasks:
# run the application
./gradlew run
# identical to:
./gradlew :app:run

# check / test tasks
./gradlew check
./gradlew test

# rerun unoptimized check / test
./gradlew check --rerun-tasks
```

### html generated testresults are in

... /app/build/reports/tests/test/index.html

1 Unittest

... /utilities/build/reports/tests/test/index.html

does current not exist

0 Unittest

... /list/build/reports/tests/test/index.html

4 Unittests

## continue with Developing / what I have already done

### more application specific gradle task **installDist**:

```git bash
# application specific task installDist:
# 'Installs' the project as a distribution as-is
./gradlew installDist
```

now your application is in directory

... /app/build/install in the subdirectory **app**

with a subdirectory **bin** and a subdirectory **lib**

now you can start the application in the **bin** dir with

app (linux / macOS) or app.bat (windows)

### more application specific gradle task **distZip** or **distTar**:

description is for **distZip**, **distTar** is similar:

```git bash
# application specific task distZip:
# Bundles the project as a distribution
./gradlew distZip
```
now your bundled application is in directory

... /app/build/distributions as a **app.zip** file

guess the content ?

it is 1:1 the content of ... /app/build/install

from Gradle Task **installDist**

personally i like this Gradle Application Plugin so much:

no more pain with Java Class Paths

## continue with Developing / what I have already done

up to here it was a project setup with explanations.

### following parts are missing

- (NICE to HAVE) add a bash file with all the gradle tasks
- (MUST) add dependency for easy commandline handling
- (LATER) publishing gradle publish plugin
- (LATER) gradle doctor plugin

### add the missing parts / what I have already done

#### (MUST) add dependency for easy commandline handling

...

Here's a brief intro about what a developer must do in order to start developing
the project further:

```shell
git clone https://github.com/your/awesome-project.git
cd awesome-project/
packagemanager install
```

And state what happens step-by-step.

### Building

If your project needs some additional steps for the developer to build the
project after some code changes, state them here:

```shell
./configure
make
make install
```

Here again you should state what actually happens when the code above gets
executed.

### Deploying / Publishing

In case there's some step you have to take that publishes this project to a
server, this is the right time to state it.

```shell
packagemanager deploy awesome-project -s server.com -u username -p password
```

And again you'd need to tell what the previous code actually does.

## Features

What's all the bells and whistles this project can perform?
* What's the main functionality
* You can also do another thing
* If you get really randy, you can even do this

## Configuration

Here you should write what are all of the configurations a user can enter when
using the project.

#### Argument 1
Type: `String`  
Default: `'default value'`

State what an argument does and how you can use it. If needed, you can provide
an example below.

Example:
```bash
awesome-project "Some other value"  # Prints "You're nailing this readme!"
```

#### Argument 2
Type: `Number|Boolean`  
Default: 100

Copy-paste as many of these as you need.

## Contributing

When you publish something open source, one of the greatest motivations is that
anyone can just jump in and start contributing to your project.

These paragraphs are meant to welcome those kind souls to feel that they are
needed. You should state something like:

"If you'd like to contribute, please fork the repository and use a feature
branch. Pull requests are warmly welcome."

If there's anything else the developer needs to know (e.g. the code style
guide), you should link it here. If there's a lot of things to take into
consideration, it is common to separate this section to its own file called
`CONTRIBUTING.md` (or similar). If so, you should say that it exists here.

## Links

Even though this information can be found inside the project on machine-readable
format like in a .json file, it's good to include a summary of most useful
links to humans using your project. You can include links like:

- Project homepage: https://your.github.com/awesome-project/
- Repository: https://github.com/your/awesome-project/
- Issue tracker: https://github.com/your/awesome-project/issues
  - In case of sensitive bugs like security vulnerabilities, please contact
    my@email.com directly instead of using issue tracker. We value your effort
    to improve the security and privacy of this project!
- Related projects:
  - Your other project: https://github.com/your/other-project/
  - Someone else's project: https://github.com/someones/awesome-project/


## Licensing

One really important part: Give your project a proper license. Here you should
state what the license is and how to find the text version of the license.
Something like:

"The code in this project is licensed under MIT license."
