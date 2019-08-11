package Algo2019.Graphs;

import java.util.LinkedList;

public class CheckDirectedDisconnectedGraph {

    static class Graph {
        int vertices;
        LinkedList<Integer>[] adjList;

        public Graph(int vertices) {
            this.vertices = vertices;

            adjList = new LinkedList[vertices];
            //Initialize lists
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination) {
            //add forward edge
            adjList[source].addFirst(destination);
        }

        public Graph reverse(Graph graph){
            Graph reverseGraph = new Graph(vertices);
            for (int i = 0; i <vertices ; i++) {
                LinkedList<Integer> nodeList = adjList[i];
                int source = i;
                for (int j = 0; j <nodeList.size() ; j++) {
                    int destination = nodeList.get(j);
                    //add reverse node
                    reverseGraph.addEdge(destination, source);
                }
            }
            return reverseGraph;
        }

        public boolean checkConnected(Graph graph){

            //reverse the given graph
            Graph reverseGraph = reverse(graph);

            //create visited array for both original and reverse graph
            boolean [] visited = new boolean[vertices];
            boolean [] visited_reverse = new boolean[vertices];

            //DFS for original graph start from first vertex
            DFS(0, visited, graph);

            //DFS for reverse graph start from first vertex
            DFS(0, visited_reverse, reverseGraph);

            //now check if any vertex is left unvisited in both the visited array
            boolean isDisconnected = false;
            for (int i = 0; i <visited.length ; i++) {
                if(!visited[i] && !visited_reverse[i]){
                    System.out.println("Vertex " + i +  " is disconnect in the given graph");
                    isDisconnected = true;
                }
            }
            if(isDisconnected){
                return false;
            }else{
                System.out.println("All the vertices in Graph are connected");
                return true;
            }
        }

        public void DFS(int current, boolean[] visit, Graph grph){

            //mark the current vertex as visited
            visit[current] = true;

            //visit all the neighbors
            LinkedList<Integer> neighbor_vertices = grph.adjList[current];
            for (int i = 0; i <neighbor_vertices.size() ; i++) {
                int vertex = neighbor_vertices.get(i);
                if(!visit[vertex])
                    DFS(vertex,visit,grph);
            }
        }

        public void printGraph(){
            for (int i = 0; i <vertices ; i++) {
                LinkedList<Integer> nodeList = adjList[i];
                System.out.println("Vertex connected from vertex: "+i);

                for (int j = 0; j <nodeList.size() ; j++) {
                    System.out.print("->" + nodeList.get(j));
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,0);
        graph.printGraph();
        graph.checkConnected(graph);
        System.out.println("--------------------------------------------");
        Graph graph1 = new Graph(5);
        graph1.addEdge(1,0);
        graph1.addEdge(2,1);
        graph1.addEdge(3,1);
        graph1.addEdge(3,2);
        graph1.printGraph();
        graph1.checkConnected(graph1);

    }
}
