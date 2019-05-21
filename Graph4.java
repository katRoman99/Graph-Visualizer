import java.util.*;

/**
 * This class builds a simple directed Graph containing 4 Nodes, creates a seperate GameArena 
 * and displays it on that Arena.
 * 
 * Not suited for building graphs dynamically (yet:) .
 *
 * Based on a Graph class.
 * Instances of the Node class are used here to form the graph.
 * Instances of a ball class act as a visual representation of a Node.
 * This class also makes a use of a GameArena class in which the graph is to be drawn.
 *
 * @see Graph
 * @see Node
 * @see GameArena
 * @see Ball
 *
 */

public class Graph4 extends Graph {

    //Parameters storing such information as a colour of Nodes and data that each of them will store
    private String node_col;
    private String font_col;
    private String n1_data;
    private String n2_data;
    private String n3_data;
    private String n4_data;

    //Lines which act as arrows on self-arcs
    private Line h1 = new Line(231, 426, 224, 422, 4, "WHITE");
    private Line h2 = new Line(231, 426, 223, 434, 4, "WHITE");
    private Line h3 = new Line(569, 426, 576, 422, 4, "WHITE");
    private Line h4 = new Line(569, 426, 575, 434, 4, "WHITE");

    //Rectangles for normal options such as info and back button
    private Rectangle exit = new Rectangle(100, 720, 100, 60, "#a97777");
    private Text exit_text = new Text("Back", 75, 725, 20, "ccf4f1");
    private Rectangle graph_info = new Rectangle(670, 720, 150, 60, "#a97777");
    private Text info_text = new Text("Graph Info", 615, 725, 20, "ccf4f1");

    //Nodes that are used to form this graph
    private Node n1;
    private Node n2;
    private Node n3;
    private Node n4;

    //All the edges of particular Nodes in a Text form
    private Text n1_edges;
    private Text n2_edges;
    private Text n3_edges;
    private Text n4_edges;

    //Text containing a vague descrption of this graph
    private Text general_info;

    //Initializing empty lists to store adjacent nodes
    private List<Node> l1;
    private List<Node> l2;
    private List<Node> l3;
    private List<Node> l4;

     /**
     * Constructor. Creates an instance of this Graph4 class which consists of 4 Nodes and is directed.
     * 
     * @param node_col Colour of the Nodes
     * @param font_col Colour of the font in which the information will be displayed
     * @param n1_data Data that Node1 will store
     * @param n2_data Data that Node2 will store
     * @param n3_data Data that Node3 will store
     * @param n4_data Data that Node4 will store
     */

    public Graph4(String node_col, String font_col, String n1_data, String n2_data, String n3_data, String n4_data) {
        this.node_col = node_col;
        this.font_col = font_col;
        this.n1_data = n1_data;
        this.n2_data = n2_data;
        this.n3_data = n3_data;
        this.n4_data = n4_data;
    }

    /**
     * Method creating a GameArena specifically for this Graph4 class.
     * Creates both a visual and internal representation of a Graph
     * by adding edges to vertices and populating the adjacency list.
     */
    public void showGraph4() {

        GameArena arena_graph4 = new GameArena(800, 800);
        arena_graph4.getFrame().setDefaultCloseOperation(arena_graph4.getFrame().DISPOSE_ON_CLOSE);

        //Populating Nodes with necessary data such as String, coordinates and colour
        n1 = new Node(n1_data, 400, 200, node_col);
        n2 = new Node(n2_data, 250, 400, node_col);
        n3 = new Node(n3_data, 400, 600, node_col);
        n4 = new Node(n4_data, 550, 400, node_col);

        l1 = this.initNodes(n1);
        l2 = this.initNodes(n2);
        l3 = this.initNodes(n3);
        l4 = this.initNodes(n4);

        this.addEdges(n1, n2, arena_graph4, true, "null", 87);
        this.addEdges(n2, n3, arena_graph4, true, "null", 87);
        this.addEdges(n2, n2, arena_graph4, true, "left", 100);
        this.addEdges(n4, n4, arena_graph4, true, "right", 100);
        this.addEdges(n3, n4, arena_graph4, true, "null", 87);
        this.addEdges(n4, n1, arena_graph4, true, "null", 87);
        this.addEdges(n1, n4, arena_graph4, true, "null", 87);

        //Populating the adjacency list
        n1_edges = new Text(this.getConnections(n1), 80, 100, 20, font_col);
        n2_edges = new Text(this.getConnections(n2), 80, 100, 20, font_col);
        n3_edges = new Text(this.getConnections(n3), 80, 100, 20, font_col);
        n4_edges = new Text(this.getConnections(n4), 80, 100, 20, font_col);

        general_info = new Text("This is Graph4. \nThis graph is directed and has 4 nodes.", 100, 100, 20, font_col);

        this.addNodes(arena_graph4);

        // Adding basic options "buttons" such as information and back button 
        this.addOptions(arena_graph4, exit, exit_text, graph_info, info_text);

        this.printGraph();

        //Adding Arrows(Lines) for vertices with self-arcs
        arena_graph4.addLine(h1);
        arena_graph4.addLine(h2);
        arena_graph4.addLine(h3);
        arena_graph4.addLine(h4);
        arena_graph4.update();

        //Checking whether any Node or button has been clicked and invoking an appropriate action upon this event.
        while (true) {
            arena_graph4.update();

            if (arena_graph4.leftMousePressed() && arena_graph4.objectClicked(exit)) {
                arena_graph4.exit();
                this.closeGraph();
            }
            else if (arena_graph4.leftMousePressed() && arena_graph4.objectClicked(graph_info)) {
                this.removeItems134(arena_graph4, n1_edges, n2_edges, n3_edges, n4_edges, general_info);
                arena_graph4.addText(general_info);
            }
            else if (arena_graph4.leftMousePressed() && arena_graph4.objectClicked(n1)) {
                this.removeItems134(arena_graph4, n1_edges, n2_edges, n3_edges, n4_edges, general_info);
                arena_graph4.addText(n1_edges);
            }

            else if (arena_graph4.leftMousePressed() && arena_graph4.objectClicked(n2)) {
                this.removeItems134(arena_graph4, n1_edges, n2_edges, n3_edges, n4_edges, general_info);
                arena_graph4.addText(n2_edges);
            }

            else if (arena_graph4.leftMousePressed() && arena_graph4.objectClicked(n3)) {
                this.removeItems134(arena_graph4, n1_edges, n2_edges, n3_edges, n4_edges, general_info);
                arena_graph4.addText(n3_edges);
            }

            else if (arena_graph4.leftMousePressed() && arena_graph4.objectClicked(n4)) {
                this.removeItems134(arena_graph4, n1_edges, n2_edges, n3_edges, n4_edges, general_info);
                arena_graph4.addText(n4_edges);
            }
        }
    }
}