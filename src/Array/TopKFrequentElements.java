package Array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        int[] res = new int[k];
        if (nums == null || nums.length < 1 || k > nums.length) return res;
        HashMap<Integer, Integer> map = new HashMap<>();

        // count each num frequency
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            heap.add(e);
        }
        int j = 0;

        while (heap.size() > 0 && j < k) {
            res[j] = heap.poll().getKey();
            j++;
        }
        return res;
    }
}
