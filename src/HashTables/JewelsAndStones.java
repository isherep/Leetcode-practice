package HashTables;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    // using hashSet
    public int numJewelsInStones(String J, String S) {
        // for each char in S, check if J contains it.
        // if it does - increment count.
        if (J == null || S == null) return 0;
        if (J.length() < 1) return 0;
        Set<Character> stones = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            stones.add(J.charAt(i));
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (stones.contains(S.charAt(i))) {
                count++;
            }
        }

        return count;
    }

    public int numJewelsInStonesFaster(String J, String S) {
        // for each char in S, check if J contains it.
        // if it does - increment count.
        if (J == null || S == null) return 0;
        if (J.length() < 1) return 0;
        // array size 58 because we need to include 8 non alphanumeric characters
        // that are between lowercase and uppercase alphabet in the ASCII table
        char[] stones = new char[58];
        for (int i = 0; i < J.length(); i++) {
            // get charcode
            int c = J.charAt(i) - 'A';
            //System.out.println(c);
            stones[c]++;
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            // get code of char
            if (stones[S.charAt(i) - 'A'] >= 1) {
                count++;
            }
        }
        return count;
    }

}
