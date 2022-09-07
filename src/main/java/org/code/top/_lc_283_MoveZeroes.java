package main.java.org.code.top;

import main.java.org.code.top.util.MyArray;

import java.util.Arrays;

/**
 * describe:
 * 定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 作者：LeetCode
 *   链接：https://leetcode-cn.com/problems/move-zeroes/solution/yi-dong-ling-by-leetcode/
 *   来源：力扣（LeetCode）
 *
 * @author lixilong
 * @date 2019/10/29
 */
public class _lc_283_MoveZeroes {

  /**
   * 解法1：非零元素逐个移到前半部门，后面全部赋值为0
   */

  public void moveZeroes(int[] nums) {
    int lastNoZeroFoundAt = 0;

    for (int j = 0; j < nums.length; j++) { //将不等于 0 的元素往前移动，并同时移动 i 指针
      if (nums[j] != 0)
        nums[lastNoZeroFoundAt++] = nums[j]; //case1：第一个元素不用移动，比如203，所以i++成立
    }

    Arrays.fill(nums, lastNoZeroFoundAt, nums.length, 0); //i 之前的元素移动好的【不为 0 的元素】

  }


  /**
   * 解法2
   *
   * @param nums: 因为交换意味着0换到尾部，尾部的0先后顺序不打紧，所以可以直接换
   */
  public void moveZeroes2(int[] nums) {
    for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
      if (nums[cur] != 0) {
        MyArray.swap(nums, lastNonZeroFoundAt++, cur);
      }
    }
  }

}




