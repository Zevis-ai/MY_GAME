import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Door extends SuperObjects{

    public OBJ_Door(){

        name = "Door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("Objects/door.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }

}
