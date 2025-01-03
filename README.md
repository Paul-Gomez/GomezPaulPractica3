# Guess the Movie Game

## Descripción:

Esta tercera práctica de Programación es un juego de consola donde hay que acertar el título de una película. El juego 
es estilo Ahorcado, donde el jugador tendrá que adivinar el título escribiendo letras en la consola. Tiene un número de 
intentos limitados. Existe un ranking de puntuaciones. 

## Características

- Elige un título de película al azar desde un archivo de texto (`movies.txt`).
- El jugador puede adivinar una letra o intentar adivinar el título completo.
- El juego ofrece un máximo de 10 intentos para adivinar.
- El juego muestra el progreso del jugador al ocultar las letras no adivinadas del título con asteriscos (`*`).
- Si el jugador adivina todas las letras o el título correctamente, gana el juego y se le otorgan puntos.
- Si el jugador no adivina el título en los 10 intentos, pierde el juego.
- El jugador puede salir en cualquier momento, perdiendo el juego.
- Las puntuaciones de las mejores 5 partidas se almacenan en un archivo binario (`scores.dat`).
- El juego verifica y mantiene las 5 mejores puntuaciones en el ranking.

## Estructura del Proyecto

- **src/main/Main.java**: Clase principal que maneja la lógica del juego.
- **models/Player.java**: Clase que representa al jugador con su nombre de usuario y puntuación.
- **models/Movie.java**: Clase que representa una película con su título y métodos para mostrar el título enmascarado.
- **models/ScoreManager.java**: Clase que maneja la carga, adición y almacenamiento de las puntuaciones.
- **utils/FileUtils.java**: Clase utilitaria que lee las películas desde un archivo de texto.

## Cómo Jugar

1. El juego se inicia automáticamente al ejecutar la clase `Main.java`.
2. Se seleccionará un título de película aleatorio de un archivo de texto (`movies.txt`).
3. Se mostrará el progreso con un formato similar a este: `Movie: S* * * W* R*`.
4. El jugador puede seleccionar entre las siguientes opciones:
    - **1**: Adivinar una letra.
    - **2**: Adivinar el título completo.
    - **3**: Salir del juego.
5. El jugador tiene **10 intentos** para adivinar el título completo o las letras correctamente.

