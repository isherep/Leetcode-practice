package DSImplementations;

public class HashMapInteger {
    public static int INITIAL_CAPACITY = 1000000;
    private Node[] table;

    /**
     * Initialize your data structure here.
     */
    public HashMapInteger() {
        table = new Node[INITIAL_CAPACITY];

    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int hash = key;
        //  return Integer.hashCode(key) % nodes.length;}
        int index = hash % INITIAL_CAPACITY;
        Node cur = new Node(key, value, hash);
        if (table[index] == null) {
            table[index] = cur;
        } else {
            table[index] = cur;
            //table[index].next = cur;
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        Node cur = table[key];
        if (cur != null) {
            return cur.val;
            // check the node at table[index]
            // if its not present there - go to it's next
        } else {
            return -1;
        }
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        table[key] = null;
    }

    class Node {
        int key;
        int val;
        int hash;
        Node next;


        public Node(int key, int val, int hash) {
            this.key = key;
            this.val = val;
            this.hash = hash;
            this.next = null;
        }
    }
}
