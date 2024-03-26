package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationJsonTests {

    private static String filepathStart;
    private static String file1;
    private static String file2;

    private static Path makePath(String fileName) {
        return Paths.get(filepathStart + fileName).toAbsolutePath().normalize();
    }
    @BeforeAll
    static void setUp() {
        filepathStart = "src/test/resources/fixtures/";
        file1 = makePath("file1.json").toString();
        file2 = makePath("file2.json").toString();
    }

    @Test
    void testDifferJsonNoFormat() throws IOException {
        String fileExpected = "stylishOrNoFormatResult.txt";

        String actual = Differ.generate(file1, file2);
        String expected = new String(Files.readAllBytes(makePath(fileExpected)));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testDifferJsonStylish() throws IOException {
        String format = "stylish";
        String fileExpected = "stylishOrNoFormatResult.txt";

        String actual = Differ.generate(file1, file2, format);
        String expected = new String(Files.readAllBytes(makePath(fileExpected)));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testDifferJsonPlain() throws IOException {
        String format = "plain";
        String fileExpected = "plainFormatResult.txt";

        String actual = Differ.generate(file1, file2, format);
        String expected = new String(Files.readAllBytes(makePath(fileExpected)));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testDifferJsonJson() throws IOException {
        String format = "json";
        String fileExpected = "jsonFormatResult.txt";

        String actual = Differ.generate(file1, file2, format);
        String expected = new String(Files.readAllBytes(makePath(fileExpected)));

        assertThat(actual).isEqualTo(expected);
    }
}
