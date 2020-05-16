package Algorithm2020.google;

import java.util.*;

public class TopVideos {

    static class Video{
        String videoName;
        int watchRate;

        public Video(String videoName, int watchRate) {
            this.videoName = videoName;
            this.watchRate = watchRate;
        }

        @Override
        public String toString() {
            return "[" + videoName + ", "+ watchRate + "]";
        }
    }

    public static void displayTop10Videos(List<Video> videos){

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i <videos.size() ; i++) {
            Video video = videos.get(i);
            if(map.containsKey(video.videoName)){
                int rate = map.get(video.videoName);
                rate += video.watchRate;
                map.put(video.videoName, rate);
            }else
                map.put(video.videoName, video.watchRate);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        //sort in reverse order
        Collections.sort(list, (o1, o2) -> o2.getValue()-o1.getValue());

        //get top 10 items
        int count = 10;
        System.out.println("Top videos: ");
        for (int i = 0; i <list.size() && count>0 ; i++) {
            Map.Entry<String, Integer> temp = list.get(i);
            System.out.print("["+ temp.getKey() + " : " + temp.getValue() + "] ");
            count--;
        }
    }

    public static void main(String[] args) {
        List<Video> videos = new ArrayList<>();
        videos.add(new Video("abc", 10));
        videos.add(new Video("def", 20));
        videos.add(new Video("abc", 15));
        videos.add(new Video("ghi", 50));
        videos.add(new Video("xyz", 100));
        videos.add(new Video("abc", 25));
        videos.add(new Video("jkl", 10));
        videos.add(new Video("mno", 15));
        videos.add(new Video("pqr", 25));
        videos.add(new Video("stu", 35));
        videos.add(new Video("lko", 19));
        videos.add(new Video("aaa", 5));
        videos.add(new Video("bbb", 10));
        videos.add(new Video("ccc", 35));
        videos.add(new Video("abc", 25));
        videos.add(new Video("eee", 20));
        displayTop10Videos(videos);
    }
}
