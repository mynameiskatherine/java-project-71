package hexlet.code;

import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2) {
        String format = "stylish";
        return Differ.generate(filepath1, filepath2, format);
    }

    public static String generate(String filepath1, String filepath2, String format) {
        Map<String, Object> file1 = Parser.parse(getFileData(filepath1));
        Map<String, Object> file2 = Parser.parse(getFileData(filepath2));

        List<Map<String, Object>> rawTree = Tree.build(file1, file2);
        return Formatter.format(rawTree, format);
    }

    private static Map<String, String> getFileData(String filepath) {
        Map<String, String> fileData = new HashMap<>();
        try {
            String fileType = FilenameUtils.getExtension(filepath);
            Path file = Paths.get(filepath).toAbsolutePath().normalize();
            String content = Files.readString(file).trim();
            fileData.put("fileType", fileType);
            fileData.put("content", content);
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return fileData;
    }

}
