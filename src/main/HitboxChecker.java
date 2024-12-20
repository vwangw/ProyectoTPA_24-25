package main;

import entities.Actor;

/**
 * Clase {@code HitboxChecker} para gestionar las colisiones entre el jugador y los obstáculos en el juego.
 * <p>
 * Esta clase verifica si un actor (como el jugador) interactúa o colisiona con algún obstáculo en el juego.
 * </p>
 */
public class HitboxChecker {

    /**
     * Referencia al panel principal del juego.
     */
    GamePanel gamePanel;

    /**
     * Constructor de la clase {@code HitboxChecker}.
     *
     * @param gamePanel el panel principal del juego que contiene todos los objetos y obstáculos.
     */
    public HitboxChecker(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    /**
     * Verifica si un actor colisiona con algún obstáculo en el juego.
     *
     * @param actor el actor cuya colisión se verificará.
     * @param player un valor booleano que indica si el actor es el jugador.
     * @return el índice del obstáculo con el que el actor colisiona, o 999 si no hay colisión.
     */
    public int checkObstacle(Actor actor, boolean player) {
        int index = 999; // Valor predeterminado que indica que no hubo colisión.

        // Itera sobre la lista de obstáculos.
        for (int i = 0; i < gamePanel.obstacle.length; i++) {
            if (gamePanel.obstacle[i] != null) {

                // Actualiza las posiciones de las hitboxes basadas en las coordenadas actuales.
                actor.hitbox.x = actor.getX() + actor.hitbox.x;
                actor.hitbox.y = actor.getY() + actor.hitbox.y;

                gamePanel.obstacle[i].hitbox.x = gamePanel.obstacle[i].x + gamePanel.obstacle[i].hitbox.x;
                gamePanel.obstacle[i].hitbox.y = gamePanel.obstacle[i].y + gamePanel.obstacle[i].hitbox.y;

                // Verifica si las hitboxes de los objetos se intersectan.
                if (actor.hitbox.intersects(gamePanel.obstacle[i].hitbox)) {

                    // Si el obstáculo tiene activada la colisión, también se activa en el actor.
                    if (gamePanel.obstacle[i].collisionOn) {
                        actor.collisionOn = true;
                    }

                    // Si el actor es el jugador, devuelve el índice del obstáculo.
                    if (player) {
                        index = i;
                    }
                    break;
                }

                // Restaura las posiciones iniciales de las hitboxes.
                actor.hitbox.x = actor.hitboxDefaultX;
                actor.hitbox.y = actor.hitboxDefaultY;

                gamePanel.obstacle[i].hitbox.x = gamePanel.obstacle[i].hitboxDefaultX;
                gamePanel.obstacle[i].hitbox.y = gamePanel.obstacle[i].hitboxDefaultY;
            }
        }
        return index;
    }
}
