package Algo2019.Graphs.BipartiteGraph;

public class CheckBipartiteGraph {

    enum Color{
        WHITE, RED, GREEN
    }

    public boolean isBipartite(int [][] graph){

        //check if graph is empty
        if(graph.length==0)
            return true;

        int vertices = graph.length;

        //initialize colors for all vertices
        Color colors[] = new Color[vertices];
        //color all the vertices with white color
        for (int i = 0; i <colors.length ; i++) {
            colors[i] = Color.WHITE;
        }

        //start coloring vertices , this code will handle the disconnected graph as well
        //color the first vertex with RED
        for (int i = 0; i <vertices; i++) {
            if(colors[i]==Color.WHITE) {
                boolean result = isBipartiteUtil(i, vertices, colors, graph);
                if(result==false)
                    return false;
            }
        }
        return true;
    }

    private boolean isBipartiteUtil(int u, int vertices,  Color [] colors, int [][]graph){

        //if is it first vertex, mark it RED
        if(u==0)
            colors[u]=  Color.RED;

        //travel all adjacent vertices
        for (int v = 0; v <vertices ; v++) {
            //if u-v exist and v is color with white
            if(graph[u][v]==1 && colors[v]==Color.WHITE){
                //color is with the alternate color of vertex v
                if(colors[u]==Color.RED) {
                    //if u is in red, make vertex v in green
                    colors[v] = Color.GREEN;
                }
                else if (colors[u]==Color.GREEN) {
                    //if u is in green, make vertex v in red
                    colors[v] = Color.RED;
                }

                //make recursive call

                return isBipartiteUtil(v, vertices, colors, graph);
            }else if(graph[u][v]==1 && colors[u]==colors[v]){
                return false;
            }
        }
        // if here means graph is successfully colored in 2 color, red and green
        //graph is bipartite
        return true;
    }


    public static void main(String[] args) {
        CheckBipartiteGraph c = new CheckBipartiteGraph();
        int [][] graph =    {   {0, 1, 1, 1},
                                {1, 0, 0, 1},
                                {0, 0, 0, 1},
                                {1, 1, 1, 0}
                            };
        boolean result = c.isBipartite(graph);
        System.out.println("Graph is Bipartite: " + result);
        System.out.println("--------------------------");
        int [][] graph1 =   {   {0, 1, 1, 0},
                                {1, 0, 0, 1},
                                {1, 0, 0, 1},
                                {0, 1, 1, 0}
                            };
        result = c.isBipartite(graph1);
        System.out.println("Graph is Bipartite: " + result);
    }
}
