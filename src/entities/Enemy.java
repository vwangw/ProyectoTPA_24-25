/**
 * Paquete que contiene las entidades de la aplicación.
 */
package entities;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

/**
 * La clase {@code Enemy} representa un obstáculo enemigo dentro del juego o la aplicación.
 * <p>
 * Un enemigo es un tipo de obstáculo que tiene una imagen representativa y está diseñado para interactuar
 * con otros elementos del juego. Cuando se crea una instancia de {@code Enemy}, carga una imagen
 * específica desde los recursos del proyecto.
 * </p>
 */
public class Enemy extends Obstacle {
    /**
     * Constructor de la clase {@code Enemy}.
     * <p>
     * Inicializa el nombre, la posición auxiliar en el eje Y ({@code yAux})
     * y carga la imagen del enemigo desde el archivo correspondiente.
     * Si ocurre un error al cargar la imagen, se imprime la pila de errores.
     * </p>
     *
     * @throws IOException si hay un problema al cargar la imagen.
     */
    public Enemy() throws IOException {
        // Nombre del enemigo.
        name = "Enemy";

        // Posición auxiliar en el eje Y.
        yAux = 0;

        // Carga de la imagen del enemigo desde los recursos.
        try {
            img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/enemy_car.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
