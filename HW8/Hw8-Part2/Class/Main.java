public class Main {
    public static void main(String[] args) {

        try {
            Graph g = AbstractGraph.createGraph(false, "List");
            int n = g.getNumV();
            System.out.println(g.toString());
            System.out.println("***DepthFirstSearch***");
            DepthFirstSearch dfs = new DepthFirstSearch(g);
            int[] dOrder = dfs.getDiscoveryOrder();
            int[] fOrder = dfs.getFinishOrder();
            System.out.println("Discovery and finish order:");
            for(int i = 0; i < n; i++){
                System.out.println(dOrder[i] + " " + fOrder[i]);
            }
            System.out.println("***BreadthFirstSearch****");
            int[] parents = BreadthFirstSearch.breadthFirstSearch(g, 0);
            System.out.println("Node and Parent in tree:");
            for(int i = 0; i < parents.length; i++){
                System.out.println(i + " " + parents[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}