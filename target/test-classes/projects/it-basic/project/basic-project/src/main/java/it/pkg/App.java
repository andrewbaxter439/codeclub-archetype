package it.pkg;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;


@Command(name = "App", description = "A handy, dandy app for doing whatever you like")
public class App
{

    @Option(names = { "-h", "--help" }, usageHelp = true, description = "display a help message")
    private boolean helpRequested = false;



    public static void main( String[] args )
    {
        App init_app = new App();

        new CommandLine(init_app).parseArgs(args);

        if (init_app.helpRequested | args.length == 0) {
            CommandLine.usage(new App(), System.out);
            return;
        }
        init_app.run();
    }

    public static void run() {
        System.out.println( "Hello World!" );
    }
}
