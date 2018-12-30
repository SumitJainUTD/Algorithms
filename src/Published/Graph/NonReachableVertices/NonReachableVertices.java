package Published.Graph.NonReachableVertices;

import java.util.LinkedList;

public class NonReachableVertices {
    static class Graph{
        int vertices;
        LinkedList<Integer>[] adjList;

        Graph(int vertices){
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i <vertices ; i++) {
                adjList[i] = new LinkedList<>();
            }
        }
        public void addEgde(int source, int destination){
            adjList[source].addFirst(destination);

            adjList[destination].addFirst(source);
        }

        public int calculateVertices(int vertex){
            boolean [] visited = new boolean[vertices];
            //Do the DFS from the given vertex
            dfs(vertex, visited);

            //count the number of non reached vertices
            int count = 0;
            for (int i = 0; i <visited.length ; i++) {
                if(visited[i]==false)
                    count++;
            }
            return count;
        }

        public void dfs(int start, boolean [] visited){
            visited[start] = true;
            for (int i = 0; i <adjList[start].size() ; i++) {
                int vertex = adjList[start].get(i);
                if(!visited[vertex])
                    dfs(vertex,visited);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 8;
        Graph graph = new Graph(vertices);
        graph.addEgde(0, 1);
        graph.addEgde(1, 2);
        graph.addEgde(2, 3);
        graph.addEgde(2, 1);
        graph.addEgde(4, 5);
        graph.addEgde(5, 6);
        int nonReachableVertices = graph.calculateVertices(0);
        System.out.println("Number of non reachable vertices from the vertex 0 are: " + nonReachableVertices);
        nonReachableVertices = graph.calculateVertices(5);
        System.out.println("Number of non reachable vertices from the vertex 6 are: " + nonReachableVertices);
    }
}
