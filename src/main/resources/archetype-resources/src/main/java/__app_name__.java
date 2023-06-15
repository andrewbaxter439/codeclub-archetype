package $package;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;


@Command(name = "${app_name}", description = "${description}")
public class ${app_name}
{

    @Option(names = { "-h", "--help" }, usageHelp = true, description = "display a help message")
    private boolean helpRequested = false;



    public static void main( String[] args )
    {
        ${app_name} init_app = new ${app_name}();

        new CommandLine(init_app).parseArgs(args);

        if (init_app.helpRequested | args.length == 0) {
            CommandLine.usage(new ${app_name}(), System.out);
            return;
        }
        init_app.run();
    }

    public static void run() {
        System.out.println( "Hello World!" );
    }
}
