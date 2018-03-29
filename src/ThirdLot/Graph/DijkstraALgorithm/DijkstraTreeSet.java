package ThirdLot.Graph.DijkstraALgorithm;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by sumi1 on 3/20/2018.
 */
public class DijkstraTreeSet {
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
    static class ResultSet{
        int vertex;
        int distance;
    }

    static class PairComparator implements Comparator<Pair<Integer, Integer>>{

        @Override
        public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
            //sort using distance values
            int key1 = o1.getKey();
            int key2 = o2.getKey();
            return key1-key2;
        }
    }

    static class Graph {
        int vertices;
        LinkedList<Edge>[] adjacencylist;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i <vertices ; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge);

            edge = new Edge(destination, source, weight);
            adjacencylist[destination].addFirst(edge); //for undirected graph
        }

        public void dijkstra_GetMinDistances(int sourceVertex){

            boolean[] inSPT = new boolean[vertices];
            ResultSet[] resultSet = new ResultSet[vertices];
            //distance used to store the distance of vertex from a source
            int [] distance = new int[vertices];

            //Initialize all the keys to infinity and
            //initialize resultSet for all the vertices
            for (int i = 0; i <vertices ; i++) {
                distance[i] = Integer.MAX_VALUE;
                resultSet[i] = new ResultSet();
                resultSet[i].vertex = i;
            }
            //Initialize priority queue
            //override the comparator to do the sorting based keys
            TreeSet treeSet = new TreeSet<>(new PairComparator());
            //create the pair for for the first index, 0 distance 0 index
            distance[0] = 0;
            Pair<Integer, Integer> p0 = new Pair<>(distance[0],0);
            //add it to tree set
            treeSet.add(p0);

            //while priority queue is not empty
            while(!treeSet.isEmpty()){
                //extract the min
                Pair<Integer, Integer> extractedPair = (Pair<Integer, Integer>) treeSet.pollFirst();

                //extracted vertex
                int extractedVertex = extractedPair.getValue();
                if(inSPT[extractedVertex]==false) {
                    inSPT[extractedVertex] = true;

                    //iterate through all the adjacent vertices and update the keys
                    LinkedList<Edge> list = adjacencylist[extractedVertex];
                    for (int i = 0; i < list.size(); i++) {
                        Edge edge = list.get(i);
                        int destination = edge.destination;
                        //only if edge destination is not present in mst
                        if (inSPT[destination] == false) {
                            ///check if distance needs an update or not
                            //means check total weight from source to vertex_V is less than
                            //the current distance value, if yes then update the distance
                            int newKey =  distance[extractedVertex] + edge.weight ;
                            int currentKey = distance[destination];
                            if(currentKey>newKey){
                                Pair<Integer, Integer> p = new Pair<>(newKey, destination);
                                treeSet.add(p);
                                resultSet[destination].distance = newKey;
                                distance[destination] = newKey;
                            }
                        }
                    }
                }
            }
            //print Shortest Path Tree
            printDijkstra(resultSet, sourceVertex);
        }

        public void printDijkstra(ResultSet[] resultSet, int sourceVertex){
            System.out.println("Dijkstra Algorithm: (Adjacency List + Tree Set)");
            for (int i = 0; i <vertices ; i++) {
                System.out.println("Source Vertex: " + sourceVertex + " to vertex " +   + i +
                        " distance: " + resultSet[i].distance);
            }
        }


        public static void main(String[] args) {
            int vertices = 6;
            Graph graph = new Graph(vertices);
            graph.addEdge(0, 1, 4);
            graph.addEdge(0, 2, 3);
            graph.addEdge(1, 2, 1);
            graph.addEdge(1, 3, 2);
            graph.addEdge(2, 3, 4);
            graph.addEdge(3, 4, 2);
            graph.addEdge(4, 5, 6);
            graph.dijkstra_GetMinDistances(0);

            int V = 9;
            Graph g = new Graph(V);
            int sourceVertex = 0;
            g.addEdge(0, 1, 4);
            g.addEdge(0, 7, 8);
            g.addEdge(1, 2, 8);
            g.addEdge(1, 7, 11);
            g.addEdge(2, 3, 7);
            g.addEdge(2, 8, 2);
            g.addEdge(2, 5, 4);
            g.addEdge(3, 4, 9);
            g.addEdge(3, 5, 14);
            g.addEdge(4, 5, 10);
            g.addEdge(5, 6, 2);
            g.addEdge(6, 7, 1);
            g.addEdge(6, 8, 6);
            g.addEdge(7, 8, 7);
            g.dijkstra_GetMinDistances(sourceVertex);
        }
    }
}
