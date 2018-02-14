package ThirdLot.Graph.WeightedGraph;

import java.util.*;

/**
 * Created by sumi1 on 2/13/2018.
 */
public class WeightedGraph {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        ArrayList<Edge> allEdges = new ArrayList<>();

        Graph(int vertices) {
            this.vertices = vertices;
        }

        public void addEgde(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            allEdges.add(edge); //add to total edges
        }

        public void printGraph(){
            for (int i = 0; i <allEdges.size() ; i++) {
                Edge edge = allEdges.get(i);
                System.out.println("Edge-" + i + " source: " + edge.source +
                " destination: " + edge.destination +
                " weight: " + edge.weight);
            }
        }


        public static void main(String[] args) {
            int vertices = 6;
            Graph graph = new Graph(vertices);
            graph.addEgde(0, 1, 4);
            graph.addEgde(0, 2, 3);
            graph.addEgde(1, 3, 2);
            graph.addEgde(3, 4, 2);
            graph.addEgde(4, 5, 6);
            graph.printGraph();
        }
    }
}
