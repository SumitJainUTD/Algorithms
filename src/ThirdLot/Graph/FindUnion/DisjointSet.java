package ThirdLot.Graph.FindUnion;

import java.util.ArrayList;
import java.util.LinkedList;

public class DisjointSet {

    static class Edge{
        int source;
        int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    static class Graph{
        int vertices;
        LinkedList<Edge>[] adjList;
        ArrayList<Edge> allEdges = new ArrayList<>();

        Graph(int vertices){
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i <vertices ; i++) {
                adjList[i] = new LinkedList<>();
            }
        }
        public void addEgde(int source, int destination){
            Edge edge = new Edge(source, destination);
            adjList[source].addFirst(edge);
            allEdges.add(edge); //add to total edges
        }

        public int find(int [] parent, int vertex){
            if(parent[vertex]==-1)
                return vertex;
            return find(parent, parent[vertex]);
        }

        public void union(int [] parent, int x, int y){
            int x_set_parent = find(parent, x);
            int y_set_parent = find(parent, y);
            //make x as parent of y
            parent[y_set_parent] = x_set_parent;
        }

        public boolean isCycle(){
            //create a parent []
            int [] parent = new int[vertices];

            for (int i = 0; i <vertices ; i++) {
                parent[i] = -1;
            }

            //iterate through all the edges and keep making the sets
            for (int i = 0; i <allEdges.size() ; i++) {
                Edge edge = allEdges.get(i);
                int x_set = find(parent, edge.source);
                int y_set = find(parent, edge.destination);

                //check if source vertex and destination vertex belongs to the same set
                // if in same set then cycle has been detected else combine them into one set
                if(x_set==y_set)
                    return true;
                else
                    union(parent, x_set, y_set);
            }
            //if here, means cycle was not found
            return false;
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEgde(0, 1);
        graph.addEgde(0, 2);
//        graph.addEgde(1, 2);
        graph.addEgde(1, 3);
        graph.addEgde(3, 4);
//        graph.addEgde(2, 3);
//        graph.addEgde(4, 0);
//        graph.addEgde(4, 1);
        graph.addEgde(4, 5);
        System.out.println(graph.isCycle());

    }
}
