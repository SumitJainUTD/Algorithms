package ThirdLot.Graph.DAGCycle;

import java.util.HashSet;
import java.util.LinkedList;

public class DirectedGraphCycleColors {

    static class Graph {
        int vertices;
        LinkedList<Integer>[] adjList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination) {
            //add forward edge
            adjList[source].addFirst(destination);

//            //add reverse edge
//            adjList[destination].addFirst(source);
        }

        public boolean isCycle() {
            //Create color sets
            HashSet<Integer> whiteSet = new HashSet<>();
            HashSet<Integer> graySet = new HashSet<>();
            HashSet<Integer> blackSet = new HashSet<>();

            //Initially put all vertices in White set
            for (int i = 0; i <adjList.length ; i++) {
                whiteSet.add(i);
            }
            //traverse only white vertices
            for (int i = 0; i <vertices ; i++) {
                if(whiteSet.contains(i) &&
                        isCycleUtil(i,whiteSet,graySet,blackSet)){
                    return true;
                }
            }
            return false;
        }
        public boolean isCycleUtil(int vertex, HashSet<Integer> whiteSet, HashSet<Integer> graySet, HashSet<Integer> blackSet){
            //visiting this vertex, make it gray from white
            whiteSet.remove(vertex);
            graySet.add(vertex);

            //visit neighbors
            for (int i = 0; i <adjList[vertex].size() ; i++) {
                int adjVertex = adjList[vertex].get(i);

                //check if this vertex is present in gray set, means cycle is found
                if (graySet.contains(adjVertex))
                    return true;

                //check if this vertex is present in black set, means this vertex is already done
                if (blackSet.contains(adjVertex))
                    continue;

                //do traversal from this vertex
                if (isCycleUtil(adjVertex, whiteSet, graySet, blackSet))
                    return true;
            }
            //if here means cycle is not found from this vertex, make if black from gray
            graySet.remove(vertex);
            blackSet.add(vertex);
            return false;
        }
    }
    public static void main(String[] args) {
        int vertices = 5;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 0);
        graph.addEdge(3, 4);
        boolean result = graph.isCycle();
        System.out.println("is Cycle present: " + result);
    }
}
