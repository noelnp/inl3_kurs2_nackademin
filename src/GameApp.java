import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameApp extends JFrame implements ActionListener {

    private JButton[][] buttons = new JButton[4][4];
    private GameLogic gameLogic;
    private JPanel boardPanel;
    private JButton specialSetupButton;


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

        //Skapar knappen till specialinställningen
        specialSetupButton = new JButton("Specialinställning");
        specialSetupButton.addActionListener(e -> {
            gameLogic.setupWinningBoard();
            updateBoard();
        });
        add(specialSetupButton,BorderLayout.SOUTH);

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
        int[][] board = gameLogic.getBoard();  // getBoard istället för direkt access
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                int value = board[row][col];
                buttons[row][col].setText(value == 0 ? "" : String.valueOf(value));  // Visa tom ruta för 0
                buttons[row][col].setOpaque(true);  // Gör knappen helt opak
                buttons[row][col].setBorder(BorderFactory.createLineBorder(Color.WHITE));
                buttons[row][col].setBackground(value == 0 ? Color.WHITE : Color.LIGHT_GRAY);  // Sätt färger
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