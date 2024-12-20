/**
 * Paquete principal del juego, contiene las clases principales para la configuración y ejecución.
 */
package main;

import entities.Obstacle;
import entities.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * La clase {@code GamePanel} representa el área principal donde se desarrolla el juego.
 * <p>
 * Esta clase configura los elementos principales del juego, como el jugador, los obstáculos,
 * el sistema de colisiones, la interfaz gráfica y el bucle principal del juego.
 * </p>
 */
public class GamePanel extends JPanel implements Runnable {

    /**
     * Tamaño original de los mosaicos en píxeles.
     */
    final int originalTileSize = 16;

    /**
     * Factor de escala para ajustar los gráficos a pantallas más grandes.
     */
    final int scale = 3;

    /**
     * Tamaño de los mosaicos escalados.
     */
    public final int tileSize = originalTileSize * scale;

    /**
     * Máximo número de columnas visibles en la pantalla.
     */
    final int maxScreenCol = 16;

    /**
     * Máximo número de filas visibles en la pantalla.
     */
    final int maxScreenRow = 12;

    /**
     * Ancho total de la pantalla en píxeles.
     *
     * @return el ancho de la pantalla.
     */
    public int getScreenWidth() {
        return screenWidth;
    }

    final int screenWidth = tileSize * maxScreenCol;

    /**
     * Alto total de la pantalla en píxeles.
     *
     * @return el alto de la pantalla.
     */
    public int getScreenHeight() {
        return screenHeight;
    }

    final int screenHeight = tileSize * maxScreenRow;

    /**
     * Imagen de fondo del juego.
     */
    BufferedImage img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/game_background.png")));

    /**
     * Cuadros por segundo objetivo del juego.
     */
    int FPS = 60;

    /**
     * Hilo principal del juego.
     */
    Thread gameThread;

    /**
     * Manejador de entrada de teclado para el jugador.
     */
    KeyInputHandler keyInputHandler = new KeyInputHandler(this);

    /**
     * Interfaz de usuario para mostrar información al jugador.
     */
    public UI ui = new UI(this);

    /**
     * Instancia del jugador.
     */
    Player player = new Player(this, keyInputHandler, ui);

    /**
     * Verificador de colisiones para detectar interacciones entre objetos.
     */
    public HitboxChecker hitboxChecker = new HitboxChecker(this);

    /**
     * Arreglo que contiene los obstáculos del juego.
     */
    public Obstacle[] obstacle = new Obstacle[3];

    /**
     * Clase para generar y colocar obstáculos en el juego.
     */
    public AssetSetter assetSetter = new AssetSetter(this);

    /**
     * Estado actual del juego.
     */
    public int gameState;

    /**
     * Constante que representa el estado del título.
     */
    public final int titleState = 0;

    /**
     * Constante que representa el estado de juego activo.
     */
    public final int playState = 1;

    /**
     * Constante que representa el estado de pausa.
     */
    public final int pauseState = 2;

    /**
     * Constante que representa el estado de "Game Over".
     */
    public final int overState = 3;

    /**
     * Constructor de la clase {@code GamePanel}.
     * <p>
     * Configura el tamaño de la pantalla, el color de fondo, y los manejadores de entrada.
     * </p>
     *
     * @throws IOException si hay un problema al cargar los recursos gráficos.
     */
    public GamePanel() throws IOException {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyInputHandler);
        this.setFocusable(true);
    }

    /**
     * Configura el juego inicializando los obstáculos y estableciendo el estado inicial.
     *
     * @throws IOException si hay un problema al crear los obstáculos.
     */
    public void setupGame() throws IOException {
        assetSetter.obstaclesFactory();
        gameState = titleState;
    }

    /**
     * Inicia el hilo principal del juego.
     */
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Bucle principal del juego que gestiona la lógica y el renderizado.
     */
    @Override
    public void run() {
        double drawInterval = 1000000000f / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    /**
     * Actualiza la lógica del juego dependiendo del estado actual.
     */
    public void update() {
        if (gameState == playState) {
            player.update();
            for (Obstacle value : obstacle) {
                if (value != null) {
                    value.update();
                }
            }
        }
        if (gameState == pauseState && gameState == overState) {
            // Lógica para pausa o estado de Game Over.
        }
    }

    /**
     * Renderiza los elementos gráficos en la pantalla.
     *
     * @param g el objeto {@code Graphics} utilizado para dibujar.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, screenWidth, screenHeight, null);
        Graphics2D g2 = (Graphics2D) g;

        if (gameState == titleState) {
            ui.draw(g2);
        } else {
            for (Obstacle value : obstacle) {
                if (value != null) {
                    value.draw(g2);
                }
            }
            player.draw(g2);
            ui.draw(g2);
        }

        g2.dispose();
    }
}
