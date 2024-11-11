import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoveJframe {
    static int x  = 0, y = 0;

    public static void move(JFrame jFrame){
        jFrame.setLocation(x,y);
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(500,500);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setTitle("zevi");

        JButton jButton = new JButton();
        jButton.setBounds(x,y,80,80);
        jFrame.add(jButton);

        jFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();

                switch (code) {
                    case KeyEvent.VK_UP -> y -= 10;
                    case KeyEvent.VK_DOWN -> y += 10;
                    case KeyEvent.VK_RIGHT -> x += 10;
                    case KeyEvent.VK_LEFT -> x -= 10;
                }
                jButton.setBounds(x, y, 80, 80);
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        jFrame.setFocusable(true);
        jFrame.requestFocusInWindow();

        while (true){
            move(jFrame);
        }
    }
}
