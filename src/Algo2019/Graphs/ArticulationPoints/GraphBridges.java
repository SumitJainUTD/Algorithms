package Algo2019.Graphs.ArticulationPoints;

import java.util.HashMap;
import java.util.LinkedList;

public class GraphBridges {

    static class Graph{
        int vertices;
        LinkedList<Integer> adjList [];

        public Graph(int vertices){
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i <vertices ; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination){
            //forward edge
            adjList[source].addFirst(destination);
            //backward edge in undirected graph
            adjList[destination].addFirst(source);
        }
    }

    int time =0;

    public void findBridges(Graph graph){

        int vertices = graph.vertices;
        LinkedList<Integer> adjList [] = graph.adjList;

        HashMap<Integer, Integer> discoveryTime = new HashMap<>();
        HashMap<Integer, Integer> lowTime = new HashMap<>();
        HashMap<Integer, Integer> parent = new HashMap<>();
        boolean [] visited = new boolean[vertices];

        for (int i = 0; i <vertices ; i++) {
            if(!visited[i]){
                parent.put(i,-1);
                DFS(i, graph, discoveryTime, lowTime, parent, visited);
            }
        }
    }

    public void DFS(int currentVertex, Graph graph, HashMap<Integer, Integer> discoveryTime, HashMap<Integer, Integer> lowTime, HashMap<Integer, Integer> parent, boolean[] visited){

        visited[currentVertex] = true;
        LinkedList<Integer> adjList [] = graph.adjList;
        discoveryTime.put(currentVertex, time);
        lowTime.put(currentVertex, time);
        time++;

        for (int i = 0; i <adjList[currentVertex].size() ; i++) {

        int adjVertex = adjList[currentVertex].get(i);
            if(!visited[adjVertex]){
                parent.put(adjVertex,currentVertex);
                DFS(adjVertex, graph, discoveryTime, lowTime, parent, visited);

                //update the low time with adjacent low time
                int currLowTime = lowTime.get(currentVertex);
                lowTime.put(currentVertex, Math.min(currLowTime, lowTime.get(adjVertex)));

                //now check for bridge
                if(lowTime.get(adjVertex)>discoveryTime.get(currentVertex)){
                    //bridge found
                    System.out.println("Bridge: " + currentVertex + "----" + adjVertex);
                }
            }else {
                //if adjacent vertex is not parent that means
                // adjacent vertex is already visited, means there is a back edge
                if(parent.get(currentVertex)!=adjVertex){
                    //update the low time if required
                    int currLowTime = lowTime.get(currentVertex);
                    lowTime.put(currentVertex, Math.min(currLowTime, discoveryTime.get(adjVertex)));
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        GraphBridges graphBridges = new GraphBridges();
        System.out.println("GraphBridges in Graph:");
        graphBridges.findBridges(graph);

        System.out.println("---------------------------------");
        Graph graph1 = new Graph(6);
        graph1.addEdge(1, 0);
        graph1.addEdge(1, 2);
        graph1.addEdge(0, 3);
        graph1.addEdge(3, 4);
        graph1.addEdge(4, 5);
        graph1.addEdge(3, 5);

        graphBridges = new GraphBridges();
        System.out.println("GraphBridges in Graph1:");
        graphBridges.findBridges(graph1);
    }
}
