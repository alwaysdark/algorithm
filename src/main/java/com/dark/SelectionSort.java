package com.dark;

/**************************************
 * Copyright (C), Navinfo
 * Package: 
 * @Author: lifan
 * @Date: Created in 2021/2/25 13:38
 * @Description: 单链表选择排序
 **************************************/
public class SelectionSort {

    public static void main(String[] args) {

        SelectionSort sortNode = new SelectionSort();
        //链表的头指针
        Node head = null;
        //新增节点,第一次新增时需要返回头指针，用于定位链表
        head = sortNode.insertNode(2, head);
        sortNode.insertNode(5, head);
        sortNode.insertNode(4, head);
        sortNode.insertNode(3, head);
        sortNode.insertNode(1, head);

        System.out.println("排序链表前：");
        sortNode.printList(head);

        //排序链表
        sortNode.selectionSort(head);
        sortNode.printList(head);


    }

    private Node selectionSort(Node head) {

        Node cur = head;
        while(cur != null){
            Node next = cur.next;
            while(next != null){
                if(next.data < cur.data){
                    int temp = next.data;
                    next.data = cur.data;
                    cur.data = temp;
                }
                next = next.next;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 打印链表
     */
    public void printList(Node head) {
        Node curNode = head;
        //循环遍历到尾节点
        while (curNode != null) {
            System.out.print(curNode.data + "  ");
            curNode = curNode.next;
        }
        System.out.println();
    }

    /**
     * 新增节点
     * @param data
     */
    public Node insertNode(int data, Node head) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return head;
        }
        Node curNode = head;
        //循环找到当前链表的尾节点
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        //尾节点的指针指向新增加的节点
        curNode.next = node;
        return head;
    }
}


class Node {
    int data;

    Node next = null;

    public Node(int data) {
        this.data = data;
    }
}