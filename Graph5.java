import java.util.*;

public class Graph5 extends Graph {

    private Line h1 = new Line(619, 526, 628 ,522, 4, "WHITE");
    private Line h2 = new Line(619, 526, 627 ,534, 4, "WHITE");

    private Node n1 = new Node("0", 400, 170, "29FAC4");
    private Node n2 = new Node("1", 200, 200, "29FAC4");
    private Node n3 = new Node("2", 600, 200, "29FAC4");
    private Node n4 = new Node("3", 200, 500, "29FAC4");
    private Node n5 = new Node("4", 400, 470, "29FAC4");
    private Node n6 = new Node("5", 600, 500, "29FAC4");

    private static boolean exit_pressed = false;
    private static Rectangle exit = new Rectangle(100, 650, 100, 60, "#a97777");
    private static Rectangle black = new Rectangle(0, 0, 800, 800, "BLACK");
    private static Text exit_text = new Text("Back", 75, 655, 20, "#ccf4f1");

    private List<Node> l1 = this.initNodes(n1);
    private List<Node> l2 = this.initNodes(n2);
    private List<Node> l3 = this.initNodes(n3);
    private List<Node> l4 = this.initNodes(n4);
    private List<Node> l5 = this.initNodes(n5);
    private List<Node> l6 = this.initNodes(n6);

    public Graph5() {
    }

    public void showGraph5() {

        GameArena arena_graph5 = new GameArena(800, 800);
        arena_graph5.getFrame().setDefaultCloseOperation(arena_graph5.getFrame().DISPOSE_ON_CLOSE);


        this.addEdges(n1, n2, arena_graph5, true, "null", 85.0);
        this.addEdges(n1, n3, arena_graph5, true, "null", 85.0);
        this.addEdges(n2, n4, arena_graph5, true, "null", 91.0);
        this.addEdges(n3, n1, arena_graph5, true, "null", 85.0);
        this.addEdges(n3, n5, arena_graph5, true, "null", 91.0);
        this.addEdges(n5, n4, arena_graph5, true, "null", 85.0);
        this.addEdges(n5, n2, arena_graph5, true, "null", 91.0);
        this.addEdges(n5, n6, arena_graph5, true, "null", 85.0);
        this.addEdges(n6, n6, arena_graph5, true, "right", 100.0);

        this.addNodes(arena_graph5);

        arena_graph5.addRectangle(exit);
        arena_graph5.addText(exit_text);

        this.printGraph();
        arena_graph5.addLine(h1);
        arena_graph5.addLine(h2);
        arena_graph5.update();

        while (exit_pressed == false) {
            arena_graph5.update();

            if (arena_graph5.leftMousePressed() && arena_graph5.objectClicked(exit)) {
                arena_graph5.exit();
                this.closeGraph();
            }

        }
    }
}