package Company.Amazon;

import java.util.*;

public class CriticalConnections {
        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

            // for each connection in the list - remove it from the list
            // check if graph becomes disconected
            List<List<Integer>> res = new LinkedList<>();
            for(int i = 0; i< connections.size(); i++){
                // remove connection
                List<List<Integer>> list = connections;
                boolean[] visited = new boolean[n];
                List<Integer> curConnect = connections.get(i);
                list.remove(curConnect);
                if(!conected(list, n, visited)){
                    res.add(curConnect);
                }
                list.add(curConnect);

            }
            return res;
        }

        public boolean conected(List<List<Integer>> connections, int N, boolean[] visited){
            // boolean[] visited= new boolean[N];
            HashMap<Integer, List<Integer>> graph = new HashMap<>();
            for(int i = 0; i< connections.size(); i++){
                // System.out.print(connections.get(i) + ",");
                List<Integer> cur = connections.get(i);
                if(graph.containsKey(cur.get(0))){
                    // add the list of it's edges
                    graph.get(cur.get(0)).add(cur.get(1));
                } else {
                    // add the node and the
                    LinkedList<Integer> edges = new LinkedList<>();
                    edges.add(cur.get(1));
                    graph.put(cur.get(0), edges);
                }
            }
            //System.out.println("\nEdges");

            // perform DFS on graph
            for(Map.Entry<Integer, List<Integer>> e: graph.entrySet()){
                DFS(e.getKey(), visited, graph);
            }
            // count how many true you got in the boolean array
            // if it is < N - return false else return true;
            int count = 0;
            for(boolean vis: visited){
                if(vis) count++;
            }

            System.out.println("count " + count);

            if(count < N) return false;
            else return true;
        }
        // count how many true you got in the boolean array
        // if it is < N - return false else return true
        public static void DFS(int node, boolean[] visited, Map<Integer,List<Integer>> graph){
            if(visited[node]) return;
            if(!visited[node]) visited[node] = true;
            List<Integer> edges = graph.get(node);
            if(edges != null){
                for(int edge: edges){
                    System.out.print(edge + ", ");
                    DFS(edge, visited, graph);
                }
            }

        }

        public static void main(String[] args){

        }


        /*    Brute-Force form discussion */
        public List<List<Integer>> criticalConnections1(int n, List<List<Integer>> connections) {
            final List<List<Integer>> result = new ArrayList<>();
            final Map<Integer, Set<Integer>> adj = getAdjList(connections);
            boolean[] visited = new boolean[n];
        /* remove each edge once and run dfs to see if all nodes are still
        reachable, if yes try the same with other edges*/

            for(List<Integer> edge : connections) {
                final int from = edge.get(0);
                final int to = edge.get(1);

                /* remove the edge from our adj list */
                adj.get(from).remove(to);
                adj.get(to).remove(from);

                /* start dfs from vertex 0 */
                dfs(adj, visited, 0);

                /* check the visited array to see all vertices were visited or not */
                boolean isConnected = true;
                for(int i = 0; i < n; i++) {
                    if( ! visited[i]) {
                        isConnected = false;
                        break;
                    }
                }
                /* reset our visited array */
                visited = new boolean[n];

                /* if our dfs couldn't reach all nodes, the map is disconnected */
                if( ! isConnected) {
                    result.add(Arrays.asList(from, to));
                }

                /* add the removed edge back into the list */
                adj.get(from).add(to);
                adj.get(to).add(from);

            }
            return result;
        }

    private void dfs(final Map<Integer, Set<Integer>> adj, final boolean[] visited,
                     final int vertex) {

        visited[vertex] = true;

        /* traverse the adj list and perfrom dfs on all vertices */
        for(final Integer v : adj.get(vertex)) {
            if( ! visited[v]) {
                dfs(adj, visited, v);
            }
        }
    }

    private Map<Integer, Set<Integer>> getAdjList(List<List<Integer>> connections) {
        final Map<Integer, Set<Integer>> adj = new HashMap<>();
        for(int i = 0; i < connections.size(); i++) {

            int from = connections.get(i).get(0);
            int to = connections.get(i).get(1);

            /* create from -> to edge */
            if(adj.containsKey(from)) {
                adj.get(from).add(to);
            } else {
                final Set<Integer> set = new HashSet<>();
                set.add(to);
                adj.put(from, set);
            }

            /* create to -> from edge */
            if(adj.containsKey(to)) {
                adj.get(to).add(from);
            } else {
                final Set<Integer> set = new HashSet<>();
                set.add(from);
                adj.put(to, set);
            }
        }
        return adj;
    }
}
