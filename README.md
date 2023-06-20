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

In your root folder, use your newly installed maven archetype to make a new project. Under `artifactId` give your project a name and under `app_name` give the name of the main class. For example for the `java_testcool` project and the `TestCool` app:

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

## Passing arguments

This app structure uses the beautiful [picocli](https://picocli.info/) command line interface argument parser. You can create arguments for your application to accept in the App class:

```java
@Command(name = "TestCoolApp", description = "A handy, dandy app for doing whatever you like")
public class TestCoolApp {

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "display a help message")
    private boolean helpRequested = false;

    @Option(names = {"-n", "--name"}, description = "Pass a name")
    private String name;

    @Option(names = {"-c", "--count"}, description = "A number")
    private Integer count;

    @Parameters(index = "0", description = "A file to read")
    private File input_file;
    //...
}
```

Which are then parsed in the `main()` class:

```java
    public static void main( String[] args )
    {
        TestCoolApp init_app = new TestCoolApp();

        new CommandLine(init_app).parseArgs(args);

        if (init_app.helpRequested | args.length == 0) {
            CommandLine.usage(new TestCoolApp(), System.out);
            return;
        }
        init_app.run();  // the run() method is your application, which can access all the declared arguments
    }
```

And requesting help can then tell your user what to do:

```shell
$ java -jar target/java_testcoolapp-1.0.0-jar-with-dependencies.jar -h
Usage: TestCoolApp [-h] [-c=<count>] [-n=<name>] <input_file>
A handy, dandy app for doing whatever you like
      <input_file>      A file to read
  -c, --count=<count>   A number
  -h, --help            display a help message
  -n, --name=<name>     Pass a name
```