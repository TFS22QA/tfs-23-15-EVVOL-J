package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public static List<String> getLinesFromFile(final String fileName) {
        List<String> list = new ArrayList<>();
        try {
            list = Files.readAllLines(new File("src/main/resources/" + fileName).toPath());
        } catch (IOException e) {
        }
        return list;
    }
}
