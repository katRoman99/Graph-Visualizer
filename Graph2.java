import java.util.*;

public class Graph2 extends Graph {

    private Node n1 = new Node("E", 400, 100, "29FAC4");
    private Node n2 = new Node("F", 600, 200, "29FAC4");
    private Node n3 = new Node("G", 300, 400, "29FAC4");
    private Node n4 = new Node("H", 500, 400, "29FAC4");
    private Node n5 = new Node("I", 200, 200, "29FAC4");

    private Graph g = new Graph();
    private static boolean exit_pressed = false;
    private static Rectangle exit = new Rectangle(100, 650, 100, 60, "#a97777");
    private static Text exit_text = new Text("Back", 75, 655, 20, "#ccf4f1");

    private List<Node> l1 = g.initNodes(n1);
    private List<Node> l2 = g.initNodes(n2);
    private List<Node> l3 = g.initNodes(n3);
    private List<Node> l4 = g.initNodes(n4);
    private List<Node> l5 = g.initNodes(n5);

    public Graph2() {
    }

    public void showGraph2() {

        GameArena arena_graph2 = new GameArena(800, 800);
        arena_graph2.getFrame().setDefaultCloseOperation(arena_graph2.getFrame().DISPOSE_ON_CLOSE);

        g.addEdges(n1, n2, arena_graph2, false, "null", 2);
        g.addEdges(n1, n3, arena_graph2, false, "null", 2);
        g.addEdges(n1, n4, arena_graph2, false, "null", 2);
        g.addEdges(n1, n5, arena_graph2, false, "null", 2);

        g.addEdges(n2, n3, arena_graph2, false, "null", 2);
        g.addEdges(n2, n4, arena_graph2, false, "null", 2);
        g.addEdges(n2, n5, arena_graph2, false, "null", 2);
            
        g.addEdges(n3, n4, arena_graph2, false, "null", 2);
        g.addEdges(n3, n5, arena_graph2, false, "null", 2);

        g.addEdges(n4, n5, arena_graph2, false, "null", 2);

        g.printGraph();

        g.addNodes(arena_graph2);

        arena_graph2.addRectangle(exit);
        arena_graph2.addText(exit_text);

        arena_graph2.update();

        while (exit_pressed == false) {
            arena_graph2.update();

            if (arena_graph2.leftMousePressed() && arena_graph2.objectClicked(exit)) {
                arena_graph2.exit();
                this.closeGraph();
            }

        }
    }
}