import java.util.*;

public class Graph1 extends Graph {
    
    private Graph g = new Graph();

    private Node n1 = new Node("A", 200, 200, "29FAC4");
    private Node n2 = new Node("B", 350, 200, "29FAC4");
    private Node n3 = new Node("C", 200, 400, "29FAC4");
    private Node n4 = new Node("D", 350, 400, "29FAC4");

    private List<Node> l1 = g.initNodes(n1);
    private List<Node> l2 = g.initNodes(n2);
    private List<Node> l3 = g.initNodes(n3);
    private List<Node> l4 = g.initNodes(n4);

    public Graph1(GameArena arena) {
            
        g.addEdges(n1, n2, arena, false, "null", 2);
        g.addEdges(n1, n3, arena, false, "null", 2);
        g.addEdges(n2, n4, arena, false, "null", 2);
        g.addEdges(n3, n4, arena, false, "null", 2);

        g.printGraph();

        g.addNodes(arena);
        arena.update();
    }
}