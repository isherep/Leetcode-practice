package LinkedLists;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 *
 * Example 2:
 *
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 *
 *
 *
 * Constraints:
 *
 *     The relative order inside both the even and odd groups should remain as it was in the input.
 *     The first node is considered odd, the second node even and so on ...
 *     The length of the linked list is between [0, 10^4].
 *
 */

/**
 * Definition for singly-linked list.
 *
 */
   class ListNode {
      int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class OddNodesFollowingEven {
    public ListNode oddEvenList(ListNode head) {
        // Create new node
        // first run - append all odd nodes
        // second run - all even nodes
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode oddCur = odd;
        ListNode evenCur = even;
        ListNode cur = head;
        while(cur != null){
            // add cur node to add list
            oddCur.next = cur;
            // add curs next node to even list
            if(evenCur != null){
                evenCur.next = cur.next;
                evenCur = evenCur.next;
            }
            // move current two steps forward
            if(cur.next != null){
                cur = cur.next.next;
            } else {
                cur = cur.next;
            }

            oddCur = oddCur.next;
        }

        // append even list to add
        oddCur.next = even.next;
        // get the beginning of add
        return odd.next;
    }
    // Better
    public ListNode oddEvenList1(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
