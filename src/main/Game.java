package main;

import entities.Player;
import gamestates.MouseInputHandler;
import gamestates.State;
import gamestates.Menu;

import javax.swing.*;
import java.awt.*;

public class Game implements Runnable {

    private JFrame window;
    private JPanel currentPanel;
    private State currentState;
    private Player player;

    public Game() {
        initWindow();
        initPlayer();
        initState();
    }

    private void initWindow() {
        window = new JFrame("Juego");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1200, 700);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
    }

    private void initState() {
        currentState = new Menu(this);
        currentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                currentState.draw(g);
            }
        };
        currentPanel.addMouseListener(new MouseInputHandler(currentState));
        currentPanel.addMouseMotionListener(new MouseInputHandler(currentState));
        window.add(currentPanel);
        window.setVisible(true);
    }

    private void initPlayer() {
        player = new Player(10);
    }

    public Player getPlayer(){return player;}

    public void changeState(State newState) {
        currentState = newState;
        currentPanel.repaint();
    }

    @Override
    public void run() {
        while (true) {
            currentPanel.repaint();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
