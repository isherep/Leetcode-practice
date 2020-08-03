package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluateExpressionList {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        HashMap<String, HashMap<String, Double>> graph = getGraph(equations, values);

        for(int i = 0; i< res.length; i++){
            String v = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            // System.out.println("v " + v + ", dest " + dest);
            // System.out.println(DFS(v, dest, graph, 1, new HashSet<String>()));
            res[i] = DFS(v, dest, graph, 1, new HashSet<String>());
        }
        return res;
    }

    public HashMap<String, HashMap<String, Double>> getGraph(List<List<String>> equations, double[] values){
        HashMap<String, HashMap<String, Double>> map = new HashMap();
        // put each value in the equasians and empty hashmap
        for(int i = 0; i< equations.size(); i++){
            map.put(equations.get(i).get(0), new HashMap<>());
            map.put(equations.get(i).get(1), new HashMap<>());
        }
        for(int i = 0; i< equations.size(); i++){
            // add values to each key , another vertex=value
            map.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
            map.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1/values[i]);
        }
        return map;
    }
    // returns the sum
    public double DFS(String vertex, String dest, HashMap<String, HashMap<String, Double>> graph, double res, HashSet<String> seen){
        System.out.println("DFS " +  vertex + ", "+ dest);
        if(vertex.equals(dest)) return 1;
        // if hit dead end
        if(vertex == null) return res;
        //HashSet<String> seen = new HashSet<>();
        // marked[V] = true
        seen.add(vertex);
        HashMap<String, Double> adj = graph.get(vertex);
        // returns hashmap of neighboor elements and their distances
        // for(Map.Entry<String,HashMap<String, Double>> e: graph.entrySet()){
        // String v = e.getKey();
        // iterate over its map
        HashMap<String, Double> map = graph.get(vertex);
        // returns "c"= 2.0, "b"=1.0
        for(Map.Entry<String,Double> e1: map.entrySet()){
            String adjNode = e1.getKey();
            //seen.add(adjNode);
            //seen.add(adjNode);
            double val = e1.getValue();
            if(!seen.contains(adjNode)){
                res = res * val;
            }
            if(adjNode.equals(dest)){
                seen.add(dest);
                return res;
            } else {
                if(!seen.contains(adjNode)){
                    DFS(adjNode, dest, graph, res, seen);
                }
            }

            //}
        }

        return 0;
    }

}
