package Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CriticalConnections {

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        // for each connection in the list - remove it from the list
        // check if graph becomes disconected
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < connections.size(); i++) {
            List<Integer> curConnect = connections.get(i);
            connections.remove(curConnect);
            //System.out.println("removed connection " + curConnect.get(0) + ", " + curConnect.get(1));
            //print list of connections after removing one
//             for (int j = 0; j < connections.size(); j++) {
//                 System.out.print("[" + connections.get(j).get(0) + ", " + connections.get(j).get(1) + "]");
//             }
            //System.out.println();
            // if the graph is not connected after removing this connectins
            if (!conected(connections, n, curConnect.get(0))) {
                res.add(curConnect);
                //System.out.println(curConnect.get(0) + ", " + curConnect.get(1));
                //connections.add(curConnect);
            }
            // put back the node at the same spot it was before
            connections.add(i, curConnect);
//            for (int j = 0; j < connections.size(); j++) {
//                //System.out.print("[" + connections.get(j).get(0) + ", " + connections.get(j).get(1) + "]");
//            }
        }
        return res;
    }

    // CHECKS IF GRAPH IS CONNECTED
    // IF DFS COVERS EACH NODE AFTER REMOVAL CONNECTION - IT IS CONNECTED
    // IF DFS DOESN'T COVER SOME NODES
    // REMOVE CONNECTION, CHECK IF THERE ARE UNVISITED NODES
    public static boolean conected(List<List<Integer>> connections, int N, int removedNode) {
        // build graph
        boolean[] visited = new boolean[N];
        // build graph
        HashMap<Integer, List<Integer>> graph = buildGraph(N, connections);
        // perform DFS on graph
        // SELECT SOME NODE
        // instead of DFS on the whole graph - start with removed edge
        // for(Map.Entry<Integer,List<Integer>> e: graph.entrySet()){
        DFS(removedNode, graph, visited);
        //}
        // count how many true you got in the boolean array
        // if it is < N - return false else return true;
        int count = 0;
        for (boolean vis : visited) {
            //System.out.print(vis + ", ");
            if (vis) count++;
        }

        //System.out.println("count " + count);

        if (count < N) return false;
        else return true;
    }

    // count how many true you got in the boolean array
    // if it is < N - return false else return true
    public static void DFS(int node, Map<Integer, List<Integer>> graph, boolean[] visited) {

        if (!visited[node]) {
            visited[node] = true;
            //System.out.println(node);
            List<Integer> edges = graph.get(node);
            //System.out.println("edges "+edges);
            if (edges != null) {
                // use dfs for each edge
                for (int edge : edges) {
                    // System.out.print(edge + ", ");
                    //visited[edge] = true;
                    DFS(edge, graph, visited);
                }
            }
        }
    }

    public static HashMap<Integer, List<Integer>> buildGraph(int n, List<List<Integer>> connections) {
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
        //printGraph(graph);
        return graph;
    }

    public static void printGraph(HashMap<Integer, List<Integer>> graph) {
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

    public static List<List<Integer>> buildListFromArray(int[][] arr){
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0; i< arr.length; i++){
            List<Integer> l = new LinkedList();
            for(int j = 0; j< arr[i].length; j++){
                l.add(arr[i][j]);
                //l.add(arr[i][1]);
            }
            res.add(l);
        }

        System.out.println(res);

        return res;
    }

    public static List<List<Integer>> readFile(){
        List<List<Integer>> connections = new LinkedList<>();
        try {
            BufferedReader in = new BufferedReader(new
                    FileReader("/Users/user/Dropbox/Leetcode-practice/large_graph_connections.txt"));
            String str;
            while ((str = in.readLine())!= null) {
                String[] ar = str.split("],");
                //System.out.println(ar.length);
                for(int i = 0; i<ar.length-1; i++){
                    List<Integer> l = new LinkedList<>();
                    String[] s = ar[i].trim().split("[^0-9]");
                    //System.out.println()
                    l.add(Integer.parseInt(s[1]));
                    l.add(Integer.parseInt(s[2]));

//                    for(int k= 0; k<s.length; k++){
//                        System.out.println(s[k]);
//                    }
                    connections.add(l);
                }
                //System.out.print
            }
            in.close();
        }
        catch (IOException e) {
            System.out.println("File Read Error");
        }
// print result list
//        for(List<Integer> connection: connections){
//            System.out.println("{" + connection.get(0) + ", " + connection.get(1) + "}");
//        }
        return connections;
    }


    public static void main(String[] args) {
        System.out.println("test");


        List<List<Integer>> connections = new LinkedList<>();
        Integer[] a1 = new Integer[]{0, 1};
        Integer[] a2 = new Integer[]{1, 2};
        Integer[] a3 = new Integer[]{2, 0};
        Integer[] a4 = new Integer[]{1, 3};

        List<Integer> l1 = Arrays.asList(a1);
        List<Integer> l2 = Arrays.asList(a2);
        List<Integer> l3 = Arrays.asList(a3);
        List<Integer> l4 = Arrays.asList(a4);

        connections.add(l1);
        connections.add(l2);
        connections.add(l3);
        connections.add(l4);

        List<List<Integer>> largeGraph = readFile();
        List<List<Integer>> test5 = buildListFromArray(new int[][]{{0,1},{1,2},{2,0},{1,3},{3,4},{4,5},{5,3}});
        List<List<Integer>> test6 = buildListFromArray(new int[][]{{0,1},{1,2},{3,10},{10,11},{2,0},{1,3},{3,4},{4,5},{5,3},{8,10},{3,11}});
        boolean[] visited = new boolean[1000];

        // correct - [1,3]
        List<List<Integer>> res5 = criticalConnections(6, test5);
        List<List<Integer>> res6 = criticalConnections(12, test6);

        // print res list
        System.out.println("res5 " + res5);
        System.out.println("res6 " + res6);
//        for (int i = 0; i < res6.size(); i++) {
//            System.out.print("[" + res6.get(i).get(0) + ", " + res6.get(i).get(1) + "]");
//        }
        /*

        1000
        in the file - expected output is []

        5
        [[1,0],[2,0],[3,2],[4,2],[4,3],[3,0],[4,0]]

        6
         [[0,1],[1,2],[2,0],[1,3],[3,4],[4,5],[5,3]]

         12
        [[0,1],[1,2],[3,10],[10,11],[2,0],[1,3],[3,4],[4,5],[5,3],[8,10],[3,11]]
        correct - [[10,8],[1,3]]

        */





       // readFile();
    }

}
