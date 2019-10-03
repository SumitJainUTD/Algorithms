package Algo2019;

public class Sort2DArray {

    public void sort(int [][] input){

        System.out.println("Given Array: ");
        print(input);
        for (int row = 0; row <input.length-1 ; row++) {
            for (int col = 0; col <input[row].length ; col++) {
                placeCurrentElementAtCorrectPosition(input, row, col, row+1);
            }
        }
        System.out.println("Sorted Array: ");
        print(input);
    }

    void placeCurrentElementAtCorrectPosition(int [][] input, int curr_row, int curr_col, int rowIndex){
        int min = input[curr_row][curr_col];
        int min_row = curr_row;
        for (int i = rowIndex; i <input.length ; i++) {
            if(min>input[i][0]){
                min = input[i][0];
                min_row = i;
            }
        }

        //swap if needed
        if(curr_row!=min_row){
            int num = input[curr_row][curr_col];
            input[curr_row][curr_col] = input[min_row][0];
            input[min_row][0] = num;

            //reorder the swapped row
            reorder(input, min_row);
        }
    }

    void reorder(int [][] input, int row){
        for (int col = 0; col <input[row].length-1 ; col++) {
            if(input[row][col]>input[row][col+1]) {
//              swap
                int num = input[row][col];
                input[row][col] = input[row][col+1];
                input[row][col+1] = num;
            }else{
                //row is sorted, no need to check further
                break;
            }
        }
    }
     void print(int [][] input){
         for (int row = 0; row <input.length ; row++) {
             for (int col = 0; col < input[row].length; col++) {
                 int currNum = input[row][col];
                 System.out.print(currNum + "   ");
             }
             System.out.println();
         }
     }

    public static void main(String[] args) {
        int [][] input = {  { 5, 12, 17, 21, 23},
                            { 1,  2,  4,  6,  8},
                            {12, 14, 18, 19, 27},
                            { 3,  7,  9, 15, 25}
        };

        Sort2DArray s = new Sort2DArray();
        s.sort(input);
    }
}
