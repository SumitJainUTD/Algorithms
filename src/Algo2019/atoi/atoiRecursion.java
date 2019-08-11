package Algo2019.atoi;

public class atoiRecursion {

    public int atoi(String input){

        System.out.println("Input String: '" + input+"'");
        input = input.trim();
        if(input.equals("")){
            return 0;
        }

        if (input.charAt(0)=='-' || input.charAt(0)=='+') {
            int sign = input.charAt(0)=='+' ? 1 : -1;
            return atoiUtil(input.substring(1)) * sign;
        }
        return atoiUtil(input);
    }

    public int atoiUtil(String input){

        // base case
        if(input.length()==0)
            return 0;

        int lastIndex = input.length()-1;
        int recurCal = atoiUtil(input.substring(0, lastIndex));
        int num = input.charAt(lastIndex)-'0';
        if(num>=0 && num <=9) {

            if (recurCal > Integer.MAX_VALUE / 10 || (recurCal == Integer.MAX_VALUE / 10) && num > 7)
                return Integer.MAX_VALUE;
            return 10*recurCal + num;
        }
        return recurCal;
    }

    public static void main(String[] args) {
        atoiRecursion a = new atoiRecursion();
        System.out.println("Converted Integer: " + a.atoi("-1234"));
        System.out.println("Converted Integer: " + a.atoi("+555"));
        System.out.println("Converted Integer: " + a.atoi(" -03056"));
        System.out.println("Converted Integer: " + a.atoi("-91283472332"));
        System.out.println("Converted Integer: " + a.atoi("2.56"));
        System.out.println("Converted Integer: " + a.atoi("2147483648"));
        System.out.println("Converted Integer: " + a.atoi("216 after words"));
        System.out.println("Converted Integer: " + a.atoi("Before words 325"));
    }
}
