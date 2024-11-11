import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyAnonymos {
    public static void main(String[] args) throws InterruptedException {

//        int x = 0, y = 0;

        JFrame jFrame = new JFrame();
        jFrame.setSize(500,200);
        jFrame.setTitle("zevi");

        JButton jButton = new JButton("zevi");
        jButton.setBounds(10,10,80,80);


        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("zevi");
            }
        });

        jFrame.add(jButton);
        jFrame.setLayout(null);
        jFrame.setVisible(true);

//        for (int i = 0; i < 100; i++) {
//            Thread.sleep(100);
//            jFrame.setLocation(x,y);
//            jButton.setLocation(0,0);
//            x += 10;
//            y += 10;
//        }
    }
}
