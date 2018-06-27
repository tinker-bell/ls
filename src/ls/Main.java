package ls;

import java.io.File;
import java.io.IOException;

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

            String result = ls.getList(isReverse, isLong, isHumanReadable);

            if (!isOutput) {
                System.out.println(result);
            } else {
                utils.writeToFile(outputFile, result);
                System.out.println("Result saved in file " + outputFile);
            }

        } catch (ParseException ex) {
            System.out.println("Unexpected exception:" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Exception while writing to file:" + ex.getMessage());
        }
    }
}
