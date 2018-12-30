package MacLaptop.October2018.Graphs;

import java.util.LinkedList;

/**
 * Created by sjain on 10/16/18.
 */
public class GraphDFS {

    int verticies;
    LinkedList<Integer>[] list;

    public GraphDFS(int verticies){
        this.verticies = verticies;
        list = new LinkedList[verticies];

        for (int i = 0; i <list.length ; i++) {
            list[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination){

        //add forward edge
        list[source].addFirst(destination);

        //add back edge
        list[destination].addFirst(source);
    }
}
