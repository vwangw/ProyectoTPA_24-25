package main;

import entities.Coin;
import entities.Enemy;
import entities.Obstacle;

import java.io.IOException;

/**
 * La clase {@code ObstacleFactory} es responsable de crear instancias de obstáculos en el juego.
 * <p>
 * Utiliza el patrón de diseño Factory para crear obstáculos de tipos específicos, como {@code Coin} y {@code Enemy}.
 * </p>
 */
public class ObstacleFactory {

    /**
     * Crea un obstáculo según el tipo especificado.
     * <p>
     * Este método devuelve una nueva instancia de un tipo de obstáculo específico, como {@code Coin} o {@code Enemy}.
     * Si se pasa un tipo no reconocido, se lanza una excepción {@code IllegalArgumentException}.
     * </p>
     *
     * @param type el tipo de obstáculo a crear, que debe ser {@code "Coin"} o {@code "Enemy"}.
     * @return una nueva instancia de {@code Obstacle} del tipo solicitado.
     * @throws IOException si ocurre un error al intentar crear el obstáculo, por ejemplo, al cargar recursos como imágenes.
     * @throws IllegalArgumentException si el tipo proporcionado no es reconocido.
     */
    public static Obstacle createObstacle(String type) throws IOException {
        return switch (type) {
            case "Coin" -> new Coin();
            case "Enemy" -> new Enemy();
            default -> throw new IllegalArgumentException("Error: " + type);
        };
    }
}
