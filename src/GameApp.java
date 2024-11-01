import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameApp extends JFrame implements ActionListener {

    private JButton[][] buttons = new JButton[4][4];
   // private GameLogic gameLogic;
    private JPanel boardPanel;


    public GameApp() {
        // gameLogic = new GameLogic();
        setupFrame();
        initializeBoard();
        updateBoard();
        setVisible(true);


    }

    private void setupFrame(){
        setTitle("15-Spel");
        setSize(400,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Skapar panelen med GridLayout
        boardPanel = new JPanel(new GridLayout(4,4));
        add(boardPanel,BorderLayout.CENTER);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}