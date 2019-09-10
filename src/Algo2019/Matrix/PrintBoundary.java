package Algo2019.Matrix;

public class PrintBoundary {

    public void print(int [][]input){
        int height = input.length;
        int width = input[0].length;

        for (int h = 0; h <height ; h++) {
            for (int w = 0; w <width ; w++) {
                if(h==0 || h==height-1){
                    //print all the elements
                    System.out.print(input[h][w] + "   ");
                }else if(w>0 && w<width-1){
                    System.out.print("    ");
                }else{
                    System.out.print(input[h][w] + "   ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int [][] grid = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 8, 7, 6},
                {5, 4, 3, 2}
        };
        PrintBoundary p = new PrintBoundary();
        p.print(grid);
    }
}
