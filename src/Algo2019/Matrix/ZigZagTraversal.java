package Algo2019.Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversal {
    public void BFS(int[][] grid) {

        int H = grid.length;
        if (H == 0)
            return ;
        int L = grid[0].length;

        boolean[][] visited = new boolean[H][L];


        Queue<String> queue = new LinkedList<>();

        //add the first element position to queue
        queue.add(0 + "," + 0);

        System.out.println("Zig-Zag Traversal: ");
        while (queue.isEmpty() == false) {
            int size = queue.size();
            while (size > 0) {
                String x = queue.remove();
                int row = Integer.parseInt(x.split(",")[0]);
                int col = Integer.parseInt(x.split(",")[1]);

                visited[row][col] = true;
                System.out.print(grid[row][col] + " ");

                //go down if allowed
                if (row + 1 < H && !visited[row + 1][col] && !queue.contains((row + 1) + "," + col))
                    queue.add((row + 1) + "," + col); //go down
                //go right if allowed
                if (col + 1 < L && !visited[row][col + 1] && !queue.contains(row + "," + (col + 1)))
                    queue.add(row + "," + (col + 1)); //go right
                size--;
            }
            //for line break for each diagonal
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int [][] grid = new int[][] {
                {1, 2,  3,  4},
                {5, 6,  7,  8},
                {9, 10, 11, 12},
                {13,14, 15, 16}
        };
        ZigZagTraversal d = new ZigZagTraversal();
        d.BFS(grid);
    }
}
