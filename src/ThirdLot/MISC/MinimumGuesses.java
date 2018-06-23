package ThirdLot.MISC;

/**
 * Created by sumi1 on 6/9/2018.
 */
public class MinimumGuesses {

    static void findMatch(int N, int x) {
        int guesses = findMatchUtil(1, N, x);
        System.out.println("No of guesses needed for N: " + N + " and x: " + x + " are: " + guesses);
    }

    static int findMatchUtil(int start, int end, int x) {
        if (!(x >= start && x <= end)) {
            //x is not in range,
            return -1;
        }
        int guessCount = 0;
        int guess = start + (end - start) / 2;
        guessCount++;
        while (guess != x) {
            //check the hint
            if (guess > x) {
                //need lower limit
                end = guess;
            } else {
                //need higher limit
                start = guess;
            }
            guess = start + (end - start) / 2;
            guessCount++;
        }
        return guessCount;
    }

    public static void main(String[] args) {
        int N = 1024;
        int x = 378;
        findMatch(N, x);
    }
}

