package Company.Amazon;

import java.util.LinkedList;
import java.util.List;

public class DistributeCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new LinkedList<Boolean>();
        if (candies == null || candies.length < 1) return res;
        // check for current maximum
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        // if each candy + extra < maximim - false
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies < max) {
                res.add(false);
            } else {
                res.add(true);
            }
        }

        return res;
    }
}
