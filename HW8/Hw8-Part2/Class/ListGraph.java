import java.util.*;

/**
 * An implementation of a graph that uses an array of lists to represent the edges
 * @author Jacob / Koffman & Wolfgang
 *
 */
public class ListGraph extends AbstractGraph {
    //Data Fields
    /**
     * An array of Lists to contain the edges that originate with each vertex
     */
    private List<List<Edge>> edges;

    /**
     * Construct a graph with the specified number of vertices and directionality
     * @param numV The number of vertices
     * @param directed The directionality flag
     */
    @SuppressWarnings("unchecked")
    public ListGraph(int numV, boolean directed) {
        super(numV, directed);
        edges = new LinkedList<>();
        for(int i = 0; i < numV; i++){
            edges.add(i,new LinkedList<Edge>());
        }
    }

    public boolean isEdge(int source, int dest){
        return edges.get(source).contains(new Edge(source, dest));
    }

    public void insert(Edge edge){
        edges.get(edge.getSource()).add(edge);
        if(!isDirected()){
            edges.get(edge.getDest()).add(new Edge(edge.getDest(),
                    edge.getSource(),
                    edge.getWeight()));
        }
    }

    public Iterator<Edge> edgeIterator(int source){
        return edges.get(source).iterator();
    }

    public Edge getEdge(int source, int dest){
        Edge target = new Edge(source, dest, Double.POSITIVE_INFINITY);
        for(Edge edge : edges.get(source)){
            if(edge.equals(target))
                return edge;
        }
        return target;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        int end = edges.size();
        for(int i=0; i < end; i++){
            sb.append("Node " + i + "-->\n");
            for(Edge e : edges.get(i)){
                sb.append("\tnode: " + e.getDest() + ", weight: " + e.getWeight() + "\n");
            }
        }
        return sb.toString();
    }

    @Override
    public void loadEdgesFromFile(Scanner scan){
        while(scan.hasNextLine())
        {
            Edge e = parseFileString(scan.nextLine());
            edges.get(e.getSource()).add(e);
        }
        scan.close();
    }

    private Edge parseFileString(String input)
    {
        Edge toReturn = null;
        Scanner sc = new Scanner(input);
        sc.useDelimiter(AbstractGraph.DELIM);
        try
        {
            int source = sc.nextInt();

            int dest = sc.nextInt();
            double weight = Edge.UNWEIGHTED_EDGE;
            if(sc.hasNextDouble())
                weight = sc.nextDouble();
            toReturn = new Edge(source, dest, weight);
        }
        catch(Exception e)
        {
            System.out.println("Failed to parse Edge: "+input);
        }
        sc.close();
        return toReturn;
    }

}
