package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public final class Formatter {
    public static String format(List<Map<String, Object>> rawTree, String selectedFormat) {

        try {
            switch (selectedFormat) {
                case ("stylish") -> {
                    return Stylish.makeStylish(rawTree);
                }
                case ("plain") -> {
                    return Plain.makePlain(rawTree);
                }
                case ("json") -> {
                    return Json.makeJson(rawTree);
                }
                default -> {
                    throw new RuntimeException("No such format found");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
