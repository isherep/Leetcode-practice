package Graph;

import java.util.*;

public class CriticalRouters {
    class Graph {
        int v;
        /**
         * This set will be working as adjacency list.
         */
        HashSet<Integer>[] connections;

        /**
         * Create a data_structure.graph data structure
         */
        Graph(int v) {
            this.v = v;
            connections = new HashSet[v];
            for (int i = 0; i < v; i++) {
                connections[i] = new HashSet<>();
            }
        }

        void addConnection(int u, int v) {
            connections[u].add(v);
            connections[v].add(u);
        }

        void removeConnection(int u, int v) {
            connections[u].remove(v);
            connections[v].remove(u);
        }
    }


    public List<List<Integer>> criticalConnections(int n,
                                                   List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        Graph graph = new Graph(n);
        for (List<Integer> connection : connections) {
            graph.addConnection(connection.get(0), connection.get(1));
        }
        //System.out.println(graph.connections);
        for (List<Integer> connection : connections) {
            graph.removeConnection(connection.get(0), connection.get(1));
            int numberOfConnectedComponents = getConnectedComponents(graph, n);
            //System.out.println("Number of components: "+numberOfConnectedComponents);
            if (numberOfConnectedComponents > 1)
                result.add(connection);
            graph.addConnection(connection.get(0), connection.get(1));
        }
        return result;

    }

    private int getConnectedComponents(Graph graph, int n) {
        int numComponents = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                queue.add(i);
                numComponents++;
            }
            while (!queue.isEmpty()){
                Integer node=queue.poll();
                if(!visited[node]){
                    HashSet<Integer> sets = graph.connections[node];
                    Iterator it = sets.iterator();
                    while (it.hasNext()) {
                        int data= (int) it.next();
                        if(!visited[data])
                            queue.add(data);
                    }
                }
                visited[node]=true;
            }
        }
        return numComponents;
    }
}
