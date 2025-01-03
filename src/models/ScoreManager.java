package models;

import java.io.*;
import java.util.*;

public class ScoreManager {
    // Ruta del archivo donde se guardan las puntuaciones
    private static final String SCORE_FILE = "resources/scores.dat";
    // Lista que almacena las puntuaciones más altas
    private List<Player> highScores = new ArrayList<>();

    // Constructor que carga las puntuaciones desde el archivo al iniciar el objeto
    public ScoreManager() {
        loadScores(); // Cargar las puntuaciones guardadas previamente
    }

    // Método que carga las puntuaciones desde el archivo 'scores.dat'
    public void loadScores() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SCORE_FILE))) {
            // Leer las puntuaciones del archivo y asignarlas a la lista highScores
            highScores = (List<Player>) ois.readObject();
        } catch (Exception e) {
            // Si ocurre un error (como si el archivo no existe), inicializar una lista vacía
            highScores = new ArrayList<>();
        }
    }

    // Método que guarda las puntuaciones actuales en el archivo 'scores.dat'
    public void saveScores() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SCORE_FILE))) {
            // Escribir la lista de puntuaciones en el archivo
            oos.writeObject(highScores);
        } catch (IOException e) {
            e.printStackTrace(); // Imprimir el error si falla al guardar el archivo
        }
    }

    // Método para añadir una nueva puntuación a la lista y mantener las 5 mejores
    public void addScore(Player player) {
        highScores.add(player); // Añadir el jugador a la lista de puntuaciones
        // Ordenar las puntuaciones de mayor a menor
        highScores.sort(Comparator.comparingInt(Player::getScore).reversed());
        // Si hay más de 5 puntuaciones, eliminar la más baja
        if (highScores.size() > 5) {
            highScores.remove(highScores.size() - 1);
        }
    }

    // Método que devuelve la lista de las mejores puntuaciones
    public List<Player> getHighScores() {
        return highScores;
    }
}
