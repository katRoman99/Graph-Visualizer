import java.util.*; 
  
public class Graph  
{ 
    private static Map<Node, List<Node>> adjNodes = new HashMap<Node, List<Node>>();

    static class Node {
        Object label;

        public Node(Object label) {
            this.label = label;

        }
    }

    public List<Node> addNodes(Node source) {

        List<Node> list = new LinkedList<Node>();
        adjNodes.put(source, list);
        return list;
    }
    
    //Add a node and create an empty list for it to hold adjacent nodes in the future
    public void addEdges(Node source, Node mapped) 
    { 
        List<Node> l = adjNodes.get(source);
        l.add(mapped);

        List<Node> l2 = adjNodes.get(mapped);
        l2.add(source);
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