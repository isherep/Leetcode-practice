package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CriticalConnections {

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        // for each connection in the list - remove it from the list
        // check if graph becomes disconected
        List<List<Integer>> res = new LinkedList<>();

        // for(int i = 0; i< connections.size(); i++){
        //     // remove connection
        //     List<List<Integer>> list = connections;
        //     //boolean[] visited = new boolean[n];
        //     List<Integer> curConnect = connections.get(i);
        //     // instead of removing cur connection[2, 0] -
        //      // remove 2 from 1 and 0 from 1
        //     list.remove(curConnect);
        //     // if(!conected(list, n)){
        //     //     res.add(curConnect);
        //     // }
        //     boolean test = conected(list, n);
        //     // put back the node
        //     list.add(curConnect);
        // }
        boolean test = conected(connections, n);
        return res;
    }

    public boolean conected(List<List<Integer>> connections, int N) {
        // build graph
        boolean[] visited = new boolean[N];
        // build graph
        HashMap<Integer, List<Integer>> graph = buildGraph(N, connections);
        // perform DFS on graph
        // for(Map.Entry<Integer,List<Integer>> e: graph.entrySet()){
        //     DFS(e.getKey(), graph, visited);
        // }
        // count how many true you got in the boolean array
        // if it is < N - return false else return true;
        int count = 0;
        for (boolean vis : visited) {
            //System.out.print(vis + ", ");
            if (vis) count++;
        }

        //System.out.println("count " + count);

        if (count < N - 1) return false;
        else return true;
    }

    public HashMap<Integer, List<Integer>> buildGraph(int n, List<List<Integer>> connections) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < connections.size(); i++) {
            // System.out.print(connections.get(i) + ",");
            List<Integer> cur = connections.get(i);
            // if graph contains from element - add edges to a list
            if (graph.containsKey(cur.get(0))) {
                // add the list of it's edges
                graph.get(cur.get(0)).add(cur.get(1));
            } else {
                // add the node and the
                LinkedList<Integer> edges = new LinkedList<>();
                edges.add(cur.get(1));
                graph.put(cur.get(0), edges);
            }

            // create a from --> to endge list
            /* create to -> from edge */
            if (graph.containsKey(cur.get(1))) {
                graph.get(cur.get(1)).add(cur.get(0));
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(cur.get(0));
                graph.put(cur.get(1), list);
            }
        }

        printGraph(graph);
        return graph;
    }

    public void printGraph(HashMap<Integer, List<Integer>> graph) {
        // PRINT THE HASHMAP GRAPH
        for (Map.Entry<Integer, List<Integer>> e : graph.entrySet()) {
            System.out.print("key: " + e.getKey() + ": ");
            List edges = e.getValue();
            System.out.print(" edges: ");
            for (int i = 0; i < edges.size(); i++) {

                System.out.print(edges.get(i) + ", ");
            }
            System.out.println();
        }
    }

    // count how many true you got in the boolean array
    // if it is < N - return false else return true
    public static void DFS(int node, Map<Integer, List<Integer>> graph, boolean[] visited) {
        //boolean[] visited= new boolean[4];
        // if node was visited - return
        // if(visited[node] = true){
        //     return;
        // }
        // if node is not visited - visit it and it's edges
        if (!visited[node]) {
            visited[node] = true;
            List<Integer> edges = graph.get(node);
            //System.out.println("edges "+edges);
            if (edges != null) {
                for (int edge : edges) {
                    System.out.print(edge + ", ");
                    visited[edge] = true;
                    DFS(edge, graph, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("test");
        int[][] connections = {{0,1},{1,2},{2,0},{1,3}};
        

    }

}
