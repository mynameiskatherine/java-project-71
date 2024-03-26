package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationYmlTests {

    private static String filepathStart;
    private static String file1;
    private static String file2;

    private static Path makePath(String fileName) {
        return Paths.get(filepathStart + fileName).toAbsolutePath().normalize();
    }
    @BeforeAll
    static void setUp() {
        filepathStart = "src/test/resources/fixtures/";
        file1 = makePath("file1.yml").toString();
        file2 = makePath("file2.yml").toString();
    }

    @Test
    void testDifferYamlNoFormat() throws IOException {
        String fileExpected = "stylishOrNoFormatResult.txt";

        String actual = Differ.generate(file1, file2);
        String expected = new String(Files.readAllBytes(makePath(fileExpected)));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testDifferYamlStylish() throws IOException {
        String format = "stylish";
        String fileExpected = "stylishOrNoFormatResult.txt";

        String actual = Differ.generate(file1, file2, format);
        String expected = new String(Files.readAllBytes(makePath(fileExpected)));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testDifferYamlPlain() throws IOException {
        String format = "plain";
        String fileExpected = "plainFormatResult.txt";

        String actual = Differ.generate(file1, file2, format);
        String expected = new String(Files.readAllBytes(makePath(fileExpected)));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testDifferYamlJson() throws IOException {
        String format = "json";
        String fileExpected = "jsonFormatResult.txt";

        String actual = Differ.generate(file1, file2, format);
        String expected = new String(Files.readAllBytes(makePath(fileExpected)));

        assertThat(actual).isEqualTo(expected);
    }

}
