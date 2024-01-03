package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.apache.commons.io.FilenameUtils;

public class Parser {

    public static Map<String,String> parse(String filePath) {
        String fileType = FilenameUtils.getExtension(filePath);
        Path file = Paths.get(filePath).toAbsolutePath().normalize();

        if (fileType.equals("yml")) {
            ObjectMapper mapper = new YAMLMapper();
            try {
                String content = Files.readString(file).trim();
                return mapper.readValue(content, new TypeReference<Map<String, String>>() { });
            } catch (Exception e) {
                throw new RuntimeException();
            }
        } else if (fileType.equals("json")) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                String content = Files.readString(file).trim();
                return mapper.readValue(content, new TypeReference<Map<String, String>>() { });
            } catch (Exception e) {
                throw new RuntimeException();
            }
        } else {
            return new HashMap<>();
        }
    }
}
