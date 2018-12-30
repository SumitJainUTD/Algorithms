package Published.Arrays.FirstDecreasingIndex;
//Written
/**
 * Created by sjain on 8/12/17.
 */
public class FirstDecreasingBinarySearch {
    public static int find(int[] arrA, int start, int end) {
        //base case1: array is null
        if (arrA == null || arrA.length == 0)
            return -1;
        //base case2: if only one element is present
        if (start == end)
            return start;
        //base case3: if only two elements are present, then return which ever is maximum
        if (end == start + 1 && arrA[start] > arrA[end])
            return start;
        //base case4: if only two elements are present, and first element<second element
        if (end == start + 1 && arrA[start] < arrA[end])
            return end;

        //modified binary search
        int mid = start + (end - start) / 2;
        if (arrA[mid] > arrA[mid + 1] && arrA[mid] > arrA[mid - 1])
            return mid;
        else if (arrA[mid] > arrA[mid + 1] && arrA[mid] < arrA[mid - 1]) {
            return find(arrA, start, mid);
        } else //if(arrA[mid]==1){
            return find(arrA, mid + 1, end);
    }

    public static void main(String[] args) {
        int [] arrA = {1,2,4,6,11,15,19,20,21,31,41,51,55,46,35,24,18,14,13,12,11,4,2,1};
        int index = find(arrA, 0, arrA.length - 1);
        System.out.println("(Binary Search) First Element from where elements starts decreasing: (index: "+index+") : " + arrA[index]);
    }
}