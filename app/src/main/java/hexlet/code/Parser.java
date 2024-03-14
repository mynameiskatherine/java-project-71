package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class Parser {

    public static Map<String, Object> parse(Map<String, String> fileTypeAndContent) {
        String fileType = fileTypeAndContent.get("fileType");
        String content = fileTypeAndContent.get("content");
        Map<String, Object> result = new HashMap<>();

        try {
            result = switch (fileType) {
                case "json" ->
                        new ObjectMapper().readValue(content, new TypeReference<Map<String, Object>>() { });
                case "yml" ->
                        new YAMLMapper().readValue(content, new TypeReference<Map<String, Object>>() { });
                default -> result;
            };
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return result;
    }
}
