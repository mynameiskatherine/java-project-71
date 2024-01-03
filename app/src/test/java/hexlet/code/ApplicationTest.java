package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {
    @Test
    void testDifferJson() {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";
        String expected = "- follow: false\n"
                + "  host: hexlet.io\n"
                + "- proxy: 123.234.53.22\n"
                + "- timeout: 50\n"
                + "+ timeout: 20\n"
                + "+ verbose: true";
        String actual = Differ.generate(filepath1, filepath2);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testEmptyDiffer() {
        String filepath1 = "src/test/resources/fileEmpty1.json";
        String filepath2 = "src/test/resources/fileEmpty2.json";
        String expected = "";
        String actual = Differ.generate(filepath1, filepath2);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testDifferYaml() {
        String filepath1 = "src/test/resources/fileYml1.yml";
        String filepath2 = "src/test/resources/fileYml2.yml";
        String expected = "- follow: false\n"
                + "  host: hexlet.io\n"
                + "- proxy: 123.234.53.22\n"
                + "- timeout: 50\n"
                + "+ timeout: 20\n"
                + "+ verbose: true";
        String actual = Differ.generate(filepath1, filepath2);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testDifferNoExt() {
        String filepath1 = "src/test/resources/fileNoExtension1";
        String filepath2 = "src/test/resources/fileNoExtension2";
        String expected = "";
        String actual = Differ.generate(filepath1, filepath2);
        assertThat(actual).isEqualTo(expected);
    }

}
