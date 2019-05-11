import java.util.*;

public class Graph5 extends Graph {

    private GameArena arena = new GameArena(800, 800, true);
    private Line h1 = new Line(619, 526, 628 ,522, 4, "WHITE");
    private Line h2 = new Line(619, 526, 627 ,534, 4, "WHITE");

    private Node n1 = new Node("0", 400, 170, "29FAC4");
    private Node n2 = new Node("1", 200, 200, "29FAC4");
    private Node n3 = new Node("2", 600, 200, "29FAC4");
    private Node n4 = new Node("3", 200, 500, "29FAC4");
    private Node n5 = new Node("4", 400, 470, "29FAC4");
    private Node n6 = new Node("5", 600, 500, "29FAC4");

    private Graph g = new Graph();

    private List<Node> l1 = g.initNodes(n1);
    private List<Node> l2 = g.initNodes(n2);
    private List<Node> l3 = g.initNodes(n3);
    private List<Node> l4 = g.initNodes(n4);
    private List<Node> l5 = g.initNodes(n5);
    private List<Node> l6 = g.initNodes(n6);

    public Graph5(GameArena arena) {
        
        g.addEdges(n1, n2, arena, true, "null", 85.0);
        g.addEdges(n1, n3, arena, true, "null", 85.0);
        g.addEdges(n2, n4, arena, true, "null", 90.0);
        g.addEdges(n3, n1, arena, true, "null", 85.0);
        g.addEdges(n3, n5, arena, true, "null", 90.0);
        g.addEdges(n5, n4, arena, true, "null", 85.0);
        g.addEdges(n5, n2, arena, true, "null", 90.0);
        g.addEdges(n5, n6, arena, true, "null", 85.0);
        g.addEdges(n6, n6, arena, true, "right", 100.0);

        g.addNodes(arena);

        g.printGraph();
        arena.addLine(h1);
        arena.addLine(h2);
        arena.update();
    }
}