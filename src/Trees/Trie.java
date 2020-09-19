package Trees;

public class Trie {
    class Node {
        boolean isWord;
        char ch;
        Node[] chars = new Node[26];

        public Node() {
        }

        public Node(char ch) {
            this.ch = ch;
            chars = new Node[26];
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        // initialize the empty one
        root = new Node(' ');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        // cur starting at head
        // iterate over untill the children are null
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int charIdx = (int) word.charAt(i) - 'a';
            // create a new node if the one doesn't exist
            if (cur.chars[charIdx] == null) {
                cur.chars[charIdx] = new Node(c);
            }
            cur = cur.chars[charIdx];
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        // find the starting node with that character
        int start = word.charAt(0) - 'a';
        Node cur1 = root;
        // find the starting branch for the word.
        while (cur1 != null && cur1.ch - 'a' != start) {
            cur1 = cur1.chars[start];
        }
        // if the cur1 start exists in the tree
        if (cur1 != null) {
            for (int i = 1; i < word.length(); i++) {
                // move to the end of word to see if there is isword at the last char
                int c = word.charAt(i) - 'a';
                if (cur1.chars[c] == null) return false;
                cur1 = cur1.chars[c];
            }
        }
        if (cur1 != null && cur1.isWord) return true;
        else return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // finds the first letter of the word
        // move the the array element at pos wor pref second char
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.chars[c - 'a'] == null) return false;
            cur = cur.chars[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie myTrie = new Trie();
        myTrie.insert("apple");
        myTrie.insert("app");
        System.out.println("searching " + myTrie.search("app"));
        System.out.println("starts with pref " + myTrie.startsWith("app"));
    }
}


