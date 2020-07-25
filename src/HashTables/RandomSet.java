package HashTables;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class RandomSet {
    /* Faster than 17 % solutions */
    private Set<Integer> set;
    public RandomSet(){
        this.set = new HashSet<>();
    }

    public boolean insert(int val){
        //insert only if present
        if(set.contains(val)){
            return false;
        } else {
            set.add(val);
            return true;
        }

    }

    public boolean remove(int val){
        if(set.contains(val)){
            set.remove(val);
            return true;
        } else {
            return false;
        }
    }
    // random i iterator
    public int getRandom(){
        Iterator<Integer> it = this.set.iterator();
        // get a random i from 0 to the set size
        int size = set.size();
        Random r = new Random();
        int ranIdx = r.nextInt(size);
        System.out.println(r);
        // use set iterator untill get to ranIdx
        int i = 0;
        int res = -1;
        while(it.hasNext()){
            int cur = it.next();
            if(i == ranIdx){
                res = cur;
                break;
            }
            i++;
        }
        return res;
    }

}
