package String;

public class FirstUniqueCharInString {
    public static int firstUnique(String s) {
        char[] counts = new char[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        int minPos = Integer.MAX_VALUE;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 1) {
                String cur = "" + (char) (i + 'a');
                int pos = s.indexOf(cur);
                minPos = Math.min(pos, minPos);
            }
            // can also search for index of char instead of string
//            if(counts[i] == 1){
//                char cur = (char)(i + 'a');
//                int pos = s.indexOf(cur);
//                minPos = Math.min(pos, minPos);
//            }
        }
        return minPos == Integer.MAX_VALUE ? -1 : minPos;
    }

    public static void main(String[] args) {
        System.out.println(firstUnique("loveleetcode"));
        System.out.println(firstUnique("leetcode"));
    }
}
