import java.util.*;

public class Graph2 extends Graph {

    public static void main(String[] args) {

        GameArena arena = new GameArena(800, 800, true);

        Node n1 = new Node("E", 400, 100, "29FAC4");
        Node n2 = new Node("F", 600, 200, "29FAC4");
        Node n3 = new Node("G", 300, 400, "29FAC4");
        Node n4 = new Node("H", 500, 400, "29FAC4");
        Node n5 = new Node("I", 200, 200, "29FAC4");

        Graph g = new Graph2();

        List<Node> l1 = g.initNodes(n1);
        List<Node> l2 = g.initNodes(n2);
        List<Node> l3 = g.initNodes(n3);
        List<Node> l4 = g.initNodes(n4);
        List<Node> l5 = g.initNodes(n5);

        g.addEdges(n1, n2, arena);
        g.addEdges(n1, n3, arena);
        g.addEdges(n1, n4, arena);
        g.addEdges(n1, n5, arena);

        g.addEdges(n2, n3, arena);
        g.addEdges(n2, n4, arena);
        g.addEdges(n2, n5, arena);
        
        g.addEdges(n3, n4, arena);
        g.addEdges(n3, n5, arena);

        g.addEdges(n4, n5, arena);

        g.addNodes(arena);

        g.printGraph();
        arena.update();
    }
}