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




    private void initializeBoard() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].setFont(new Font("Arial", Font.BOLD, 20));
                buttons[row][col].addActionListener(this);
                boardPanel.add(buttons[row][col]);
            }
        }

    }

    private void updateBoard() {

    }






    @Override
    public void actionPerformed(ActionEvent e) {

    }
}