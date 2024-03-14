package hexlet.code;

import java.util.ArrayList;
import java.util.HashSet;
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
                    List<Object> valueList = new ArrayList<>();
                    if (file1.containsKey(e) && file2.containsKey(e)) {
                        if (Objects.deepEquals(file1.get(e), file2.get(e))) {
                            valueList.add(file1.get(e));
                            result.add(Map.of("key", e, "status", "unchanged", "value", valueList));
                        } else {
                            valueList.add(file1.get(e));
                            valueList.add(file2.get(e));
                            result.add(Map.of("key", e, "status", "updated", "value", valueList));
                        }
                    } else if (file1.containsKey(e) && !(file2.containsKey(e))) {
                        valueList.add(file1.get(e));
                        result.add(Map.of("key", e, "status", "removed", "value", valueList));
                    } else {
                        valueList.add(file2.get(e));
                        result.add(Map.of("key", e, "status", "added", "value", valueList));
                    }
                });
        return result;
    }
}
