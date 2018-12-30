package Published.Graph.GraphPrintAllPaths;

import java.util.LinkedList;

public class GraphPrintAllPaths {

    public void print(Graph graph, int start, int end, String path, boolean[] visited){
        String newPath = path +  "->" + start;
        visited[start] = true;
        LinkedList<Integer> list = graph.adjacencyList[start];
        for (int i = 0; i <list.size() ; i++) {
            int destination = list.get(i);
            if(destination!=end && visited[destination]==false){
//                visited[node.destination] = true;
                print(graph,destination,end,newPath,visited);
            }else if(destination==end){
                System.out.println(newPath + "->" + destination);
            }
        }
        //remove from path
        visited[start] = false;
    }

    public void printAllPaths(Graph graph, int start, int end){
        boolean[] visited = new boolean[graph.vertices];
        visited[start] = true;
        print(graph, start, end, "", visited);
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        GraphPrintAllPaths p = new GraphPrintAllPaths();
        p.printAllPaths(graph,0,5);
    }
}

class Graph{
    int vertices;
    LinkedList<Integer> [] adjacencyList;

    public Graph(int vertices){
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i <vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination){
        //add edge
        adjacencyList[source].addLast(destination);
    }
}