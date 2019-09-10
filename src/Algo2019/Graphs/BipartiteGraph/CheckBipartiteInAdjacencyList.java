package Algo2019.Graphs.BipartiteGraph;

import java.util.LinkedList;

public class CheckBipartiteInAdjacencyList {
    enum Color{
        WHITE, RED, GREEN
    }

    static class Graph{
        int vertices;
        LinkedList<Integer> [] adjList;

        public Graph(int vertices){
            this.vertices = vertices;

            adjList = new LinkedList[vertices];
            //Initialize lists
            for (int i = 0; i <vertices ; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination){
            //add forward edge
            adjList[source].addFirst(destination);

            //add back edge
            adjList[destination].addFirst(source);
        }

        public boolean isBipartite(Graph graph){

            //check if graph is empty
            if(graph.vertices==0)
                return true;

            //initialize colors for all vertices
            Color colors[] = new Color[vertices];
            //color all the vertices with white color
            for (int i = 0; i <colors.length ; i++) {
                colors[i] = Color.WHITE;
            }

            //start coloring vertices , this code will handle the disconnected graph as well
            //color the first vertex with RED
            for (int i = 0; i <vertices; i++) {
                if(colors[i]==Color.WHITE) {
                    boolean result = isBipartiteUtil(i, colors);
                    if(result==false)
                        return false;
                }
            }
            return true;
        }

        private boolean isBipartiteUtil(int source, Color [] colors){

            //if is it first vertex, mark it RED
            if(source==0)
                colors[source]=  Color.RED;

            //travel all adjacent vertices

            for (int i = 0; i <adjList[source].size() ; i++) {
                int vertex = adjList[source].get(i);
                if(colors[vertex]==Color.WHITE){
                    //color is with the alternate color of
                    if(colors[source]==Color.RED) {
                        //if source is in red, make vertex green
                        colors[vertex] = Color.GREEN;
                    }
                    else if (colors[source]==Color.GREEN) {
                        //if source is in red, make vertex green
                        colors[vertex] = Color.RED;
                    }

                    //make recursive call for DFS
                    return isBipartiteUtil(vertex, colors);

                } else if(colors[source]==colors[vertex]){
                    return false;
                }
            }
            // if here means graph is successfully colored in 2 color, red and green
            //graph is bipartite
            return true;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(2,3);
        graph.addEdge(3,1);

        boolean result = graph.isBipartite(graph);
        System.out.println("Graph is Bipartite: " + result);
        System.out.println("--------------------------");

        Graph graph1 = new Graph(4);
        graph1.addEdge(0,1);
        graph1.addEdge(0,2);
        graph1.addEdge(2,3);
        graph1.addEdge(3,1);

        result = graph1.isBipartite(graph1);
        System.out.println("Graph is Bipartite: " + result);
        System.out.println("--------------------------");
    }
}