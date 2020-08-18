package Company.Amazon;

import java.util.*;

public class LargestAssociation {

    public List<String> largestItemAssociation(List<PairString> itemAssociation) {
        //UnionFind uf = new UnionFind(num);
        // grapy data structure

        Map<String, List<String>> assocmap = new HashMap<>();
        //Map with all items and child association of every item 1->2, 2-> , 3->4, 4->5 ,5->
        for (PairString p : itemAssociation) {
            if (!assocmap.containsKey(p.first)) {
                assocmap.put(p.first, new ArrayList<>());
            }
            assocmap.get(p.first).add(p.second);
            if (!assocmap.containsKey(p.second)) {
                assocmap.put(p.second, new ArrayList<>());
            }
        }
        //DFS for every item: Resultant map 1->{5},{2} 2->{1,2},{4,5} 3->{3,4,5}
        //
        Map<Integer, List<List<String>>> sizemap = new HashMap<>();
        int maxassoc = Integer.MIN_VALUE;
        // build sets for every key in the graph
        for (String key : assocmap.keySet()) {
            Queue<String> q = new LinkedList<>();
            TreeSet<String> temp = new TreeSet<>();
            q.offer(key);
            while (!q.isEmpty()) {
                String head = q.poll();
                // add to the tree set
                temp.add(head);
                // get the item that associated to polled
                List<String> tail = assocmap.get(head);
                for (String t : tail) {
                    // add all children to the q
                    q.offer(t);
                }
            }
            int size = temp.size();
            // get size of temp and compare to current
            maxassoc = Math.max(maxassoc, size);
            // store each size and coresponding list in the map

            if (!sizemap.containsKey(size)) {
                sizemap.put(size, new ArrayList<>());
            }
            sizemap.get(size).add(new ArrayList<>(temp));
        }

        // Retrieve the maximum size lists and sort them lexiographically
        // There might be more than one list with that size
        List<List<String>> maxassoclist = sizemap.get(maxassoc);

        Collections.sort(maxassoclist, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int result = 0;
                for (int i = 0; i < o1.size() && result == 0; i++) {
                    result = o1.get(i).compareTo(o2.get(i));
                }
                return result;
            }
        });
        // get
        return maxassoclist.get(0);
    }

    public static void main(String[] args) {
        LargestAssociation s = new LargestAssociation();
        /**
         * Example 1
         */
        List<PairString> input = Arrays.asList(
                new PairString[]{
                        s.new PairString("item1", "item2"),
                        s.new PairString("item3", "item4"),
                        s.new PairString("item4", "item5")
                }
        );
        /**
         * Testing equal sized arraylist. 1->2->3->7 4->5->6->7
         */
        List<PairString> input2 =  Arrays.asList(
                new PairString[] {
                        s.new PairString("item1","item2"),
                        s.new PairString("item2","item3"),
                        s.new PairString("item4","item5"),
                        s.new PairString("item6","item7"),
                        s.new PairString("item5","item6"),
                        s.new PairString("item3","item7")
                }
        );
        List<String> lst = s.largestItemAssociation(input);
        for (String sa : lst) System.out.print(" " + sa);
        System.out.println();
        List<String> lst2 = s.largestItemAssociation(input2);
        for (String sa : lst2) System.out.print(" " + sa);
        System.out.println();
        /**
         * Testing duplicates: 1->2->3->7 , 5->6
         */
        List<PairString> input3 =  Arrays.asList(
                new PairString[] {
                        s.new PairString("item1","item2"),
                        s.new PairString("item1","item3"),
                        s.new PairString("item2","item7"),
                        s.new PairString("item3","item7"),
                        s.new PairString("item5","item6"),
                        s.new PairString("item3","item7")
                }
        );

        List<String> lst3 = s.largestItemAssociation(input3);
        for (String sa : lst3) System.out.print(" " + sa);
    }

    public class PairString {
        String first;
        String second;

        public PairString(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }
}

