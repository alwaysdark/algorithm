package leetcode;

import java.util.HashMap;

public class Problem_0146_LRUCache {
    private MyCache<Integer, Integer> cache;
    
    public Problem_0146_LRUCache(int capacity) {
        cache = new MyCache<>(capacity);
    }
    public int get(int key) {
        Integer ans = cache.get(key);
        return ans == null ? -1 : ans;
    }

    public void put(int key, int value) {
        cache.set(key, value);
    }
    public static class Node<K, V>{
        private K key;
        private V value;
        Node<K, V> pre;
        Node<K, V> next;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    public static class NodeDoubleLinkedList<K, V>{
        private Node<K, V> head;
        private Node<K, V> tail;

        public NodeDoubleLinkedList(){
            head = null;
            tail = null;
        }
        public void addNode(Node<K, V> newNode){
            if (newNode == null) {
                return;
            }
            if (head == null){
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.pre = tail;
                tail = newNode;
            }
        }
        public void moveNodeToTail(Node<K, V> node){
            if(tail == node){
                return;
            }
            if(this.head == node){
                this.head = node.next;
                head.pre = null;
            }else{
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            node.pre = tail;
            node.next = null;
            tail.next = node;
            tail = node;
        }
        public Node<K, V> removeHead() {
            if(head == null){
                return null;
            }
            Node<K, V> res = head;
            if (head == tail){
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.pre = null;
                res.next = null;
            }
            return res;
        }
    }
    public static class MyCache<K, V> {
        private HashMap<K, Node<K, V>> keyNodeMap;
        private NodeDoubleLinkedList<K, V> nodeList;
        private final int capacity;
        public MyCache(int cap){
            if (cap < 1) {
                throw new RuntimeException("should be more than 0.");
            }
            keyNodeMap = new HashMap<>();
            nodeList = new NodeDoubleLinkedList<>();
            capacity = cap;
        }
        public V get(K key) {
            if (keyNodeMap.containsKey(key)){
                Node<K, V> res = keyNodeMap.get(key);
                nodeList.moveNodeToTail(res);
                return res.value;
            }
            return null;
        }
        public void set(K key, V value){
            if (keyNodeMap.containsKey(key)){
                Node<K, V> node = keyNodeMap.get(key);
                node.value = value;
                nodeList.moveNodeToTail(node);
            } else {
                if (keyNodeMap.size() == capacity){
                    removeMostUnusedCache();
                }
                Node<K, V> newNode = new Node<>(key, value);
                keyNodeMap.put(key, newNode);
                nodeList.addNode(newNode);
            }
        }
        private void removeMostUnusedCache() {
            Node<K, V> removeNode = nodeList.removeHead();
            keyNodeMap.remove(removeNode.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */