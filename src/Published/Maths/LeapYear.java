package Published.Maths;

/**
 * Created by sumi1 on 6/30/2018.
 */
public class LeapYear {

    static void isLeapYear(int year){
        if(year<=0){
            System.out.println("Invalid year entry");
            return;
        }

        //check for leap year
        boolean isLeap;
        if(year%4==0){
            if(year%100==0){
                if(year%400==0){
                    isLeap = true;
                }else{
                    isLeap = false;
                }
            }else{
                isLeap = true;
            }
        }else{
            isLeap = false;
        }

        if(isLeap)
            System.out.println("Given year " + year +  " is leap year");
        else
            System.out.println("Given year " + year +  " is not leap year, its a common year");
    }

    public static void main(String[] args) {
        isLeapYear(1992);
        isLeapYear(2000);
        isLeapYear(2001);
        isLeapYear(2002);
        isLeapYear(2004);
    }
}
