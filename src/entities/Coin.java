package entities;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Coin extends Obstacle{
    public Coin() throws IOException {
        super();
        name = "Coin";
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/gold_coin.jpg"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
