package Algo2019.Matrix;

public class DFSInMatrixRecursion {

    public void DFS(int[][] grid) {

        int h = grid.length;
        if (h == 0)
            return;
        int l = grid[0].length;

        //created visited array
        boolean [][] visited = new boolean[h][l];
        System.out.println("Depth-First Search: ");
        DFSUtil(grid, 0,  0, visited);
    }

    public void DFSUtil(int[][] grid, int row, int col, boolean[][] visited) {

        int H = grid.length;
        int L = grid[0].length;

        if (row < 0 || col < 0 || row >= H || col >= L || visited[row][col])
            return;

        //mark the cell visited
        visited[row][col] = true;
        System.out.print(grid[row][col] + " ");
        DFSUtil(grid, row+ 1, col,visited); // go right
        DFSUtil(grid, row- 1, col,visited); //go left
        DFSUtil(grid, row, col + 1,visited); //go down
        DFSUtil(grid, row, col - 1,visited); // go up
    }

    public static void main(String[] args) {

        int [][] grid = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        DFSInMatrixRecursion d = new DFSInMatrixRecursion();
        d.DFS(grid);
    }
}
