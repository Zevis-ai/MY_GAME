import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Boots extends SuperObjects{

    public OBJ_Boots(){

        name = "Boots";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("Objects/boots.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
