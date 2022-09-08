package main.java.org.code.top;

import java.util.HashSet;
import java.util.Set;

/**
 * describe:
 *
 * @author lixilong
 *
 *给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。
 *
 * 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
 *
 * 你能在O(n)的时间解决这个问题吗？
 *
 * 示例:
 *
 * 输入: [3, 10, 5, 25, 2, 8]
 *
 * 输出: 28
 *
 * 解释: 最大的结果是 5 ^ 25 = 28.
 *
 *
 * @date 2019/11/16
 */
public class _lc_421_M_FindMaximumXOR {

  // 先确定高位，再确定低位（有点贪心算法的意思），才能保证这道题的最大性质
  // 一位接着一位去确定这个数位的大小
  // 利用性质： a ^ b = c ，则 a ^ c = b，且 b ^ c = a

  public static int findMaximumXOR(int[] nums) {
    int res = 0;
    int mask = 0;
    for (int i = 31; i >= 0; i--) {
      // 注意点1：注意保留前缀的方法，mask 是这样得来的
      // 用异或也是可以的 mask = mask ^ (1 << i);
      mask = mask | (1 << i);

      // System.out.println(Integer.toBinaryString(mask));
      Set<Integer> set = new HashSet<>();
      for (int num : nums) {
        // 注意点2：这里使用 & ，保留前缀的意思（从高位到低位）
        set.add(num & mask);
      }

      // 这里先假定第 n 位为 1 ，前 n-1 位 res 为之前迭代求得
      int temp = res | (1 << i);
      for (Integer prefix : set) {
        if (set.contains(prefix ^ temp)) {
          res = temp;
          break;
        }
      }

    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = {3, 10, 5, 25, 2, 8};
    int maximumXOR = findMaximumXOR(nums);
    System.out.println(maximumXOR);
  }


}
