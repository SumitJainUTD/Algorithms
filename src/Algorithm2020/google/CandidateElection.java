package Algorithm2020.google;

import java.util.*;

public class CandidateElection {

    Map<String, Integer> candidateMap = new HashMap<>();
    Map<Integer, List<String>> rankMap = new TreeMap<>((o1, o2) -> o2-o1);
    public void voteCandidate(String candidate){
        System.out.println("Vote to " + candidate);
        int votes = candidateMap.getOrDefault(candidate, 0);
        if(votes>0)
            rankMap.get(votes).remove(candidate);
        rankMap.computeIfAbsent(votes+1, k->new ArrayList<>()).add(candidate);
        candidateMap.put(candidate, votes+1);
    }

    public List<String> getTopCandidate(int k){
        List<String> topCandidates = new ArrayList<>();
        for(Integer key: rankMap.keySet()){
            if(k>0){
                List<String> candidates = rankMap.get(key);
                topCandidates.addAll(candidates);
                k = k - candidates.size();
            }else
                break;
        }
        return topCandidates;
    }

    public static void main(String[] args) {
        CandidateElection c = new CandidateElection();
        c.voteCandidate("Sam");
        c.voteCandidate("Sam");
        c.voteCandidate("Sam");
        c.voteCandidate("Bob");
        c.voteCandidate("Sam");
        c.voteCandidate("Bob");
        c.voteCandidate("Carl");
        c.voteCandidate("Dow");

        List<String> topCandidates = c.getTopCandidate(2);
        System.out.println("Top 2 candidates are: " + Arrays.toString(topCandidates.toArray()));

        topCandidates = c.getTopCandidate(1);
        System.out.println("Top 1 candidates are: " + Arrays.toString(topCandidates.toArray()));

        topCandidates = c.getTopCandidate(3);
        System.out.println("Top 3 candidates are: " + Arrays.toString(topCandidates.toArray()));
    }
}
