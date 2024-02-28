package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, Object>> rawTree, String selectedFormat) {

        try {
            if (selectedFormat.equals("stylish")) {
                return Stylish.makeStylish(rawTree);
            } else if (selectedFormat.equals("plain")) {
                return Plain.makePlain(rawTree);
            } else if (selectedFormat.equals("json")) {
                return Json.makeJson(rawTree);
            } else {
                return rawTree.toString().trim();
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
