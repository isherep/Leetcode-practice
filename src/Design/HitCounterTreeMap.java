package Design;

import java.util.TreeMap;

public class HitCounterTreeMap {
    // sorted by tree map
    TreeMap<Integer, Integer> window;
    int count = 0;

    /**
     * Initialize your data structure here.
     */
    public HitCounterTreeMap() {
        window = new TreeMap<>();
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        if (window.containsKey(timestamp)) {
            window.put(timestamp, window.get(timestamp) + 1);
            count++;
            return;
        }

        removeExpiredEntries(timestamp);

        window.put(timestamp, 1);
        count++;
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        removeExpiredEntries(timestamp);
        return count;
    }

    private void removeExpiredEntries(int timestamp) {
        while (!window.isEmpty() && timestamp - window.firstKey() >= 300) {
            count -= window.get(window.firstKey());
            window.remove(window.firstKey());
        }
    }

}
