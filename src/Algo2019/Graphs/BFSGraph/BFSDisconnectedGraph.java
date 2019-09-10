package Algo2019.Graphs.BFSGraph;

import java.util.LinkedList;
import java.util.Queue;

public class BFSDisconnectedGraph {
    static class Graph{
        int vertices;
        LinkedList<Integer>[] adjList;

        public Graph(int vertices){
            this.vertices = vertices;
            adjList = new LinkedList[vertices];

            //initialize the lists
            for (int i = 0; i <vertices ; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination){
            //add forward edge
            adjList[source].addFirst(destination);

            //add back edge for undirected graph
            adjList[destination].addFirst(source);

        }

        public void BFS(){

            boolean [] visited = new boolean[vertices];
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i <vertices ; i++) {
                if(!visited[i]){
                    queue.add(i);

                    while(!queue.isEmpty()){

                        //get a vertex from queue
                        int vertex = queue.remove();
                        //mark the vertex visited
                        visited[vertex] = true;

                        //print the vertex
                        System.out.print(vertex + " ");

                        //add unvisited adjacent vertices
                        for (int j = 0; j <adjList[vertex].size() ; j++) {
                            int adjVertex = adjList[vertex].get(j);
                            if(!visited[adjVertex]) {
                                visited[adjVertex] = true;
                                queue.add(adjVertex);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSConnectedGraph.Graph g = new BFSConnectedGraph.Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 6);
        g.BFS();
    }
}