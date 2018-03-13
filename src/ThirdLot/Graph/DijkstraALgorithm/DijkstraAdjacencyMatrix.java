package ThirdLot.Graph.DijkstraALgorithm;


public class DijkstraAdjacencyMatrix {

    static class Graph{
        int vertices;
        int matrix[][];

        public Graph(int vertex) {
            this.vertices = vertex;
            matrix = new int[vertex][vertex];
        }

        public void addEdge(int source, int destination, int weight) {
            //add edge
            matrix[source][destination]=weight;

            //add back edge for undirected graph
            matrix[destination][source] = weight;
        }

        //get the vertex with minimum key which is not included in MST
        int getMinimumVertex(boolean [] mst, int [] key){
            int minKey = Integer.MAX_VALUE;
            int vertex = -1;
            for (int i = 0; i <vertices ; i++) {
                if(mst[i]==false && minKey>key[i]){
                    minKey = key[i];
                    vertex = i;
                }
            }
            return vertex;
        }

        class ShortestPathTreeNode{
            // will store the vertex(parent) from which the current vertex will reached
            int parent;
            // will store the key for printing the MST key
            int distance;
        }

        public void dijkstra_GetMinDistances(int sourceVertex){
            boolean[] spt = new boolean[vertices];
//            HashMap<Integer, ShortestPathTreeNode> resultMap = new HashMap<>();
            ShortestPathTreeNode[] sptNodes = new ShortestPathTreeNode[vertices];
            int [] key = new int[vertices];

            //Initialize all the keys to infinity and
            //initialize resultSet for all the vertices
            for (int i = 0; i <vertices ; i++) {
                key[i] = Integer.MAX_VALUE;
                sptNodes[i] = new ShortestPathTreeNode();
            }

            //start from the vertex 0
            key[sourceVertex] = 0;
            sptNodes[sourceVertex] = new ShortestPathTreeNode();
            sptNodes[sourceVertex].parent = -1;

            //create MST
            for (int i = 0; i <vertices ; i++) {

                //get the vertex with the minimum key
                int vertex = getMinimumVertex(spt, key);

                //include this vertex in MST
                spt[vertex] = true;

                //iterate through all the adjacent vertices of above vertex and update the keys
                for (int j = 0; j <vertices ; j++) {
                    //check of the edge
                    if(matrix[vertex][j]>0){
                        //check if this vertex 'j' already in spt and
                        //if no then check if key needs an update or not
                        if(spt[j]==false && matrix[vertex][j]<key[j]){
                            //update the key
                            key[j] = matrix[vertex][j];
                            //update the result set
                            int parent_vertex_distance = sptNodes[vertex].distance;
                            sptNodes[j].parent = vertex;
                            sptNodes[j].distance = parent_vertex_distance + key[j];
                        }
                    }
                }
            }
            //print spt
            printDijkstra(sptNodes, sourceVertex);
        }

        public void printDijkstra(ShortestPathTreeNode[] resultSet, int sourceVertex){
            System.out.println("Dijkstra Algorithm: ");
            for (int i = 0; i <vertices ; i++) {
                System.out.println("Source Vertex: " + sourceVertex + " to vertex " +   + i +
                        " distance: " + resultSet[i].distance);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        int sourceVertex = 1;
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        graph.dijkstra_GetMinDistances(sourceVertex);
    }
}