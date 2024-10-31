import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameApp extends JFrame implements ActionListener {

    private JButton[][] buttons = new JButton[4][4];
    private JPanel boardPanel;


    public GameApp() {
        setTitle("15-Spel");
        setSize(400,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}