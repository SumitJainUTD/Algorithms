package Algo2019;

public class HummingDistanceString {

    public static void getDistance(String x, String y){

        int humming_distance =0;

        if(x.length()!=y.length()){
            System.out.println("Both string sizes are different");
            return;
        }

        for (int i = 0; i <x.length() ; i++) {
            if(x.charAt(i)!=y.charAt(i))
                humming_distance++;
        }

        System.out.println("x="+x+", y="+y+"  Hamming distance: " + humming_distance);

    }

    public static void main(String[] args) {
        String x = "AABBCCDD";
        String y = "AAAACCCC";
        getDistance(x, y);
        x = "dogandcat";
        y = "catanddog";
        getDistance(x, y);
    }
}
