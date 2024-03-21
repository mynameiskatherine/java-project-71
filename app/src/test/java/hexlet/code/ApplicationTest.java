package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {
    static String filepathStart;
    @BeforeAll
    static void setUp() {
        filepathStart = "src/test/resources/fixtures/";
    }

    @Test
    void testDifferJsonNoFormat() throws IOException {
        String file1 = "file1.json";
        String file2 = "file2.json";
        String fileExpected = "stylishOrNoFormatResult.txt";

        String actual = Differ.generate(filepathStart + file1, filepathStart + file2);
        Path expectedFile = Paths.get(filepathStart + fileExpected).toAbsolutePath().normalize();
        String expected = new String(Files.readAllBytes(expectedFile));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testDifferJsonStylish() throws IOException {
        String file1 = "file1.json";
        String file2 = "file2.json";
        String format = "stylish";
        String fileExpected = "stylishOrNoFormatResult.txt";

        String actual = Differ.generate(filepathStart + file1, filepathStart + file2, format);
        Path expectedFile = Paths.get(filepathStart + fileExpected).toAbsolutePath().normalize();
        String expected = new String(Files.readAllBytes(expectedFile));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testDifferYamlStylish() throws IOException {
        String file1 = "file1.yml";
        String file2 = "file2.yml";
        String format = "stylish";
        String fileExpected = "stylishOrNoFormatResult.txt";

        String actual = Differ.generate(filepathStart + file1, filepathStart + file2, format);
        Path expectedFile = Paths.get(filepathStart + fileExpected).toAbsolutePath().normalize();
        String expected = new String(Files.readAllBytes(expectedFile));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testDifferJsonPlain() throws IOException {
        String file1 = "file1.json";
        String file2 = "file2.json";
        String format = "plain";
        String fileExpected = "plainFormatResult.txt";

        String actual = Differ.generate(filepathStart + file1, filepathStart + file2, format);
        Path expectedFile = Paths.get(filepathStart + fileExpected).toAbsolutePath().normalize();
        String expected = new String(Files.readAllBytes(expectedFile));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testDifferYamlPlain() throws IOException {
        String file1 = "file1.yml";
        String file2 = "file2.yml";
        String format = "plain";
        String fileExpected = "plainFormatResult.txt";

        String actual = Differ.generate(filepathStart + file1, filepathStart + file2, format);
        Path expectedFile = Paths.get(filepathStart + fileExpected).toAbsolutePath().normalize();
        String expected = new String(Files.readAllBytes(expectedFile));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testDifferJsonJson() throws IOException {
        String file1 = "file1.json";
        String file2 = "file2.json";
        String format = "json";
        String fileExpected = "jsonFormatResult.txt";

        String actual = Differ.generate(filepathStart + file1, filepathStart + file2, format);
        Path expectedFile = Paths.get(filepathStart + fileExpected).toAbsolutePath().normalize();
        String expected = new String(Files.readAllBytes(expectedFile));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testEmptyDifferStylish() {
        String file1 = "fileEmpty1.json";
        String file2 = "fileEmpty2.json";
        String format = "stylish";
        String expected = "{\n}";

        String actual = Differ.generate(filepathStart + file1, filepathStart + file2, format);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testEmptyDifferPlain() {
        String file1 = "fileEmpty1.json";
        String file2 = "fileEmpty2.json";
        String format = "plain";
        String expected = "";

        String actual = Differ.generate(filepathStart + file1, filepathStart + file2, format);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testDifferNoExtStylish() {
        String file1 = "fileNoExtension1";
        String file2 = "fileNoExtension2";
        String format = "stylish";
        String expected = "{\n}";

        String actual = Differ.generate(filepathStart + file1, filepathStart + file2, format);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testDifferNoExtPlain() {
        String file1 = "fileNoExtension1";
        String file2 = "fileNoExtension2";
        String format = "plain";
        String expected = "";

        String actual = Differ.generate(filepathStart + file1, filepathStart + file2, format);

        assertThat(actual).isEqualTo(expected);
    }
}
