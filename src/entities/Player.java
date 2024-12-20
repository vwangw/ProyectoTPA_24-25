/**
 * Paquete que contiene las entidades de la aplicación.
 */
package entities;

import main.GamePanel;
import main.KeyInputHandler;
import main.UI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * La clase {@code Player} representa el jugador controlado por el usuario dentro del juego.
 * <p>
 * El jugador puede moverse hacia la izquierda y la derecha en respuesta a las entradas del usuario,
 * interactuar con obstáculos como monedas o enemigos, y acumular puntos.
 * </p>
 */
public class Player extends Actor {

    /**
     * Referencia al panel principal del juego.
     */
    GamePanel gamePanel;

    /**
     * Referencia a la interfaz de usuario del juego.
     */
    UI ui;

    /**
     * Maneja la entrada de teclado del jugador.
     */
    KeyInputHandler keyInputHandler;

    /**
     * Imagen que representa al jugador.
     */
    BufferedImage img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player_car.png")));

    /**
     * Contador de monedas recolectadas por el jugador.
     */
    public int coinCount = 0;

    /**
     * Constructor de la clase {@code Player}.
     * <p>
     * Inicializa las referencias al panel de juego, al manejador de entrada de teclado
     * y a la interfaz de usuario. Configura la caja de colisión y los valores predeterminados.
     * </p>
     *
     * @param gamePanel referencia al panel principal del juego.
     * @param keyInputHandler manejador de entrada de teclado del jugador.
     * @param ui referencia a la interfaz de usuario del juego.
     * @throws IOException si hay un problema al cargar la imagen del jugador.
     */
    public Player(GamePanel gamePanel, KeyInputHandler keyInputHandler, UI ui) throws IOException {
        this.gamePanel = gamePanel;
        this.keyInputHandler = keyInputHandler;
        this.ui = ui;

        hitbox = new Rectangle(0, 0, gamePanel.tileSize, gamePanel.tileSize);
        hitboxDefaultX = 8;
        hitboxDefaultY = 16;

        setDefaultValue();
    }

    /**
     * Configura los valores iniciales del jugador, incluyendo su posición y velocidad.
     */
    public void setDefaultValue() {
        x = gamePanel.getScreenWidth() / 2;
        y = 500;
        speed = 6;
    }

    /**
     * Actualiza la posición del jugador en la pantalla y gestiona sus interacciones.
     * <p>
     * El jugador se mueve en función de las teclas presionadas, se asegura de que no salga
     * de los límites de la pantalla, y verifica si ha colisionado con algún obstáculo.
     * </p>
     */
    public void update() {
        if (keyInputHandler.leftPressed) {
            x -= speed;
        } else if (keyInputHandler.rightPressed) {
            x += speed;
        }

        // Restringe el movimiento dentro de los límites de la pantalla.
        if (x >= gamePanel.getScreenWidth() - 30) {
            x = gamePanel.getScreenWidth() - 30;
        }
        if (x <= 0) {
            x = 0;
        }

        collisionOn = false;
        int ObsIndex = gamePanel.hitboxChecker.checkObstacle(this, true);
        interactObstacle(ObsIndex);
    }

    /**
     * Gestiona las interacciones del jugador con los obstáculos.
     * <p>
     * Si el jugador interactúa con una moneda, aumenta el contador de monedas y los puntos.
     * Si interactúa con un enemigo, cambia el estado del juego a "Game Over".
     * </p>
     *
     * @param i índice del obstáculo con el que el jugador ha interactuado.
     */
    public void interactObstacle(int i) {
        if (i != 999) {
            String obstacleName = gamePanel.obstacle[i].name;

            switch (obstacleName) {
                case "Coin":
                    coinCount++;
                    ui.pointsCounter += 10 * 50;
                    gamePanel.obstacle[i] = null;
                    break;
                case "Enemy":
                    gamePanel.gameState = gamePanel.overState;
                    break;
            }
        }
    }

    /**
     * Dibuja al jugador en la pantalla.
     *
     * @param g2 el objeto {@code Graphics2D} utilizado para renderizar al jugador.
     */
    public void draw(Graphics2D g2) {
        g2.drawImage(img, x, y, 30, 60, null);
    }
}
