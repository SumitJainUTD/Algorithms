package ThirdLot.Graph.MaxFlow;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sumi1 on 4/8/2018.
 */
public class MaxFlow_Ford_Fulkerson_List {

    static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.weight = weight;
            this.destination = destination;
        }
    }

    static class Graph {
        int vertices;
        LinkedList<Integer>[] graph;
        HashMap<Integer, Integer> edges = new HashMap<>();

        public Graph(int vertex) {
            this.vertices = vertex;
            graph = new LinkedList[vertex];
            for (int i = 0; i < vertex; i++) {
                graph[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination, int weight) {
            //add edge
            Edge edge = new Edge(destination, weight);
            edges.put(destination, weight);
            graph[source].addFirst(destination);
        }

        public LinkedList<Integer>[] createdResidualGraph(){
            LinkedList<Integer> residualGraph[] = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                residualGraph[i] = new LinkedList<>();
            }
            //initialize residual graph same as original graph
            for (int i = 0; i <vertices ; i++) {
                if(graph[i].size()>0) {
                    System.out.print("Vertex " + i + " is connected to: ");
                    for (int j = 0; j < graph[i].size(); j++) {
                        residualGraph[i].addFirst(graph[i].get(j));
                    }
                }
            }
            return residualGraph;
        }

        public int findMaxFlow(int source, int sink) {
            //residual graph
            LinkedList<Integer> residualGraph[] = createdResidualGraph();


            //initialize parent [] to store the path Source to destination
            int [] parent = new int[vertices];

            int max_flow = 0; //initialize the max flow

            while(isPathExist_BFS(residualGraph, source, sink, parent)){
                //if here means still path exist from source to destination

                //parent [] will have the path from source to destination
                //find the capacity which can be passed though the path (in parent[])

                int flow_capacity = Integer.MAX_VALUE;

                int t = sink;
                while(t!=source){
                    int s = parent[t];
//                    flow_capacity = Math.min(flow_capacity, residualGraph[s][t]);
                    t = s;
                }

                //update the residual graph
                //reduce the capacity on fwd edge by flow_capacity
                //add the capacity on back edge by flow_capacity
                t = sink;
                while(t!=source){
                    int s = parent[t];
                    updateResidualGraph(residualGraph, s, t, -flow_capacity);
                    updateResidualGraph(residualGraph, t, s, flow_capacity);
                    t = s;
                }

                //add flow_capacity to max value
                max_flow+=flow_capacity;
            }
            return max_flow;
        }

        public void updateResidualGraph(LinkedList<Integer> residualGraph[], int s, int t, int flow_Capacity ){
            if(!residualGraph[s].contains(t)){
                residualGraph[s].addFirst(t);
                edges.put(t, flow_Capacity);
            }else{
                int cap = edges.get(s);
                edges.put(t,cap+flow_Capacity);
            }

        }

        public boolean isPathExist_BFS(LinkedList<Integer> residualGraph[], int src, int dest, int [] parent){
            boolean pathFound = false;

            //create visited array [] to
            //keep track of visited vertices
            boolean [] visited = new boolean[vertices];

            //Create a queue for BFS
            Queue<Integer> queue = new LinkedList<>();

            //insert the source vertex, mark it visited
            queue.add(src);
            parent[src] = -1;
            visited[src] = true;

            while(queue.isEmpty()==false){
                int u = queue.poll();

                //visit all the adjacent vertices
                for (int v = 0; v <vertices ; v++) {
                    //if vertex is not already visited and u-v edge weight >0
                    if(visited[v]==false && residualGraph[u].contains(v)==true && edges.get(v)>0) {
                        queue.add(v);
                        parent[v] = u;
                        visited[v] = true;
                    }
                }
            }
            //check if dest is reached during BFS
            pathFound = visited[dest];
            return pathFound;
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph g = new Graph(vertices);
        g.addEdge(0, 1, 16);
        g.addEdge(0, 2, 13);
        g.addEdge(1, 3, 12);
        g.addEdge(2, 1, 4);
        g.addEdge(2, 4, 14);
        g.addEdge(3, 2, 9);
        g.addEdge(3, 5, 20);
        g.addEdge(4, 3, 7);
        g.addEdge(4, 5, 4);
        int source = 0;
        int destination = 5;
        int max_flow = g.findMaxFlow(source,destination);
        System.out.println("Maximum flow from source: " + source + " to destination: " + destination
                + " is: " + max_flow);
    }
}