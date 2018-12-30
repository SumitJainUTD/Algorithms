package Published.Graph.PrimsAlgorithm;


import java.util.*;

public class PrimsPQ {

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

    static class HeapNode{
        int vertex;
        int key;
    }

    static class ResultSet {
        int parent;
        int weight;
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

        public void addEgde(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge);

            edge = new Edge(destination, source, weight);
            adjacencylist[destination].addFirst(edge); //for undirected graph
        }

        public void primMST(){

            boolean[] inPriorityQueue = new boolean[vertices];
            ResultSet[] resultSet = new ResultSet[vertices];
            int [] key = new int[vertices];  //keys used to store the key to know whether priority queue update is required

//          //create heapNode for all the vertices
            HeapNode [] heapNodes = new HeapNode[vertices];
            for (int i = 0; i <vertices ; i++) {
                heapNodes[i] = new HeapNode();
                heapNodes[i].vertex = i;
                heapNodes[i].key = Integer.MAX_VALUE;
                resultSet[i] = new ResultSet();
                resultSet[i].parent = -1;
                inPriorityQueue[i] = true;
                key[i] = Integer.MAX_VALUE;
            }

            //decrease the key for the first index
            heapNodes[0].key = 0;

            //add all the vertices to the priority queue
            PriorityQueue<HeapNode> pq = new PriorityQueue<>(vertices,
                    new Comparator<HeapNode>() {
                        @Override
                        public int compare(HeapNode o1, HeapNode o2) {
                            return o1.key -o2.key;
                        }
                    });
            //add all the vertices to priority queue
            for (int i = 0; i <vertices ; i++) {
                pq.offer(heapNodes[i]);
            }

            //while priority queue is not empty
            while(!pq.isEmpty()){
                //extract the min
                HeapNode extractedNode = pq.poll();

                //extracted vertex
                int extractedVertex = extractedNode.vertex;
                inPriorityQueue[extractedVertex] = false;

                //iterate through all the adjacent vertices
                LinkedList<Edge> list = adjacencylist[extractedVertex];
                for (int i = 0; i <list.size() ; i++) {
                    Edge edge = list.get(i);
                    //only if edge destination is present in heap
                    if(inPriorityQueue[edge.destination]) {
                        int destination = edge.destination;
                        int newKey = edge.weight;
                        //check if updated key < existing key, if yes, update if
                        if(key[destination]>newKey) {
                            decreaseKey(pq, newKey, destination);
                            //update the parent node for destination
                            resultSet[destination].parent = extractedVertex;
                            resultSet[destination].weight = newKey;
                            key[destination] = newKey;
                        }
                    }
                }
            }
            //print mst
            printMST(resultSet);
        }

        public void decreaseKey(PriorityQueue<HeapNode> pq, int newKey, int vertex){

            //iterate through nodes in priority queue and update the key for the vertex
            Iterator it = pq.iterator();

            while (it.hasNext()) {
                HeapNode heapNode = (HeapNode) it.next();
                if(heapNode.vertex==vertex) {
                    pq.remove(heapNode);
                    heapNode.key = newKey;
                    pq.offer(heapNode);
                    break;
                }
            }
        }

        public void printMST(ResultSet[] resultSet){
            int total_min_weight = 0;
            System.out.println("Minimum Spanning Tree: ");
            for (int i = 1; i <vertices ; i++) {
                System.out.println("Edge: " + i + " - " + resultSet[i].parent +
                        " key: " + resultSet[i].weight);
                total_min_weight += resultSet[i].weight;
            }
            System.out.println("Total minimum key: " + total_min_weight);
        }

        public static void main(String[] args) {
            int vertices = 6;
            Graph graph = new Graph(vertices);
            graph.addEgde(0, 1, 4);
            graph.addEgde(0, 2, 3);
            graph.addEgde(1, 2, 1);
            graph.addEgde(1, 3, 2);
            graph.addEgde(2, 3, 4);
            graph.addEgde(3, 4, 2);
            graph.addEgde(4, 5, 6);
            graph.primMST();
        }
    }
}

