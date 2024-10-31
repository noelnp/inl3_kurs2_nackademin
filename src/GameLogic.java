import java.util.ArrayList;
import java.util.Collections;

public class GameLogic {
    private int[][] board;


    public GameLogic() {
        board = new int[4][4];
        initBoard();
    }

    private void initBoard() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 15; i++) numbers.add(i);
        numbers.add(0); // Lägg till 0 för tom plats
        Collections.shuffle(numbers);
        // Initiera spelet med nummer och blanda dem
    }

    public boolean canMoveBrick(int brick) {
        // Kolla om brickan kan flyttas på
        return true;
    }

    public void moveBrick(int brick) {
        // Flytta brickan om det är möjligt
    }

    public boolean isSolved() {
        // Kolla om spelet är avklarat
        return true;
    }
}