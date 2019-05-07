import java.util.*; 
  
public class Graph  
{ 
    static Map<Node, List<Node>> adjNodes = new HashMap<Node, List<Node>>();

    static class Node {
        String label;
        Ball ball;
        Text text;
        String colour;

        public Node(String label, int x, int y, String colour) {
            this.label = label;
            this.ball = new Ball(x, y, 30, colour);
            this.text = new Text(label, x-5, y+5, 20, "BLACK");


        }
    }

    public List<Node> initNodes(Node source) {

        List<Node> list = new LinkedList<Node>();
        adjNodes.put(source, list);
        return list;
    }
    
    //Add a node and create an empty list for it to hold adjacent nodes in the future
    public void addEdges(Node source, Node mapped, GameArena arena) 
    { 
        List<Node> l = adjNodes.get(source);
        l.add(mapped);

        List<Node> l2 = adjNodes.get(mapped);
        l2.add(source);

        Line line = new Line(source.ball.getXPosition(), source.ball.getYPosition(), mapped.ball.getXPosition(), mapped.ball.getYPosition(), 5, "WHITE");
        arena.addLine(line);
    }

    public void addNodes(GameArena arena) {

        for (Node n: adjNodes.keySet()) {

            arena.addBall(n.ball);
            arena.addText(n.text);
        }
    }

    public void printGraph() {

            for (Node n : adjNodes.keySet()) {
                System.out.print("<" + n.label + ">");
                for (Node k : adjNodes.get(n)) 
                    System.out.print(" ===> " + k.label);
                System.out.println("\n");
            }
    }
}