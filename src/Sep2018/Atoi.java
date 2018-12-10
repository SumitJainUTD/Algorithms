package Sep2018;

/**
 * Created by sumi1 on 9/22/2018.
 */
public class Atoi {
    public static int myAtoi(String str) {
        if (str.isEmpty())
            return 0;
        str = str.trim();
        int i = 0, ans = 0, sign = 1, len = str.length();
        if (str.charAt(i) == '-' || str.charAt(i) == '+')
            sign = str.charAt(i++) == '+' ? 1 : -1;
        for (; i < len; ++i) {
            System.out.println(str.charAt(i));
            int tmp = str.charAt(i) - '0';
            if (tmp < 0 || tmp > 9)
                break;
            if (ans > Integer.MAX_VALUE / 10
                    || (ans == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < tmp))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            else
                ans = ans * 10 + tmp;
        }
        return sign * ans;
    }

    public static void main(String[] args) {
        String s = "34s 5";
        System.out.println(myAtoi(s));
    }
}
