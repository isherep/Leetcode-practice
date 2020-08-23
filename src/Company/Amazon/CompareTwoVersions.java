package Company.Amazon;

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 * <p>
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * <p>
 * The . character does not represent a decimal point and is used to separate number sequences.
 * <p>
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * <p>
 * You may assume the default revision number for each level of a version number to be 0. For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level revision number are both 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 * <p>
 * Example 2:
 * <p>
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 * <p>
 * Example 3:
 * <p>
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * Output: -1
 * <p>
 * Example 4:
 * <p>
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
 * <p>
 * Example 5:
 * <p>
 * Input: version1 = "1.0", version2 = "1.0.0"
 * Output: 0
 * Explanation: The first version number does not have a third level revision number, which means its third level revision number is default to "0"
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * Version strings are composed of numeric strings separated by dots . and this numeric strings may have leading zeroes.
 * Version strings do not start or end with dots, and they will not be two consecutive dots.
 */
public class CompareTwoVersions {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version1.length() < 1) return -1;
        if (version2 == null || version2.length() < 1) return 1;
        // if both strings are null or empty
        if ((version1 == null && version2 == null) || (version1.length() < 1 && version2.length() < 1)) return 0;
        // first compare strings untill one of them end
        // return when you find one number that is different from other
        // if version 1 number > version 2 number - return 1 else -1
        // if after ending the loop no difference found :
        // if version2 ended but v1 not - return 1
        // but if version v1 remaining are all 0 - return 0
        // if version1 ended but not v2 return -1
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        System.out.println("str1 length " + str1.length);

        int i = 0;
        int j = 0;
        int res = 0;
        while (i < str1.length && j < str2.length) {
            if (Integer.parseInt(str1[i]) > Integer.parseInt(str2[j])) {
                res = 1;
                break;
            }
            if (Integer.parseInt(str1[i]) < Integer.parseInt(str2[j])) {
                res = -1;
                break;
            }
            //else return 0;
            i++;
            j++;
        }
        if (i <= str1.length && res == 0) {
            while (i < str1.length) {
                if (Integer.parseInt(str1[i]) != 0) {
                    return 1;
                }
                i++;
            }
        }
        // maybe it's better to check if str1[i] == null and str2[j]
        if (j <= str2.length && res == 0) {
            while (j < str2.length) {
                if (Integer.parseInt(str2[j]) != 0) {
                    return -1;
                }
                j++;
            }
        }
        System.out.println("i " + i + "j " + j);
        return res;
    }
}
