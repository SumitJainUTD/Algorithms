package MacLaptop.SixthLot.GraphNew.GraphList;

import java.util.LinkedList;

/**
 * Created by sjain on 10/1/18.
 */
public class Graph {

    int vertices;
    LinkedList<Integer> [] list;

    public Graph(int vertices){
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
