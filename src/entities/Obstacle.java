/**
 * Paquete que contiene las entidades de la aplicación.
 */
package entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * La clase {@code Obstacle} representa un obstáculo genérico en el juego.
 * <p>
 * Un obstáculo es una entidad que tiene una posición, una imagen asociada y
 * se mueve a lo largo de la pantalla con una velocidad específica. También
 * puede detectar colisiones mediante una caja de colisión rectangular.
 * </p>
 * <p>
 * Esta clase puede ser extendida para crear tipos específicos de obstáculos
 * como enemigos o monedas.
 * </p>
 */
public class Obstacle extends Actor {

    /**
     * Indica si el obstáculo está en colisión con otro objeto.
     */
    public boolean collision = false;

    /**
     * Imagen del obstáculo.
     */
    public BufferedImage img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/enemy_car.jpg")));

    /**
     * Nombre del obstáculo.
     */
    public String name;

    /**
     * Caja de colisión del obstáculo.
     */
    public Rectangle hitbox = new Rectangle(0, 0, 48, 48);

    /**
     * Posición x predeterminada de la caja de colisión, relativa al obstáculo.
     */
    public int hitboxDefaultX = 0;

    /**
     * Posición y predeterminada de la caja de colisión, relativa al obstáculo.
     */
    public int hitboxDefaultY = 0;

    /**
     * Desplazamiento auxiliar en el eje Y para ajustar la altura de dibujo.
     */
    public int yAux;

    /**
     * Constructor de la clase {@code Obstacle}.
     * <p>
     * Inicializa las propiedades del obstáculo, incluyendo su posición inicial, velocidad
     * y otros parámetros predeterminados. La posición X se elige aleatoriamente dentro del
     * ancho permitido.
     * </p>
     *
     * @throws IOException si hay un problema al cargar la imagen predeterminada.
     */
    public Obstacle() throws IOException {
        super();
        x = (int) (Math.random() * 800);
        y = 0;
        speed = 5;
    }

    /**
     * Actualiza la posición del obstáculo en la pantalla.
     * <p>
     * Incrementa la posición en el eje Y según la velocidad. Si el obstáculo
     * supera el límite inferior de la pantalla, su posición se reinicia en la parte superior
     * con una nueva posición X aleatoria.
     * </p>
     */
    public void update() {
        y += speed;

        if (y > 600) {
            y = 0;
            x = (int) (Math.random() * 800);
        }
    }

    /**
     * Dibuja el obstáculo en la pantalla.
     *
     * @param g2 el objeto {@code Graphics2D} utilizado para dibujar la imagen.
     */
    public void draw(Graphics2D g2) {
        g2.drawImage(img, x, y, 30, 60 - yAux, null);
    }
}