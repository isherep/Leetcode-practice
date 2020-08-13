package Permutations;

import java.util.LinkedList;
import java.util.List;

public class AllPermutationsOfTheString {

    public static List<String> permute(String s) {

        char[] chars = s.toCharArray();
        List<String> res = new LinkedList<>();
        helper(s.length(), chars, res, 0);
        return res;
    }

    public static void helper(int n, char[] chars, List<String> res, int first) {

        if (first == n) {
            StringBuilder sb = new StringBuilder();
            sb.append(chars);
            res.add(sb.toString());
        }

        for (int i = first; i < n; i++) {
            swap(chars, i, first);
            helper(n, chars, res, first + 1);
            swap(chars, i, first);
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {

        System.out.print(permute("ABC"));

    }

}
