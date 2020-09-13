package Strings;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatChars {
    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int length = 0;
        for(int i = 0; i< s.length(); i++){
            for(int j = i; j< s.length(); j++){

                char cur = s.charAt(j);
                if(!map.containsKey(cur)){
                    map.put(cur, i);
                    length++;
                    max = Math.max(max, length);
                } else {
                    int index = map.get(cur);
                    i = index+1;
                     length = j - index;
                    // map.remove(cur);
                }
            }
        }

        return max;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
