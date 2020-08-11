package Design;

import java.util.LinkedList;
import java.util.Queue;

// Queue Implementation
public class HitCounter {
    class Pair {
        int time;
        int hits;

        public Pair(int time, int count) {
            this.time = time;
            this.hits = count;
        }
    }

    Queue<Pair> q;
    int count;

    public HitCounter() {
        q = new LinkedList<>();
        count = 0;
    }

    public void hit(int timestamp) {
        advance(timestamp);
        if (!q.isEmpty() && q.peek().time == timestamp) {
            q.peek().hits += 1;
        } else {
            q.offer(new Pair(timestamp, 1));
        }
        count += 1;
    }

    private void advance(int timestamp) {
        while (!q.isEmpty() && q.peek().time <= timestamp - 300) {
            count -= q.poll().hits;
        }
    }

    public int getHits(int timestamp) {
        advance(timestamp);
        return count;
    }
}
