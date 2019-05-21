import java.util.*;

/**
 * This class builds a simple Graph containing 5 Nodes, creates a seperate GameArena 
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

public class Graph2 extends Graph {

    //Parameters storing such information as a colour of Nodes and data that each of them will store
    private String node_col;
    private String font_col;
    private String n1_data;
    private String n2_data;
    private String n3_data;
    private String n4_data;
    private String n5_data;

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
    private Node n5;

    //Text containing a vague descrption of this graph
    private Text general_info;

    //Initializing empty lists to store adjacent nodes
    private List<Node> l1;
    private List<Node> l2;
    private List<Node> l3;
    private List<Node> l4;
    private List<Node> l5;

    //All the edges of particular Nodes in a Text form
    private Text n1_edges;
    private Text n2_edges;
    private Text n3_edges;
    private Text n4_edges;
    private Text n5_edges;


    /**
     * Constructor. Creates an instance of this Graph2 class which consists of 5 Nodes.
     * 
     * @param node_col Colour of the Nodes
     * @param font_col Colour of the font in which the information will be displayed
     * @param n1_data Data that Node1 will store
     * @param n2_data Data that Node2 will store
     * @param n3_data Data that Node3 will store
     * @param n4_data Data that Node4 will store
     * @param n5_data Data that Node5 will store
     */
    public Graph2(String node_col, String font_col, String n1_data, String n2_data, String n3_data, String n4_data, String n5_data) {
        this.node_col = node_col;
        this.font_col = font_col;
        this.n1_data = n1_data;
        this.n2_data = n2_data;
        this.n3_data = n3_data;
        this.n4_data = n4_data;
        this.n5_data = n5_data;
    }

    /**
     * Method creating a GameArena specifically for this Graph2 class.
     * Creates both a visual and internal representation of a Graph
     * by adding edges to vertices and populating the adjacency list.
     */
    public void showGraph2() {

        GameArena arena_graph2 = new GameArena(800, 800);
        arena_graph2.getFrame().setDefaultCloseOperation(arena_graph2.getFrame().DISPOSE_ON_CLOSE);

        //Populating Nodes with necessary data such as String, coordinates and colour
        n1 = new Node(n1_data, 400, 100, node_col);
        n2 = new Node(n2_data, 600, 200, node_col);
        n3 = new Node(n3_data, 300, 400, node_col);
        n4 = new Node(n4_data, 500, 400, node_col);
        n5 = new Node(n5_data, 200, 200, node_col);

        l1 = this.initNodes(n1);
        l2 = this.initNodes(n2);
        l3 = this.initNodes(n3);
        l4 = this.initNodes(n4);
        l5 = this.initNodes(n5);

        this.addEdges(n1, n2, arena_graph2, false, "null", 2);
        this.addEdges(n1, n3, arena_graph2, false, "null", 2);
        this.addEdges(n1, n4, arena_graph2, false, "null", 2);
        this.addEdges(n1, n5, arena_graph2, false, "null", 2);

        this.addEdges(n2, n3, arena_graph2, false, "null", 2);
        this.addEdges(n2, n4, arena_graph2, false, "null", 2);
        this.addEdges(n2, n5, arena_graph2, false, "null", 2);
            
        this.addEdges(n3, n4, arena_graph2, false, "null", 2);
        this.addEdges(n3, n5, arena_graph2, false, "null", 2);

        this.addEdges(n4, n5, arena_graph2, false, "null", 2);

        this.printGraph();

        this.addNodes(arena_graph2);

        //Populating the adjacency list
        n1_edges = new Text(this.getConnections(n1), 80, 600, 20, font_col);
        n2_edges = new Text(this.getConnections(n2), 80, 600, 20, font_col);
        n3_edges = new Text(this.getConnections(n3), 80, 600, 20, font_col);
        n4_edges = new Text(this.getConnections(n4), 80, 600, 20, font_col);
        n5_edges = new Text(this.getConnections(n5), 80, 600, 20, font_col);

        general_info = new Text("This is Graph2. \nThis graph is undirected and has 5 nodes.", 100, 600, 20, font_col);

        // Adding basic options "buttons" such as information and back button 
        this.addOptions(arena_graph2, exit, exit_text, graph_info, info_text);

        arena_graph2.update();

        //Checking whether any Node or button has been clicked and invoking an appropriate action upon this event.
        while (true) {

            arena_graph2.update();

            if (arena_graph2.leftMousePressed() && arena_graph2.objectClicked(exit)) {
                arena_graph2.exit();
                this.closeGraph();
            }
            else if (arena_graph2.leftMousePressed() && arena_graph2.objectClicked(graph_info)) {
                this.removeItems(arena_graph2, n1_edges, n2_edges, n3_edges, n4_edges, n5_edges, general_info);
                arena_graph2.addText(general_info);
            }

            else if (arena_graph2.leftMousePressed() && arena_graph2.objectClicked(n1)) {
                this.removeItems(arena_graph2, n1_edges, n2_edges, n3_edges, n4_edges, n5_edges, general_info);
                arena_graph2.addText(n1_edges);
            }

            else if (arena_graph2.leftMousePressed() && arena_graph2.objectClicked(n2)) {
                this.removeItems(arena_graph2, n1_edges, n2_edges, n3_edges, n4_edges, n5_edges, general_info);
                arena_graph2.addText(n2_edges);
            }

            else if (arena_graph2.leftMousePressed() && arena_graph2.objectClicked(n3)) {
                this.removeItems(arena_graph2, n1_edges, n2_edges, n3_edges, n4_edges, n5_edges, general_info);
                arena_graph2.addText(n3_edges);
            }

            else if (arena_graph2.leftMousePressed() && arena_graph2.objectClicked(n4)) {
                this.removeItems(arena_graph2, n1_edges, n2_edges, n3_edges, n4_edges, n5_edges, general_info);
                arena_graph2.addText(n4_edges);
            }

            else if (arena_graph2.leftMousePressed() && arena_graph2.objectClicked(n5)) {
                this.removeItems(arena_graph2, n1_edges, n2_edges, n3_edges, n4_edges, n5_edges, general_info);
                arena_graph2.addText(n5_edges);
            }
        }
    }

    /**
     * A method that removes all the Text information displayed on the screen when necessary.
     * 
     * @param arena Arena on which the information is displayed
     * @param n1_edges Text representation of the adjacency list for Node1
     * @param n2_edges Text representation of the adjacency list for Node2
     * @param n3_edges Text representation of the adjacency list for Node3
     * @param n4_edges Text representation of the adjacency list for Node4
     * @param n5_edges Text representation of the adjacency list for Node5
     * @param general_info Text representation of the descrption of the graph
     */
    public void removeItems(GameArena arena, Text n1_edges, Text n2_edges, Text n3_edges, Text n4_edges, Text n5_edges, Text general_info) {

        arena.removeText(n1_edges);
        arena.removeText(n2_edges);
        arena.removeText(n3_edges);
        arena.removeText(n4_edges);
        arena.removeText(n5_edges);
        arena.removeText(general_info);
    }
}