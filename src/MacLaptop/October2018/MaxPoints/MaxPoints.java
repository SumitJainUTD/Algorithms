package MacLaptop.October2018.MaxPoints;

/**
 * Created by sjain on 10/6/18.
 */
public class MaxPoints {

    public int maxPoints(Point[] points) {
        int [] result = new int[points.length];

        for (int i = 0; i <result.length ; i++) {
            //every point will be passing through at least 1 line
            result[i] = 1;
        }


        for (int i = 0; i <points.length ; i++) {
            int x1 = points[i].x;
            int y1 = points[i].y;

        }





        //return the max
        int max = -1;
        for (int i = 0; i <result.length ; i++) {
            max = Math.max(max, result[i]);
        }
        return max;
    }

    private boolean isOnTheSameLine(int x1, int y1, int x2, int y2, int x3, int y3){
        double slope = (y2-y1)/(x2-x1);
        //(y-y1) = m(x-x1)
        if((y3-y1)==slope*(x3-x1)){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        MaxPoints m = new MaxPoints();
        System.out.println(m.isOnTheSameLine(4,4,2,2,3,3));
    }
}

class Point {
        int x;
         int y;
         Point() { x = 0; y = 0; }
         Point(int a, int b) { x = a; y = b; }
     }
