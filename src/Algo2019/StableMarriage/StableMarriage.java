package Algo2019.StableMarriage;

import java.util.*;

public class StableMarriage {

    public void matchMaking(int [][] men, int [][] women){
        HashMap<Integer, Integer> couples = findCouples(men, women);
        System.out.println("\n------------------Final Matching----------------------------");
        Set<Integer> set = couples.keySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            int key = iterator.next();
            System.out.println("Woman: " + key + " is engaged with man: " + couples.get(key));
        }
    }

    public HashMap<Integer, Integer> findCouples(int [][] men, int [][] women){

        //couples map will contain all the matches, with women as key and her match (men) as value
        HashMap<Integer, Integer> couples = new HashMap<>();

        //add all the women to couples map with their matches as NULL (initially)
        for (int i = 0; i <women.length ; i++) {
            couples.put(i, null);
        }

        //create a list of all bachelors
        Set<Integer> bachelors = new HashSet<>();
        for (int i = 0; i <men.length ; i++) {
            bachelors.add(i);
        }

        int bachelorCount = bachelors.size();

        //do till all the bachelors are nor engaged
        while(bachelorCount>0){

            int currentBachelor = bachelors.iterator().next();
            System.out.println ("\nMan " + currentBachelor + " is looking for a woman now-");

            // check for all the women preferences of current bachelor in preference order
            for (int wmen = 0; wmen <men[currentBachelor].length ; wmen++) {

                //check if current woman is available for current bachelor
                if(couples.get(wmen)==null){
                    //this woman is available for this man, make the match
                    couples.put(wmen, currentBachelor);
                    System.out.println("Women " + wmen + " has ACCEPTED the man: " + currentBachelor);
                    bachelors.remove(currentBachelor);
                    break;
                }else{
                    //current woman had already accepted the proposal from some other man
                    //check if women is interested accepting current bachelor
                    // and dumping the man which she had accepted earlier
                    int alreadyAcceptedMan = couples.get(wmen);
                    if(willChangePartner(currentBachelor, alreadyAcceptedMan, wmen, women)){

                        //current women will accept
                        couples.put(wmen, currentBachelor);
                        // add the dumped man in bachelor list
                        bachelors.add(alreadyAcceptedMan);
                        bachelors.remove(currentBachelor);
                        System.out.println("Women " + wmen + " has DUMPED the man: " + alreadyAcceptedMan);
                        System.out.println("Women " + wmen + " has ACCEPTED the man: " + currentBachelor);
                        break; //
                    }
                }
            }
            //get the size again
            bachelorCount = bachelors.size();
        }
        //return the couples
        return couples;
    }

    boolean willChangePartner(int currentBachelor, int alreadyAcceptedMan, int currentWomen, int [][]women){

        int pref_currentBachelor = -1;
        int pref_alreadyAcceptedMan = -1;

        //get the preferences of both the men
        for (int i = 0; i <women[currentWomen].length ; i++) {

            if(women[currentWomen][i]==currentBachelor)
                pref_currentBachelor = i;

            if(women[currentWomen][i]==alreadyAcceptedMan)
                pref_alreadyAcceptedMan = i;
        }

        //women will accept the current bachelor only if he has higher preference
        //than the man she had accepted earlier
        if(pref_currentBachelor<pref_alreadyAcceptedMan)
            return true;

        return false;
    }


    public static void main(String[] args) {
        int men[][] = {
                {0, 1, 2, 3},
                {0, 1, 2, 3},
                {0, 1, 2, 3},
                {0, 1, 2, 3}
        };

        // Preference order for 3 women
        int women[][] = {
                {1, 0, 2, 3},
                {1, 2, 3, 0},
                {0, 1, 3, 2},
                {0, 1, 3, 2}
        };
        StableMarriage sm = new StableMarriage();
        sm.matchMaking(men, women);
    }
}
