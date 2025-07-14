/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        for(ListNode ptr : lists){
            if(ptr != null) pq.add(ptr);
        }

        ListNode head = null, tail = null;

            while(pq.size() != 0){

                ListNode ptr = pq.remove();

                // add ptr at tail end of output.
                if(head == null){
                    head = tail = ptr;
                }else{
                    tail.next = ptr;
                    tail = tail.next;
                }

                if(ptr.next != null) pq.add(ptr.next);
            }

        return head;
    }
}