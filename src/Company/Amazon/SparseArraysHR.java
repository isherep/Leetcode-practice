package Company.Amazon;

import java.util.HashMap;

public class SparseArraysHR {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] res = new int[queries.length];
        // for each string put the count of strings into map
        // for each element in the query
        // check if it is in the map - if it is - retrieve its count
        // if it's not - put 0 count
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String cur = strings[i];
            if (map.containsKey(cur)) {
                // update the count
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            // check if map contains
            if (map.containsKey(q)) {
                res[i] = map.get(q);
            } else {
                res[i] = 0;
            }
        }

        return res;

        //Return an integer array of the results of all queries in order.
    }
}
