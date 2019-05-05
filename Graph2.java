import java.util.*;

public class Graph2 {

    public static void main(String[] args) {

        Node n1 = new Node("E");
        Node n2 = new Node("F");
        Node n3 = new Node("G");
        Node n4 = new Node("H");
        Node n5 = new Node("I");

        Graph g = new Graph();
        
        List<Node> l1 = g.addNodes(n1);
        List<Node> l2 = g.addNodes(n2);
        List<Node> l3 = g.addNodes(n3);
        List<Node> l4 = g.addNodes(n4);
        List<Node> l5 = g.addNodes(n5);

        g.addEdges(n1, n2);
        g.addEdges(n1, n3);
        g.addEdges(n1, n4);
        g.addEdges(n1, n5);

        g.addEdges(n2, n3);
        g.addEdges(n2, n4);
        g.addEdges(n2, n5);
        
        g.addEdges(n3, n4);
        g.addEdges(n3, n5);

        g.addEdges(n4, n5);


        g.printGraph();
    }
}