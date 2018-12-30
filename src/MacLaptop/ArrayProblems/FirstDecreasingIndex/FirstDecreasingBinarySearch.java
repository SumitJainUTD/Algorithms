package MacLaptop.ArrayProblems.FirstDecreasingIndex;

/**
 * Created by sjain on 8/12/17.
 */
public class FirstDecreasingBinarySearch {
    public static int find(int [] arrA, int start, int end){
        if(start>end)
            return 0;
        int mid = start + (end-start)/2;
        if(arrA[mid]>arrA[mid-1] && arrA[mid]>arrA[mid+1])
            return mid;
        else if(arrA[mid]<arrA[mid-1] && arrA[mid]>arrA[mid+1]){
            return find(arrA,start,mid);
        }else //if(arrA[mid]==1){
            return find(arrA,mid+1,end);
    }

    public static void main(String[] args) {
        int [] arrA = {1,2,4,6,11,15,19,20,21,31,41,51,55,46,35,24,18,14,13,12,11,4,2,1};
        System.out.println("(Binary Search) First Element from where elements starts decreasing: " + arrA[find(arrA, 0, arrA.length-1)]);
    }
}
