package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stylish {
    public static String makeStylish(Map<Map<String, String>, List<Object>> map) {
        String result = map.keySet().stream()
                .map(e -> {
                    List<Object> values = map.get(e);
                    return e.entrySet().stream()
                            .map(i -> {
                                if (i.getValue().equals("unchanged")) {
                                    return "    " + i.getKey() + ": " + values.get(0) + "\n";
                                } else if (i.getValue().equals("updated")) {
                                    return "  - " + i.getKey() + ": " + values.get(0) + "\n"
                                            + "  + " + i.getKey() + ": " + values.get(1) + "\n";
                                } else if (i.getValue().equals("removed")) {
                                    return "  - " + i.getKey() + ": " + values.get(0) + "\n";
                                } else {
                                    return "  + " + i.getKey() + ": " + values.get(0) + "\n";
                                }
                            })
                            .collect(Collectors.joining());
                })
                .collect(Collectors.joining());
        return "{\n" + result + "}";
    }
}
