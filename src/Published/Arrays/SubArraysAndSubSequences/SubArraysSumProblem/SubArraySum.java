package Published.Arrays.SubArraysAndSubSequences.SubArraysSumProblem;

/**
 * Created by sumi1 on 12/22/2017.
 */
public class SubArraySum {
    public int findSum(int [] arrA){

        int arrSize = arrA.length;
        int totalSum = 0;
        //start point
        for (int startPoint = 0; startPoint <arrSize ; startPoint++) {
            //group sizes
            for (int grps = startPoint; grps <=arrSize ; grps++) {
                //if start point = 1 then
                //grp size = 1 , print 1
                //grp size = 2, print 1 2
                //grp size = 3, print 1 2 3 ans so on
                for (int j = startPoint ; j < grps ; j++) {
                    totalSum += arrA[j];
                }
            }
        }
        return totalSum;
    }

    public static void main(String[] args) {
        int [] arrA = {1,2,3,4};
        int sum = new SubArraySum().findSum(arrA);
        System.out.println("Sum of elements of sub arrays is: " +  sum);
    }

}

