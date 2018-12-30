package MacLaptop.ThirdLot.FourCardsGame;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by sjain on 9/20/17.
 */
public class FourCardsGame {


    public Boolean solve(ArrayList<Integer> cards, double result){
        if(cards.size()==0 && result==24)
            return true;
        if(cards.size()==0)
            return false;

        if(cards.size()==2){
            int third = cards.get(0);
            int fourth = cards.get(1);
            double temp = third + fourth;
            if(calculate(third,fourth,24)==false){
                temp = Math.abs(third - fourth);
            }
        }else{
            ArrayList<Integer> backup = new ArrayList<Integer>();
            Collections.copy(backup,cards);
            for (int i = 0; i <cards.size() ; i++) {
                int first = cards.get(i);
                for (int j = i+1; j <cards.size() ; j++) {
                    int second = cards.get(j);
                    //now we have options to perform +, -, *, / on first and second
                    double temp = first + second;
                    backup.remove(i);
                    backup.remove(j);
                    if(solve(backup,temp)==false){
                        //back track
                        temp = Math.abs(first-second);
                        if(solve(backup,temp)==false){
                            //back track
                            temp = first * second;
                            if(solve(backup,temp)==false){
                                //back track
                                temp = first / second;
                                if(solve(backup,temp)==false){
                                    //back track
                                    temp = second / first;
                                    if(solve(backup,temp)==false){
                                        return false;
                                    }else {
                                        return true;
                                    }
                                }else{
                                    return true;
                                }
                            }else{
                                return true;
                            }
                        }else{
                            return true;
                        }
                    }else{
                        return true;
                    }

                }
            }
        }

        return false;
    }

    public boolean calculate(double a, double b, double expected){
        double x = a + b;
        if(x==expected)
            return true;
        x = Math.abs(a-b);
        if(x==expected)
            return true;
        x = a * b;
        if(x==expected)
            return true;
        x = a/b;
        if(x==expected)
            return true;
        x = b/a;
        if(x==expected)
            return true;
        return false;
    }


}
