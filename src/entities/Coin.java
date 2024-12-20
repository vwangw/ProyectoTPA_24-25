/**
 * Paquete que contiene las entidades de la aplicación.
 */
package entities;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

/**
 * La clase {@code Coin} representa un obstáculo en forma de moneda dentro del juego o la aplicación.
 * <p>
 * Una moneda es un tipo de obstáculo que tiene una imagen representativa, velocidad y un estado de colisión.
 * Cuando se crea una instancia de {@code Coin}, carga una imagen desde los recursos del proyecto.
 * </p>
 */
public class Coin extends Obstacle {
    /**
     * Constructor de la clase {@code Coin}.
     * <p>
     * Inicializa el nombre, la posición auxiliar en el eje Y ({@code yAux}), la velocidad
     * y carga la imagen de la moneda desde el archivo correspondiente.
     * Si ocurre un error al cargar la imagen, se imprime la pila de errores.
     * </p>
     *
     * @throws IOException si hay un problema al cargar la imagen.
     */
    public Coin() throws IOException {
        // Nombre de la moneda.
        name = "Coin";

        // Posición auxiliar en el eje Y.
        yAux = 20;

        // Velocidad de la moneda.
        speed = 4;

        // Carga de la imagen de la moneda desde los recursos.
        try {
            img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/gold_coin.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Indica que este objeto tiene colisión.
        collision = true;
    }
}
