package main.java.org.code.top;

import java.util.Arrays;

/**
 * describe:
 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。

 你需要返回给定数组中的重要翻转对的数量。

 示例 1:

 输入: [1,3,2,3,1]
 输出: 2

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-pairs
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 * @author lixilong
 * @date 2019/11/25
 */
public class _lc_493_ReversePairs {

  //： 方法1掌握，看懂
  public int reversePairs(int[] nums) {
    return mergeSort(nums, 0, nums.length - 1);
  }

  private int mergeSort(int[] nums, int left,int right) {
    if (left >= right) return 0;
    int mid = left + ((right - left) >> 1);
    int cnt = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

    for (int i = left, j = mid + 1; i <= mid; i++) { //统计左右两序列
      while (j <= right && (nums[i] >> 1) > nums[j]) {
        j++;
      }
      cnt += j - (mid + 1);
    }

    Arrays.sort(nums, left, right + 1);
    return cnt;
  }



//  标准的归并排序思路

  public int reversePairs2(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    return mergeSort2(nums, 0, nums.length - 1);
  }

  private int mergeSort2(int[] nums, int l,int r) {
    if (l >= r) return 0;
    int mid = l + ((r - l) >> 1);
    int cnt = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);
    int[] cache = new int[r-l+1];
    int i = l, t = l, c = 0;
    for (int j = mid+1; j <=r; j++, c++) {
      while (i <= mid && nums[i] <= 2 * (long) nums[j]) j++; //统计左右两序列
      while (t <= mid && nums[t] < 2 * (long) nums[j]) cache[c++] = nums[t++]; //统计左右两序列
      cache[c]= nums[i];
      cnt += mid -i + 1;
    }
    while (t<=mid) cache[c++] = nums[t++];
    System.arraycopy(cache,0,nums,l,r-1+1);
    return cnt;
  }




}
