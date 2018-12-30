package Published.Maths;

/**
 * Created by sumi1 on 6/5/2018.
 */
    public class FloydTriangle {

        public static void printTriangle(int rows){
            if(rows<=0)
                return;

            int count=1;
            int number = 1;
            while(count<=rows){
                for (int i = 0; i <count ; i++) {
                    System.out.print(number + " ");
                    number++;
                }
                count++;
                System.out.println();
            }
        }

        public static void main(String[] args) {
            int rows = 7;
            printTriangle(rows);
        }
    }
