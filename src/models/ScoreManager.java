package models;

import java.io.*;
import java.util.*;

public class ScoreManager {
    private static final String SCORE_FILE = "resources/scores.dat";
    private List<Player> highScores = new ArrayList<>();

    public ScoreManager() {
        loadScores();
    }

    public void loadScores() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SCORE_FILE))) {
            highScores = (List<Player>) ois.readObject();
        } catch (Exception e) {
            highScores = new ArrayList<>();
        }
    }

    public void saveScores() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SCORE_FILE))) {
            oos.writeObject(highScores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addScore(Player player) {
        highScores.add(player);
        highScores.sort(Comparator.comparingInt(Player::getScore).reversed());
        if (highScores.size() > 5) {
            highScores.remove(highScores.size() - 1);
        }
    }

    public List<Player> getHighScores() {
        return highScores;
    }
}
