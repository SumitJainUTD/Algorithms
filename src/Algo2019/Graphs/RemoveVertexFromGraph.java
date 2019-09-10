package Algo2019.Graphs;

import java.util.*;

public class RemoveVertexFromGraph {

    static class Graph {
        HashMap<Object, LinkedList<Object>> adjList = new HashMap();
        HashMap<Object, Integer> indexes = new HashMap<>();
        int index = -1;

        public Graph(ArrayList<Object> vertices) {
            for (int i = 0; i < vertices.size(); i++) {
                Object vertex = vertices.get(i);
                LinkedList<Object> list = new LinkedList<>();
                adjList.put(vertex, list);
                indexes.put(vertex, ++index);
            }
        }

        public void addEdge(Object source, Object destination) {
            //add forward edge
            LinkedList<Object> list;
            list = adjList.get(source);
            list.addFirst(destination);
            adjList.put(source, list);
        }

        public void removeVertex(Object vertex){
            adjList.remove(vertex);
            indexes.remove(vertex);

            Set<Object> set = adjList.keySet();
            Iterator<Object> iterator = set.iterator();

            while(iterator.hasNext()){
                Object v = iterator.next();
                LinkedList<Object> list = adjList.get(v);
                for (int i = 0; i <list.size() ; i++) {
                    if(list.contains(vertex))
                        list.remove(vertex);
                }
            }

            System.out.println("Removed Vertex " + vertex + " is removed from the graph (including all associated edges)");
        }

        public void printGraph() {
            Set<Object> set = adjList.keySet();
            Iterator<Object> iterator = set.iterator();

            while(iterator.hasNext()){
                Object vertex = iterator.next();
                System.out.print("Vertex " + vertex + " is connected to: ");
                LinkedList<Object> list = adjList.get(vertex);
                for (int i = 0; i <list.size() ; i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Object> vertices = new ArrayList<>();
        vertices.add(0);
        vertices.add(1);
        vertices.add(2);
        vertices.add(3);
        vertices.add(4);
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.printGraph();
        graph.removeVertex(3);
        graph.printGraph();
    }
}
