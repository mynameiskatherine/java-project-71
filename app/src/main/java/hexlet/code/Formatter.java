package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(Map<Map<String, String>, List<Object>> map, String selectedFormat) {

        try {
            if (selectedFormat.equals("stylish")) {
                return Stylish.makeStylish(map);
            } else if (selectedFormat.equals("plain")) {
                return Plain.makePlain(map);
            } else if (selectedFormat.equals("json")) {
                return Json.makeJson(map);
            } else {
                return map.toString().trim();
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
