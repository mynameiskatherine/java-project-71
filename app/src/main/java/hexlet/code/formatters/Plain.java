package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Plain {
    public static String makePlain(List<Map<String, Object>> rawTree) {
        String result = rawTree.stream()
                .map(e -> {
                    switch ((String) e.get("status")) {
                        case ("unchanged") -> {
                            return "";
                        }
                        case ("updated") -> {
                            return "Property '" + e.get("key") + "' was updated. From "
                                    + valueToString(e.get("__value1")) + " to "
                                    + valueToString(e.get("__value2")) + "\n";
                        }
                        case ("removed") -> {
                            return "Property '" + e.get("key") + "' was removed\n";
                        }
                        case ("added") -> {
                            return "Property '" + e.get("key") + "' was added with value: "
                                    + valueToString(e.get("__value2")) + "\n";
                        }
                        default -> throw new RuntimeException("no status found");
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
