package entities;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Coin extends Obstacle{
    public Coin() throws IOException {
        name = "Coin";
        try{
            img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/gold_coin.jpg")));
        }catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
    }
}
