package main.java.org.code.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * describe:
 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

 注意：答案中不可以包含重复的三元组。

 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]

 三数之和为0
 * @author lixilong
 * @date 2019/01/24
 */
public class _lc_15_ThreeSum {

//  链接：https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
//  来源：力扣（LeetCode）


  /**
   * 解法2
   *
   * 排序 + 双指针 + 去重
   * https://github.com/gaoshengnan/LeetCode/blob/master/src/main/java/highFrequencyLeetcode/leetcode_15/ThreeSum.java
   * 时间复杂度：O(n²)
   * 空间复杂度：O(n)
   */
  public static List<List<Integer>> threeSum2(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) { //范围去掉最右节点
      int left = i + 1;
      int right = nums.length - 1;
      if (nums[i] > 0) //当前元素大于0,后续组合必大于0.剪枝即可
        break;
      if (i > 0 && nums[i] == nums[i - 1])
        continue; // 去掉重复的起点，继续下一轮循环
      while (left < right) {
        int sum = nums[left] + nums[right] + nums[i];
        if (sum == 0) {
          result.add(Arrays.asList(nums[i], nums[left], nums[right])); //该次结果OK，加入结果集
          while (left < right && nums[left] == nums[left + 1]) left++; // 去掉重复的左点
          while (left < right && nums[right] == nums[right - 1]) right--; // 去掉重复的右点
          right--; left++;// 进入下一组左右点判断
        } else if (sum > 0) {
          right--; // sum>0 ,说明和过大了，需要变小，所以向左移动右边指针
        } else {
          left++; // 同理，需要变大，向右移动左指针
        }
      }
    }
    return result;
  }




  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList();
    int len = nums.length;
    if(nums == null || len < 3) return ans;
    Arrays.sort(nums); // 排序
    for (int i = 0; i < len ; i++) {
      if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
      if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
      int L = i+1;
      int R = len-1;
      while(L < R){
        int sum = nums[i] + nums[L] + nums[R];
        if(sum == 0){
          ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
          while (L<R && nums[L] == nums[L+1]) L++; // 去重
          while (L<R && nums[R] == nums[R-1]) R--; // 去重
          L++;
          R--;
        }
        else if (sum < 0) L++;
        else if (sum > 0) R--;
      }
    }
    return ans;
  }



}
