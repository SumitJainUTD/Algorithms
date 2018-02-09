package ThirdLot.Graph.DFS;

import java.util.LinkedList;
public class DisconnetedGraphDFS {
    //this code will work for disconnected graphs as well
    static class Graph{
        int vertices;
        LinkedList<Integer> [] adjList;

        Graph(int vertices){
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i <vertices ; i++) {
                adjList[i] = new LinkedList<>();
            }
        }
         public void addEgde(int source, int destination){
            adjList[source].addFirst(destination);
         }

         public void DFSRecursion(){
             boolean [] visited = new boolean[vertices];
             System.out.println("Depth-First Search: ");
             //visit from each node if not already visited
             for (int i = 0; i <vertices ; i++) {
                 if(!visited[i]){
                     dfs(i, visited);
                 }
             }
         }

         public void dfs(int start, boolean [] visited){
             visited[start] = true;
             System.out.print(start + " ");
             for (int i = 0; i <adjList[start].size() ; i++) {
                 int vertex = adjList[start].get(i);
                 if(!visited[vertex])
                     dfs(vertex,visited);
             }
         }
    }

    public static void main(String[] args) {
        int vertices = 7;
        Graph graph = new Graph(vertices);
        graph.addEgde(1,3);
        graph.addEgde(2,3);
        graph.addEgde(0,4);
        graph.addEgde(4,5);
        graph.addEgde(5,6);
        graph.DFSRecursion();

    }
}
