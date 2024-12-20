/**
 * Paquete que contiene las entidades de la aplicación.
 */
package entities;

import java.awt.*;

/**
 * La clase {@code Actor} representa una entidad abstracta dentro del juego o la aplicación
 * que puede moverse, interactuar con otros objetos y representarse visualmente.
 * <p>
 * Cada actor tiene una posición ({@code x, y}), una velocidad y una caja de colisión
 * para la detección de colisiones. Las subclases de {@code Actor} deben proporcionar
 * implementaciones específicas para los comportamientos y características de los actores.
 * </p>
 */
public abstract class Actor {
    /**
     * La velocidad del actor, que representa qué tan rápido puede moverse.
     */
    protected int speed;

    /**
     * La coordenada x de la posición del actor.
     */
    public int x;

    /**
     * La coordenada y de la posición del actor.
     */
    public int y;

    /**
     * El rectángulo que representa la caja de colisión del actor, utilizado para detectar colisiones.
     */
    public Rectangle hitbox;

    /**
     * Bandera que indica si el actor está actualmente en colisión con otro objeto.
     */
    public boolean collisionOn = false;

    /**
     * La coordenada x predeterminada de la caja de colisión, relativa a la posición del actor.
     */
    public int hitboxDefaultX;

    /**
     * La coordenada y predeterminada de la caja de colisión, relativa a la posición del actor.
     */
    public int hitboxDefaultY;

    /**
     * Obtiene la coordenada y de la posición del actor.
     *
     * @return la coordenada y del actor.
     */
    public int getY() {
        return y;
    }

    /**
     * Obtiene la coordenada x de la posición del actor.
     *
     * @return la coordenada x del actor.
     */
    public int getX() {
        return x;
    }
}
