package Published.Graph.FindUnion;

import java.util.*;

public class DisjointSet {
    static class Edge{
        int source;
        int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    static class Graph{
        int vertices;
        ArrayList<Edge> allEdges = new ArrayList<>();

        Graph(int vertices){
            this.vertices = vertices;
        }
        public void addEgde(int source, int destination){
            Edge edge = new Edge(source, destination);
            allEdges.add(edge); //add to total edges
        }

        public void makeSet(int [] parent){
            //Make set- creating a new element with a parent pointer to itself.
            for (int i = 0; i <vertices ; i++) {
                parent[i] = i;
            }
        }

        public int find(int [] parent, int vertex){
            //chain of parent pointers from x upwards through the tree
            // until an element is reached whose parent is itself
            if(parent[vertex]!=vertex)
                return find(parent, parent[vertex]);;
            return vertex;
        }

        public void union(int [] parent, int x, int y){
            int x_set_parent = find(parent, x);
            int y_set_parent = find(parent, y);
            //make x as parent of y
            parent[y_set_parent] = x_set_parent;
        }

        public void disjointSets(){
            //create a parent []
            int [] parent = new int[vertices];

            //makeset
            makeSet(parent);

            //iterate through all the edges and keep making the sets
            for (int i = 0; i <allEdges.size() ; i++) {
                Edge edge = allEdges.get(i);
                int x_set = find(parent, edge.source);
                int y_set = find(parent, edge.destination);

                //check if source vertex and destination vertex belongs to the same set
                // if in same set then cycle has been detected else combine them into one set
                if(x_set==y_set) {
                    //do nothing
                }else
                    union(parent, x_set, y_set);
            }
            printSets(parent);
        }

        public void printSets(int [] parent){
            //Find different Sets
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int i = 0; i <parent.length ; i++) {
                if(map.containsKey(parent[i])){
                    ArrayList<Integer> list = map.get(parent[i]);
                    list.add(i);//add vertex
                    map.put(parent[i],list);
                }else{
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(parent[i],list);
                }
            }
            //Print the Different sets
            Set<Integer> set = map.keySet();
            Iterator<Integer> iterator = set.iterator();
            while(iterator.hasNext()){
                int key = iterator.next();
                System.out.println("Set Id: " + key + " elements: " + map.get(key));
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEgde(0, 1);
        graph.addEgde(0, 2);
        graph.addEgde(1, 3);
        graph.addEgde(4, 5);
        graph.disjointSets();
    }
}


