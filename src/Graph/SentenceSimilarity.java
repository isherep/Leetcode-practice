package Graph;

import java.util.*;

public class SentenceSimilarity {
    HashMap<String, ArrayList<String>> map;

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        // if words are different length
        if (words1.length != words2.length) return false;
        buildDictionary(pairs);
        for (int i = 0; i < words1.length; i++) {
            // compare each words1 if it is connected to words2[i]
            if (!areConnected(words1[i], words2[i])) {
                return false;
            }
        }

        return true;
    }


    public boolean areConnected(String w1, String w2) {
        if (w1.equals(w2)) return true;
        // run BFD
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(w1);
        visited.add(w1);
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.equals(w2)) {
                return true;
            }

            List<String> list = map.get(cur);
            if (list != null && list.size() > 0) {
                for (String word : list) {
                    if (word != null) {
                        if (!visited.contains(word)) {
                            visited.add(cur);
                            q.add(word);
                        }
                    }

                }
            }

        }
        // while
        return false;
    }

    public void buildDictionary(List<List<String>> pairs) {
        this.map = new HashMap<>();
        for (List<String> pair : pairs) {
            String w1 = pair.get(0);
            String w2 = pair.get(1);
            map.putIfAbsent(w1, new ArrayList<>());
            ArrayList<String> adj = map.get(w1);
            adj.add(w2);
            map.put(w1, adj);
        }
        for (List<String> pair : pairs) {
            String w1 = pair.get(1);
            String w2 = pair.get(0);
            map.putIfAbsent(w1, new ArrayList<>());
            ArrayList<String> adj = map.get(w1);
            adj.add(w2);
            map.put(w1, adj);
        }

    }
}
