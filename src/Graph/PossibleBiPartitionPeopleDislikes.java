package Graph;

import java.util.*;

public class PossibleBiPartitionPeopleDislikes {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if (dislikes == null || dislikes.length < 1) {
            return true;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : dislikes) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new LinkedList<>());
            }
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new LinkedList<>());
            }
            // map.put(edge[1], new LinkedList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);

        }
        int[] colors = new int[N + 1];
        Arrays.fill(colors, -1);
        Queue<Integer> q = new LinkedList<>();
        //int i = 1;
        int count = 1;
        for (int i = 1; i <= N; i++) {
            // if not seen
            if (colors[i] == -1) {
                colors[i] = 0;
                q.add(i);
            }
            while (!q.isEmpty()) {
                int cur = q.poll();
                int curCol = colors[cur];
                List<Integer> adj = map.get(cur);
                if (adj != null) {
                    for (int node : adj) {
                        // if it is same color
                        if (colors[node] == curCol) {
                            return false;
                        }
                        // proof - because in odd adges there are at least 1 color without the pair.
                        if (colors[node] == -1) {
                            colors[node] = 1 - curCol;
                            q.add(node);
                        }
                    }

                }
            }

        }
        return true;
    }
}
