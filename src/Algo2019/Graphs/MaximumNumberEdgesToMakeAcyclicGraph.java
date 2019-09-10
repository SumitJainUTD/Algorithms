package Algo2019.Graphs;

public class MaximumNumberEdgesToMakeAcyclicGraph {

    public static void findNoOfEdges(int vertices){

        //for undirected graph
        System.out.println("Maximum edges to make Acyclic Undirected Graph with " + vertices +  " vertices are: " + (vertices-1));

        //for directed graph
        int edgesDirectedGraph = vertices*(vertices-1)/2;
        System.out.println("Maximum edges to make Acyclic Directed Graph with " + vertices +  " vertices are: " + edgesDirectedGraph);
        System.out.println("---------------------------------");
    }

    public static void main(String[] args) {
        int vertices = 3;
        findNoOfEdges(vertices);
        vertices = 4;
        findNoOfEdges(vertices);
        vertices = 5;
        findNoOfEdges(vertices);
    }
}
