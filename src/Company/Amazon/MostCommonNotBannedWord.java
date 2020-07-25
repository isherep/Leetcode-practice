package Company.Amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MostCommonNotBannedWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        // find the most common word in the paragraph
        // check if it is not in banned
        // if it is - retrieve the next common one
        // retrieve the next common one untill find the one that is not in banned

        // put pragraph into the the map word: frequency
        // select the max from the map


        // create a map of words that are not in banned words
        // select the most frequent one from there

        // First select all the words that only consists of letters, spaces, or the punctuation symbols !?',;.
        //Words only consist of letters, never apostrophes or other punctuation symbols.
        // 1. turn paragraph into the list words
        // List<String> words = new LinkedList<>();
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
