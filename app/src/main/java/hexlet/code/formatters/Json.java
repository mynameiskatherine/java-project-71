package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public final class Json {
    public static String makeJson(List<Map<String, Object>> rawTree) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rawTree);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
