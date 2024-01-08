package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Plain {
    public static String makePlain(Map<Map<String, String>, List<Object>> map) {
        String result = map.keySet().stream()
                .map(e -> {
                    List<Object> values = map.get(e);
                    return e.entrySet().stream()
                            .map(i -> {
                                if (i.getValue().equals("unchanged")) {
                                    return "";
                                } else if (i.getValue().equals("updated")) {
                                    return "Property '" + i.getKey() + "' was updated. From "
                                            + valueToString(values.get(0))
                                            + " to " + valueToString(values.get(1)) + "\n";
                                } else if (i.getValue().equals("removed")) {
                                    return "Property '" + i.getKey() + "' was removed\n";
                                } else {
                                    return "Property '" + i.getKey() + "' was added with value: "
                                            + valueToString(values.get(0)) + "\n";
                                }
                            })
                            .collect(Collectors.joining());
                })
                .collect(Collectors.joining());
        return result.trim();
    }

    private static String valueToString(Object value) {
        if (value == null) {
            return "null";
        } else if (value instanceof Number || value instanceof Boolean) {
            return value.toString();
        } else if (value instanceof CharSequence) {
            return "'" + value + "'";
        } else {
            return "[complex value]";
        }
    }
}
