package MacLaptop.October2018.TicTacToe;

/**
 * Created by sjain on 10/21/18.
 */
public class TicTacToe2 {
    public boolean validTicTacToe(String[] board) {
        int [] counts = getCount(board);
        int cntx = counts[0];
        int cnto = counts[1];

        if(cntx != cnto && cntx != cnto+1) return false;
        if(win(board,'X') && win(board,'O')) return false;
        if(win(board,'X') && cntx == cnto) return false;
        if(win(board,'O') && cntx == cnto + 1) return false;
        return true;
    }
    public boolean win(String[] board,char c) {
        String end = ""+c+c+c;
        for(String s: board) {
            if(s.equals(end)) return true;
        }
        for(int i= 0;i<board.length;i++) {
            String t = "";
            for(int j = 0;j<board.length;j++) {
                t += board[j].charAt(i);
            }
            if(t.equals(end)) return true;
        }
        String a = "" + board[0].charAt(0) + board[1].charAt(1) + board[2].charAt(2);
        String b = "" + board[0].charAt(2) + board[1].charAt(1) + board[2].charAt(0);
        if(a.equals(end) || b.equals(end)) return true;
        return false;
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
}
