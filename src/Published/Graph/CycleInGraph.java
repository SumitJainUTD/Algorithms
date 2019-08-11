package Published.Graph;

import java.util.LinkedList;

/**
 * Created by sjain on 10/16/18.
 */
public class CycleInGraph {

    int verticies;
    LinkedList<Integer> [] list;

    public CycleInGraph(int verticies){
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

    public boolean isCycle(){

        boolean [] visited = new boolean[verticies];
        for (int i = 0; i <list.length ; i++) {
            if(visited[i]==false) {
                if (isCycleUtil(i, -1, visited)) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean isCycleUtil(int vertex, int parent, boolean[] visited){
        visited[vertex] = true;

        //do the dfs
        for (int i = 0; i <list[vertex].size() ; i++) {
            int dest = list[vertex].get(i);
            if(dest!=parent){
                if(visited[dest]){
                    return true;
                }else{
                   return isCycleUtil(dest, vertex, visited);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int vertices = 6;
        CycleInGraph graph = new CycleInGraph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 2);
        boolean result = graph.isCycle();
        System.out.println("is Cycle present: " + result);
    }
}
