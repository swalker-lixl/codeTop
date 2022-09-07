package main.java.org.code.top;

import main.java.org.code.top.Template.Sort;

import java.util.PriorityQueue;

/**
 * describe:
 *  寻找第k大的数的解法：
 *
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 *
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。
 * 每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * @author lixilong
 * @date 2019/01/23
 */
public class _lc_703_KthLargest {


  //解法一：排序解决法，最粗暴，降序排序后直接找定位k-1下标元素即可。

  //解法二：保存前K个最大的值，并更新 （入新值排序后剔除K最大之外的 n * klog k）

  /**
   * 解法二：类快排解法（降序排序）
   * 如果key的位置正好等于k-1，那么问题则得到解决
   * 如果key的位置不等于k-1，可使用递归查找对应子数组。直到key的位置等于k-1，则找对问题的解。
   */
  public static int findK(int[] array, int left, int right, int k) {
    int i = Sort.partition(array, left, right);
    if (i == k - 1) {
      return array[k - 1];
    } else if (i > k - 1) {
      return findK(array, left, i - 1, k);
    } else if (i < k - 1) {
      return findK(array, i + 1, right, k);
    }
    return 0;
  }

  //解法三：非常适合内存有限，数据海量的情况. 保存前K个最大的值，并更新 （维护一个小顶堆，堆的大小始终是K  n * log k）
  //主要考察用堆的数据结构，可以避免每次排序所有数据
  PriorityQueue<Integer> q;
  int k;

  public _lc_703_KthLargest(int k, int[] nums) { //构造函数维护一个最小堆
    this.k = k;
    q = new PriorityQueue<Integer>(k); //Java中 PriorityQueue 默认就是最小堆
    for (int num : nums)
      add(num);  //不断地遍历数组中的元素，并加到队列中
  }

  public int add(int val) {
    if (q.size() < k)
      q.offer(val); //当 K——堆还没满时，直接加入即可
    else if (q.peek() < val) {
      q.poll(); //当 K——堆已满时，判断满足条件后，更新K最大堆的最小值[移除+加入]
      q.offer(val);
    }
    return q.peek();
  }




}
