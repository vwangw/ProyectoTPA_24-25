package main;

import java.awt.*;

public class UI {

    GamePanel gamePanel;
    Font arial_40;
    int pointsCounter = 0;
    public boolean gameFinished = false;

    public UI (GamePanel gamePanel){
        this.gamePanel = gamePanel;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
    }

    public void draw (Graphics2D g2){

        if(gameFinished){

            g2.setFont(arial_40);
            g2.setColor(Color.WHITE);

            String text;
            int textLength;
            int x;
            int y;

            text = "Game Finished";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gamePanel.screenWidth/2-textLength/2;
            y = gamePanel.screenHeight/2;

            g2.drawString(text,x,y);

        }else {
            g2.setFont(arial_40);
            g2.setColor(Color.WHITE);
            g2.drawString("Points: "+ Integer.toString(pointsCounter/50),25,40);
            pointsCounter++;
            if(pointsCounter > 3*50){
                gamePanel.ui.gameFinished = true;
                pointsCounter = 0;
            }
        }
    }
}
