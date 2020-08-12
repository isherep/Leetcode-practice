package Permutations;

import java.util.*;

public class PermutationsDuplicates {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 1) return res;

        List<Integer> numsList = new ArrayList<>();
        // convert into arraylist
        for (int n : nums) {
            numsList.add(n);
        }

        List<Integer> numsList2 = new ArrayList<>(numsList);
        backtrack(nums.length, numsList, res, 0, numsList2);
        return res;
    }

    public void backtrack(int n, List<Integer> numsList, List<List<Integer>> res, int first, List<Integer> numsList2) {

        if (first == n) {
            ArrayList<Integer> l = new ArrayList<Integer>(numsList);
            //if(!res.contains(l)){
            res.add(l);
            //}
        }
        Set<Integer> appeared = new HashSet<>();
        for (int i = first; i < n; i++) {
            // if the number is not in the set yet
            if (appeared.add(numsList.get(i))) {
                Collections.swap(numsList, i, first);
                backtrack(n, numsList, res, first + 1, numsList2);
                Collections.swap(numsList, i, first);
            }
        }
    }
}
