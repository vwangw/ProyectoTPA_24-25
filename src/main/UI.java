package main;

import java.awt.*;

/**
 * La clase {@code UI} se encarga de manejar la interfaz de usuario del juego.
 * <p>
 * Esta clase dibuja las diferentes pantallas de la interfaz, como la pantalla de título, la pantalla de juego en progreso,
 * la pantalla de pausa y la pantalla de fin de juego.
 * </p>
 */
public class UI {

    GamePanel gamePanel;
    Graphics2D g2;
    Font arial_40;
    public long pointsCounter = 0;
    public boolean gameFinished = false;
    public int commandNum = 0;

    /**
     * Constructor de la clase {@code UI}.
     * <p>
     * Inicializa la fuente para mostrar texto y asigna el panel del juego para la interfaz.
     * </p>
     *
     * @param gamePanel el panel del juego que contiene la configuración del juego y el estado.
     */
    public UI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
    }

    /**
     * Dibuja la interfaz de usuario en el panel de juego según el estado actual del juego.
     * <p>
     * Dependiendo del estado del juego, se dibujará una pantalla diferente (pantalla de título, en juego, pausa o fin del juego).
     * </p>
     *
     * @param g2 el objeto {@code Graphics2D} que se utiliza para dibujar en el panel de juego.
     */
    public void draw(Graphics2D g2) {
        this.g2 = g2;
        if (gamePanel.gameState == gamePanel.titleState) {
            drawTitleScreen();
        } else if (gamePanel.gameState == gamePanel.playState) {
            drawPlayingScreen();
        } else if (gamePanel.gameState == gamePanel.pauseState) {
            drawPauseScreen();
        } else if (gamePanel.gameState == gamePanel.overState) {
            drawOverScreen();
        }
    }

    /**
     * Dibuja la pantalla de título del juego.
     * <p>
     * Muestra el nombre del juego y las opciones para iniciar o salir.
     * </p>
     */
    public void drawTitleScreen() {
        g2.setColor(new Color(70, 120, 80));
        g2.fillRect(0, 0, gamePanel.screenWidth, gamePanel.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
        String text = "Car Game";
        int x = getCenteredX(text);
        int y = gamePanel.tileSize * 3;

        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
        text = "START";
        x = getCenteredX(text);
        y += gamePanel.tileSize * 4;
        g2.drawString(text, x, y);
        if (commandNum == 0) {
            g2.drawString(">", x - gamePanel.tileSize, y);
        }

        text = "QUIT";
        x = getCenteredX(text);
        y += gamePanel.tileSize * 2;
        g2.drawString(text, x, y);
        if (commandNum == 1) {
            g2.drawString(">", x - gamePanel.tileSize, y);
        }
    }

    /**
     * Dibuja la pantalla de juego en progreso.
     * <p>
     * Muestra los puntos actuales del jugador y actualiza el contador de puntos.
     * Si se alcanza un número máximo de puntos, se marca el fin del juego.
     * </p>
     */
    public void drawPlayingScreen() {
        if (gameFinished) {
            gamePanel.gameState = gamePanel.overState;
        } else {
            g2.setFont(arial_40);
            g2.setColor(Color.WHITE);
            g2.drawString("Points: " + (pointsCounter / 50), 25, 40);
            pointsCounter++;
            if (pointsCounter > 60 * 50) {
                gamePanel.ui.gameFinished = true;
                pointsCounter = 0;
            }
        }
    }

    /**
     * Dibuja la pantalla de pausa del juego.
     * <p>
     * Muestra el texto "PAUSED" cuando el juego está en pausa.
     * </p>
     */
    public void drawPauseScreen() {
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
        String text = "PAUSED";
        int x;
        x = getCenteredX(text);
        int y = gamePanel.screenHeight / 2;

        g2.drawString(text, x, y);
    }

    /**
     * Dibuja la pantalla de fin del juego.
     * <p>
     * Muestra el texto "Game Finished" cuando el jugador ha perdido o el juego ha terminado.
     * </p>
     */
    public void drawOverScreen() {
        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);
        String text = "Game Finished";
        g2.drawString(text, getCenteredX(text), gamePanel.screenHeight / 2);
    }

    /**
     * Calcula la posición X centrada para un texto en función de su longitud y el ancho de la pantalla.
     *
     * @param text el texto que se va a centrar.
     * @return la coordenada X para que el texto se dibuje centrado.
     */
    public int getCenteredX(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gamePanel.screenWidth / 2 - length / 2;
    }
}
