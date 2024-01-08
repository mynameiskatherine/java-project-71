package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Json {
    public static String makeJson(Map<Map<String, String>, List<Object>> map) {
        Map<String, Map<String, Object>> result = new LinkedHashMap<>();
        map.keySet().forEach(e -> {
            List<Object> values = map.get(e);
            e.entrySet().stream()
                            .map(i -> {
                                Map<String, Object> jsonValues = new LinkedHashMap<>();
                                switch (i.getValue()) {
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
                                    default -> throw new IllegalStateException("Unexpected value: " + i.getValue());
                                }
                                return Map.of(i.getKey(), jsonValues);
                            })
                            .forEach(result::putAll);
        });
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
