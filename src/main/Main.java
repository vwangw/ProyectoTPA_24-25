package main;

import javax.swing.*;
import java.io.IOException;

/**
 * La clase {@code Main} es el punto de entrada principal de la aplicación del juego.
 * <p>
 * Esta clase contiene el método {@code main} que configura y lanza el juego, creando la ventana del juego,
 * añadiendo el panel del juego a la ventana y comenzando el hilo del juego.
 * </p>
 */
public class Main {

    /**
     * El punto de entrada principal del juego.
     * <p>
     * Este método configura la ventana del juego, la agrega al panel de juego,
     * y comienza el hilo del juego para que se ejecute de manera continua.
     * </p>
     *
     * @param args los argumentos de la línea de comandos (no utilizados en este caso).
     * @throws IOException si ocurre un error al cargar recursos, como imágenes o sonidos.
     */
    public static void main(String[] args) throws IOException {
        // Crea una nueva ventana JFrame.
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define el comportamiento de la ventana al cerrarla.
        window.setResizable(false); // La ventana no es redimensionable.
        window.setTitle("Juego TPA"); // Título de la ventana.

        // Crea un nuevo panel de juego y lo agrega a la ventana.
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        // Ajusta el tamaño de la ventana para ajustarse al contenido.
        window.pack();

        // Centra la ventana en la pantalla.
        window.setLocationRelativeTo(null);
        window.setVisible(true); // Muestra la ventana.

        // Configura el juego y comienza el hilo de ejecución del juego.
        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
}
