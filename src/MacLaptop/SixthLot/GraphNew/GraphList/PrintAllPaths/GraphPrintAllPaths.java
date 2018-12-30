package MacLaptop.SixthLot.GraphNew.GraphList.PrintAllPaths;

import java.util.LinkedList;

/**
 * Created by sjain on 10/1/18.
 */
public class GraphPrintAllPaths {

    int vertices;
    LinkedList<Integer>[] list;

    public GraphPrintAllPaths(int vertices){
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
        //list[destination].addFirst(source);
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

    public void printPaths(int source, int destination){

        for (int i = 0; i <list[source].size() ; i++) {
            printUtils(list[source].get(i),destination, source + " ");
        }
    }

    public void printUtils(int curr, int destination, String path){
        path = path + " " + curr;
        if(curr==destination){
            System.out.println(path);
        }
        for (int i = 0; i <list[curr].size() ; i++) {
            int temp = list[curr].get(i);
            if(path.contains(temp+"")==false){
                printUtils(temp, destination, path);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        GraphPrintAllPaths graph = new GraphPrintAllPaths(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        graph.printPaths(0,5);
    }
}
