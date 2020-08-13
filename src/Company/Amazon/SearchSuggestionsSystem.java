package Company.Amazon;

import java.util.*;

public class SearchSuggestionsSystem {
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
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

        Arrays.sort(products);
        System.out.println(

        );
        for (String p : products) {
            System.out.print(p + ", ");
        }
        //sb.append(searchWord.charAt(i));
        for (int j = 0; j < searchWord.length(); j++) {
            sb.append(searchWord.charAt(j));
            //System.out.println(sb.toString());
            allPrefx.add(sb.toString());
        }

        for (int i = 0; i < allPrefx.size(); i++) {
            find3Words(allPrefx.get(i));
        }

        return res;
    }


    public static List<String> find3Words(String pref) {
        List<String> res = new LinkedList<>();
        // 1. Find all the words that have that pref
        // 2. If found more than 3 - select 3 lexiographically smaller ones.
        return res;
    }


    public List<List<String>> suggestedProducts1(String[] products, String searchWord) {
        List<List<String>> finalResult = new ArrayList();
        if (products == null || products.length == 0 || searchWord == null || searchWord.isEmpty()) {
            return finalResult;
        }
        Arrays.sort(products);
        // create productList for the products
        List<String> possibleProductList = new ArrayList();
        for (String product : products) {
            possibleProductList.add(product);
        }
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            // check in possible product list and filter products
            List<String> filteredList = new ArrayList();
            for (String product : possibleProductList) {
                if (i < product.length() && c == product.charAt(i)) {
                    filteredList.add(product);
                }
            }
            // add only atmost three items to the intermediate result
            List<String> intermediateResult = new ArrayList();
            for (int j = 0; j < 3 && j < filteredList.size(); j++) {
                intermediateResult.add(filteredList.get(j));
            }

            // add intermediateResult to the final result
            finalResult.add(intermediateResult);

            // change the possibleProductList to the already filtered list
            possibleProductList = filteredList;
        }
        return finalResult;
    }

    public List<List<String>> suggestedProductsMap(String[] products, String searchWord) {
        Arrays.sort(products);
        //System.out.println(products);

        List<List<String>> res = new ArrayList<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        Arrays.sort(products);
        List<String> productsList = Arrays.asList(products);

        for (int i = 0; i < products.length; i++) {
            map.put(products[i], i);
        }

        String key = "";
        // put all previxes into the map
        for (char c : searchWord.toCharArray()) {
            key += c;
            System.out.println(key);
            // ceilingKey()  first largest - function of TreeMap Class returns the least key greater than or equal to the given key or null if the such a key is absent.
            String ceiling = map.ceilingKey(key);
            System.out.println("k: " + key);
            // floorKey() method is used to return the greatest key less than or equal to given key from the parameter.
            String floor = map.floorKey(key + "~");
            //
            System.out.println("f: " + floor);
            if (ceiling == null || floor == null) break;
            // portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
            res.add(productsList.subList(map.get(ceiling), Math.min(map.get(ceiling) + 3, map.get(floor) + 1)));
        }

        while (res.size() < searchWord.length()) res.add(new ArrayList<>());
        return res;
    }


    public static void main(String[] args) {

        suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"},
                "mouse"
        );
    }
}
