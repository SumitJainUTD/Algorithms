package MacLaptop.October2018;

/**
 * Created by sjain on 10/24/18.
 */

import java.util.*;

class ProcessLogs {

    void process(long startTime, long endTime, List<String> logLines){

        LinkedHashMap<String, HashMap<String,Integer>> map = new LinkedHashMap<>();
        for(int i=0;i<logLines.size();i++){

            String [] result = logLines.get(i).split("\\|");

            long time  = Long.parseLong(result[0]);

            String processName = result[1];
            String mainMsg = result[2];
            if(time>=startTime && time <=endTime){

                if(map.containsKey(processName)){

                    //check if mainMsg is present
                    HashMap<String,Integer> map2 = map.get(processName);
                    if(map2.containsKey(mainMsg)){
                        int count = map2.get(mainMsg);
                        map2.put(mainMsg, ++count);
                    }
                    else{
                        map2.put(mainMsg, 1);
                    }
                }else{
                    HashMap<String,Integer> map2 = new HashMap<String, Integer>();
                    map2.put(mainMsg, 1);
                    map.put(processName, map2);
                }
            }
        }

        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();
        String process1="";
        String process2="";
        int maxOne=0;
        int maxTwo=0;
        while(iterator.hasNext()){

            String key = iterator.next();
            String result = key +" - " ;
            HashMap<String, Integer> map2 = map.get(key);
            Set<String> set2 = map2.keySet();
            Iterator<String> iterator2 = set2.iterator();
            int totalCount = 0;
            while(iterator2.hasNext()){
                String mainMsg = iterator2.next();
                int count = map2.get(mainMsg);
                result += count+ " " + mainMsg + " / ";
                totalCount +=count;
            }
            if(maxOne < totalCount){
                maxTwo = maxOne;
                maxOne =totalCount;
                process1 = key;
            } else if(maxTwo < totalCount){
                maxTwo = totalCount;
                process2 = key;
            }

            System.out.println(result);


        }
        System.out.println("Top 2 processes are " + process1 + " : " +maxOne + " and " + process2 + " : " + maxTwo);
    }



    public static void main(String[] args) {
        List<String> logLines=new ArrayList<String>();
        logLines.add("1540403503|S1|WARN|warning message");
        logLines.add("1540403503|S1|WARN|warning message");
        logLines.add("1540403504|S2|WARN|warning message");
        logLines.add("1540403504|S1|ERROR|error message");
        logLines.add("1540403604|S4|ERROR|error message");
        logLines.add("1540403614|S1|DEBUG|debug message");
        logLines.add("1540403614|S5|DEBUG|debug message");
        logLines.add("1540403615|S6|INFO|info message");
        logLines.add("1540403615|S6|DEBUG|debug message");
        logLines.add("1540403615|S6|DEBUG|debug message");
        logLines.add("1540403715|S7|INFO|info message");
        logLines.add("1540403715|S7|INFO|info message");

        ProcessLogs s = new ProcessLogs();
        long startTime = 1540403503;
        long endTime =  1540403715;
        s.process(startTime, endTime , logLines);
    }
}



/*
Your previous Plain Text content is preserved below:

Input File:

List<String> logLines=
1540403503|S1|WARN|warning message
1540403503|S1|WARN|warning message
1540403504|S2|WARN|warning message
1540403504|S1|ERROR|error message
1540403604|S4|ERROR|error message
1540403614|S1|DEBUG|debug message
1540403614|S5|DEBUG|debug message
1540403615|S6|INFO|info message
1540403615|S6|DEBUG|debug message
1540403615|S6|DEBUG|debug message
1540403715|S7|INFO|info message
1540403715|S7|INFO|info message


Implement Method:
process(long startTime, long endTime, String fileName){

}

class Result{

}

Output:
S1 - 2WARN / 1ERROR / 1DEBUG
S2 - 1WARN
S4 - 1ERROR
S5 - 1DEBUG
S6 - 1INFO / 2DEBUG
S7 - 2INFO

Top 2 Services with most number of messages:
S1 and S6 have most number of message

This is just a simple shared plaintext pad, with no execution capabilities.

When you know what language you'd like to use for your interview,
simply choose it from the dropdown in the top bar.

You can also change the default language your pads are created with
in your account settings: https://coderpad.io/settings

Enjoy your interview!

 */