# Structure for creating a CLI Java app (with initial tests)

Hello CodeClubbers! I created this with a bit of experimentation with Maven in Java. If you're aiming to put together an app in Java to solve our [monthly coding challenges](https://shwcodingclub.github.io/) then you can use this 'archetype' to get started!

## Prerequisites

You'll need:

 - Java
 - [Apache Maven](https://maven.apache.org/install.html)
 - _Git_ (or just download the [zip](https://github.com/andrewbaxter439/codeclub-archetype/archive/refs/heads/main.zip))

## Installation

To get started, clone this repo, cd into it then use `mvn install` to make it available for your project-building:

```shell
git clone https://github.com/andrewbaxter439/codeclub-archetype.git

cd codeclub-archetype

mvn install
```

## Start a new project

In your root folder, use your newly installed maven archetype to make a new project. Under `artifactId` give your project a name and under `appName` give the name of the main class. For example for the `java_testcool` project and the `TestCool` app:

```shell
mvn archetype:generate                     \
  -DarchetypeGroupId=com.codeclub          \
  -DarchetypeArtifactId=codeclub-archetype \
  -DgroupId=com.codeclub                   \
  -DartifactId=java_testcool               \
  -Dapp_name=TestCool
```

In Windows Powershell, the arguments must be in quotation marks:

```shell
mvn archetype:generate                       \
  "-DarchetypeGroupId=com.codeclub"          \
  "-DarchetypeArtifactId=codeclub-archetype" \
  "-DgroupId=com.codeclub"                   \
  "-DartifactId=java_testcool"               \
  "-Dapp_name=TestCool"
```

This creates a new project directory with the following structure:

```
│   pom.xml
│
└───src
    ├───main
    │   └───java
    │       └───com
    │           └───codeclub
    │                   TestCool.java
    │
    └───test
        └───java
            └───com
                └───codeclub
                        TestCoolTest.java
```

Open in your favourite IDE to get started! I use [IntelliJ IDEA](https://www.jetbrains.com/community/education/#students/)

## Testing and building

To run the tests you've created in `src/test/[AppNameTest].java`:

```shell
mvn test 
```

To build and run your app run `mvn package` which will create the `target\[artifactId]-[version]-jar-with-dependencies.jar` file then run with java:

```shell
$ java -jar target/java_testcoolapp-1.0.0-jar-with-dependencies.jar -h
Usage: TestCoolApp [-h]
A handy, dandy app for doing whatever you like
  -h, --help   display a help message
```