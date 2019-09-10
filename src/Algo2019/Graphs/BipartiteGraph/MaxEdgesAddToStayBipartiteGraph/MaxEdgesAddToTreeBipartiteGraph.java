package Algo2019.Graphs.BipartiteGraph.MaxEdgesAddToStayBipartiteGraph;

import java.util.LinkedList;

public class MaxEdgesAddToTreeBipartiteGraph {

    enum Color{
        WHITE, RED, GREEN
    }

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

            //add back edge
            adjList[destination].addFirst(source);
        }
    }

    public int calculateMaxEdge(Graph graph){
        int [] colorsCount = new int[2];
        //index 0 will store the count for red vertices
        //index 1 will store the count for green vertices

        //check if graph is empty
        if(graph.vertices==0)
            return 0;

        int vertices = graph.vertices;
        //initialize colors for all vertices
        Color colors[] = new Color[vertices];
        //color all the vertices with white color
        for (int i = 0; i <colors.length ; i++) {
            colors[i] = Color.WHITE;
        }

        //start coloring vertices and count as well
        //color the first vertex with RED

        bipartiteUtil(0, colors, colorsCount, graph);
        int redCount = colorsCount[0];
        int greenCount = colorsCount[1];
        return redCount*greenCount-(vertices-1);
    }

    void bipartiteUtil(int source, Color [] colors, int [] colorsCount, Graph graph){
        //if is it first vertex, mark it RED
        if(source==0) {
            colors[source] = Color.RED;
            colorsCount[0]++;
        }
        //travel all adjacent vertices
        for (int i = 0; i <graph.adjList[source].size() ; i++) {
            int vertex = graph.adjList[source].get(i);
            if(colors[vertex]==Color.WHITE){
                //color is with the alternate color of
                if(colors[source]==Color.RED) {
                    //if source is in red, make vertex green
                    colors[vertex] = Color.GREEN;
                    colorsCount[1]++;
                }
                else if (colors[source]==Color.GREEN) {
                    //if source is in red, make vertex green
                    colors[vertex] = Color.RED;
                    colorsCount[0]++;
                }
                //make recursive call for DFS
                bipartiteUtil(vertex, colors, colorsCount, graph);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,5);

        MaxEdgesAddToTreeBipartiteGraph m = new MaxEdgesAddToTreeBipartiteGraph();
        System.out.println("Maximum Edges can be added are: " +  m.calculateMaxEdge(graph));
    }
}
