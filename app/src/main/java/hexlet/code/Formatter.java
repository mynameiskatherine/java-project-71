package hexlet.code;

import java.util.Map;
import java.util.stream.Collectors;

public class Formatter {
    public static String format(Map<Map<String, Object>, String> text, String selectedFormat) {

        if (selectedFormat.equals("stylish")) {
            String result = text.keySet().stream()
                            .map(e -> {
                                String status = text.get(e);
                                String entry = e.entrySet().stream()
                                        .map(i -> i.getKey() + ": " + i.getValue())
                                        .collect(Collectors.joining());
                                return  "  " + status + " " + entry + "\n";
                            })
                    .collect(Collectors.joining());
            return "{\n" + result + "}";
        } else {
            return text.toString().trim();
        }
    }
}

