package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {
    @Test
    void testMain() {
        String filepath1 = "/home/kate/Projects/java-project-71/app/src/test/resources/file1.json";
        String filepath2 = "/home/kate/Projects/java-project-71/app/src/test/resources/file2.json";
        String expected = "- follow: false\n"
                + "  host: hexlet.io\n"
                + "- proxy: 123.234.53.22\n"
                + "- timeout: 50\n"
                + "+ timeout: 20\n"
                + "+ verbose: true";
        String actual = Differ.generate(filepath1, filepath2);
        assertThat(actual).isEqualTo(expected);
    }
}
