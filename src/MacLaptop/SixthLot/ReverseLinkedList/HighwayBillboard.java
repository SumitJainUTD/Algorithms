package MacLaptop.SixthLot.ReverseLinkedList;

/**
 * Created by sjain on 10/1/18.
 */
public class HighwayBillboard {

    public int highway(int [] miles, int [] revenue, int res ){

        if(miles==null || revenue==null || miles.length==0 || revenue.length ==0)
            return 0;

        int [] solution = new int[miles.length+1];

        solution[0] = revenue[0];

        for (int i = 1; i <miles.length ; i++) {
            int limit = miles[i]-miles[i-1];
            if(limit<6)
                solution[i] = revenue[i];
            else{
                int temp = 0;
                for (int j = limit; j >=0 ; j--) {
                    temp  = Math.max(temp, solution[j]);
                }
                solution[i] = temp + revenue[i];
            }
        }

        //return the max
        int result = 0;
        for (int i = 0; i <solution.length ; i++) {
            result = Math.max(result, solution[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] x = {6, 7, 12, 13, 14};
        int[] revenue = {5, 6, 5, 3, 1};
        int distance = 20;
        int milesRestriction = 5;

        HighwayBillboard h = new HighwayBillboard();
        System.out.println(h.highway(x,revenue,milesRestriction));
    }
}
