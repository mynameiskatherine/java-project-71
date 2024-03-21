package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Stylish {
    private static final String STRINGSTARTNEUTRAL = "    ";
    private static final String STRINGSTARTPOSITIVE = "  + ";
    private static final String STRINGSTARTNEGATIVE = "  - ";
    private static final String STRINGDIVIDER = ": ";

    private static String constructString(String stringStart, Object key, Object value) {
        return stringStart + key + STRINGDIVIDER + value + "\n";
    }

    public static String makeStylish(List<Map<String, Object>> rawTree) {
        String result = rawTree.stream()
                .map(e -> {
                    switch ((String) e.get("status")) {
                        case ("unchanged") -> {
                            return constructString(STRINGSTARTNEUTRAL, e.get("key"), e.get("__value"));
                        }
                        case ("updated") -> {
                            return constructString(STRINGSTARTNEGATIVE, e.get("key"), e.get("__value1"))
                                    + constructString(STRINGSTARTPOSITIVE, e.get("key"),  e.get("__value2"));
                        }
                        case ("removed") -> {
                            return constructString(STRINGSTARTNEGATIVE, e.get("key"), e.get("__value1"));
                        }
                        case ("added") -> {
                            return constructString(STRINGSTARTPOSITIVE, e.get("key"),  e.get("__value2"));
                        }
                        default -> throw new RuntimeException("no status found");
                    }
                })
                .collect(Collectors.joining());

        return "{\n" + result + "}";
    }
}
