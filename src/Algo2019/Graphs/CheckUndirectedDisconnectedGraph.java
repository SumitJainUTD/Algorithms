package Algo2019.Graphs;

import java.util.LinkedList;

public class CheckUndirectedDisconnectedGraph {

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

    public void isConnected(Graph graph){

        int vertices = graph.vertices;
        LinkedList<Integer> adjList [] = graph.adjList;

        //created visited array
        boolean[] visited = new boolean[vertices];

        //start the DFS from vertex 0
        DFS(0, adjList, visited);

        //check if all the vertices are visited, if yes then graph is connected
        int count = 0;
        for (int i = 0; i <visited.length ; i++) {
            if(visited[i])
                count++;
        }
        if(vertices==count){
            System.out.println("Given graph is connected");
        }else{
            System.out.println("Given graph is not connected");
        }
    }

    public void DFS(int source, LinkedList<Integer> adjList [], boolean[] visited){

        //mark the vertex visited
        visited[source] = true;

        //travel the neighbors
        for (int i = 0; i <adjList[source].size() ; i++) {
            int neighbor = adjList[source].get(i);
            if(visited[neighbor]==false){
                //make recursive call from neighbor
                DFS(neighbor, adjList, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(1,3);
        graph.addEdge(3,2 );

        CheckUndirectedDisconnectedGraph c = new CheckUndirectedDisconnectedGraph();
        c.isConnected(graph);

        graph.addEdge(3, 4);
        c.isConnected(graph);
    }
}
