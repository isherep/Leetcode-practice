package Company.Amazon;

import java.util.Arrays;

public class ReorderLogFiles {

    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, (a, b) -> {
            // find the start of second indetifier
            int spaceIdxA = a.indexOf(' ');
            int spaceIdxB = b.indexOf(' ');

            // get the second string
            String identASub = a.substring(spaceIdxA + 1);
            String identBSub = b.substring(spaceIdxB + 1);

            if (Character.isAlphabetic(identASub.charAt(0)) && Character.isAlphabetic(identBSub.charAt(0))) {
                // if string starting from second are equal
                if (identASub.equals(identBSub)) {
                    // case when there is a tie
                    return a.compareTo(b);
                } else {
                    return identASub.compareTo(identBSub);
                }
            } else if (Character.isAlphabetic(identASub.charAt(0)) && !Character.isAlphabetic(identBSub.charAt(0))) {
                // find which one is numeric
                //String numLog = Character.isAlphabetic(firstA) ? a : b;
                return -1;

            } else if (!Character.isAlphabetic(identASub.charAt(0)) && Character.isAlphabetic(identBSub.charAt(0))) {
                return 1;
            } else {
                return 0;
            }
        });
        return logs;
    }
}
