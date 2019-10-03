package Algo2019;

import java.util.ArrayList;
        import java.util.Arrays;

public class RobotTrips {

    public static int efficientRobot(int [] itemWeights, int maxWeight){

        int trips = 0;
        Arrays.sort(itemWeights);

        boolean [] visited = new boolean[itemWeights.length];
        int processedItems = 0;

        //base case : if there is only one item, only 1 item is required
        if(itemWeights.length==1)
            return 1;

        while(processedItems!=itemWeights.length){
            ArrayList<Integer> pickedWeights = new ArrayList<>();
            int weightSum = 0;
            for (int j = itemWeights.length-1; j >=0 ; j--) {
                if(!visited[j] && weightSum<maxWeight){
                    weightSum += itemWeights[j];
                    pickedWeights.add(itemWeights[j]);
                    visited[j] = true;
                    processedItems++;

                    if(weightSum>maxWeight){
                        //remove the last entry from the list
                        pickedWeights.remove(pickedWeights.size()-1);
                        visited[j] = false;
                        processedItems--;
                        weightSum -= itemWeights[j];
                        break;
                    }
                }
            }

            for (int i = 0; i<itemWeights.length ; i++) {
                if(!visited[i] && weightSum<maxWeight){
                    weightSum += itemWeights[i];
                    pickedWeights.add(itemWeights[i]);
                    visited[i] = true;
                    processedItems++;

                    if(weightSum>maxWeight){
                        //remove the last entry from the list
                        pickedWeights.remove(pickedWeights.size()-1);
                        visited[i] = false;
                        processedItems--;
                        break;
                    }
                }
            }
            trips++;
            System.out.println(Arrays.toString(pickedWeights.toArray()));
        }
        System.out.println("Minimum Trips for Robot: " + trips);
        return trips;
    }

    public static void main(String[] args) {
        int [] itemWeights = {2, 3, 1, 5, 3, 6, 2, 2};
        int K = 6;
        efficientRobot(itemWeights, K);
    }
}
