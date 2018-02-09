package SecondLot.ArrayProblems.NutsAndBolts;

import java.util.Arrays;

public class NutsAndBoltsBruteForce {

    public static void match(char [] nuts,char [] bolts){
        for (int i = 0; i <nuts.length ; i++) {
            char nut = nuts[i];
            for (int j = 0; j <bolts.length ; j++) {
                if(nut==bolts[j]){
                   swap(bolts,i,j);
                    break;
                }
            }
        }
        System.out.println("Matched nuts and bolts are: ");
        System.out.println(Arrays.toString(nuts));
        System.out.println(Arrays.toString(bolts));
    }

    public static void swap(char [] bolts, int i, int j){
        char temp = bolts[i];
        bolts[i] = bolts[j];
        bolts[j] = temp;
    }

    public static void main(String[] args) {
        char [] nuts = {'$', '%', '&', 'x', '@'};
        char [] bolts = {'%', '@', 'x', '$', '&'};
        match(nuts,bolts);
    }
}
