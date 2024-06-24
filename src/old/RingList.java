package com.dark;

import java.util.*;

/**************************************
 * Copyright (C), Navinfo
 * Package: 
 * @Author: lifan
 * @Date: Created in 2021/2/25 17:22
 * @Description:
 **************************************/
public class RingList {

    public static void main(String[] args) {

        //Node n14 = new Node(5);
        Node n13 = new Node(4);
        Node n12 = new Node(3,n13);
        Node n11 = new Node(2,n12);
        Node h1 = new Node(1,n11);

        Node n22 = new Node(4);
        Node n21 = new Node(3,n22);
        Node h2 = new Node(1,n21);

        printList(h1);
        Node node = foldList(h1);
        printList(node);
    }

    public static Node foldList(Node node){

        if(node == null){
            return null;
        }
        Node dy = new Node(-1);
        dy.next = node;
        Node fast = dy;
        Node slow = dy;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;

        }
        Node two = slow.next;
        slow.next = null;
        Node one = node;
        if(two == one){
             return node;
        }
        two = reverseList(two);
        Node dummy = new Node(-1);
        Node cur = dummy;
        while(one != null){
            cur.next = one;
            one = one.next;
            cur.next.next = two;
            two = two.next;
            cur = cur.next.next;

        }
        return dummy.next;
    }

    /**
     * 反转链表 头结点插入法
     * @param node
     * @return
     */
    public static Node reverseList(Node node){

        Node dummy = new Node(-1);
        while (node != null){
            Node tmp = dummy.next;
            dummy.next = node;
            node = node.next;
            dummy.next.next = tmp;
        }
        return dummy.next;
    }

    /**
     * 合并两个有序链表
     * @param h1
     * @param h2
     * @return
     */

    public static Node mergeSortList(Node h1,Node h2){

       if(h1 == null){
           return h2;
       }
       if(h2 == null){
           return h1;
       }
       if(h1.data < h2.data){
           h1.next = mergeSortList(h1.next, h2);
           return h1;
       }else{
           h2.next = mergeSortList(h1,h2.next);
           return h2;
       }
    }


    /**
     * 环形链表中环的初始节点
     */

    public static void ringList(){

        Node n4 = new Node(-4);
        Node n3 = new Node(0,n4);
        Node n2 = new Node(2,n3);
        Node head = new Node(3,n2);
        n4.next = n2;

        Node cur = head;
        HashSet s = new HashSet();
        while(cur != null){
            if(s.contains(cur)){
                System.out.println(cur.data);
                break;
            }
            s.add(cur);
            cur = cur.next;
        }
    }

    /**
     * 打印链表
     */
    public static void printList(Node head) {
        Node curNode = head;
        //循环遍历到尾节点
        while (curNode != null) {
            System.out.print(curNode.data + "  ");
            curNode = curNode.next;
        }
        System.out.println();
    }

    private static class Node {
        int data;

        Node next = null;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data,Node next) {
            this.data = data;
            this.next = next;
        }
    }

}



