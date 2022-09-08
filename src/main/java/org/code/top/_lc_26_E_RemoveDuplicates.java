package main.java.org.code.top;

/**
 * describe:
 *   作者：LeetCode
 *   链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-by-/
 *   来源：力扣（LeetCode）
 *
 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

 示例 1:

 给定数组 nums = [1,1,2],

 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

 你不需要考虑数组中超出新长度后面的元素。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 * @author lixilong
 * @date 2019/10/29
 */
public class _lc_26_E_RemoveDuplicates {


  //方法一：双指针
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] != nums[i]) { //只处理需要挪动的情况，否则i不应该增长
          nums[++i] = nums[j];//遇到相等时，跳过了j-i个重复间隔。
      }
    }
    return i + 1;
  }

  //题目是有序数组去重 优化【执行有问题】
  public int removeDuplicates2(int[] nums) {
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] != nums[i]) { //只处理需要挪动的情况，否则i不应该增长
        if (j-i>1)//遇到相等时，跳过了j-i个重复间隔。 各种case,至少得跳一个
        {
          nums[i] = nums[j];
        }
        ++i; //累加操作肯定是在for的里层，if的外层，不然else情况怎么累加呢？
      }

    }
    return i + 1;
  }

}
