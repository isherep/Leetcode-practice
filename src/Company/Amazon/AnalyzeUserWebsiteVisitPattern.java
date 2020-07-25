package Company.Amazon;

import java.util.*;

/*
    https://leetcode.com/problems/analyze-user-website-visit-pattern/
    We are given some website visits: the user with name username[i] visited the website website[i] at time timestamp[i].

    A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of their visits.  (The websites in a 3-sequence are not necessarily distinct.)

    Find the 3-sequence visited by the largest number of users. If there is more than one solution, return the lexicographically smallest such 3-sequence.

    Example 1:

    Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"]
    Output: ["home","about","career"]
    Explanation:
    The tuples in this example are:
    ["joe", 1, "home"]
    ["joe", 2, "about"]
    ["joe", 3, "career"]
    ["james", 4, "home"]
    ["james", 5, "cart"]
    ["james", 6, "maps"]
    ["james", 7, "home"]
    ["mary", 8, "home"]
    ["mary", 9, "about"]
    ["mary", 10, "career"]
    The 3-sequence ("home", "about", "career") was visited at least once by 2 users.
    The 3-sequence ("home", "cart", "maps") was visited at least once by 1 user.
    The 3-sequence ("home", "cart", "home") was visited at least once by 1 user.
    The 3-sequence ("home", "maps", "home") was visited at least once by 1 user.
    The 3-sequence ("cart", "maps", "home") was visited at least once by 1 user.

    3 <= N = username.length = timestamp.length = website.length <= 50
    1 <= username[i].length <= 10
    0 <= timestamp[i] <= 10^9
    1 <= website[i].length <= 10
    Both username[i] and website[i] contain only lowercase characters.
    It is guaranteed that there is at least one user who visited at least 3 websites.
    No user visits two websites at the same time.


    1. Sort all the entries using their timestamp as we need to consider that as well.
    2. Now create a list of websites visited by particular User ( added based on timestamp order as all entries sorted in first step)
    3. Now generate 3 websites sequence for that user and generate a set to we can avoid duplicate sequence.
    4. Now calculate the frequency of each sequence
    5. Get the most used sequence

 */
public class AnalyzeUserWebsiteVisitPattern {

    static class Visit {
        String userName;
        int timestamp;
        String website;

        Visit(String u, int t, String w) {
            userName = u;
            timestamp = t;
            website = w;
        }

        Visit() {
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

        // Convert all the entry as visit object to ease of understand
        List<Visit> visitList = new ArrayList<>();
        for (int i = 0; i < username.length; i++) {

            visitList.add(new Visit(username[i], timestamp[i], website[i]));
        }

        // Sort all the visit entries using their timestamp
        Comparator<Visit> cmp = (v1, v2) -> {
            return v1.timestamp - v2.timestamp;
        };
        Collections.sort(visitList, cmp);

        //Collect list of websites for each user
        Map<String, List<String>> userWebSitesMap = new HashMap<>();
        for (Visit v : visitList) {
            userWebSitesMap.putIfAbsent(v.userName, new ArrayList<>());
            userWebSitesMap.get(v.userName).add(v.website);
        }

        Map<List<String>, Integer> seqUserFreMap = new HashMap<>();
        // Now get all the values of all the users
        for (List<String> websitesList : userWebSitesMap.values()) {
            if (websitesList.size() < 3)
                continue; // no need to consider less than 3 entries of web site visited by user
            // set of all sequences of 3 that user visited
            Set<List<String>> sequencesSet = generate3Seq(websitesList);
            // Now update the frequency of the sequence ( increment by 1 for 1 user)
            for (List<String> seq : sequencesSet) {
                seqUserFreMap.putIfAbsent(seq, 0);
                seqUserFreMap.put(seq, seqUserFreMap.get(seq) + 1);
            }
        }

        List<String> res = new ArrayList<>();
        int MAX = 0;
        // looping over map and selecting the one with max of users
        for (Map.Entry<List<String>, Integer> entry : seqUserFreMap.entrySet()) {
            if (entry.getValue() > MAX) {
                MAX = entry.getValue();
                res = entry.getKey();
            } else if (entry.getValue() == MAX) {
                // if entry string is lexiografically smaller - select it
                if (entry.getKey().toString().compareTo(res.toString()) < 0) {
                    res = entry.getKey();
                }
            }
        }
        return res;
    }

    // It will not return duplicate seq for each user that why we are using Set
    // the key here is to generate sequences and not combinations that's why need to
    // use for loop and list, so it will keep the order of insertion
    private Set<List<String>> generate3Seq(List<String> websitesList) {
        Set<List<String>> setOfListSeq = new HashSet<>();
        for (int i = 0; i < websitesList.size(); i++) {
            for (int j = i + 1; j < websitesList.size(); j++) {
                for (int k = j + 1; k < websitesList.size(); k++) {
                    /*
                        i 0 j 1 k 2
                        i 0 j 1 k 2
                        i 0 j 1 k 3
                        i 0 j 2 k 3
                        i 1 j 2 k 3
                        i 0 j 1 k 2
                     */
                    List<String> list = new ArrayList<>();
                    list.add(websitesList.get(i));
                    list.add(websitesList.get(j));
                    list.add(websitesList.get(k));
                    setOfListSeq.add(list);
                }
            }
        }
        return setOfListSeq;
    }
}
