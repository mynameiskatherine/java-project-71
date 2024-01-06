package hexlet.code;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Differ {
    public static Map<Map<String, Object>, String> generate(String filePath1, String filePath2) {
        Map<String, Object> file1 = Parser.parse(filePath1);
        Map<String, Object> file2 = Parser.parse(filePath2);

        Map<Map<String, Object>, String> result = new LinkedHashMap<>();

        Set<String> mergedKeys = new HashSet<>();
        mergedKeys.addAll(file1.keySet());
        mergedKeys.addAll(file2.keySet());

        if (mergedKeys.isEmpty()) {
            return result;
        }
        mergedKeys.stream()
                .sorted()
                .map(e -> {
                    Map<Map<String, Object>, String> diffMap = new LinkedHashMap<>();
                    Map<String, Object> nestedMap = new LinkedHashMap<>();
                    if (file1.containsKey(e) && file2.containsKey(e)) {
                        if (Objects.deepEquals(file1.get(e), file2.get(e))) {
                            nestedMap.put(e, file1.get(e));
                            diffMap.put(new LinkedHashMap<>(nestedMap), " ");
                        } else {
                            nestedMap.put(e, file1.get(e));
                            diffMap.put(new LinkedHashMap<>(nestedMap), "-");
                            nestedMap.put(e, file2.get(e));
                            diffMap.put(new LinkedHashMap<>(nestedMap), "+");
                        }
                    } else if (file1.containsKey(e) && !(file2.containsKey(e))) {
                        nestedMap.put(e, file1.get(e));
                        diffMap.put(new LinkedHashMap<>(nestedMap), "-");
                    } else {
                        nestedMap.put(e, file2.get(e));
                        diffMap.put(new LinkedHashMap<>(nestedMap), "+");
                    }
                    return diffMap;
                })
                .forEach(e -> result.putAll(e));
        return result;
    }
}
