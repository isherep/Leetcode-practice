package Graph;

import java.util.*;

public class isBipartite {
    public boolean isBipartite(int[][] graph) {
        // build the graph
        HashMap<Integer, List<Integer>> map
                = new HashMap<>();
        for (int[] edge : graph) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new LinkedList<>());
            }
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new LinkedList<>());
            }
            List<Integer> list = map.get(edge[0]);
            list.add(edge[1]);
            map.put(edge[0], list);

            List<Integer> list1 = map.get(edge[1]);
            list.add(edge[0]);
            map.put(edge[1], list1);
            // map.get(edge[1]).add(edge[0]);
        }
        // push starting node into the queueu
        int start = 0;
        int[] color = new int[map.size()];
        boolean[] visited = new boolean[map.size()];
        Arrays.fill(color, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        // let's assign the color 1 to the start
        // than others have to be 0 or 1
        color[start] = 1;

        while (!q.isEmpty()) {

            int cur = q.poll();
            int curCol = color[cur];
            // go over all adj and color them int he color oposite
            // to cur
            List<Integer> adj = map.get(cur);
            for (int n : adj) {
                //if(!visted[n]){
                // compare
                if (color[n] == curCol) {
                    return false;
                }
                if (color[n] == -1) {
                    // assign oposite color to curColor
                    color[n] = 1 - color[cur];
                    q.add(n);

                }
            }
        }
        return true;
    }

    public boolean isBipartite1(int[][] graph) {
        //corner case
        if (graph.length == 1 || graph.length == 0) return true;
        int[] color = new int[graph.length];
        int flag = 1;
        int head = 0;
        //head
        color[head] = flag;
        //bfs
        Queue<Integer> temp = new LinkedList<>();
        while (head < graph.length) {
            temp.offer(head);
            if (color[head] == 0) {
                color[head] = flag;
            }
            while (!temp.isEmpty()) {
                int level = temp.poll();
                for (int i = 0; i < graph[level].length; i++) {
                    // if one of the level colors is the same as cur color - false
                    if (color[graph[level][i]] == color[level]) return false;
                    else if (color[graph[level][i]] == 0) color[graph[level][i]] = -color[level];
                    //System.out.println("level: "+level+" i:"+graph[level][i]+" color:"+color[graph[level][i]]);
                    if (level < graph[level][i]) temp.offer(graph[level][i]);
                }
            }
            head++;
        }
        return true;
    }


    public boolean isBipartiteShort(int[][] g) {
        int[] colors = new int[g.length];

        for (int i = 0; i < g.length; i++)
            if (colors[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                colors[i] = 1;
                while (!q.isEmpty()) {
                    Integer node = q.poll();
                    // adjacent of 1 will be the second subarray in the graph
                    for (int adjacent : g[node])
                        // if one of neighbor colors are the same - false
                        if (colors[adjacent] == colors[node])
                            return false;
                        // if not seen - 0 is not seen default
                        else if (colors[adjacent] == 0) {
                            q.add(adjacent);
                            // mark it oposite collor and add to the queueu
                            colors[adjacent] = -colors[node];
                        }
                }
            }
        return true;
    }

}
