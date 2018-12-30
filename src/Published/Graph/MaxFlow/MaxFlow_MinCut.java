package Published.Graph.MaxFlow;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sumi1 on 4/7/2018.
 */
public class MaxFlow_MinCut {
    static class Graph {
        int vertices;
        int graph[][];

        public Graph(int vertex) {
            this.vertices = vertex;
            graph = new int[vertex][vertex];
        }

        public void addEdge(int source, int destination, int weight) {
            //add edge
            graph[source][destination] = weight;
        }

        public void findMinCut(int source, int sink) {
            //residual graph
            int[][] residualGraph = new int[vertices][vertices];

            //initialize residual graph same as original graph
            for (int i = 0; i <vertices ; i++) {
                for (int j = 0; j <vertices ; j++) {
                    residualGraph[i][j] = graph[i][j];
                }
            }

            //initialize parent [] to store the path Source to destination
            int [] parent = new int[vertices];

            while(isPathExist_BFS(residualGraph, source, sink, parent)){
                //if here means still path exist from source to destination

                //parent [] will have the path from source to destination
                //find the capacity which can be passed though the path (in parent[])

                int flow_capacity = Integer.MAX_VALUE;

                int t = sink;
                while(t!=source){
                    int s = parent[t];
                    flow_capacity = Math.min(flow_capacity, residualGraph[s][t]);
                    t = s;
                }

                //update the residual graph
                //reduce the capacity on fwd edge by flow_capacity
                //add the capacity on back edge by flow_capacity
                t = sink;
                while(t!=source){
                    int s = parent[t];
                    residualGraph[s][t]-=flow_capacity;
                    residualGraph[t][s]+=flow_capacity;
                    t = s;
                }
            }

            //once here means Max flow is found, lets find the min cut

            //find all the reachable vertices from source vertex
            //mark them true in visited array
            boolean visited[] = new boolean[vertices];
            dfs(residualGraph, source, visited);

            //No min cut - Edges for which one vertex is reachable and another is not reachable
            for (int i = 0; i <vertices ; i++) {
                for (int j = 0; j <vertices ; j++) {
                    if(graph[i][j]>0 && visited[i] && visited[j]==false){
                        System.out.println("Edge: " + i + "--->" + j);
                    }
                }
            }
        }

        public void dfs(int [][] residualGraph, int src, boolean [] visited){
            visited[src] = true;
            int vertices = residualGraph.length;
            for (int t = 0; t <vertices ; t++) {
                if(visited[t]==false && residualGraph[src][t]>0)
                    dfs(residualGraph, t, visited);
            }
        }

        public boolean isPathExist_BFS(int [][] residualGraph, int src, int dest, int [] parent){
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
                    if(visited[v]==false && residualGraph[u][v]>0) {
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
        g.findMinCut(source,destination);
    }
}
