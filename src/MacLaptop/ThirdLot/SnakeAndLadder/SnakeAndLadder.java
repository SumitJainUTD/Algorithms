package MacLaptop.ThirdLot.SnakeAndLadder;

/**
 * Created by sjain on 9/27/17.
 */
public class SnakeAndLadder {

    public int findMinMoves(int [] board){
        return  0;
    }


    public static void main(String[] args) {
        int size = 30;
        int [] board = new int[size];
        for (int i = 0; i <size ; i++) {
            board[i] = -1;
        }
        //snakes
        board[2] = 21;
        board[4] = 7;
        board[10] = 25;
        board[19] = 28;

        // Snakes
        board[26] = 0;
        board[20] = 8;
        board[16] = 3;
        board[18] = 6;
    }
}
