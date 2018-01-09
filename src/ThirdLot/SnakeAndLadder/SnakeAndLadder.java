package ThirdLot.SnakeAndLadder;

import java.util.LinkedList;
import java.util.Queue;


public class SnakeAndLadder {

    static class Node{
        int cell;
        int moves;
    }
    public int findMinMoves(int [] board){

        int size = board.length;
        //create visited array for each cell
        boolean [] visited = new boolean[size];

        Queue<Node> queue = new LinkedList<>();
        //start from position 1 (index 0) and it is already visited
        Node node = new Node();
        node.cell=0;
        node.moves =0;
        queue.add(node);
        visited[0] = true;

        //BFS from cell number 0
        while(queue.isEmpty()==false){
            //remove from front of queue
            node = queue.remove();
            int cellNum = node.cell;

            //check if reached to the end
            if(cellNum==size-1)
                break;

            //if not reached to the end then add the reachable adjacent cells from the current cells
            //Since dice can be controlled and max value can be achieved 6
            //so from the current cell, you can reach to next 6 cells so add next 6 cells
            for (int i = cellNum+1; i <(cellNum+6) && i<size ; i++) {
                //check if cell is already not visited
                if(visited[i]!=true){
                    //add it to the queue, update moves and mak visited
                    Node currentNode = new Node();
                    currentNode.moves = node.moves+1; //can be reached by throwing dice one more time
                    visited[i] = true;
                    //now fill the cell can be reached (might be snake or ladder)
                    if(board[i]==-1){
                        //means can be reached by throwing dice at that cell
                        currentNode.cell = i;
                    }else{
                        //might be snake OR ladder at this cell 'i'
                        //then tail of the snake or top of the ladder will be achieved
                        // by reaching at cell 'i'
                        currentNode.cell = board[i];
                    }
                    //add to queue
                    queue.add(currentNode);
                }
            }
        }
        return  node.moves;
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

        SnakeAndLadder s = new SnakeAndLadder();
        System.out.println("Minimum Dice throws needed to reach to end: " + s.findMinMoves(board));
    }
}
