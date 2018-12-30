package Published.Graph.GraphBFS;

import java.util.LinkedList;
import java.util.Queue;


public class Graph {
    int vertex;
    LinkedList<Integer> list[];

    public Graph(int vertex) {
        this.vertex = vertex;
        list = new LinkedList[vertex];
        for (int i = 0; i <vertex ; i++) {
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination){
        //add forward edge
        list[source].addFirst(destination);
    }

    public void BFS(int startIndex){
        boolean[] visited = new boolean[vertex];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startIndex);
        visited[startIndex]= true;
        while(queue.isEmpty()==false){
            int nodeIndex = queue.remove();
            System.out.print(nodeIndex + " ");
            LinkedList<Integer> nodeList = list[nodeIndex];
            for (int i = 0; i <nodeList.size(); i++) {
                int dest = nodeList.get(i);
                if(visited[dest]==false){
                    queue.add(dest);
                    visited[dest] = true;
                }
            }
        }
        System.out.println();
    }

    public void printGraph(){
        for (int i = 0; i <vertex ; i++) {
            LinkedList<Integer> nodeList = list[i];
            System.out.print("head");
            for (int j = 0; j <nodeList.size() ; j++) {
                System.out.print("->" + nodeList.get(j));
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
        graph.BFS(0);
    }
}
