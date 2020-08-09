package Company.Amazon;

public class TwoStringsHR {

    static String twoStrings(String s1, String s2) {
        // find the bigger string sizes
        String bigstr = s1.length() > s2.length() ? s1 : s2;
        String smallstr = s1.length() > s2.length() ? s2 : s1;
        int bigstrSize = bigstr.length();
        int smallstrSize = smallstr.length();

        boolean string_check[] = new boolean[1000];

        for (int i = 0; i < bigstrSize; i++) {
            string_check[bigstr.charAt(i) - 'A'] = true;
        }
        // if at least one char is present in boolean array
        for (int i = 0; i < smallstrSize; i++) {
            if (string_check[smallstr.charAt(i) - 'A'] == true) {
                return "YES";
            }
        }
        return "NO";
    }

}
