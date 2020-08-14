package Company.Amazon;

/**
 * Given a string s and an int k, return all unique substrings of s of size k with k distinct characters.
 *
 * Example 1:
 *
 * Input: s = "abcabc", k = 3
 * Output: ["abc", "bca", "cab"]
 *
 * Example 2:
 *
 * Input: s = "abacab", k = 3
 * Output: ["bac", "cab"]
 *
 * Example 3:
 *
 * Input: s = "awaglknagawunagwkwagl", k = 4
 * Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
 * Explanation:
 * Substrings in order are: "wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag", "wagl"
 * "wagl" is repeated twice, but is included in the output once.
 *
 * Constraints:
 *
 *     The input string consists of only lowercase English letters [a-z]
 *     0 ≤ k ≤ 26
 */
public class SubstringsSizeKNoDupls {
    /*

    use two pointers
    // move one by one up to 3.
    // if there is no uplicates
    // when the substring lent == 3 and it does not have duplicate
    // advance j
    // after len 3 - advance i and j

    // maintain hash array and maintain counts and after advancing i -
    // clear it up and start over.



     */
}
