package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * La clase {@code KeyInputHandler} gestiona la entrada del teclado para controlar el juego.
 * <p>
 * Esta clase implementa {@code KeyListener} y escucha eventos de teclado para mover al jugador,
 * navegar en el menú y pausar/reanudar el juego.
 * </p>
 */
public class KeyInputHandler implements KeyListener {

    /**
     * Referencia al panel principal del juego.
     */
    GamePanel gamePanel;

    /**
     * Indicadores de teclas presionadas para el movimiento.
     */
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    /**
     * Constructor de la clase {@code KeyInputHandler}.
     *
     * @param gamePanel el panel principal del juego que utiliza esta clase para gestionar las entradas.
     */
    public KeyInputHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    /**
     * Evento no utilizado para caracteres escritos.
     *
     * @param e el evento de tipo de tecla.
     */
    @Override
    public void keyTyped(KeyEvent e) {
        // Este método no se utiliza.
    }

    /**
     * Gestiona los eventos cuando una tecla se presiona.
     *
     * @param e el evento de la tecla presionada.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        // Comportamiento en el estado de título.
        if (gamePanel.gameState == gamePanel.titleState) {
            if (code == KeyEvent.VK_W) {
                gamePanel.ui.commandNum--;
                if (gamePanel.ui.commandNum < 0) {
                    gamePanel.ui.commandNum = 1;
                }
            }
            if (code == KeyEvent.VK_S) {
                gamePanel.ui.commandNum++;
                if (gamePanel.ui.commandNum > 1) {
                    gamePanel.ui.commandNum = 0;
                }
            }
            if (code == KeyEvent.VK_ENTER) {
                if (gamePanel.ui.commandNum == 0) {
                    gamePanel.gameState = gamePanel.playState; // Inicia el juego.
                }
                if (gamePanel.ui.commandNum == 1) {
                    System.exit(0); // Cierra el juego.
                }
            }
        }

        // Movimiento del jugador.
        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }

        // Pausa/reanuda el juego.
        if (code == KeyEvent.VK_P) {
            if (gamePanel.gameState == gamePanel.pauseState) {
                gamePanel.gameState = gamePanel.playState; // Reanuda el juego.
            } else if (gamePanel.gameState == gamePanel.playState) {
                gamePanel.gameState = gamePanel.pauseState; // Pausa el juego.
            }
        }
    }

    /**
     * Gestiona los eventos cuando una tecla se libera.
     *
     * @param e el evento de la tecla liberada.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        // Actualiza los indicadores de movimiento al liberar las teclas.
        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}
