package test2024;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Xiyao Li
 * Date: 2024/2/14 1:36
 */
public class TestLRU {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {}

        public Node(int _key, int _value) {
            this.key = _key;
            this.value = _value;
        }
    }

    Node head;
    Node tail;
    int capacity;
    int size;
    Map<Integer, Node> key2NodeMap;

    public TestLRU(int capacity) {
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.capacity = capacity;
        this.size = 0;
        key2NodeMap = new HashMap<>();
    }

    public int get(int key) {
        // 查询节点是否在缓存中
        Node temp = key2NodeMap.get(key);
        // 如果在缓存中，则把节点移动到链表头部
        if(temp != null) {
            moveToHead(temp);
            return temp.value;
        }
        // 如果不在缓存中，返回-1
        return -1;

    }

    public void put(int key, int value) {
        // 查询节点是否在缓存中
        Node temp = key2NodeMap.get(key);
        // 如果在缓存中，修改value的值，把节点移动到链表头部
        if(temp != null) {
            temp.value = value;
            moveToHead(temp);
        }
        // 如果不在缓存中，创建一个新节点，插到链表头部，插入map中，size++
        else{
            Node newNode = new Node(key, value);
            addHead(newNode);
            size++;
            key2NodeMap.put(key, newNode);
            // 如果超过了capacity，会把队尾的节点给删除，size--
            if(size > capacity) {
                Node oldTail = removeTail();
                size--;
                key2NodeMap.remove(oldTail.key);
            }
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addHead(node);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addHead(Node node) {
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    }

    private Node removeTail() {
        Node oldTail = tail.prev;
        removeNode(oldTail);
        return oldTail;
    }

    public static void main(String[] args) {
        TestLRU testLRU = new TestLRU(2);
//        ["LRUCache","put","put","get","put","get","put","get","get","get"]
//        [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        testLRU.put(1, 1);
        testLRU.put(2, 2);
        System.out.println(testLRU.get(1));
    }
}
