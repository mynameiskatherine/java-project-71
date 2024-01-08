package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.apache.commons.io.FilenameUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Parser {

    public static Map<String, Object> parse(String filepath) {
        String fileType = FilenameUtils.getExtension(filepath);
        Path file = Paths.get(filepath).toAbsolutePath().normalize();
        Map<String, Object> result = new HashMap<>();

        if (Objects.equals(fileType, "json")) {
            ObjectMapper mapper = new ObjectMapper();
            result = parseJsonYaml(file, mapper);
        } else if (Objects.equals(fileType, "yml")) {
            ObjectMapper mapper = new YAMLMapper();
            result = parseJsonYaml(file, mapper);
        }
        return result;
    }
    private static Map<String, Object> parseJsonYaml(Path filepath, ObjectMapper mapper) {
        try {
            String content = Files.readString(filepath).trim();
            return mapper.readValue(content, new TypeReference<Map<String, Object>>() { });
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
