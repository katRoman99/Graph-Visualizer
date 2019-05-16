import java.util.*;

public class Graph4 extends Graph {

    private Line h1 = new Line(231, 426, 224, 422, 4, "WHITE");
    private Line h2 = new Line(231, 426, 223, 434, 4, "WHITE");
    private Line h3 = new Line(569, 426, 576, 422, 4, "WHITE");
    private Line h4 = new Line(569, 426, 575, 434, 4, "WHITE");

    private Node n1 = new Node("J", 400, 200, "29FAC4");
    private Node n2 = new Node("K", 250, 400, "29FAC4");
    private Node n3 = new Node("L", 400, 600, "29FAC4");
    private Node n4 = new Node("M", 550, 400, "29FAC4");

    private static boolean exit_pressed = false;
    private static Rectangle exit = new Rectangle(100, 650, 100, 60, "#a97777");
    private static Rectangle black = new Rectangle(0, 0, 800, 800, "BLACK");
    private static Text exit_text = new Text("Back", 75, 655, 20, "#ccf4f1");

    private List<Node> l1 = this.initNodes(n1);
    private List<Node> l2 = this.initNodes(n2);
    private List<Node> l3 = this.initNodes(n3);
    private List<Node> l4 = this.initNodes(n4);

    public Graph4() {
    }

    public void showGraph4() {

        GameArena arena_graph4 = new GameArena(800, 800);
        arena_graph4.getFrame().setDefaultCloseOperation(arena_graph4.getFrame().DISPOSE_ON_CLOSE);

        arena_graph4.addRectangle(black);

        this.addEdges(n1, n2, arena_graph4, true, "null", 87);
        this.addEdges(n2, n3, arena_graph4, true, "null", 87);
        this.addEdges(n2, n2, arena_graph4, true, "left", 100);
        this.addEdges(n4, n4, arena_graph4, true, "right", 100);
        this.addEdges(n3, n4, arena_graph4, true, "null", 87);
        this.addEdges(n4, n1, arena_graph4, true, "null", 87);
        this.addEdges(n1, n4, arena_graph4, true, "null", 87);

        this.addNodes(arena_graph4);

        arena_graph4.addRectangle(exit);
        arena_graph4.addText(exit_text);

        this.printGraph();
        arena_graph4.addLine(h1);
        arena_graph4.addLine(h2);
        arena_graph4.addLine(h3);
        arena_graph4.addLine(h4);
        arena_graph4.update();

        while (exit_pressed == false) {
            arena_graph4.update();

            if (arena_graph4.leftMousePressed() && arena_graph4.objectClicked(exit)) {
                arena_graph4.exit();
                this.closeGraph();
            }

        }
    }

}