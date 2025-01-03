package models;

public class Movie {
    private String title;

    public Movie(String title) {
        this.title = title.toLowerCase();
    }

    public String getTitle() {
        return title;
    }

    public String getMaskedTitle(String guessedLetters) {
        StringBuilder masked = new StringBuilder();
        for (char c : title.toCharArray()) {
            if (Character.isLetter(c)) {
                masked.append(guessedLetters.contains(String.valueOf(c)) ? c : '*');
            } else {
                masked.append(c);
            }
        }
        return masked.toString();
    }
}
