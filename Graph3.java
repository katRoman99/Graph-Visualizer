import java.util.*;

public class Graph3 extends Graph {

    private Node n1 = new Node("J", 400, 200, "29FAC4");
    private Node n2 = new Node("K", 250, 400, "29FAC4");
    private Node n3 = new Node("L", 400, 600, "29FAC4");
    private Node n4 = new Node("M", 550, 400, "29FAC4");

    private Graph g = new Graph();
    private static boolean exit_pressed = false;
    private static Rectangle exit = new Rectangle(100, 650, 100, 60, "#a97777");
    private static Text exit_text = new Text("Back", 75, 655, 20, "#ccf4f1");

    private List<Node> l1 = g.initNodes(n1);
    private List<Node> l2 = g.initNodes(n2);
    private List<Node> l3 = g.initNodes(n3);
    private List<Node> l4 = g.initNodes(n4);

    public Graph3() {
    }

    public void showGraph3() {

        GameArena arena_graph3 = new GameArena(800, 800);
        arena_graph3.getFrame().setDefaultCloseOperation(arena_graph3.getFrame().DISPOSE_ON_CLOSE);
        
        g.addEdges(n1, n2, arena_graph3, true, "null", 87);
        g.addEdges(n2, n3, arena_graph3, true, "null", 87);
        g.addEdges(n3, n4, arena_graph3, true, "null", 87);
        g.addEdges(n4, n1, arena_graph3, true, "null", 87);

        g.addNodes(arena_graph3);

        arena_graph3.addRectangle(exit);
        arena_graph3.addText(exit_text);

        g.printGraph();
        arena_graph3.update();

        while (exit_pressed == false) {
            arena_graph3.update();

            if (arena_graph3.leftMousePressed() && arena_graph3.objectClicked(exit)) {
                arena_graph3.exit();
                this.closeGraph();
            }

        }
    }
}