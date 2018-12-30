package MacLaptop.October2018;

/**
 * Created by sjain on 10/14/18.
 */
public class PrintVertical {

    public  static void vertical(int i){
        if(i==0)
            return;
        int x = i%10;
        vertical(i/10);
        System.out.println(x);
    }

    public static void main(String[] args) {
        int i = 12345;
        vertical(i);
    }
}
