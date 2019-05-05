import java.util.*;

public class Graph1 extends Graph {

    public static void main(String[] args) {

        Node n1 = new Node("A");
        Node n2 = new Node("B");
        Node n3 = new Node("C");
        Node n4 = new Node("D");

        Graph g = new Graph();
        
        List<Node> l1 = g.addNodes(n1);
        List<Node> l2 = g.addNodes(n2);
        List<Node> l3 = g.addNodes(n3);
        List<Node> l4 = g.addNodes(n4);

        g.addEdges(n1, n2);
        g.addEdges(n1, n3);
        g.addEdges(n2, n4);
        g.addEdges(n3, n4);

        g.printGraph();
    }
}