package Algo2019.NoOfIslands;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslandsBFS {

    public int numIslands(char[][] islandGrid) {

        int h = islandGrid.length;
        if (h == 0)
            return 0;
        int l = islandGrid[0].length;
        int islands = 0;

        boolean[][] visited = new boolean[islandGrid.length][islandGrid[0].length];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                visited[i][j] = false;
            }
        }

        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                if (!visited[i][j] && islandGrid[i][j] == '1') {
                    queue.add(i + "," + j);
                    BFS(queue, islandGrid, visited);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void BFS(Queue<String> queue, char[][] islandGrid, boolean[][] visited) {

        int H = islandGrid.length;
        int L = islandGrid[0].length;

        while (queue.isEmpty() == false) {

            String x = queue.remove();
            int row = Integer.parseInt(x.split(",")[0]);
            int col = Integer.parseInt(x.split(",")[1]);

            if(row<0 || col<0 || row>=H || col>=L || visited[row][col] || islandGrid[row][col]!='1')
                continue;

            visited[row][col]=true;
            queue.add(row + "," + (col-1)); //go left
            queue.add(row + "," + (col+1)); //go right
            queue.add((row-1) + "," + col); //go up
            queue.add((row+1) + "," + col); //go down
        }
    }

    public static void main(String[] args) {

        char [][] islandGrid = new char[][] {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        NoOfIslandsBFS noOfIslands = new NoOfIslandsBFS();
        System.out.println("No of Islands: " + noOfIslands.numIslands(islandGrid));

        islandGrid = new char[][] {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println("No of Islands: " + noOfIslands.numIslands(islandGrid));
    }
}
