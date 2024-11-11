import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Zevi extends JFrame implements KeyListener {
    private JLabel label;

    public Zevi() {
        // הגדרת חלון
        setTitle("Key Listener Example");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // יצירת תווית להצגת ההודעה
        label = new JLabel("Press A, B, or C", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 24));
        add(label);

        // הוספת מאזין מקשים
        addKeyListener(this);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Zevi();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // לא נדרש פעולה כאן
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_A -> label.setText("לחצת על A");
            case KeyEvent.VK_B -> label.setText("לחצת על B");
            case KeyEvent.VK_C -> label.setText("לחצת על C");
            default -> label.setText("Press A, B, or C");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // ניתן להוסיף קוד כאן במידה ויש צורך
    }
}
