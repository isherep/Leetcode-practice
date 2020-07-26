package Company.Amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MostCommonNotBannedWord {

    public String mostCommonWord(String paragraph, String[] banned) {

        String[] words = paragraph.split(" ");
        // endsWith(),
        char[] symbols = {',', '.', ';', '?', '.', '!', '\''};
        for (int i = 0; i < words.length; i++) {
            //words[i].trim(",");
            for (int j = 0; j < symbols.length; j++) {
                // if the last character of word is a symbol
                if (words[i].charAt(words[i].length() - 1) == symbols[j]) {
                    words[i] = words[i].substring(0, words[i].length() - 1);
                }
            }
            System.out.print(words[i] + ", ");
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String cur = words[i].toLowerCase();
            if (map.containsKey(cur)) {
                int count = map.get(cur);
                map.put(cur, count + 1);
            } else {
                map.put(cur, 1);
            }
        }
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < banned.length; i++) {
            set.add(banned[i]);
        }
        int max = 0;
        String maxWord = words[0];
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            String word = e.getKey().toLowerCase();
            int count = e.getValue();
            System.out.println(word + ", " + count);
            // if the set doesn't contain word
            if (!set.contains(word)) {
                if (count > max) {
                    max = count;
                    maxWord = word;
                }

            }
        }

        return maxWord;
    }

}
