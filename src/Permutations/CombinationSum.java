package Permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), target, res);
        return res;
    }

    public void backtrack(int[] candidates, int target, int left, List<Integer> comb, int remain, List<List<Integer>> res) {

        if (remain < 0) {
            return;
        } else if (remain == 0) {
            res.add(new ArrayList<>(comb));
        } else {

            for (int i = left; i < candidates.length; i++) {
                // add to the set
                comb.add(candidates[i]);
                backtrack(candidates, target, i, comb, remain - candidates[i], res);
                comb.remove(comb.size() - 1);
            }
        }
    }
}
