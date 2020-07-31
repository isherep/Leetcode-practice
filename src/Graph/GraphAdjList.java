package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ADJACENCY LIST REPRESENTATION OF A DIRECTED GRAPH
 */
public class GraphAdjList {
    private int V; // number of vertices
    private LinkedList<Integer>[] adj;

    public GraphAdjList(int V) {
        this.V = V;
        // initialize adjacancy array of linked lists
        adj = new LinkedList[V];
        // initialize each linked list in the adj array
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // add edge
    public void addEdge(int v, int w) {
        // find v and add to its linked list
        adj[v].add(w); // only to v in digraph
    }

    public boolean hasPath(int v, int w) {
        // start BFS at v
        Queue<Integer> q = new LinkedList<>();
        boolean[] seen = new boolean[V];
        q.add(v);
        // put v into q, and mark its as visited
        // while q is not empty
        seen[v] = true;
        while (!q.isEmpty()) {
            // poll q,
            // if polled is w - return true
            int cur = q.poll();
            if (cur == w) {
                return true;
            }
            // iterate over each node in adjacency items
            for (int i = 0; i < adj[cur].size(); i++) {
                int n = adj[cur].get(i);
                //System.out.println(n);
                if (!seen[n]) {
                    seen[n] = true;
                    q.offer(n);
                }
            }

        }

        return false;
    }

    public List<Integer> getPath(int v, int w) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] seen = new boolean[V];
        LinkedList<Integer> path = new LinkedList<>();
        //System.out.println(this.hasPath(v,w));
        if (this.hasPath(v, w)) {
            while (!q.isEmpty()) {
                int cur = q.poll();
                if (cur == w) {
                    path.add(w);
                    return path;
                }
                path.add(cur);
                for (int i = 0; i < adj[cur].size(); i++) {
                    int n = adj[cur].get(i);
                    if (!seen[n]) {
                        seen[n] = true;
                        q.add(n);
                    }
                }
            }
            seen[v] = true;
            q.add(v);
            return path;
        } else {
            return path;
        }
    }

    public static void main(String[] args) {
        GraphAdjList diGraph = new GraphAdjList(4);
        // https://www.geeksforgeeks.org/find-if-there-is-a-path-between-two-vertices-in-a-given-graph/
        diGraph.addEdge(0, 2);
        diGraph.addEdge(2, 0);
        diGraph.addEdge(2, 3);
        diGraph.addEdge(3, 3);
        diGraph.addEdge(1, 2);
        diGraph.addEdge(0, 1);

        assert diGraph.hasPath(2, 3);//  == false : " Underweight";
        assert diGraph.hasPath(3, 3);
        assert diGraph.hasPath(0, 1);
        assert diGraph.hasPath(0, 2);
        assert diGraph.hasPath(2, 0);
        //assert diGraph.hasPath(3,2);
        // should be false
        //System.out.println(diGraph.hasPath(2,1));
        // assert diGraph.hasPath(3,1);
        //System.Diagnostics.Debug.Assert(myStubModel.isValidModelNumber(mNum) == true);
        System.out.print(diGraph.getPath(1, 0));
        System.out.print(diGraph.getPath(3, 1));
        System.out.print(diGraph.getPath(1, 3));


    }
}
