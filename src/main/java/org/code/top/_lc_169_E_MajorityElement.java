package main.java.org.code.top;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * describe:
 *  题设已保证肯定有  MajorityElement
 * @author lixilong
 * @date 2019/10/25
 */
public class _lc_169_E_MajorityElement {

  public static void main(String[] args) {
    int[] nums = {5,6,8,9,2,3,4};
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }
  }


  //方法1：暴力枚举找到出现超过 唯一一个 n/2 的数字
//Time complexity : O(n^2)  Space complexity : O(1)
  public int majorityElement1(int[] nums) {
    int majorityCount = nums.length / 2;

    for (int num : nums) {
      int count = 0; //对每个元素出现的次数都计数，然后对比是否超过 常数majorityCount，超过则返回
      for (int elem : nums) {
        if (elem == num)  count += 1;
      }

      if (count > majorityCount)  return num;
    }

    return -1;
  }


  /**
   * 方法2：Boyer-Moore 投票算法
  想法
  如果我们把众数记为 +1+1 ，把其他数记为 -1−1 ，将它们全部加起来，显然和大于 0 ，从结果本身我们可以看出众数比其他数多。

  本质上， Boyer-Moore 算法就是找 nums 的一个后缀 sufsuf ，其中 suf[0]suf[0] 就是后缀中的众数。
  我们维护一个计数器，如果遇到一个我们目前的候选众数，就将计数器加一，否则减一。
  只要计数器等于 0 ，我们就将 nums 中之前访问的数字全部 忘记 ，并把下一个数字当做候选的众数。

  作者：LeetCode
  链接：https://leetcode-cn.com/problems/majority-element/solution/qiu-zhong-shu-by-leetcode-2/
  */
  //Time complexity : O(n)  Space complexity : O(1)
  public int majorityElement2(int[] nums) {
    int occurs = 0;
    Integer candidate = null;

    for (int num: nums) {
      if (occurs == 0)  candidate = num; //忘记前面众数和非众数
      occurs += (num == candidate) ? 1 : -1;
    }
    return candidate;
  }


  //方法3：排好序后，返回的中间位置的前一个数肯定是众数，因为 长度超过要 n/2
  //Time complexity : O(nlgn)  Space complexity : O(1) or (O(n)
  /*
    If the elements are sorted in monotonically increasing (or decreasing) order,
    the majority element can be found at index flower(n/2) and flower(n/2) +1 ,
    incidentally, if n is even).
  */
  public int majorityElement3(int[] nums) {
    Arrays.sort(nums);
    return nums[(nums.length-1)/2];
  }


















  //方法4：暴力枚举优化，HashMap用来计数
  //Time complexity : O(n)  Space complexity : O(n)

  public int majorityElement4(int[] nums) {
    Map<Integer, Integer> counts = countNums(nums);

    Map.Entry<Integer, Integer> majorityEntry = null;
    for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
      if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
        majorityEntry = entry;  // entry  整体赋值
      }
    }

    return majorityEntry.getKey();
  }


  private Map<Integer, Integer> countNums(int[] nums) {
    Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
    for (int num : nums) {
      if (!counts.containsKey(num)) {
        counts.put(num, 1);
      }
      else {
        counts.put(num, counts.get(num)+1);
      }
    }
    return counts;
  }


  //方法4：Divide and Conquer
  //Time complexity : O(nlgn)  Space complexity : O(lgn)

  public int majorityElement5(int[] nums) {
    return majorityElementRec(nums, 0, nums.length-1);
  }

  private int majorityElementRec(int[] nums, int lo, int hi) {
    // base case; the only element in an array of size 1 is the majority
    // element.
    if (lo == hi)  return nums[lo];

    // recurse on left and right halves of this slice.
    int mid = (hi-lo)/2 + lo;
    int left = majorityElementRec(nums, lo, mid);
    int right = majorityElementRec(nums, mid+1, hi);

    // if the two halves agree on the majority element, return it.
    if (left == right)  return left;
    // otherwise, count each element and return the "winner".
    int leftCount = countInRange(nums, left, lo, hi);
    int rightCount = countInRange(nums, right, lo, hi);

    return leftCount > rightCount ? left : right;
  }


  private int countInRange(int[] nums, int num, int lo, int hi) {
    int count = 0;
    for (int i = lo; i <= hi; i++) {
      if (nums[i] == num)   count++;
    }
    return count;
  }

}
