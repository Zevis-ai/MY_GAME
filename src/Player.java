import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    int hesKey = 0;

    public Player(GamePanel gp, KeyHandler keyH){

        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValue();
        getPlayerImage();
    }

    public void setDefaultValue(){
        worldx  = gp.tileSize * 23;
        worldy  = gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("Player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("Player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("Player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("Player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("Player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("Player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("Player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("Player/boy_right_2.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){

        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed){
            if (keyH.upPressed) {
                direction = "up";

            } else if (keyH.downPressed) {
                direction = "down";

            } else if (keyH.leftPressed) {
                direction = "left";

            } else if (keyH.rightPressed) {
                direction = "right";

            }

            // CHECK TILE COLLISION
            collisonOn = false;
            gp.cChecker.checkTile(this);

            // CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);


            // IF COLLISION IS FALSE, PLAYER CAN MOVE
            if (!collisonOn){
                switch (direction){
                    case "up" -> worldy -= speed;
                    case "down" -> worldy += speed;
                    case "left" -> worldx -= speed;
                    case "right" ->  worldx += speed;
                }
            }

            spriteCounter++;
            if (spriteCounter > 10){
                if (spriteNum == 1){
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void pickUpObject(int i){
        if (i != 999){
//            gp.obj[i] = null;
            String objectName = gp.obj[i].name;

            switch (objectName){
                case "Key":
                    hesKey++;
                    gp.obj[i] = null;
                    System.out.println("Key: " + hesKey);
                    break;
                case "Door":
                    if (hesKey > 0){
                        gp.obj[i] = null;
                        hesKey--;
                    }
                    System.out.println("Key: " + hesKey);
                    break;
                case "Boots":
                    speed += 3;
                    gp.obj[i] = null;
                    break;
            }
        }
    }

    public void draw(Graphics2D g2){
//        g2.setColor(Color.WHITE);
//
//        g2.fillRect(x,y,gp.tileSize,gp.tileSize);

        BufferedImage image = null;

        switch (direction){
            case "up":
                if (spriteNum == 1){
                    image = up1;
                }
                if (spriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1){
                    image = down1;
                }
                if (spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1){
                    image = left1;
                }
                if (spriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1){
                    image = right1;
                }
                if (spriteNum == 2){
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

    }
}
