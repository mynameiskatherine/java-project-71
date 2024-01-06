package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.apache.commons.io.FilenameUtils;

public class Parser {

    public static Map<String, Object> parse(String filePath) {
        String fileType = FilenameUtils.getExtension(filePath);
        Path file = Paths.get(filePath).toAbsolutePath().normalize();
        Map<String, Object> result = new HashMap<>();

        if (Objects.equals(fileType, "json")) {
            result = parseJson(file);
        } else if (Objects.equals(fileType, "yml")) {
            result = parseYaml(file);
        }
        return result;
    }
    private static Map<String, Object> parseJson(Path filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String content = Files.readString(filePath).trim();
            return mapper.readValue(content, new TypeReference<Map<String, Object>>() { });
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private static Map<String, Object> parseYaml(Path filePath) {
        ObjectMapper mapper = new YAMLMapper();
        try {
            String content = Files.readString(filePath).trim();
            return mapper.readValue(content, new TypeReference<Map<String, Object>>() { });
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
