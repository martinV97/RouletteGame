package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileManager {

    public static List<Double> readNumbers(String path) throws IOException {
        return Files.lines(Paths.get(path))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }
}
