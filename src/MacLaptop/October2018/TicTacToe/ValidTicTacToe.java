package MacLaptop.October2018.TicTacToe;

/**
 * Created by sjain on 10/21/18.
 */
public class ValidTicTacToe {


    public boolean validTicTacToe(String[] board) {

        int [] counts = getCount(board);
        int countX = counts[0];
        int countO = counts[1];

        if(countO>countX || Math.abs(countO-countX)>1)
            return false;

        boolean [] result = isValid(board);

        if( result[2]){
            if((result[0]) && (countX-countO)==0 || (result[1] && (countX>countO)) || (result[0] && (countO>countX)))
                return false;
            else
                return true;
        }
        else
            return false;


    }

    public boolean [] isValid(String [] board){
        boolean isXWinner = false;
        boolean isOWinner = false;
        for(int i=0;i<board.length;i++){
            String x = board[i];
            int countX = 0;
            int countO = 0;
            for(int j=0;j<x.length();j++){
                if(x.charAt(j)=='X')
                    countX++;
                if(x.charAt(j)=='O')
                    countO++;
            }
            if(countX==3)
                isXWinner = true;
            if(countO==3)
                isOWinner = true;
        }
        if(isXWinner && isOWinner)
            return new boolean[]{isXWinner, isOWinner,false};

        //check diagonals
        if(board[0].charAt(0)==board[1].charAt(1) && board[0].charAt(0)==board[2].charAt(2) && board[0].charAt(0)=='X'){
            if(!isXWinner && !isOWinner){
                isXWinner = true;
            }else{
                return new boolean[]{isXWinner, isOWinner,false};
            }
        }
        if(board[0].charAt(0)==board[1].charAt(1) && board[0].charAt(0)==board[2].charAt(2) && board[0].charAt(0)=='O'){
            if(!isXWinner && !isOWinner){
                isOWinner = true;
            }else{
                return new boolean[]{isXWinner, isOWinner,false};
            }
        }


        if(board[0].charAt(2)==board[1].charAt(1) && board[0].charAt(2)==board[2].charAt(0) && board[0].charAt(2)=='X'){
            isXWinner = true;
        }
        if(board[0].charAt(2)==board[1].charAt(1) && board[0].charAt(2)==board[2].charAt(0) && board[0].charAt(2)=='O'){
            isOWinner = true;
        }
        if(isXWinner && isOWinner)
            return new boolean[]{isXWinner, isOWinner,false};


        //check columns - 1
        if(board[0].charAt(0)==board[1].charAt(0) && board[0].charAt(0)==board[2].charAt(0) && board[0].charAt(0)=='X'){
            isXWinner = true;
        }
        if(board[0].charAt(0)==board[1].charAt(0) && board[0].charAt(0)==board[2].charAt(0) && board[0].charAt(0)=='O'){
            isOWinner = true;
        }

        if(isXWinner && isOWinner)
            return new boolean[]{isXWinner, isOWinner,false};

        //check columns - 2
        if(board[0].charAt(1)==board[1].charAt(1) && board[0].charAt(1)==board[2].charAt(1) && board[0].charAt(1)=='X'){
            isXWinner = true;
        }
        if(board[0].charAt(1)==board[1].charAt(1) && board[0].charAt(1)==board[2].charAt(1) && board[0].charAt(1)=='O'){
            isOWinner = true;
        }

        if(isXWinner && isOWinner)
            return new boolean[]{isXWinner, isOWinner,false};

        //check columns - 3
        if(board[0].charAt(2)==board[1].charAt(2) && board[0].charAt(2)==board[2].charAt(2) && board[0].charAt(2)=='X'){
            isXWinner = true;
        }
        if(board[0].charAt(2)==board[1].charAt(2) && board[0].charAt(2)==board[2].charAt(2) && board[0].charAt(2)=='O'){
            isOWinner = true;
        }

        if(isXWinner && isOWinner)
            return new boolean[]{isXWinner, isOWinner,false};

        return new boolean[]{isXWinner, isOWinner,true};

    }

    public int[] getCount(String [] board){
        int countX = 0;
        int countO = 0;
        for(int i=0;i<board.length;i++){
            String x = board[i];
            for(int j=0;j<x.length();j++){
                if(x.charAt(j)=='X')
                    countX++;
                if(x.charAt(j)=='O')
                    countO++;
            }
        }
        return new int [] {countX, countO};
    }

    public static void main(String[] args) {
        ValidTicTacToe v = new ValidTicTacToe();
//        String [] board = new String [] {"XOX","O O","XOX"};
        String [] board = new String [] {"OXX","XOX","OXO"};
        System.out.println(v.validTicTacToe(board));
    }
}
