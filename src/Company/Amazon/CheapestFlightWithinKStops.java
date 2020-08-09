package Company.Amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class CheapestFlightWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // create graph
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            // if vertex doesn't exist - put it and empty hashmap to prevent null exception
            if (!map.containsKey(flights[i][0])) {
                map.put(flights[i][0], new HashMap<>());
            }// else {
            /// new map with 1 and 2
            map.get(flights[i][0]).put(flights[i][1], flights[i][2]);
            //}
        }
        // create a priority queueu based on f2
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        // price, city
        // create first object with price 0 and source and one stop
        pq.add(new int[]{0, src, K + 1});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int price = cur[0];
            int vert = cur[1];
            int stops = cur[2];
            if (vert == dst) {
                return price;
            }
            // check if stops are exhausted and
            if (stops > 0) {
                // iterate over each neighboor in the matrix
                HashMap<Integer, Integer> adj = map.getOrDefault(vert, new HashMap<>());
                for (int a : adj.keySet()) {
                    // add to the priority queueu
                    // increment cumulative price
                    // decrement stops
                    int[] arr = new int[]{price + adj.get(a), a, stops - 1};
                    pq.add(arr);
                }
            }
        }
        return -1;
    }

    // BELLMAN - FORD
    public int findCheapestPriceBF(int n, int[][] flights, int src, int dst, int k) {
        int INF = 0x3F3F3F3F;
        int[] cost = new int[n];
        Arrays.fill(cost, INF);
        cost[src] = 0;
        int ans = cost[dst];
        for (int i = k; i >= 0; i--) {
            int[] cur = new int[n];
            Arrays.fill(cur, INF);
            for (int[] flight : flights) {
                cur[flight[1]] = Math.min(cur[flight[1]], cost[flight[0]] + flight[2]);
            }
            cost = cur;
            ans = Math.min(ans, cost[dst]);
        }
        return ans == INF ? -1 : ans;
    }

}
