package Graph;

import java.util.*;

import static Graph.CriticalConnections.readFile;

public class Connections {
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        Map<Integer,Set<Integer>> graph = constructGraph(connections);

        //boolean isConnected = isGraphConnected(n,graph);
        //assert (isConnected=true);
        List<List<Integer>> result = new ArrayList<>();
        boolean isConnected = true;

        //loop through input connections

        for(List<Integer> connection: connections) {
            //remove this connection from graph

            int from = connection.get(0);
            int to = connection.get(1);

            //remove the edge and reverse edge from graph -- start

            if(graph.containsKey(from)) {
                Set<Integer> fromNeighbors = graph.get(from);
                fromNeighbors.remove(to);
            }

            if(graph.containsKey(to)) {
                Set<Integer> fromNeighbors = graph.get(to);
                fromNeighbors.remove(from);
            }

            //remove the edge and reverse edge from graph -- end

            //check if the graph is connected still

            isConnected = isGraphConnected(n,graph);

            //if not, mark the connection as critical

            if(!isConnected) {
                result.add(connection);
            }

            //add the edge and reverse edge back to graph -- start
            if(graph.containsKey(from)) {
                Set<Integer> fromNeighbors = graph.get(from);
                fromNeighbors.add(to);
            }

            if(graph.containsKey(to)) {
                Set<Integer> fromNeighbors = graph.get(to);
                fromNeighbors.add(from);
            }

            //add the edge and reverse edge back to graph -- end


        }

        return result;

    }

    private static Map<Integer,Set<Integer>> constructGraph(List<List<Integer>> connections) {
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        for(List<Integer> connection: connections) {
            int from = connection.get(0);
            int to = connection.get(1);

            if(!graph.containsKey(from)) {
                graph.put(from,new HashSet<>());
            }

            if(!graph.containsKey(to)) {
                graph.put(to,new HashSet<>());
            }

            Set<Integer> fromNeighbors = graph.get(from);
            fromNeighbors.add(to);
            Set<Integer> toNeighbors = graph.get(to);
            toNeighbors.add(from);
            graph.put(from,fromNeighbors);
            graph.put(to,toNeighbors);
        }
        return graph;
    }


    private static boolean isGraphConnected(int n, Map<Integer,Set<Integer>> graph) {

        boolean[] marked = new boolean[n];
        dfs(0,graph,marked);
        for(int i=0; i < n; i++) {
            if(!marked[i]) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(int src, Map<Integer, Set<Integer>> graph, boolean[] marked) {
        marked[src] = true;
        Set<Integer> neighbors = graph.get(src);
        if(neighbors != null) {
            for(Integer neighbor: neighbors) {
                if(!marked[neighbor]) {
                    dfs(neighbor,graph,marked);
                }
            }
        }

    }

    public static void main(String[] args){


        List<List<Integer>> largeGraph = readFile();

        List<List<Integer>> resLarge = criticalConnections(1001, largeGraph);

        System.out.println(resLarge);

    }
}
