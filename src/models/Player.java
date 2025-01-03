package models;

public class Player {
    // Atributo que almacena el nombre del jugador
    private String nickname;
    // Atributo que almacena la puntuación del jugador
    private int score;

    // Constructor que inicializa un jugador con su nombre y puntuación
    public Player(String nickname, int score) {
        this.nickname = nickname; // Asigna el nombre del jugador
        this.score = score;       // Asigna la puntuación inicial del jugador
    }

    // Método para obtener el nombre del jugador
    public String getNickname() {
        return nickname;
    }

    // Método para obtener la puntuación del jugador
    public int getScore() {
        return score;
    }
}