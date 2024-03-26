package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Plain {
    public static String makePlain(List<Map<String, Object>> rawTree) {
        String result = rawTree.stream()
                .map(e -> {
                    StringBuilder stringBuilder = new StringBuilder("Property '");
                    switch ((String) e.get("type")) {
                        case ("unchanged") -> {
                            return "";
                        }
                        case ("updated") -> {
                            stringBuilder.append(e.get("key")).append("' was updated. From ")
                                    .append(valueToString(e.get("__value1"))).append(" to ")
                                    .append(valueToString(e.get("__value2"))).append("\n");
                            return stringBuilder.toString();
                        }
                        case ("removed") -> {
                            stringBuilder.append(e.get("key")).append("' was removed\n");
                            return stringBuilder.toString();
                        }
                        case ("added") -> {
                            stringBuilder.append(e.get("key")).append("' was added with value: ")
                                    .append(valueToString(e.get("__value2"))).append("\n");
                            return stringBuilder.toString();
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
