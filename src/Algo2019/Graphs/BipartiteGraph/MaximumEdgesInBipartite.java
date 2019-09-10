package Algo2019.Graphs.BipartiteGraph;

public class MaximumEdgesInBipartite {

    public void maxEdges(int vertices){

        int maximum_edges = (vertices*vertices)/4;

        System.out.println("Maximum Edges in Bipartite Graph with vertices " + vertices + " is : " + maximum_edges);
    }

    public static void main(String[] args) {
        MaximumEdgesInBipartite m = new MaximumEdgesInBipartite();
        m.maxEdges(10);
        m.maxEdges(7);
        m.maxEdges(1);
        m.maxEdges(2);
        m.maxEdges(5);
    }
}
