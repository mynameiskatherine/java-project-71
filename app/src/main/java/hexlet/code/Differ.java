package hexlet.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Differ {
    public static String generate(String filePath1, String filePath2) {
        Map<String, String> file1 = Parser.parse(filePath1);
        Map<String, String> file2 = Parser.parse(filePath2);
        Set<String> mergedKeys = new HashSet<>();
        mergedKeys.addAll(file1.keySet());
        mergedKeys.addAll(file2.keySet());
        String resultString = "";
        if (mergedKeys.isEmpty()) {
            return resultString;
        }

        List<String> resultList = new ArrayList<>();
        mergedKeys.stream()
                .sorted()
                .map(e -> {
                    if (file1.containsKey(e) && file2.containsKey(e)) {
                        if (file1.get(e).equals(file2.get(e))) {
                            return List.of("  " + e + ": " + file1.get(e));
                        } else {
                            return List.of("- " + e + ": " + file1.get(e), "+ " + e + ": " + file2.get(e));
                        }
                    } else if (file1.containsKey(e) && !(file2.containsKey(e))) {
                        return List.of("- " + e + ": " + file1.get(e));
                    } else {
                        return List.of("+ " + e + ": " + file2.get(e));
                    }
                })
                .forEach(resultList::addAll);

        for (String str : resultList) {
            resultString = resultString + str + "\n";
        }
        return resultString.trim();
    }
}
