package ThirdLot.DecompressString;

/**
 * Created by sjain on 9/10/17.
 */
public class DecompressString {

    public String decompress(String input) {
        if (input == null || input.length() == 0)
            return "";

        if(input.length()==1)
            return input;
        int number =0;
        String result = "";
        int index = 0;
        while (index < input.length()) {
            number = getNumber(input, index);
            if (number == -1) {
                char x = input.charAt(index);
                result = result + x;
                index++;
            } else {
                //get the full number
                index++;
                int next = getNumber(input, index);
                while (next != -1) {
                    number = number * 10 + next;
                    index++;
                    next = getNumber(input, index);
                }
                break;
            }
        }
        //remove the bracket
        String end = "";
        int endIndex = input.length() - 1;
        while (endIndex>=index && input.charAt(endIndex) != ']') {
            end = input.charAt(endIndex) + end;
            endIndex--;
        }
        String tempResult = decompress(input.substring(++index, endIndex)); //++index to remove '['
        String middleResult = "";
        for (int i = 0; i < number; i++) {
            middleResult += tempResult;
        }
        return result + middleResult + end;
    }

    public int getNumber(String input, int index){
        char a = input.charAt(index);
        try{
            return Integer.parseInt(String.valueOf(a));
        }catch (Exception exp){
            return -1;
        }
    }

    public static void main(String[] args) {
        DecompressString d = new DecompressString();
//        String input = "a3[b2[c1[d]]]e";
        String input = "2[abc]3[cd]ef";
        System.out.println(d.decompress(input));

    }
}
