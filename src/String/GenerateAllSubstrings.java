package String;

import java.util.LinkedList;
import java.util.List;

public class GenerateAllSubstrings {

    public static List<String> getAllsubstrings(String s) {
        List<String> res = new LinkedList<>();
        if (s == null || s.length() < 1) {
            return res;
        }

        // for each i - generate i0, i1, i
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.substring(i, j));
                res.add(sb.toString());
            }

        }
        return res;
    }

    public static int countSubstringsKDist(String s, int K) {
        List<String> subs = getAllsubstrings(s);
        // count how many distinct characters are in each list item
        int count = 0;
        for (String sub : subs) {
            boolean[] isThere = new boolean[126];
            // go for each char in the string
            for (int i = 0; i < sub.length(); i++) {
                isThere[sub.charAt(i) - 'A'] = true;
            }
            // count how many true are in the array
            int countUniqueu = 0;
            for (boolean b : isThere) {
                if (b) countUniqueu++;
            }
            if (countUniqueu == K) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        //System.out.println(getAllsubstrings("apple"));
        System.out.println(countSubstringsKDist("pqpqs", 2));// expected 7
        System.out.println(countSubstringsKDist("aabab", 0));// expected 0
        System.out.println(countSubstringsKDist("pq", 1)); // expected 2
    }
}

