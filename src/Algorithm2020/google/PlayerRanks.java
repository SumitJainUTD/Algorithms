package Algorithm2020.google;

import java.util.*;

public class PlayerRanks {

    Map<String, Integer> nameMap = new HashMap<>();
    Map<Integer, List<String>> rankMap = new TreeMap<>((o1, o2) -> o2-o1);

    public void addPlayer(String name, int score){
        nameMap.put(name, score);
        addScoreToRankMap(name, score);
    }

    public void updateEntry(String name){
        int existingScore = 0;
        if(nameMap.containsKey(name)){
            existingScore = nameMap.get(name);
        }
        int newScore = existingScore+1;
        nameMap.put(name, newScore);

        //update the rankMap
        if(existingScore!=0)
            //remove from existing score key
            rankMap.get(existingScore).remove(name);

        addScoreToRankMap(name, newScore);
    }

    public List<String> getEntryFromRank(int rank){
        if(rank>rankMap.size()){
            System.out.println("Invalid rank: " + rank);
            return null;
        }

        Set<Integer> keys = rankMap.keySet();
        int key = (int) keys.toArray()[rank-1];
        return rankMap.get(key);
    }

    private void addScoreToRankMap(String name, int score){
        if(rankMap.containsKey(score)){
            List<String> names = rankMap.get(score);
            names.add(name);
        }else{
            List<String> newNameList = new ArrayList<>();
            newNameList.add(name);
            rankMap.put(score, newNameList);
        }
    }

    public static void main(String[] args) {
        PlayerRanks playerRanks = new PlayerRanks();
        playerRanks.addPlayer("Carl", 70);
        playerRanks.addPlayer("Sam", 80);
        playerRanks.addPlayer("Bob", 70);
        playerRanks.addPlayer("Dow", 55);
        playerRanks.addPlayer("King", 60);
        playerRanks.addPlayer("Joe", 55);
        playerRanks.addPlayer("Alex", 30);

        List<String> players = playerRanks.getEntryFromRank(2);
        if(players!=null)
            System.out.println("Players with rank 2: " + Arrays.toString(players.toArray()));

        playerRanks.updateEntry("Dow");
        playerRanks.updateEntry("Xoe");

        players = playerRanks.getEntryFromRank(5);
        if(players!=null)
            System.out.println("Players with rank 5: " + Arrays.toString(players.toArray()));

        players = playerRanks.getEntryFromRank(7);
        if(players!=null)
            System.out.println("Players with rank 6: " + Arrays.toString(players.toArray()));

        players = playerRanks.getEntryFromRank(1);
        if(players!=null)
            System.out.println("Players with rank 1: " + Arrays.toString(players.toArray()));

        players = playerRanks.getEntryFromRank(10);

        playerRanks.updateEntry("Carl");

        players = playerRanks.getEntryFromRank(2);
        if(players!=null)
            System.out.println("Players with rank 2: " + Arrays.toString(players.toArray()));
    }
}
