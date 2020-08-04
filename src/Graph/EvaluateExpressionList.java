package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluateExpressionList {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        String first = equations.get(0).get(0);
        double[] res = new double[queries.size()];
        HashMap<String, HashMap<String, Double>> graph = getGraph(equations, values);

        for (int i = 0; i < res.length; i++) {
            String v = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            // System.out.println("v " + v + ", dest " + dest);
            // System.out.println(DFS(v, dest, graph, 1, new HashSet<String>()));
            res[i] = DFS(v, dest, graph, new HashSet<String>());
        }
        return res;
    }


    public double DFS(String vertex, String dest, HashMap<String, HashMap<String, Double>> graph, HashSet<String> seen) {
        //System.out.println("DFS " +  vertex + ", "+ dest);
        // Stack<Str
        // if graph doesn't have vertex or destination
        if (seen.contains(vertex)) return -1;
        if (!graph.containsKey(vertex) || !graph.containsKey(dest)) {
            return -1;
        }

        if (graph.get(vertex).containsKey(dest)) return graph.get(vertex).get(dest);

        seen.add(vertex);

        HashMap<String, Double> map = graph.get(vertex);
        // returns "c"= 2.0, "b"=1.0
        for (Map.Entry<String, Double> e1 : map.entrySet()) {
            String adjNode = e1.getKey();
            double val = e1.getValue();
            double res = DFS(adjNode, dest, graph, seen);
            if (res != -1) {
                return val * res;
            }
        }
        return -1;
    }

    public HashMap<String, HashMap<String, Double>> getGraph(List<List<String>> equations, double[] values) {
        HashMap<String, HashMap<String, Double>> map = new HashMap();
        // put each value in the equasians and empty hashmap
        for (int i = 0; i < equations.size(); i++) {
            map.put(equations.get(i).get(0), new HashMap<>());
            map.put(equations.get(i).get(1), new HashMap<>());
        }
        for (int i = 0; i < equations.size(); i++) {
            // add values to each key , another vertex=value
            map.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
            map.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1 / values[i]);
        }
        return map;
    }
}
