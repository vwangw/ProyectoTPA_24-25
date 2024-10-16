
import javax.swing.JPanel;
import java.awt.*;


public class GamePanel extends JPanel {

    private Game game;

    public GamePanel(Game game){
        this.game=game;

        setPanelSize();
    }

    public void setPanelSize(){
        Dimension size=new Dimension(500,500);
        setPreferredSize(size);

    }

    public void paintComponent(Graphics g){
        g.fillRect(50,50,100,100);
    }

    public Game getGame(){
        return game;
    }
}
