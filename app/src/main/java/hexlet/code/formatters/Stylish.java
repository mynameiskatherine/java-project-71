package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stylish {
    public static String makeStylish(List<Map<String, Object>> rawTree) {
        String result = rawTree.stream()
                .map(e -> {
                    List<Object> values = (List<Object>) e.get("value");
                    if (e.get("status").equals("unchanged")) {
                        return "    " + e.get("key") + ": " + values.get(0) + "\n";
                    } else if (e.get("status").equals("updated")) {
                        return "  - " + e.get("key") + ": " + values.get(0) + "\n"
                                + "  + " + e.get("key") + ": " + values.get(1) + "\n";
                    } else if (e.get("status").equals("removed")) {
                        return "  - " + e.get("key") + ": " + values.get(0) + "\n";
                    } else {
                        return "  + " + e.get("key") + ": " + values.get(0) + "\n";
                    }
                })
                .collect(Collectors.joining());

        return "{\n" + result + "}";
    }
}
