import java.util.*;

public class Graph3 extends Graph {

    private Node n1 = new Node("J", 400, 100, "29FAC4");
    private Node n2 = new Node("K", 250, 275, "29FAC4");
    private Node n3 = new Node("L", 400, 450, "29FAC4");
    private Node n4 = new Node("M", 550, 275, "29FAC4");

    private static boolean exit_pressed = false;
    private static Rectangle exit = new Rectangle(100, 720, 100, 60, "#a97777");
    private static Text exit_text = new Text("Back", 75, 725, 20, "#ccf4f1");
    private static Rectangle graph_info = new Rectangle(670, 720, 150, 60, "#a97777");
    private static Text info_text = new Text("Graph Info", 615, 725, 20, "#ccf4f1");
    private static Text info = new Text("This is Graph3. \nThis graph is directed and has 4 nodes.", 100, 600, 20, "#ccf4f1");

    private List<Node> l1 = this.initNodes(n1);
    private List<Node> l2 = this.initNodes(n2);
    private List<Node> l3 = this.initNodes(n3);
    private List<Node> l4 = this.initNodes(n4);

    public Graph3() {
    }

    public void showGraph3() {

        GameArena arena_graph3 = new GameArena(800, 800);
        arena_graph3.getFrame().setDefaultCloseOperation(arena_graph3.getFrame().DISPOSE_ON_CLOSE);
        
        this.addEdges(n1, n2, arena_graph3, true, "null", 87);
        this.addEdges(n2, n3, arena_graph3, true, "null", 87);
        this.addEdges(n3, n4, arena_graph3, true, "null", 87);
        this.addEdges(n4, n1, arena_graph3, true, "null", 87);

        this.addNodes(arena_graph3);

        Text txt1 = new Text(this.getConnections(n1), 80, 600, 20, "#ccf4f1");
        Text txt2 = new Text(this.getConnections(n2), 80, 600, 20, "#ccf4f1");
        Text txt3 = new Text(this.getConnections(n3), 80, 600, 20, "#ccf4f1");
        Text txt4 = new Text(this.getConnections(n4), 80, 600, 20, "#ccf4f1");

        arena_graph3.addRectangle(exit);
        arena_graph3.addText(exit_text);
        arena_graph3.addRectangle(graph_info);
        arena_graph3.addText(info_text);

        this.printGraph();
        arena_graph3.update();

        while (exit_pressed == false) {
            arena_graph3.update();

            if (arena_graph3.leftMousePressed() && arena_graph3.objectClicked(exit)) {
                arena_graph3.exit();
                this.closeGraph();
            }
            else if (arena_graph3.leftMousePressed() && arena_graph3.objectClicked(graph_info)) {
                this.removeItems(arena_graph3, txt1, txt2, txt3, txt4, info);
                arena_graph3.addText(info);
            }
            else if (arena_graph3.leftMousePressed() && arena_graph3.objectClicked(n1)) {
                this.removeItems(arena_graph3, txt1, txt2, txt3, txt4, info);
                arena_graph3.addText(txt1);
            }

            else if (arena_graph3.leftMousePressed() && arena_graph3.objectClicked(n2)) {
                this.removeItems(arena_graph3, txt1, txt2, txt3, txt4, info);
                arena_graph3.addText(txt2);
            }

            else if (arena_graph3.leftMousePressed() && arena_graph3.objectClicked(n3)) {
                this.removeItems(arena_graph3, txt1, txt2, txt3, txt4, info);
                arena_graph3.addText(txt3);
            }

            else if (arena_graph3.leftMousePressed() && arena_graph3.objectClicked(n4)) {
                this.removeItems(arena_graph3, txt1, txt2, txt3, txt4, info);
                arena_graph3.addText(txt4);
            }
        }
    }

    public void removeItems(GameArena arena, Text t1, Text t2, Text t3, Text t4, Text i) {

        arena.removeText(t1);
        arena.removeText(t2);
        arena.removeText(t3);
        arena.removeText(t4);
        arena.removeText(i);
    }
}