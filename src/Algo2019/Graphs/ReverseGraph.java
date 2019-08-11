package Algo2019.Graphs;
import java.util.LinkedList;

public class ReverseGraph {
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
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);
        System.out.println("---------------Original Graph---------------------------");
        graph.printGraph();
        Graph reverseGraph = graph.reverse(graph);
        System.out.println("---------------Reverse Graph---------------------------");
        reverseGraph.printGraph();
    }
}
