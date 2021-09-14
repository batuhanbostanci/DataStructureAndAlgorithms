import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    static class Node {
        int value;
        int weight;

        public Node(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
    List<List<Node>> adjList = new ArrayList<>();
    
    public Graph(List<Edges> edges) {
        for(int i=0;i<edges.size();i++){
            adjList.add(i,new ArrayList<>());
        }
        for(Edges e:edges){
            adjList.get(e.source).add(new Node(e.destination,e.weight));
        }
    }
    public static void get(Graph graph,int value){
            for (Node edge : graph.adjList.get(value)) {
                System.out.println("(" + value + "," + edge.value +")"+ "  " + edge.weight);
            }
            System.out.println();

    }
    public static void printGraph(Graph graph)  {

            for(int src_vertex=0;src_vertex<graph.adjList.size();src_vertex++){

            for (Node edge : graph.adjList.get(src_vertex)) {
                System.out.println("(" + src_vertex + "," + edge.value +")"+ "  " + edge.weight);
            }

        }
    }







}



