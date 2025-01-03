package main;

import models.Movie;
import models.Player;
import models.ScoreManager;
import utils.FileUtils;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> movieList = FileUtils.readMoviesFromFile("resources/movies.txt");

        if (movieList.isEmpty()) {
            System.out.println("Error: No movies found in the file.");
            return;
        }

        // Seleccionar película al azar
        String randomMovie = movieList.get((int) (Math.random() * movieList.size()));
        Movie movie = new Movie(randomMovie);

        System.out.println("Welcome to 'Guess the Movie'!");
        playGame(movie, scanner);
    }

    public static void playGame(Movie movie, Scanner scanner) {
        ScoreManager scoreManager = new ScoreManager();
        int attempts = 10;
        int score = 0;
        String guessedLetters = "";
        String nickname;
        boolean gameWon = false;

        while (attempts > 0) {
            System.out.println("Movie: " + movie.getMaskedTitle(guessedLetters));
            System.out.println("[1] Guess a letter [2] Guess the movie's title [3] Exit");
            System.out.println("Attempts left: " + attempts + ", Current score: " + score);
            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter a letter:");
                    String letter = scanner.nextLine().toLowerCase();
                    if (letter.length() != 1 || !letter.matches("[a-z]")) {
                        System.out.println("Invalid input. Enter a single letter.");
                        continue;
                    }
                    if (guessedLetters.contains(letter)) {
                        System.out.println("You already guessed that letter!");
                        continue;
                    }
                    guessedLetters += letter;

                    if (movie.getTitle().contains(letter)) {
                        System.out.println("Correct guess!");
                        score += 10;
                    } else {
                        System.out.println("Wrong guess!");
                        attempts--;
                        score -= 10;
                    }

                    if (movie.getMaskedTitle(guessedLetters).equals(movie.getTitle())) {
                        gameWon = true;
                        break;
                    }
                }
                case 2 -> {
                    System.out.println("Guess the movie's title:");
                    String titleGuess = scanner.nextLine().toLowerCase();
                    if (titleGuess.equals(movie.getTitle())) {
                        gameWon = true;
                        score += 20;
                    } else {
                        gameWon = false;
                        score -= 20;
                    }
                    break;
                }
                case 3 -> {
                    System.out.println("Exiting the game.");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }

            if (gameWon) {
                System.out.println("Congratulations! You guessed the movie.");
                break;
            }
        }

        System.out.println("The movie was: " + movie.getTitle());
        System.out.println("Your final score: " + score);

        if (gameWon) {
            System.out.println("Enter your nickname:");
            nickname = scanner.nextLine();
            Player player = new Player(nickname, score);
            scoreManager.addScore(player);
            scoreManager.saveScores();
        }

        System.out.println("Top Scores:");
        for (Player player : scoreManager.getHighScores()) {
            System.out.println(player.getNickname() + ": " + player.getScore());
        }
    }
}