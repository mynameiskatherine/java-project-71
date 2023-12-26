package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {

    @Parameters(paramLabel = "filePath1", description = "path to first file")
    private String filePath1;
    @Parameters(paramLabel = "filePath2", description = "path to second file")
    private String filePath2;

    @Option(names = { "-f", "--format" }, defaultValue = "stylish", description = "output format [default: stylish]")
    private String format = "stylish";

    @Override
    public void run() {
        try {
            System.out.println(Differ.generate(filePath1, filePath2));
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
