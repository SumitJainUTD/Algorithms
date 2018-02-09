package ThirdLot.TextJustification;

public class TextJustification {

    public String find(String [] words, int maxWidth, int index){
        if(index<words.length){
            String result = "";
            int currentLen = 0;
            int remainLength = maxWidth;
            while(result.length()<maxWidth && index<words.length){
                if(remainLength>=words[index].length()+1){ //remainingLength+1 for space
                    if(!result.equals("")){
                        result += "@" + words[index];
                        currentLen = words[index].length()+1;
                    }else{
                        result += words[index];
                        currentLen = words[index].length();
                    }
                    remainLength -= currentLen;
                    index++;
                }else if(remainLength>0){
                    if(result.contains("@")==false){
                        for (int i = 0; i < remainLength; i++) {
                            result = result + " ";
                        }
                    }else {
                        //go in only if there at least 2 words
                        String[] arr = result.split("@");
                        int mod = (remainLength % (arr.length - 1));
                        int splitedSpace = remainLength / (arr.length - 1);
                        String spaces = " ";
                        for (int i = 0; i < splitedSpace; i++) {
                            spaces = spaces + " ";
                        }
                        String leftmost = spaces;
                        for (int i = 0; i < mod; i++) {
                            leftmost = leftmost + " ";
                        }
                        result = result.replaceFirst("@", leftmost);
                        result = result.replaceAll("@", spaces);
                    }
                }
            }
            result = result.replaceAll("@", " ");
            return result + "\n" + find(words,maxWidth,index);
        }else{
            return "";
        }
    }

    public static void main(String[] args) {
        TextJustification t = new TextJustification();
        String [] words = {"This", "is", "a", "text", "justification","problem","in","tutorial","horizon"};
        int maxWidth = 25;
        System.out.println(t.find(words,maxWidth,0));
    }
}


