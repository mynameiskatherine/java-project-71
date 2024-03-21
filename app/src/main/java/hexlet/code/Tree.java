package hexlet.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class Tree {
    public static List<Map<String, Object>> build(Map<String, Object> file1, Map<String, Object> file2) {
        Set<String> mergedKeys = new HashSet<>(file1.keySet());
        mergedKeys.addAll(file2.keySet());

        List<Map<String, Object>> result = new ArrayList<>();

        mergedKeys.stream()
                .sorted()
                .forEach(e -> {
                    Map<String, Object> unit = new LinkedHashMap<>();
                    unit.put("key", e);
                    if (file1.containsKey(e) && file2.containsKey(e)) {
                        if (Objects.deepEquals(file1.get(e), file2.get(e))) {
                            unit.put("status", "unchanged");
                            unit.put("__value", file1.get(e));
                        } else {
                            unit.put("status", "updated");
                            unit.put("__value1", file1.get(e));
                            unit.put("__value2", file2.get(e));
                        }
                    } else if (file1.containsKey(e) && !(file2.containsKey(e))) {
                        unit.put("status", "removed");
                        unit.put("__value1", file1.get(e));
                    } else {
                        unit.put("status", "added");
                        unit.put("__value2", file2.get(e));
                    }
                    result.add(unit);
                });
        return result;
    }
}
