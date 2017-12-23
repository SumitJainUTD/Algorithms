package ThirdLot.Graph.GraphPrintAllPaths;

import java.util.LinkedList;
import java.util.Stack;

public class GraphPrintAllPaths {

    public void print(Graph graph, int start, int end, String path, boolean[] visited){
        String newPath = path +  "->" + start;
        visited[start] = true;
        LinkedList<Node> list = graph.adjacencyList[start];
        for (int i = 0; i <list.size() ; i++) {
            Node node = list.get(i);
            if(node.destination!=end && visited[node.destination]==false){
//                visited[node.destination] = true;
                print(graph,node.destination,end,newPath,visited);
            }else if(node.destination==end){
                System.out.println(newPath + "->" + node.destination);
            }
        }
        //remove from path
        visited[start] = false;
    }

    public void printAllPaths(Graph graph, int start, int end){
        boolean[] visited = new boolean[graph.vertices];
        visited[start] = true;
        print(graph, start, end, "", visited);
    }

    public static void main(String[] args) {
        int vertices = 4;
        Graph graph = new Graph(vertices);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,3);
        graph.addEdge(2,0);
        graph.addEdge(2,1);
        GraphPrintAllPaths p = new GraphPrintAllPaths();
        p.printAllPaths(graph,2,3);
    }
}

class Graph{
    int vertices;
    LinkedList<Node> [] adjacencyList;

    public Graph(int vertices){
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i <vertices; i++) {
            adjacencyList[i] = new LinkedList<Node>();
        }
    }

    public void addEdge(int source, int destination){
        Node node = new Node(source, destination);
        //add edge
        adjacencyList[source].addLast(node);
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
