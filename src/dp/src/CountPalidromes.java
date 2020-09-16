public class CountPalidromes {
    public int countSubstrings(String s) {

        int sLen = s.length();
        char[] cArr = s.toCharArray();
        int totalPallindromes = 0;
        int[][] dp = new int[sLen][sLen];
        // Single length pallindroms
        for (int i = 0; i < sLen; i++) {
            dp[i][i] = 1;
            totalPallindromes++;
        }

        // 2 length pallindromes
        for (int i = 0; i < sLen - 1; i++) {
            if (cArr[i] == cArr[i + 1]) {
                dp[i][i + 1] = 1;
                totalPallindromes++;
            }
        }

        // Lengtgth > 3
        //       here
        // lookup
        for (int subLen = 2; subLen < sLen; subLen++) {
            // substring start has to less than string length - sublen
            //int start = sLen-1 - subLen;
            for (int start = 0; start < sLen - subLen; start++) {
                int end = start + subLen;
                if (cArr[start] == cArr[end] && dp[start + 1][end - 1] == 1) {
                    dp[start][end] = 1;
                    totalPallindromes++;
                }
            }
        }
        return totalPallindromes;
    }
}

