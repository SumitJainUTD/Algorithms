package MacLaptop.SixthLot;

/**
 * Created by sjain on 9/20/18.
 */
public class MaxTip {

    public static int maxTip(int [] X, int xCount, int xStart, int xMax, int [] Y, int yCount, int yStart, int yMax, int N ){
        if(xCount + yCount ==N)
            return 0;

        //if X limit is reached. pick rest of the elements from Y
        if(xCount>=xMax && yStart<Y.length){
            //pick the next element in Y
            int t1 = Y[yStart] +  maxTip(X, xCount, xStart+1, xMax, Y, yCount+1, yStart+1, yMax, N);
            //do not pick the next element in Y
            int t2 = maxTip(X, xCount, xStart+1, xMax, Y, yCount, yStart+1, yMax, N);

            return Math.max(t1, t2);
        }

        //if Y limit is reached. pick rest of the elements from X
        else  if(yCount>=yMax && xStart<X.length){
            //pick the next element in Y
            int t1 = X[xStart] +  maxTip(X, xCount+1, xStart+1, xMax, Y, yCount, yStart+1, yMax, N);
            //do not pick the next element in Y
            int t2 = maxTip(X, xCount, xStart+1, xMax, Y, yCount, yStart+1, yMax, N);

            return Math.max(t1, t2);
        }
        else if(yStart<Y.length && xStart<X.length){
            //try out all the options
            //pick the next element in Y
            int t1 = Y[yStart] + maxTip(X, xCount, xStart+1, xMax, Y, yCount + 1, yStart + 1, yMax, N);

            //pick the next element in X
            int t2 = X[xStart] + maxTip(X, xCount + 1, xStart + 1, xMax, Y, yCount, yStart+1, yMax, N);

            return  Math.max(t1, t2);
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int X [] = {1,4,3,2,7,5,9,6};
        int Y [] = {1,2,3,6,5,4,9,8};
        int xMax = 4;
        int yMax = 4;
        int N = 8;

        System.out.println(maxTip(X, 0, 0, xMax, Y, 0, 0, yMax, N));
    }
}
