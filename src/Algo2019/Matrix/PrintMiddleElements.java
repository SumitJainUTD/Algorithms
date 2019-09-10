package Algo2019.Matrix;

public class PrintMiddleElements {

    public void print(int [][]input){
        int height = input.length;
        int width = input[0].length;

        for (int h = 0; h <height ; h++) {
            for (int w = 0; w <width ; w++) {
                if(h==0 || h==height-1){
                    //print all the elements
                    //do nothing
                }else if(w>0 && w<width-1){
                    System.out.print(input[h][w] + "   ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int [][] grid = new int[][] {
                {1, 2, 3, 4, 8},
                {5, 6, 7, 8, 9},
                {9, 8, 7, 6, 7},
                {5, 4, 3, 2, 2},
                {1, 2, 3, 4, 8}
        };
        PrintMiddleElements p = new PrintMiddleElements();
        p.print(grid);
    }
}

