package Design;

import java.util.Random;

/**
 * The problem is, we need to randomly pick an index proportional to its weight.
 * What this means?
 * We have weights array, each
 * weights[i]  represents weight of index i.
 * The more the weight is, then high chances of getting that index randomly.
 * <p>
 * suppose weights = [1, 3]
 * then 3 is larger, so there are high chances to get index 1.
 * <p>
 * We can know the chances of selecting each index by knowing their probability.
 * <p>
 * P(i) = weight[i]/totalWeight
 * <p>
 * totalWeight = 1 + 3 = 4
 * So, for index 0, P(0) = 1/4  = 0.25 = 25%
 * for index 1, P(1) = 3/4 = 0.75 = 75%
 * <p>
 * So, there are 25% of chances to pick index 0 and 75% chances to pick index 1.
 * <p>
 * I have provided java code for this problem in the comment section.
 * If you are interested, you can check that. Happy coding.
 * <p>
 * IF YOU UNDERSTAND THIS, DON'T FORGET TO UPVOTE.
 */
public class RandomPickWithWeight {
    private int[] weights;
    private int[] arr;

    public RandomPickWithWeight(int[] w) {
        this.weights = w;
        // find how many elements to put in a new array
        int len = 0;
        for (int i = 0; i < w.length; i++) {
            len += w[i];

        }
        //System.out.println(len);
        // [1,3,2] [0, 1 1 1, 2, 2]
        int timIdx = 0;
        int start = 0;
        arr = new int[len];
        for (int i = 0; i < w.length; i++) {
            int times = w[i];
            int idx = i;
            int j = start;
            int k = 0;
            while (k < times) {
                arr[j] = idx;
                j++;
                k++;
            }
            start += k;
        }
    }

    // The problem is, we need to randomly pick an index proportional to its weight.
    public int pickIndex() {
        Random ran = new Random();
        int index = ran.nextInt(arr.length);
        return arr[index];

        // should return the integer proportional to its weight in the w array.
    }
}
