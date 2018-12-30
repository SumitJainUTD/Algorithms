package Published.Graph.SoftwareInstallation;

/**
 * Created by sumi1 on 1/15/2018.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
public class SoftwareInstallation {
    static class Node {
        char destination;
        char source;

        Node(char source, char destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    static class Graph {
        int vertices;
        LinkedList<Node>[] adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEgde(char source, char destination,  ArrayList<Character> softwares) {
            Node node = new Node(source, destination);
            adjList[softwares.indexOf(source)].addFirst(node);
        }

        public void topologicalSorting(ArrayList<Character> softwares) {
            boolean[] visited = new boolean[vertices];
            Stack<Character> stack = new Stack<>();
            //visit from each node if not already visited
            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {
                    topologicalSortUtil(softwares.get(i), visited, stack, softwares);
                }
            }
            System.out.println("Software Sequence: ");
            int size = stack.size();
            for (int i = 0; i <size ; i++) {
                System.out.print(stack.pop() + " ");
            }
        }

        public void topologicalSortUtil(char sftwr, boolean[] visited, Stack<Character> stack, ArrayList<Character> softwares) {
            int index = softwares.indexOf(sftwr);
            visited[index] = true;
            for (int i = 0; i < adjList[softwares.indexOf(sftwr)].size(); i++) {
                Node node = adjList[index].get(i);
                if (!visited[softwares.indexOf(node.destination)])
                    topologicalSortUtil(node.destination, visited, stack, softwares);
            }
            stack.push(sftwr);
        }
    }

    public static void main(String[] args) {
        ArrayList<Character> softwares= new ArrayList<>();
        softwares.add('A');
        softwares.add('B');
        softwares.add('C');
        softwares.add('D');
        softwares.add('E');
        softwares.add('F');
        int vertices = softwares.size();
        Graph graph = new Graph(vertices);
        graph.addEgde('A', 'B', softwares);
        graph.addEgde('A', 'C', softwares);
        graph.addEgde('B', 'D', softwares);
        graph.addEgde('B', 'E', softwares);
        graph.addEgde('C', 'D', softwares);
        graph.addEgde('D', 'E', softwares);
        graph.topologicalSorting(softwares);
    }
}
