package models;

public class Movie {
    // Atributo que almacena el título de la película en minúsculas
    private String title;

    // Constructor que inicializa el título de la película en minúsculas
    public Movie(String title) {
        this.title = title.toLowerCase(); // Convertir el título a minúsculas para no diferenciar entre mayúsculas y minúsculas
    }

    // Método para obtener el título original de la película
    public String getTitle() {
        return title;
    }

    // Método que enmascara el título de la película, mostrando solo las letras adivinadas y '*' para las no adivinadas
    public String getMaskedTitle(String guessedLetters) {
        StringBuilder masked = new StringBuilder();

        // Iterar sobre cada carácter del título de la película
        for (char c : title.toCharArray()) {
            // Si el carácter es una letra, mostrarla si ha sido adivinada, de lo contrario mostrar '*'
            if (Character.isLetter(c)) {
                masked.append(guessedLetters.contains(String.valueOf(c)) ? c : '*');
            } else {
                // Si el carácter no es una letra (como un espacio o guion), lo dejamos sin cambios
                masked.append(c);
            }
        }
        return masked.toString(); // Retorna el título enmascarado
    }
}
