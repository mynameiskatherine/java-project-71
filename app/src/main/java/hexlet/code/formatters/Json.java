package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Json {
    public static String makeJson(List<Map<String, Object>> rawTree) {
        Map<String, Map<String, Object>> result = new LinkedHashMap<>();
        rawTree.forEach(e -> {
            List<Object> values = (List<Object>) e.get("value");
            Map<String, Object> jsonValues = new LinkedHashMap<>();
            switch ((String) e.get("status")) {
                case "unchanged" -> {
                    jsonValues.put("__v1", values.get(0));
                    jsonValues.put("__v2", values.get(0));
                }
                case "updated" -> {
                    jsonValues.put("__v1", values.get(0));
                    jsonValues.put("__v2", values.get(1));
                }
                case "removed" -> jsonValues.put("__v1", values.get(0));
                case "added" -> jsonValues.put("__v2", values.get(0));
                default -> throw new IllegalStateException("Unexpected value: " + e.get("status"));
            }
            result.put((String) e.get("key"), jsonValues);
        });

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
