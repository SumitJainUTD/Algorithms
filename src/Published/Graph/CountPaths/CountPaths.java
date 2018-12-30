package Published.Graph.CountPaths;


import java.util.LinkedList;

public class CountPaths {

    static int paths =0;

    static class Graph{
        int vertices;
        LinkedList<Integer>[] adjList;

        Graph(int vertices){
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i <vertices ; i++) {
                adjList[i] = new LinkedList<>();
            }
        }
        public void addEgde(int source, int destination){
            adjList[source].addFirst(destination);
        }

        public void countPaths(int source, int destination){
            count(source, destination);
            System.out.println("No of paths between source: " +  source
            + " and destination: " +  destination + " are:" + paths);
        }

        public void count(int start, int destination){
            if(start==destination) {
                paths++;
            }else {
                for (int i = 0; i < adjList[start].size(); i++) {
                    int ajdacentVertex = adjList[start].get(i);
                    count(ajdacentVertex, destination);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEgde(0, 1);
        graph.addEgde(0, 2);
        graph.addEgde(1, 2);
        graph.addEgde(1, 3);
        graph.addEgde(3, 4);
        graph.addEgde(2, 3);
        graph.addEgde(4, 5);
        int source =0;
        int destination=5;
        graph.countPaths(source,destination);
    }
}
