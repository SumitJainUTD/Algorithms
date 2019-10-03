package Algo2019.PrintAllSwapForConvertOneStringToAnother;

public class PrintAllSwapForConvert {

    public void convert(String source, String target){
        System.out.println("Source: " + source);
        System.out.println("Target: " + target);
        StringBuilder allCombination = new StringBuilder();
        allCombination.append(source);
        StringBuilder currentPath = new StringBuilder();
        currentPath.append(source);
        convertUtil(source, target, allCombination, currentPath);
    }

    public void convertUtil(String source, String target, StringBuilder allCombination, StringBuilder currentPath){

        //check if goal is achieved
        if(source.equals(target)){
            System.out.println(currentPath);
            return;
        }

        for (int i = 0; i <source.length()-1 ; i++) {
            String newSource = swap(source, i, i+1);
            //to avoid going in circles
            if(!allCombination.toString().contains(newSource)) {
                allCombination.append("," + newSource);
                convertUtil(newSource, target, allCombination, currentPath.append(" -> " + newSource));
            }
        }
    }

    public String swap(String src, int i, int j){
        StringBuilder stringBuilder = new StringBuilder(src);
        stringBuilder.setCharAt(i, src.charAt(j));
        stringBuilder.setCharAt(j, src.charAt(i));
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        PrintAllSwapForConvert p = new PrintAllSwapForConvert();
        String source = "GUM";
        String target = "MUG";
        p.convert(source, target);

    }
}
