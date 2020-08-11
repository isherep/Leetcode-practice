package HashTables;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {
    HashMap<String, TreeMap<Integer, String>> timebaseMap;

    public TimeMap() {
        timebaseMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timebaseMap.putIfAbsent(key, new TreeMap<Integer, String>());
        timebaseMap.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (timebaseMap.get(key) == null) return "";
        Map.Entry<Integer, String> entry = timebaseMap.get(key).floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
