import java.util.ArrayList;
import java.util.Collections;


public class GameLogic {
    int[][] board;


    public GameLogic() {
        board = new int[4][4];
        initBoard();
    }

    private void initBoard() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 15; i++) numbers.add(i);
        numbers.add(0); // Lägg till 0 för tom plats
        Collections.shuffle(numbers); // Blanda listan

        // Fyll board arrayen med värdena från numbers
        int index = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                board[row][col] = numbers.get(index);
                index++;
            }
        }
    }

    public boolean canMoveBrick(int brick) {
        //ser till att brickan är inom korrekt intervall
        if (brick < 1 || brick > 15){
            return false;
        }
        //Brickans positionering
        int [] targetPos = findPosition(brick);
        //Den tomma platsens positionering
        int [] blankPos = findPosition(0);

        //felhantering ifall vi inte hittar positionerna
        if (targetPos == null || blankPos == null) {
            return false;
        }

        int targetRow = targetPos[0];
        int targetCol = targetPos[1];
        int blankRow = blankPos[0];
        int blankCol = blankPos[1];
        // håller koll på att brickan är intill den tomma platsen
        return (targetRow == blankRow - 1 && targetCol == blankCol) ||
                (targetRow == blankRow + 1 && targetCol == blankCol) ||
                (targetRow == blankRow && targetCol == blankCol -1) ||
                (targetRow == blankRow && targetCol == blankCol +1);

    }

    private int[] findPosition(int value) {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (board[row] [col] == value) {
                    return new int[]{row, col};
                }

            }
        }
        return null;

    }

    public void moveBrick(int brick) {
        if (canMoveBrick(brick)) {
             int[] brickPosition = findPosition(brick);
             int[] blankPosition = findPosition(0);

            board[blankPosition[0]][blankPosition[1]] = brick;
            board[brickPosition[0]][brickPosition[1]] = 0;
        } else {
            System.out.println("Brickan kan ej flyttas på.");
        }
    }

    public boolean isSolved() {
        int expectedValue = 1; // Börjar från 1


        //Gå igenom hela brädet rad för rad, kolumn för kolumn
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {

               //Om vi når den sista rutan, den ska vara 0
                if(row == 3 && col == 3){
                    return board[row][col] == 0;
                }

                // Kollar om värdet matchar förväntat värde
                if (board[row][col] != expectedValue) {
                    return false;
                }
                expectedValue++;

            }
        }


        return true;
    }

    public int[][] getBoard() {
        return board;
    }

    public void printBoard() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                System.out.print(board[row][col] + "\t");
            }
            System.out.println();
        }
    }

    //Skapar metod för specialinställning i spelet
    public void setupWinningBoard(){

        int count = 1;

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (row == 3 && col == 3){
                    board[row][col] = 0; // En tom plats längst ner till höger
                } else {
                    board[row][col] = count++;
                }
            }
        }
    }

}