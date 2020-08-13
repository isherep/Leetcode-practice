package Company.Amazon;

import java.util.LinkedList;
import java.util.List;

public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // word mouse
        // type m - ["mobile","moneypot","monitor"],
        // type mo - ["mobile","moneypot","monitor"],
        // type mou ["mouse","mousepad"],
        // type mou ["mouse","mousepad"],
        // type mou ["mouse","mousepad"]

        List<List<String>> res = new LinkedList<>();
        // get all previxes of products
        List<String> allPrefx = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        //sb.append(searchWord.charAt(i));
        for(int j = 0; j < searchWord.length(); j++){
            sb.append(searchWord.charAt(j));
            System.out.println(sb.toString());
            allPrefx.add(sb.toString());
        }

        for(int i = 0; i< allPrefx.size(); i++){
            find3Words(allPrefx.get(i));
        }

        return res;
    }



    public List<String> find3Words(String pref){
        List<String> res = new LinkedList<>();
        // 1. Find all the words that have that pref
        // 2. If found more than 3 - select 3 lexiographically smaller ones.
        return res;
    }
}
