package OtherLaptop.ArrayProblems.LocalMinima;

/**
 * Created by sjain on 8/14/17.
 */
public class LocalMinimaBinary {

    public int find(int [] arrA, int start, int end){

        //find the mid
        int mid = start + (end-start)/2;
        int size = arrA.length;

        //check the local minima (element is smaller than its left and right neighbors)
        //first check if left and right neighbor exists
        if((mid==0 || arrA[mid-1]>arrA[mid]) &&
                (mid==size-1 || arrA[mid+1]>arrA[mid]))
            return arrA[mid];
        //check if left neighbor is less than mid element, if yes go left
        else if(mid>0 && arrA[mid]>arrA[mid-1]){
            return find(arrA, start, mid);
        }else { //if(mid<size-1 && arrA[mid]>arrA[mid+1])
            return find(arrA, mid+1, end);
        }
    }


    public static void main(String[] args) {
        LocalMinimaBinary l = new LocalMinimaBinary();
        int [] arrA = {11, 4, 2, 5, 11, 13, 5};
        System.out.println("Local Minima is: " + l.find(arrA,0,arrA.length));
    }
}

