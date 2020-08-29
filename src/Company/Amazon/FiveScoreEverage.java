package Company.Amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FiveScoreEverage {

    public int[][] highFive(int[][] items) {

        if (items == null) return new int[][]{{}};
        HashMap<Integer, PriorityQueue> map = new HashMap<>();
        for (int[] item : items) {
            int id = item[0];
            map.put(id, new PriorityQueue<Integer>(5, (a, b) -> b - a));
        }

        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            //map.put(id, new PriorityQueue<Integer>(5, (a, b) -> b-a));
            map.get(id).add(score);
        }
        int[][] res = new int[map.keySet().size()][2];
        int i = 0;
        for (Map.Entry<Integer, PriorityQueue> e : map.entrySet()) {
            int id = e.getKey();
            res[i][0] = id;
            PriorityQueue<Integer> heap = e.getValue();
            int k = 0;
            int sum = 0;
            while (k < 5 && !heap.isEmpty()) {
                sum += heap.poll();
                k++;
            }
            int ave = sum / 5;
            res[i][1] = ave;

            i++;
        }
        // put the size of map keys in the length
        return res;
    }

}
