package ls;

import java.io.File;

import org.apache.commons.cli.*;

public class Main {

    public static void main(String[] args) {
        CommandLineParser parser = new DefaultParser();

        Options options = new Options();
        options.addOption("l", "long", false,
                "Print files in long format");
        options.addOption("h", "human-readable", false,
                "Print files in human-readable formant");
        options.addOption("r", "reverse", false,
                "Prints files names in descending order.");
        options.addOption("o", "output", true,
                "Output file name");

        Boolean isLong = false;
        Boolean isHumanReadable = false;
        Boolean isReverse = false;
        Boolean isOutput = false;
        String outputFile = "";

        try {
            CommandLine cmdLine = parser.parse(options, args);

            isLong = cmdLine.hasOption("long");
            isHumanReadable = cmdLine.hasOption("human-readable");
            isReverse = cmdLine.hasOption("reverse");
            if (cmdLine.hasOption("output")) {
                isOutput = true;
                outputFile = cmdLine.getOptionValue("output");
            }

            String root = cmdLine.getArgs().length == 1 ? cmdLine.getArgs()[0] : ".";

            File rootFile = new File(root);
            FilesList ls = new FilesList(rootFile);

            if (!isOutput) {
                System.out.println(ls.getList(isReverse, isLong, isHumanReadable));
            } else {
                System.out.println("TODO: implement file output");
            }

        } catch (ParseException exp) {
            System.out.println("Unexpected exception:" + exp.getMessage());
        }
    }
}
