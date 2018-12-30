package MacLaptop.SixthLot.GraphNew.GraphList;

import java.util.*;

/**
 * Created by sjain on 10/2/18.
 */
public class GraphBFS {

    int vertices;
    LinkedList<Integer> list [];

    public GraphBFS(int vertices){
        this.vertices = vertices;
        list = new LinkedList[vertices];
        for (int i = 0; i <list.length ; i++) {
            list[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination){
        //add the forward edge
        list[source].addFirst(destination);
    }

    public void BFS(int startVertex){
        boolean [] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(startVertex);
        visited[startVertex] = true;
        System.out.println("BFS ");
        while(queue.isEmpty()==false){
            int x = queue.remove();
            visited[x] = true;
            System.out.print(x + " ");
            for (int i = 0; i <list[x].size() ; i++) {
                int temp = list[x].get(i);
                if(visited[temp]==false)
                    queue.add(temp);
            }
        }
    }

    public static void main(String[] args) {
        GraphBFS g = new GraphBFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.BFS(0);

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        Set<Integer> set = hm.keySet();
        hm.put(1,1);
        hm.put(2,4);

        System.out.println(hm.containsKey(1));

        Iterator<Integer> iterator = set.iterator();

        while(iterator.hasNext()){
            int key = iterator.next();
            System.out.println("Key " + key + " value " + hm.get(key));
        }

    }
}
