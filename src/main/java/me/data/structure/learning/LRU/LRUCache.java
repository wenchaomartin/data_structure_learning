package me.data.structure.learning.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Entry header, tail;
    Integer size;
    Map<Integer, Entry> map;

    public LRUCache(Integer capacity) {
        this.size = capacity;
        initDoubleLinked();
        map = new HashMap<>(capacity);
    }

    private void initDoubleLinked() {
        header = new Entry();
        tail = new Entry();
        header.next = tail;
        tail.previous = header;
    }

    int get(Integer key) {
        Entry node = map.get(key);
        if (node == null) return -1;
        //删除该节点
        node.previous.next = node.next;
        node.next.previous = node.previous;
        //移到最前面
        Entry temp = header.next;
        temp.previous = node;
        node.next = temp;

        header.next = node;
        node.previous = header;
        return node.value;
    }

    void put(int key, int value) {
        Entry node = map.get(key);
        if (node != null) {
            node.value = value;
            node.previous.next = node.next;
            node.next.previous = node.previous;
            //移到最前面
            Entry temp = header.next;
            temp.previous = node;
            node.next = temp;

            header.next = node;
            node.previous = header;
            return;
        }
        if (map.size() < size) {
            Entry newNode = new Entry();
            newNode.key = key;
            newNode.value = value;

            Entry temp = header.next;

            temp.previous = newNode;
            newNode.next= temp;
            header.next = newNode;
            newNode.previous=header;
            map.put(key, newNode);

        } else {
            //删除最后一个节点
            Entry temp = tail.previous;
            temp.previous.next = tail;
            tail.previous = temp.previous;
            map.remove(temp.key);

            Entry newNode = new Entry();
            newNode.key = key;
            newNode.value = value;

            Entry temp2 = header.next;
            temp2.previous = newNode;
            newNode.next= temp2;
            header.next = newNode;
            newNode.previous=header;
            map.put(key, newNode);
        }

    }


    class Entry {
        Entry previous;
        Entry next;
        Integer value;
        Integer key;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.get(2); // 缓存是 {1=1}
        lRUCache.put(2, 6); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(1, 5); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.put(1, 2);
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
//        System.out.println(lRUCache.get(3));    // 返回 3
//        System.out.println(lRUCache.get(4));    // 返回 4
    }
}
