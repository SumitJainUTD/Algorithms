package Published.Graph.FindUnion;

import java.util.ArrayList;
import java.util.LinkedList;

public class OptimizedDisjointSetFindCycle { //still pending path compressions
    static class Edge{
        int source;
        int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    static class SubSet {
        int parent;
        int rank;
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
        //(Path Compression)
        public int find(SubSet [] subSet, int vertex){
            if(subSet[vertex].parent!=vertex)
                return find(subSet, subSet[vertex].parent);;
            return vertex;
        }
        //(Union by rank)
        public void union(SubSet [] subSet, int x, int y){
            int x_set_parent = find(subSet, x);
            int y_set_parent = find(subSet, y);

            //attach the smaller rank tree to the higher rank tree
            if(subSet[x_set_parent].rank>subSet[y_set_parent].rank){
                //make x as parent of y
                subSet[y_set_parent].parent = x_set_parent;
            }else if(subSet[y_set_parent].rank<subSet[y_set_parent].rank){
                //make y as parent of x
                subSet[x_set_parent].parent = y_set_parent;
            }else{
               // make any tree child of other tree
                subSet[y_set_parent].parent = x_set_parent;
                //now increase the rank of x for the next time
                subSet[x_set_parent].rank++;
            }

        }

        public boolean isCycle(){
            //create a set []
            SubSet[] subSets = new SubSet[vertices];

            for (int i = 0; i <vertices ; i++) {
                subSets[i] = new SubSet();
                subSets[i].parent = i;
                subSets[i].rank = 0;
            }

            //iterate through all the edges and keep making the sets
            for (int i = 0; i <allEdges.size() ; i++) {
                Edge edge = allEdges.get(i);
                int x_set = find(subSets, edge.source);
                int y_set = find(subSets, edge.destination);

                //check if source vertex and destination vertex belongs to the same set
                // if in same set then cycle has been detected else combine them into one set
                if(x_set==y_set)
                    return true;
                else
                    union(subSets, x_set, y_set);
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
        graph.addEgde(1, 3);
        graph.addEgde(3, 4);
        graph.addEgde(2, 3);
        graph.addEgde(4, 5);
        System.out.println("The GraphDFS contains cycle: " +  graph.isCycle());

    }
}

