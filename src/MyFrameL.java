import javax.swing.*;
import java.awt.*;

public class MyFrameL {
    public static void main(String[] args) throws InterruptedException {

//        int a = 5; // 0101 בבינארי
//        int b2 = 3; // 0011 בבינארי
//        int result = a & b2; // התוצאה תהיה 1 (0001 בבינארי)
//
//        final int WIFI = 1;
//        final int AC = 16;
//
//        int wifiEndAC = WIFI & AC;
//        System.out.println("wifiEndAC " + wifiEndAC);
//
//        System.out.println(result);
        JFrame jFrame = new JFrame();
        JPanel jPanel = new JPanel();

        jPanel.setLayout(new GridLayout(2, 2));

        JButton jButton1 = new JButton("1");
        JButton jButton2 = new JButton("2");
        JButton jButton3 = new JButton("3");
        JButton jButton4 = new JButton("4");

        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel.add(jButton3);
        jPanel.add(jButton4);

        jFrame.add(jPanel);
        jFrame.setSize(700, 800);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        int r = 0, g = 0, b = 0;

        while (true) {

            r = (r + 5) % 256;
            g = (g + 10) % 256;
            b = (b + 15) % 256;

            Color color1 = new Color(r, g, b);
            Color color2 = new Color((r + 50) % 256, (g + 100) % 256, (b + 150) % 256);
            Color color3 = new Color((r + 100) % 256, (g + 150) % 256, (b + 50) % 256);
            Color color4 = new Color((r + 150) % 256, (g + 50) % 256, (b + 100) % 256);

            jButton1.setBackground(color1);
            jButton2.setBackground(color2);
            jButton3.setBackground(color3);
            jButton4.setBackground(color4);

            Thread.sleep(50);
        }
    }
}
