package utils;

import java.io.*;
import java.util.*;

public class FileUtils {
    public static List<String> readMoviesFromFile(String filePath) {
        List<String> movies = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                movies.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
