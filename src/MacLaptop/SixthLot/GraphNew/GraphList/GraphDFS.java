package MacLaptop.SixthLot.GraphNew.GraphList;

import java.util.LinkedList;

/**
 * Created by sjain on 10/1/18.
 */
public class GraphDFS {

    int vertices;
    LinkedList<Integer>[] list;

    public GraphDFS(int vertices){
        this.vertices = vertices;
        list = new LinkedList[vertices];

        for (int i = 0; i <list.length ; i++) {
            list[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination){

        //add the forward edge
        list[source].addFirst(destination);

        //add the reverse egde
        list[destination].addFirst(source);
    }

    public void printGraph(){

        for (int i = 0; i <vertices ; i++) {
            System.out.print("Vertex " + i + " Connected to - ");
            for (int j = 0; j <list[i].size() ; j++) {
                System.out.print(list[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    public void DFS(){
        boolean [] visited = new boolean[vertices];
        System.out.print("Depth First Traversal : ");
        for (int i = 0; i <vertices ; i++) {
            if(visited[i]==false){
                DFSUtil(i, visited);
            }
        }
    }

    public void DFSUtil(int vertex, boolean [] visited){
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (int i = 0; i <list[vertex].size() ; i++) {
            int dest = list[vertex].get(i);
            if(visited[dest]==false) {
                DFSUtil(dest, visited);
            }
        }
    }

    public static void main(String[] args) {
        GraphDFS graph = new GraphDFS(6);
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
        graph.DFS();
    }
}
