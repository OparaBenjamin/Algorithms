package algo;

import lib.In;

public class Graph {
    private final int V; // number of vertices
    private int E; // number of edges
    private Bag<Integer>[] adj; // adjacency lists

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V]; // Create array of lists.
        for (int v = 0; v < V; v++) // Initialize all lists
            adj[v] = new Bag<>(); // to empty.
    }

    public Graph(In in) {
        this(in.readInt()); // Read V and construct this graph.
        int E = in.readInt(); // Read E.
        for (int i = 0; i < E; i++) { // Add an edge.
            int v = in.readInt(); // Read a vertex,
            int w = in.readInt(); // read another vertex,
            addEdge(v, w); // and add edge connecting them.
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v’s list.
        adj[w].add(v); // Add v to w’s list.
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }


//    public class TestSearch
//    {
//        public static void main(String[] args)
//        {
//            Graph G = new Graph(new In(args[0]));
//            int s = Integer.parseInt(args[1]);
//            Search search = new Search(G, s);
//            for (int v = 0; v < G.V(); v++)
//                if (search.marked(v))
//                    StdOut.print(v + " ");
//            StdOut.println();
//            if (search.count() != G.V())
//                StdOut.print("NOT ");
//            StdOut.println("connected");
//        }
//    }
}