package gamestates;

public class Game implements Runnable{

    private GameWindow gameWindow;
    private GamePanel gamePanel;

    public Game(){
        gamePanel=new GamePanel(this);
        gameWindow=new GameWindow(gamePanel);
        gamePanel.requestFocus();
    }

    @Override
    public void run() {

        while(true){
            gamePanel.repaint();
        }
    }
}
