package Algo2019.atoi;

public class atoi {

    public int atoiConvert(String input){

        System.out.println("Input String: '" + input+"'");
        int result = 0;
        int startIndex =0;
        input = input.trim();
        if(input.equals("")){
            return result;
        }
        int sign = 1;
        //check the sign
        if(input.charAt(startIndex) == '+' || input.charAt(startIndex) == '-'){
            sign = input.charAt(startIndex) == '+' ? 1 : -1;
            startIndex ++;
        }


        for (int i = startIndex; i <input.length() ; i++) {
            char temp = input.charAt(i);
            int num = temp - '0';
            if(num>=0 && num <=9) {
                if (result >  Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10) && num>7) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = result * 10 + num;
            } else
                break;
        }
        return result*sign;
    }

    public static void main(String[] args) {
        atoi a = new atoi();
        System.out.println("Converted Integer: " + a.atoiConvert("1234"));
        System.out.println("Converted Integer: " + a.atoiConvert("+555"));
        System.out.println("Converted Integer: " + a.atoiConvert(" -03056"));
        System.out.println("Converted Integer: " + a.atoiConvert("-91283472332"));
        System.out.println("Converted Integer: " + a.atoiConvert("2.56"));
        System.out.println("Converted Integer: " + a.atoiConvert("2147483648"));
        System.out.println("Converted Integer: " + a.atoiConvert("216 after words"));
        System.out.println("Converted Integer: " + a.atoiConvert("Before words 325"));
    }
}
