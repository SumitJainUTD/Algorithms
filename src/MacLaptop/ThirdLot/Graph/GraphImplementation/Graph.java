package MacLaptop.ThirdLot.Graph.GraphImplementation;

import java.util.LinkedList;

/**
 * Created by sjain on 9/26/17.
 */
public class Graph {
    int vertex;
    LinkedList<Node> list[];

    public Graph(int vertex) {
        this.vertex = vertex;
        list = new LinkedList[vertex];
        for (int i = 0; i <vertex ; i++) {
            list[i] = new LinkedList<Node>();
        }
    }

    public void addEdge(int source, int destination){
        Node node = new Node(source, destination);

        //add forward edge
        list[source].addFirst(node);

        node = new Node(destination, source);
        list[destination].addFirst(node);
    }

    public void printGraph(){
        for (int i = 0; i <vertex ; i++) {
            LinkedList<Node> nodeList = list[i];
            System.out.println("Adjacency list from vertex: "+list[i].get(0).source);
            System.out.print("head");
            for (int j = 0; j <nodeList.size() ; j++) {
                System.out.print("->" + nodeList.get(j).destination);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.printGraph();
    }
}

class Node{
    int source;
    int destination;

    public Node(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }
}
