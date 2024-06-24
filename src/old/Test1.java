package com.dark;


import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**************************************
 * Copyright (C), Navinfo
 * Package: 
 * @Author: lifan
 * @Date: Created in 2021/3/25 18:32
 * @Description:
 **************************************/
public class Test1 extends ListNode{

    public static void main(String[] args) {
        StringBuffer s = new StringBuffer();

        s.reverse().toString();

//        ListNode n5 = new ListNode(5);
//        ListNode n4 = new ListNode(4,n5);
//        ListNode n3 = new ListNode(3,n4);
//        ListNode n2 = new ListNode(2,n3);
//        ListNode n1 = new ListNode(1,n2);
//
//
//        new Test1().reverseKGroup(n1,2);

        LinkedHashMap m = new LinkedHashMap();

        m.put("123","123");
        m.put("234","234");

        HashMap mm = new HashMap();
        mm.put("","");

        ReentrantLock lock = new ReentrantLock();
        lock.lock();

    }

    public ListNode reverseKGroup (ListNode head, int k) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        flag:while(fast != null){
            printList(dummy);
            for(int i=0;i<k;i++){
                if(fast != null){
                    fast = fast.next;
                }else{
                    break flag;
                }
            }
            if(fast == null){
                break flag;
            }
            ListNode tmp = fast.next;
            fast.next = null;
            ListNode tmp1 = slow.next;
            slow.next = null;
            tmp1 = res(tmp1);
            slow.next = tmp1;
            for(int i=0;i<k;i++){
                slow = slow.next;
            }
            slow.next = tmp;
            fast = slow;
        }
        printList(dummy);
        return dummy.next;
    }

    private ListNode res(ListNode head){
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = tmp;
        }
        return dummy.next;
    }

    /**
     * 打印链表
     */
    public static void printList(ListNode head) {
        ListNode curNode = head;
        //循环遍历到尾节点
        while (curNode != null) {
            System.out.print(curNode.val + "  ");
            curNode = curNode.next;
        }
        System.out.println();
    }
}
