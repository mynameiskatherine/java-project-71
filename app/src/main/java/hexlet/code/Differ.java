package hexlet.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Differ {

    public static Map<Map<String, String>, List<Object>> generate(String filepath1, String filepath2) {
        Map<String, Object> file1 = Parser.parse(filepath1);
        Map<String, Object> file2 = Parser.parse(filepath2);

        Map<Map<String, String>, List<Object>> result = new LinkedHashMap<>();
        Set<String> mergedKeys = new HashSet<>(file1.keySet());
        mergedKeys.addAll(file2.keySet());

        mergedKeys.stream()
                .sorted()
                .map(e -> {
                    Map<Map<String, String>, List<Object>> diffMap = new LinkedHashMap<>();
                    List<Object> valueList = new ArrayList<>();
                    if (file1.containsKey(e) && file2.containsKey(e)) {
                        if (Objects.deepEquals(file1.get(e), file2.get(e))) {
                            valueList.add(file1.get(e));
                            diffMap.put(Map.of(e, "unchanged"), valueList);
                        } else {
                            valueList.add(file1.get(e));
                            valueList.add(file2.get(e));
                            diffMap.put(Map.of(e, "updated"), valueList);
                        }
                    } else if (file1.containsKey(e) && !(file2.containsKey(e))) {
                        valueList.add(file1.get(e));
                        diffMap.put(Map.of(e, "removed"), valueList);
                    } else {
                        valueList.add(file2.get(e));
                        diffMap.put(Map.of(e, "added"), valueList);
                    }
                    return diffMap;
                })
                .forEach(result::putAll);
        return result;
    }

    public static String generate(String filepath1, String filepath2, String format) {
        return Formatter.format(Differ.generate(filepath1, filepath2), format);
    }
}
