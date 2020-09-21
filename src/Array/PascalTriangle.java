package Array;

import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if (numRows <= 0) return res;
        while (numRows >= 1) {
            if (res.size() == 0) {
                LinkedList<Integer> first = new LinkedList<>();
                first.add(1);
                res.add(first);
            } else {
                LinkedList<Integer> l = new LinkedList<>();
                l.addFirst(1);
                l.addLast(1);
                List<Integer> prev = res.get(res.size() - 1);
                for (int i = 1; i < prev.size(); i++) {
                    l.add(i, prev.get(i - 1) + prev.get(i));
                }
                res.add(l);
            }
            numRows--;
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = generate(5);
    }
}
