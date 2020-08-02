package Graph;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CriticalConnections {
//    boolean[] marked;
//    int[] id;
    //int count;


    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        // for each connection in the list - remove it from the list
        // check if graph becomes disconected
        List<List<Integer>> res = new LinkedList<>();
        // if the graph is not connected after removing this connectins
        HashMap<Integer, List<Integer>> graph = buildGraph(n, connections);
        int curNumComp = CC(graph, graph.keySet().size(), 0);
        for (int i = 0; i < connections.size(); i++) {
            List<Integer> curConnect = connections.get(i);
            connections.remove(curConnect);
            n--;
            graph.get(curConnect.get(0)).remove(curConnect.get(1));
            graph.get(curConnect.get(1)).remove(curConnect.get(0));
            int count = 0;
            int newNumber = CC(graph, n, count);
            //  System.out.println("New Number of connect compo: " + curNumComp);
            if (newNumber > curNumComp) {
                // System.out.println("New Number of connect compo: " + curNumComp);
                res.add(curConnect);
            }
            // put back the node at the same spot it was before
            connections.add(i, curConnect);
            n++;
            graph.get(curConnect.get(0)).add(curConnect.get(1));
            graph.get(curConnect.get(1)).add(curConnect.get(0));

        }
        System.out.println("Res " + res);
        return res;
    }

    //
// counts number of connected components
    public int CC(HashMap<Integer, List<Integer>> G, int N, int count) {
        // number of vertices
        int V = G.keySet().size();
        boolean[] marked = new boolean[V];
        int[] id = new int[V];
        for (int v = 0; v < V; v++) {
            if (!marked[v]) {
                dfsC(G, v, marked, id, count);
                // for every time we find unmarked vertex after all other's were
                // traversed - it means it is in a different component
                count++;
            }
        }

        return count;
    }

    private void dfsC(HashMap<Integer, List<Integer>> G, int v, boolean[] marked, int[] id, int count) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.get(v))
            if (!marked[w])
                dfsC(G, w, marked, id, count);
    }

    public HashMap<Integer, List<Integer>> buildGraph(int n, List<List<Integer>> connections) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < connections.size(); i++) {
            List<Integer> cur = connections.get(i);
            if (graph.containsKey(cur.get(0))) {
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
        return graph;
    }

    public List<List<Integer>> buildListFromArray(int[][] arr) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> l = new LinkedList();
            for (int j = 0; j < arr[i].length; j++) {
                l.add(arr[i][j]);
                //l.add(arr[i][1]);
            }
            res.add(l);
        }
        return res;
    }

    // reads the file with test case
    public List<List<Integer>> readFile(String fileName) throws IOException {
        List<List<Integer>> connections = new LinkedList<>();
        File file = new File(fileName);
        try {
            BufferedReader in = new BufferedReader(new
                    FileReader(file));
            String str;
            while ((str = in.readLine()) != null) {
                String[] ar = str.split("],");
                for (int i = 0; i < ar.length - 1; i++) {
                    List<Integer> l = new LinkedList<>();
                    String[] s = ar[i].trim().split("[^0-9]");
                    l.add(Integer.parseInt(s[1]));
                    l.add(Integer.parseInt(s[2]));
                    connections.add(l);
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
        return connections;
    }

    public static void main(String[] args) throws IOException {
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

        CriticalConnections myTask = new CriticalConnections();

        List<List<Integer>> largeGraph = myTask.readFile("/Users/user/Dropbox/Leetcode-practice/large_graph_connections.txt");
        List<List<Integer>> test4 = myTask.buildListFromArray(new int[][]{{0, 1}, {1, 2}, {2, 0}, {1, 3}});
        List<List<Integer>> test5 = myTask.buildListFromArray(new int[][]{{0, 1}, {1, 2}, {2, 0}, {1, 3}, {3, 4}, {4, 5}, {5, 3}});
        List<List<Integer>> test6 = myTask.buildListFromArray(new int[][]{{0, 1}, {1, 2}, {3, 10}, {10, 11}, {2, 0}, {1, 3}, {3, 4}, {4, 5}, {5, 3}, {8, 10}, {3, 11}});
        boolean[] visited = new boolean[1000];

        // correct - [1,3]
        List<List<Integer>> res4 = myTask.criticalConnections(4, test4);
        // List<List<Integer>> res6 = myTask.criticalConnections(12, test6);
        List<List<Integer>> resLarge = myTask.criticalConnections(1000, largeGraph); // exp [].

        // print res list
        //System.out.println("res5 " + res4);
        // System.out.println("res6 " + res6);
        //System.out.println("resLarge " + resLarge);
//        for (int i = 0; i < res6.size(); i++) {
//            System.out.print("[" + res6.get(i).get(0) + ", " + res6.get(i).get(1) + "]");
//        }
//        /*
//
//        1000
//        in the file - expected output is []
//
//        5
//        [[1,0],[2,0],[3,2],[4,2],[4,3],[3,0],[4,0]]
//
//        6
//         [[0,1],[1,2],[2,0],[1,3],[3,4],[4,5],[5,3]]
//
//         12
//        [[0,1],[1,2],[3,10],[10,11],[2,0],[1,3],[3,4],[4,5],[5,3],[8,10],[3,11]]
//        correct - [[10,8],[1,3]]

//        4
//                [[0,1],[1,2],[2,0],[1,3]]  coorect [1,3]
//
//        */
//
//
//        // readFile();
    }

}


//    public static boolean conected1( int N, int removedNode, HashMap<Integer, List<Integer>> graph) {
//
//
//        boolean[] vis1 = new boolean[N];
//        // Call for correct direction
//        Arrays.fill(vis1, false);
//        dfs1(removedNode, vis1, graph);
//
//        // Call for reverse direction
//        boolean[] vis2 = new boolean[N];
//        Arrays.fill(vis2, false);
//        dfs2(removedNode, vis2, graph);
//
//        for (int i = 1; i <= N; i++) {
//
//            // If any vertex it not visited in any direction
//            // Then graph is not connected
//            if (!vis1[i] && !vis2[i])
//                return false;
//        }
//
//        // If graph is connected
//        return true;
//    }
//
//    // DFS function
//    static void dfs1(int node, boolean[] vis1, HashMap<Integer, List<Integer>> graph) {
//        //vis1[node] = true;
//        if (!vis1[node]) {
//            vis1[node] = true;
//            System.out.println(node);
//            List<Integer> edges = graph.get(node);
//            //System.out.println("edges "+edges);
//            if (edges != null) {
//                // use dfs for each edge
//                for (int edge : edges) {
//                    // System.out.print(edge + ", ");
//                    //visited[edge] = true;
//                    dfs1(edge, vis1, graph);
//                }
//            }
//        }
//
//    }
//
//    // DFS function
//    static void dfs2(int node, boolean[] vis2, HashMap<Integer,List<Integer>> graph) {
//        //vis2[node] = true;
//        if (!vis2[node]) {
//            vis2[node] = true;
//            //System.out.println(node);
//            List<Integer> edges = graph.get(node);
//            //System.out.println("edges "+edges);
//            if (edges != null) {
//                // use dfs for each edge
//                for (int edge : edges) {
//                    // System.out.print(edge + ", ");
//                    //visited[edge] = true;
//                    dfs2(edge, vis2, graph);
//                }
//            }
//        }
//
//    }
//
//    // count how many true you got in the boolean array
//    // if it is < N - return false else return true
//    public void DFS(int node, Map<Integer, List<Integer>> graph, boolean[] visited) {
//
//        if (!visited[node]) {
//            visited[node] = true;
//            System.out.println(node);
//            List<Integer> edges = graph.get(node);
//            //System.out.println("edges "+edges);
//            if (edges != null) {
//                // use dfs for each edge
//                for (int edge : edges) {
//                    // System.out.print(edge + ", ");
//                    //visited[edge] = true;
//                    DFS(edge, graph, visited);
//                }
//            }
//        }
//    }
//

//    public  List<List<Integer>> readFile() {
//        List<List<Integer>> connections = new LinkedList<>();
//        try {
//            BufferedReader in = new BufferedReader(new
//                    FileReader("/Users/user/Dropbox/Leetcode-practice/large_graph_connections.txt"));
//            String str;
//            while ((str = in.readLine()) != null) {
//                String[] ar = str.split("],");
//                //System.out.println(ar.length);
//                for (int i = 0; i < ar.length - 1; i++) {
//                    List<Integer> l = new LinkedList<>();
//                    String[] s = ar[i].trim().split("[^0-9]");
//                    //System.out.println()
//                    l.add(Integer.parseInt(s[1]));
//                    l.add(Integer.parseInt(s[2]));
//
////                    for(int k= 0; k<s.length; k++){
////                        System.out.println(s[k]);
////                    }
//                    connections.add(l);
//                }
//                //System.out.print
//            }
//            in.close();
//        } catch (IOException e) {
//            System.out.println("File Read Error");
//        }
//// print result list
////        for(List<Integer> connection: connections){
////            System.out.println("{" + connection.get(0) + ", " + connection.get(1) + "}");
////        }
//        return connections;
//    }
////

//    public void printGraph(HashMap<Integer, List<Integer>> graph) {
//        // PRINT THE HASHMAP GRAPH
//        for (Map.Entry<Integer, List<Integer>> e : graph.entrySet()) {
//            System.out.print("key: " + e.getKey() + ": ");
//            List edges = e.getValue();
//            System.out.print(" edges: ");
////            for (int i = 0; i < edges.size(); i++) {
////                System.out.print(edges.get(i) + ", ");
////            }
//            // System.out.println();
//        }
//    }
//
// CHECKS IF GRAPH IS CONNECTED
//    // IF DFS COVERS EACH NODE AFTER REMOVAL CONNECTION - IT IS CONNECTED
//    // IF DFS DOESN'T COVER SOME NODES
//    // REMOVE CONNECTION, CHECK IF THERE ARE UNVISITED NODES
//    public boolean conected(List<List<Integer>> connections, int N, int removedNode) {
//        // build graph
//        boolean[] visited = new boolean[N];
//        // build graph
//        HashMap<Integer, List<Integer>> graph = buildGraph(N, connections);
//        // perform DFS on graph
//        // SELECT SOME NODE
//        // instead of DFS on the whole graph - start with removed edge
//        // for(Map.Entry<Integer,List<Integer>> e: graph.entrySet()){
//        DFS(removedNode, graph, visited);
//        //}
//        // count how many true you got in the boolean array
//        // if it is < N - return false else return true;
//        int count = 0;
//        for (boolean vis : visited) {
//            //System.out.print(vis + ", ");
//            if (vis) count++;
//        }
//
//        System.out.println("count " + count);
//
//        if (count < N) return false;
//        else return true;
//    }
//
//



