package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Plain {
    public static String makePlain(List<Map<String, Object>> rawTree) {
        String result = rawTree.stream()
                .map(e -> {
                    List<Object> values = (List<Object>) e.get("value");
                    if (e.get("status").equals("unchanged")) {
                        return "";
                    } else if (e.get("status").equals("updated")) {
                        return "Property '" + e.get("key") + "' was updated. From "
                                + valueToString(values.get(0))
                                + " to " + valueToString(values.get(1)) + "\n";
                    } else if (e.get("status").equals("removed")) {
                        return "Property '" + e.get("key") + "' was removed\n";
                    } else {
                        return "Property '" + e.get("key") + "' was added with value: "
                                + valueToString(values.get(0)) + "\n";
                    }
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
