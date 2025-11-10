package leetcode;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Problem_0019_RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode pre = null;
        boolean enough = false;
        while(cur != null){
            n--;
            if(n <= 0){
                if(n == 0){
                    enough = true;
                } else if(n == -1){
                    pre = head;
                } else {
                    pre = pre.next;
                }
            }
            cur = cur.next;
        }
        if(!enough) {
            return head;
        }
        if(pre == null){
            return head.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
