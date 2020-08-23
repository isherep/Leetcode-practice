package Company.Amazon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MaximumNumberNonOverlappingSubstrings {
    public List<String> maxNumOfSubstrings(String s) {
        List<String> res = new LinkedList<>();
        // find the last occurance of evern character
        // each substring must contain all occurances of that character
        // find start and end for each character
        HashMap<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                int startIdx = i;
                // put i also as the ending index
                map.put(s.charAt(i), new int[]{i, i});
            } else {
                int[] indexes = map.get(s.charAt(i));
                indexes[1] = i;
                map.put(s.charAt(i), indexes);
            }
        }
        // print map
        for (Map.Entry<Character, int[]> e : map.entrySet()) {
            String temp = s.substring(e.getValue()[0], e.getValue()[1]);

            System.out.println(e.getKey() + ", " + e.getValue()[0] + ", " + e.getValue()[1]);
        }
        return res;
    }
}
