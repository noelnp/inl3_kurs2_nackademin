import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameApp extends JFrame implements ActionListener {

    private JButton[][] buttons = new JButton[4][4];
    private GameLogic gameLogic;
    private JPanel boardPanel;


    public GameApp() {
        gameLogic = new GameLogic();
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

    private void initializeBoard(){
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].setFont(new Font("Arial", Font.BOLD, 20));
                buttons[row][col].addActionListener(this);
                boardPanel.add(buttons[row][col]);
            }
        }
    }



    private void updateBoard(){
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                int value = gameLogic.board[row][col];
                buttons[row][col].setText(value == 0 ? "" : String.valueOf(value));
            }
        }


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (buttons[row][col] == clickedButton) {
                    int brick = gameLogic.board[row][col];
                    if (gameLogic.canMoveBrick(brick)) {
                        gameLogic.moveBrick(brick);
                        updateBoard();
                    }
                    if (gameLogic.isSolved()) {
                        JOptionPane.showMessageDialog(this, "Grattis, du vann!");
                    }
                    return;
                }
            }
        }


    }
}