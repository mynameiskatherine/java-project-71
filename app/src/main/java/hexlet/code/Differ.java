package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Differ {
    public static String generate(String filePath1, String filePath2) {
        Map<String, String> json1 = getData(filePath1);
        Map<String, String> json2 = getData(filePath2);

        List<String> mergedKeys = new ArrayList<>(json1.keySet());
        for (String key : json2.keySet()) {
            if (!(json1.containsKey(key))) mergedKeys.add(key);
        }

        List<String> result = new ArrayList<>();
        mergedKeys.stream()
                .sorted()
                .map(e -> {
                    if (json1.containsKey(e) && json2.containsKey(e)) {
                        return json1.get(e).equals(json2.get(e)) ? List.of("  " + e + ": " + json1.get(e)) : List.of("- " + e + ": " + json1.get(e), "+ " + e + ": " + json2.get(e));
                    } else if (json1.containsKey(e) && !(json2.containsKey(e))) {
                        return List.of("- " + e + ": " + json1.get(e));
                    } else {
                        return List.of("+ " + e + ": " + json2.get(e));
                    }
                })
                .forEach(e -> result.addAll(e));

        return result.toString();
    }

    private static Map<String, String> getData(String filePath) {
        Path file = Paths.get(filePath).isAbsolute() ? Paths.get(filePath).normalize() : Paths.get(filePath).toAbsolutePath().normalize();
        ObjectMapper mapper = new ObjectMapper();
        try {
            String content = Files.readString(file).trim();
            return mapper.readValue(content, new TypeReference<Map<String, String>>() { });
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
