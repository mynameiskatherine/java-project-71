package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {
    @Test
    void testDifferJsonStylish() {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";
        String format = "stylish";
        String expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        String actual = Differ.generate(filepath1, filepath2, format);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testEmptyDifferStylish() {
        String filepath1 = "src/test/resources/fileEmpty1.json";
        String filepath2 = "src/test/resources/fileEmpty2.json";
        String format = "stylish";
        String expected = "{\n}";
        String actual = Differ.generate(filepath1, filepath2, format);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testDifferYamlStylish() {
        String filepath1 = "src/test/resources/file1.yml";
        String filepath2 = "src/test/resources/file2.yml";
        String format = "stylish";
        String expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        String actual = Differ.generate(filepath1, filepath2, format);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testDifferNoExtStylish() {
        String filepath1 = "src/test/resources/fileNoExtension1";
        String filepath2 = "src/test/resources/fileNoExtension2";
        String format = "stylish";
        String expected = "{\n}";
        String actual = Differ.generate(filepath1, filepath2, format);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testDifferJsonPlain() {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";
        String format = "plain";
        String expected = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";
        String actual = Differ.generate(filepath1, filepath2, format);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testEmptyDifferPlain() {
        String filepath1 = "src/test/resources/fileEmpty1.json";
        String filepath2 = "src/test/resources/fileEmpty2.json";
        String format = "plain";
        String expected = "";
        String actual = Differ.generate(filepath1, filepath2, format);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testDifferYamlPlain() {
        String filepath1 = "src/test/resources/file1.yml";
        String filepath2 = "src/test/resources/file2.yml";
        String format = "plain";
        String expected = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";
        String actual = Differ.generate(filepath1, filepath2, format);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testDifferNoExtPlain() {
        String filepath1 = "src/test/resources/fileNoExtension1";
        String filepath2 = "src/test/resources/fileNoExtension2";
        String format = "plain";
        String expected = "";
        String actual = Differ.generate(filepath1, filepath2, format);
        assertThat(actual).isEqualTo(expected);
    }
}
