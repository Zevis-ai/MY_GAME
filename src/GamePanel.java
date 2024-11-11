import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    /**
     *   SCREEN SETTINGS
     */
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 40x40 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;// 768 pixels
    public final int screenHeight = tileSize * maxScreenRow;// 576 pixels

    // WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Sound sound = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AsserSetter aSetter = new AsserSetter(this);
    Thread gameThread;

    // ENTITY AND OBJECT
    public Player player = new Player(this,keyH);
    public SuperObjects obj[] = new SuperObjects[10];



//    int playerX = 100;
//    int playerY = 100;
//    int speedPlayer = 4;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setUpGame(){
        aSetter.setObject();

        playMusic(0);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
        this.requestFocusInWindow();
    }

//    @Override
//    public void run() {
//
//        double drawInterval = 1000000000/FPS; // 0.01666 seconds
//        double nextDrawTime = System.nanoTime() + drawInterval;
//
//        while (gameThread != null){
//
//            update();
//
//            repaint();
//
//            try {
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime = remainingTime/1000000;
//
//                if (remainingTime < 0){
//                    remainingTime = 0;
//                }
//
//                Thread.sleep((long)remainingTime);
//
//                nextDrawTime += drawInterval;
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;


        while (gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime)/ drawInterval;
            timer += (currentTime - lastTime);

            lastTime = currentTime;

            if (delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }


        }
    }


    public void update(){
        player.update();
//        if (keyH.upPressed == true) {
//            playerY -= speedPlayer;
//        } else if (keyH.downPressed == true) {
//            playerY += speedPlayer;
//        } else if (keyH.leftPressed == true) {
//            playerX -= speedPlayer;
//        } else if (keyH.rightPressed == true) {
//            playerX += speedPlayer;
//        }

    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        // TILE
        tileM.draw(g2);
        // OBJECT
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null){
                obj[i].draw(g2,this);
            }
        }
        // PLAYER
        player.draw(g2);

//        g2.setColor(Color.WHITE);
//
//        g2.fillRect(playerX,playerY,tileSize,tileSize);

        g2.dispose();
    }
    public void playMusic(int i){

        sound.setFile(i);
        sound.play();
        sound.loop();

    }
    public void stopMusic(){
        sound.stop();
    }
    public void playSE(int i){

        sound.setFile(i);
        sound.play();
    }
}
