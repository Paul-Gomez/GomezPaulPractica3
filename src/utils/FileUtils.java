package utils;

import java.io.*;
import java.util.*;

public class FileUtils {
    // Método estático que lee una lista de películas desde un archivo
    public static List<String> readMoviesFromFile(String filePath) {
        List<String> movies = new ArrayList<>(); // Lista que almacenará las películas leídas del archivo
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Abrir el archivo para leerlo línea por línea
            String line;
            while ((line = reader.readLine()) != null) {
                // Añadir cada línea del archivo (película) a la lista, eliminando espacios extra al inicio y final
                movies.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace(); // Imprimir cualquier error que ocurra al leer el archivo
        }
        return movies; // Retornar la lista de películas
    }
}
