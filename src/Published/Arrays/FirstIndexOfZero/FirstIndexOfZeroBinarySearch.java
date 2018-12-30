package Published.Arrays.FirstIndexOfZero;
//Written
/**
 * Created by sjain on 8/12/17.
 */
public class FirstIndexOfZeroBinarySearch {
    public static int find(int [] arrA, int start, int end){
        //base case 1:
        if(start>end)
            return 0;
        //base case2: if only one element
        if(start==end){
            //if that element is 0, then return that index
            if(arrA[start]==0)
                return start;
            if(arrA[start]==1)
                return -1;
        }

        int mid = start + (end-start)/2;
        if(arrA[mid]==0 && arrA[mid-1]==1)
            return mid;
        else if(arrA[mid]==0 && arrA[mid-1]==0){
            return find(arrA,start,mid);
        }else //if(arrA[mid]==1){
            return find(arrA,mid+1,end);
    }

    public static void main(String[] args) {
        int [] arrA = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println("(Binary Search)First Index from where 0 starts: " + find(arrA,0,arrA.length-1));
    }
}
