package main.java.org.code.top;

import java.util.Arrays;

/**
 * describe:
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * @author lixilong
 * @date 2019/10/29
 */
public class _lc_88_Merge {


  //方法一 : 合并后排序
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    System.arraycopy(nums2, 0, nums1, m, n);
    Arrays.sort(nums1);
  }


  //方法二 : 双指针 / 从前往后
  public void merge2(int[] nums1, int m, int[] nums2, int n) {
    // Make a copy of nums1.
    int [] nums1_copy = new int[m];

    System.arraycopy(nums1, 0, nums1_copy, 0, m); // 得到 nums1_copy 为num1的初始值

    int p1 = 0; int p2 = 0; // Two get pointers for nums1_copy and nums2.
    int p = 0;     // Set pointer for nums1

    while ((p1 < m) && (p2 < n))
      nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];


    if (p1 < m) // 任然剩余num1的部分
      System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2); //nums1是目标数组
    if (p2 < n) // 任然剩余num1的部分
      System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2); //nums1是目标数组
  }


  public void merge3(int[] nums1, int m, int[] nums2, int n) {
    // two get pointers for nums1 and nums2
    int p1 = m - 1;
    int p2 = n - 1;
    // set pointer for nums1
    int p = m + n - 1;

    // while there are still elements to compare
    while ((p1 >= 0) && (p2 >= 0))
      nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--]; //从后往前来，就不需要额外空间存临时数组了

    // add missing elements from nums2
    System.arraycopy(nums2, 0, nums1, 0, p2 + 1); //题设条件下num1长度默认不小于nums2
  }

 /* 作者：LeetCode
  链接：https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetcode/
  来源：力扣（LeetCode）
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
