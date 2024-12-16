package entities;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Enemy extends Obstacle{
    public Enemy() throws IOException {
        name = "Enemy";
        try{
            img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/enemy_car.jpg")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
