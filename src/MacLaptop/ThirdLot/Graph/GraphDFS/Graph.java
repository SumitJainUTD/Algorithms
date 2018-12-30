package MacLaptop.ThirdLot.Graph.GraphDFS;

import java.util.LinkedList;
import java.util.Stack;

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

//        //add reverse edge
//        node = new Node(destination, source);
//        list[destination].addLast(node);
    }

    public void DFS(int startIndex){
        boolean[] visited = new boolean[vertex];
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(startIndex);
        visited[startIndex]= true;
        while(stack.isEmpty()==false){
            int nodeIndex = stack.pop();
            System.out.print(nodeIndex + " ");
            LinkedList<Node> nodeList = list[nodeIndex];
            for (int i = 0; i <nodeList.size(); i++) {
                int dest = nodeList.get(i).destination;
                if(visited[dest]==false){
                    stack.push(dest);
                    visited[dest] = true;
                }
            }
        }
        System.out.println();
    }

    public void printGraph(){
        for (int i = 0; i <vertex ; i++) {
            LinkedList<Node> nodeList = list[i];
            System.out.print("head");
            for (int j = 0; j <nodeList.size() ; j++) {
                System.out.print("->" + nodeList.get(j).destination);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        graph.printGraph();
        graph.DFS(0);
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
