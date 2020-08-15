package Company.Amazon;

import java.util.HashMap;

public class CopyRandomList {


    public Node copyRandomList(Node head) {

        if (head == null) return head;
        Node dummyHead = new Node(-1);
        // put node's and their randoms in the hashmap
        Node cur = head;
        System.out.println(cur.val);
        HashMap<Node, Node> map = new HashMap<>();
        while (cur != null) {
            // put original and it's clone
            map.put(cur, new Node(cur.val));
            //System.out.println(cur.val + ", ");
            cur = cur.next;
        }
        // get the cur pointer to head
        Node node = head;
        // no need to have new list head
        while (node != null) {
            // get clone = 7== [7]
            Node clone = map.get(node);// will return 7
            // now assign next and random to clone, they will be
            // find the lcone of node.random in the map
            clone.next = map.get(node.next);
            clone.random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }


    public void printList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + ", ");
            cur = cur.next;
        }
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {

        int[] arr = {7, 13, 11, 10, 1};
        CopyRandomList myList = new CopyRandomList();

        Node dumHead = new Node(-1);
        Node head = dumHead;

        for (int n : arr) {
            dumHead.next = new Node(n);
            dumHead = dumHead.next;
        }
        //head = head.next;
        Node cur = head;
        myList.printList(cur);

        Node res = myList.copyRandomList(head.next);
        myList.printList(res);

    }
}

