package Algo2019.Graphs;

import java.util.LinkedList;

public class CheckIfGraphIsTree {

    static class Graph {
        int vertices;
        LinkedList<Integer>[] adjList;

        public Graph(int vertices) {
            this.vertices = vertices;

            adjList = new LinkedList[vertices];
            //Initialize lists
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination) {
            //add forward edge
            adjList[source].addFirst(destination);
            //add backward edge
            adjList[destination].addFirst(source);
        }

        public void checkifTree(){

            printGraph();

            //If cycle is not present and graph is connected, its a tree

            //create visited array
            boolean [] visited = new boolean[vertices];

            //DFS for original graph start from first vertex
            boolean isCycle = isCycleUtil(0, visited, -1);

            if(isCycle){
                //graph is disconnected, its not tree
                System.out.println("Given Graph is not Tree");
                return;
            }

            //check the visited array to determine graph is connected or not
            for (int i = 0; i <vertices ; i++) {
                if(!visited[i]) {
                    System.out.println("Given Graph is not Tree");
                    return;
                }
            }
            //if here, means graph is tree
                System.out.println("Given Graph is Tree");
        }

        boolean isCycleUtil(int currVertex, boolean [] visited, int parent){

            //add this vertex to visited vertex
            visited[currVertex] = true;

            //visit neighbors except its direct parent
            for (int i = 0; i <adjList[currVertex].size() ; i++) {
                int vertex = adjList[currVertex].get(i);
                //check the adjacent vertex from current vertex
                if(vertex!=parent) {
                    //if destination vertex is not its direct parent then
                    if(visited[vertex]){
                        //if here means this destination vertex is already visited
                        //means cycle has been detected
                        return true;
                    }
                    else{
                        //recursion from destination node
                        if (isCycleUtil(vertex, visited, currVertex)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public void printGraph(){
            for (int i = 0; i <vertices ; i++) {
                LinkedList<Integer> nodeList = adjList[i];
                System.out.println("Vertex connected from vertex: "+i);

                for (int j = 0; j <nodeList.size() ; j++) {
                    System.out.print("->" + nodeList.get(j));
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            Graph graph = new Graph(5);
            graph.addEdge(1,0);
            graph.addEdge(3,1);
            graph.addEdge(3,2);
            graph.addEdge(3,4);
            graph.checkifTree();
            System.out.println("----------------------------");
            Graph graph1 = new Graph(5);
            graph.addEdge(1,0);
            graph.addEdge(3,1);
            graph.addEdge(3,2);
            graph.addEdge(3,4);
            graph.addEdge(4,0);
            graph1.checkifTree();
            System.out.println("----------------------------");
            Graph graph2 = new Graph(5);
            graph2.addEdge(1,0);
            graph2.addEdge(3,1);
            graph2.addEdge(3,2);
            graph2.checkifTree();
        }
    }
}
