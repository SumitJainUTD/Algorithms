package Algo2019.NoOfIslands;

import java.util.Stack;

public class NoOfIslands {

    public int numIslands(char[][] islandGrid) {

        int h = islandGrid.length;
        if (h == 0)
            return 0;
        int l = islandGrid[0].length;
        int result = 0;

        boolean[][] visited = new boolean[islandGrid.length][islandGrid[0].length];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                visited[i][j] = false;
            }
        }

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                if (!visited[i][j] && islandGrid[i][j] == '1') {
                    stack.push(i + "," + j);
                    DFS(stack, islandGrid, visited);
                    result++;
                }
            }
        }
        return result;
    }

    public void DFS(Stack<String> stack, char[][] islandGrid, boolean[][] visited) {

        int H = islandGrid.length;
        int L = islandGrid[0].length;

        while (stack.empty() == false) {

            String x = stack.pop();
            int row = Integer.parseInt(x.split(",")[0]);
            int col = Integer.parseInt(x.split(",")[1]);

            if(row<0 || col<0 || row>=H || col>=L || visited[row][col] || islandGrid[row][col]!='1')
                continue;

            visited[row][col]=true;
            stack.push(row + "," + (col-1)); //go left
            stack.push(row + "," + (col+1)); //go right
            stack.push((row-1) + "," + col); //go up
            stack.push((row+1) + "," + col); //go down
        }
    }

    public static void main(String[] args) {

        char [][] islandGrid = new char[][] {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        NoOfIslands noOfIslands = new NoOfIslands();
        System.out.println("No of Islands: " + noOfIslands.numIslands(islandGrid));

        islandGrid = new char[][] {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println("No of Islands: " + noOfIslands.numIslands(islandGrid));
    }
}