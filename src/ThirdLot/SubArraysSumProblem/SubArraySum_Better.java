package ThirdLot.SubArraysSumProblem;

/**
 * Created by sumi1 on 12/22/2017.
 */
public class SubArraySum_Better {
    public int findSum(int [] arrA){

        int n = arrA.length;
        int totalSum = 0;
//       For ith index the number of occurrences are = (n-i)*(i+1)
//        Contribution of each element in totalSum is arrA[i]*(n-i)*(i+1)
        for (int i = 0; i <n ; i++) {
            totalSum += arrA[i]*(n-i)*(i+1);
        }
        return totalSum;
    }

    public static void main(String[] args) {
        int [] arrA = {1,2,3,4};
        int sum = new SubArraySum_Better().findSum(arrA);
        System.out.println("Sum of elements of sub arrays is: " +  sum);
    }
}
