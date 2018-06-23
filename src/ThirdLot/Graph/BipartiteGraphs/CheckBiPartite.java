package ThirdLot.Graph.BipartiteGraphs;

/**
 * Created by sumi1 on 4/9/2018.
 */
public class CheckBiPartite {

    enum Color {
        RED, WHITE, BLUE;
    }

    public boolean isBipartite(int [][] graph){

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
                //color is withh the alternate color of vertex v
                if(colors[u]==Color.RED)
                    colors[v] = Color.BLUE;
                else if (colors[u]==Color.BLUE)
                    colors[v] = Color.RED;

                //make recursive call

                return isBipartiteUtil(v, vertices, colors, graph);
            }else if(graph[u][v]==1 && colors[u]==colors[v]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int [][] graph = {{0, 1, 0, 1},
                         {1, 0, 1, 1},
                         {0, 1, 0, 1},
                         {1, 1, 1, 0}};
        System.out.println(new CheckBiPartite().isBipartite(graph));
    }
}
