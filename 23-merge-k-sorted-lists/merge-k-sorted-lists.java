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
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.val));

        for(ListNode node : lists){
            if(node != null)
            pq.add(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(!pq.isEmpty()){
           ListNode minNode = pq.poll();
           tail.next = minNode;
           tail = tail.next; 

           if(minNode.next != null){
            pq.add(minNode.next);
           }
        }
        return dummy.next;
    }
}