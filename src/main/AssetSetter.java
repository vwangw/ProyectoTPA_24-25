/**
 * Paquete principal del juego, contiene las clases principales para la configuración y ejecución.
 */
package main;

import entities.Obstacle;

import java.io.IOException;
import java.util.Random;

/**
 * La clase {@code AssetSetter} se encarga de colocar y gestionar los obstáculos dentro del juego.
 * <p>
 * Esta clase utiliza la fábrica de obstáculos para crear instancias de diferentes tipos de obstáculos,
 * posicionarlos aleatoriamente y asegurar que no se solapen en la pantalla.
 * </p>
 */
public class AssetSetter {
    /**
     * Referencia al panel principal del juego.
     */
    GamePanel gamePanel;

    /**
     * Generador de números aleatorios para posicionar los obstáculos.
     */
    private final Random random = new Random();

    /**
     * Constructor de la clase {@code AssetSetter}.
     *
     * @param gamePanel referencia al panel principal del juego.
     */
    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    /**
     * Crea y posiciona los obstáculos iniciales en el juego.
     * <p>
     * Este método genera dos obstáculos (por ejemplo, una moneda y un enemigo), los posiciona aleatoriamente
     * y asegura que no se solapen en sus posiciones iniciales.
     * </p>
     *
     * @throws IOException si hay un problema al crear los obstáculos.
     */
    public void obstaclesFactory() throws IOException {
        gamePanel.obstacle[0] = createAndPlaceObstacle("Coin");
        gamePanel.obstacle[1] = createAndPlaceObstacle("Enemy");

        // Reposiciona los obstáculos si se solapan.
        while (samePos()) {
            gamePanel.obstacle[0] = createAndPlaceObstacle("Coin");
            gamePanel.obstacle[1] = createAndPlaceObstacle("Enemy");
        }
    }

    /**
     * Crea un obstáculo de un tipo específico y lo posiciona aleatoriamente.
     *
     * @param type el tipo de obstáculo a crear (por ejemplo, "Coin" o "Enemy").
     * @return una instancia del obstáculo creado.
     * @throws IOException si hay un problema al crear el obstáculo.
     */
    private Obstacle createAndPlaceObstacle(String type) throws IOException {
        Obstacle obstacle = ObstacleFactory.createObstacle(type);
        obstacle.x = random.nextInt(gamePanel.getScreenHeight() - gamePanel.tileSize);
        return obstacle;
    }

    /**
     * Verifica si los obstáculos actuales tienen posiciones que se solapan.
     * <p>
     * Determina si la distancia entre las posiciones X e Y de los dos obstáculos es menor a 100 unidades.
     * </p>
     *
     * @return {@code true} si los obstáculos están demasiado cerca, {@code false} en caso contrario.
     */
    public boolean samePos() {
        return (Math.abs(gamePanel.obstacle[0].x - gamePanel.obstacle[1].x) < 100)
                && (Math.abs(gamePanel.obstacle[0].y - gamePanel.obstacle[1].y) < 100);
    }
}
