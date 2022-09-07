package main.java.org.code.top.Template;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * describe:
 LRU Cache
 • 两个要素: 大小 、替换策略
 • Hash Table + Double LinkedList
 • O(1) 查询
 O(1) 修改、更新


 替换策略
 LFU - least frequently used
 LRU - least recently used
 Java实现在模板中

 * @author lixilong
 * @date 2019/11/28
 */
public class LRUCacheSimple {



  //  Hash Table + Double LinkedList
  private Map<Integer, Integer> map;

  public LRUCacheSimple(int capacity) {
    map = new LinkedCappedHashMap<>(capacity);
  }

  public int get(int key) {
    if(!map.containsKey(key)) { return -1; }
    return map.get(key);
  }

  public void put(int key, int value) {
    map.put(key,value);
  }


  private static class LinkedCappedHashMap<K,V> extends LinkedHashMap<K,V> {
    int maximumCapacity;
    LinkedCappedHashMap(int maximumCapacity) {
      super(16, 0.75f, true);
      this.maximumCapacity = maximumCapacity;
    }
    protected boolean removeEldestEntry(Map.Entry eldest) {
      return size() > maximumCapacity;
    }
  }
}
