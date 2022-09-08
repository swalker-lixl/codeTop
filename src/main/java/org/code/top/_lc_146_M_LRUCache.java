package main.java.org.code.top;

import java.util.Hashtable;

/**
 * describe:
 *
 *   作者：labuladong
 *   链接：https://leetcode-cn.com/problems/lru-cache/solution/lru-ce-lue-xiang-jie-he-shi-xian-by-labuladong/

 146. LRU缓存机制
 *
 * @author lixilong
 * @date 2019/01/26
 */
public class _lc_146_M_LRUCache {

//  实现思路: 哈希表 + 双向链表

  private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
  private int size; ////LRU 队列当前时刻大小
  private int capacity; //LRU 队列初始化长度
  private DLinkedNode head, tail;

  public _lc_146_M_LRUCache(int capacity) {
    this.size = 0;
    this.capacity = capacity;

    head = new DLinkedNode(); // head.prev = null;
    tail = new DLinkedNode(); // tail.next = null;

    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    DLinkedNode node = cache.get(key);
    if (node == null) return -1;

    moveToHead(node); // move the accessed node to the head;

    return node.value;
  }

  public void put(int key, int value) {
    DLinkedNode node = cache.get(key);

    if(node == null) {
      DLinkedNode newNode = new DLinkedNode();
      newNode.key = key; newNode.value = value;

      cache.put(key, newNode); addNode(newNode); //存储后，并入队

      ++size;

      if(size > capacity) { // pop the tail
        DLinkedNode tail = popTail(); cache.remove(tail.key); //存储删除后，并移出队
        --size;
      }
    } else {
      // update the value.
      node.value = value;
      moveToHead(node);
    }
  }


  private void addNode(DLinkedNode node) {
    /**
     * Always add the new node right after head.
     */
    node.prev = head;
    node.next = head.next;

    head.next.prev = node;
    head.next = node;
  }

  private void removeNode(DLinkedNode node){
    /**
     * Remove an existing node from the linked list.
     */
    DLinkedNode prev = node.prev;
    DLinkedNode next = node.next;

    prev.next = next;
    next.prev = prev;
  }

  private void moveToHead(DLinkedNode node){
    /**
     * Move certain node in between to the head.
     */
    removeNode(node);
    addNode(node);
  }

  private DLinkedNode popTail() {
    /**
     * Pop the current tail.
     */
    DLinkedNode res = tail.prev;
    removeNode(res);
    return res;
  }
}



class DLinkedNode {
  int key;
  int value;
  DLinkedNode prev;
  DLinkedNode next;
}


/**
 * LRUCache 对象会以如下语句构造和调用:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
作者：LeetCode
链接：https://leetcode-cn.com/problems/lru-cache/solution/lru-huan-cun-ji-zhi-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

