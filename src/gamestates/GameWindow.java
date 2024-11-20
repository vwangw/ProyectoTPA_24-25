package gamestates;

import javax.swing.*;

public class GameWindow extends JFrame {
    private JFrame jframe;

    public GameWindow(GamePanel gamePanel){
       jframe  = new JFrame();

       jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       jframe.add(gamePanel);
       jframe.pack();
       jframe.setLocationRelativeTo(null);
       jframe.setVisible(true);
    }
}