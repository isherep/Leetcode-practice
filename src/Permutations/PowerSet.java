package Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> curList,
                           int[] nums, int start) {
        list.add(new ArrayList<>(curList));
        for (int i = start; i < nums.length; i++) {
            curList.add(nums[i]);
            backtrack(list, curList, nums, i + 1);
            curList.remove(curList.size() - 1);
        }
    }
}
