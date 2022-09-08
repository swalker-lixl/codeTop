package main.java.org.code.top;

/**
 * describe:
 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

 示例:

 输入: [-2,1,-3,4,-1,2,1,-5,4],
 输出: 6
 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。


 作者：guanpengchn
 链接：https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author lixilong
 * @date 2019/01/25
 */
public class _lc_53_E_MaxSubArray {


//  方法1：动态规划
  public int maxSubArray(int[] nums) {
    int ans = nums[0];
    int sum = 0;
    for(int num: nums) {
      if(sum > 0)  sum += num; //累加
      else  sum = num; //替换

      ans = Math.max(ans, sum); //优选
    }
    return ans;
  }

/***
 *   1.暴力
 *   2.DP
 *   a.分治（子问题）max_sum(i) = Max(max_sum(i), 0) + a[i]
 *   b.状态数组定义 f[i]
 *   c.DP方程  f[i] = Max(f[i-1],0) + a[i]
 *
 */

  //方法1：加注释说明
  //Time complexity : O(nlgn)  Space complexity : O(lgn)
  public int maxSubArray1(int[] nums) {
    int sum = nums[0], maxOfAll = nums[0]; //初始化
    for (int i = 1; i < nums.length; i++) {
      if (sum >= 0) { //二分
        sum += nums[i];
      } else {
        sum = nums[i];
      }
      maxOfAll = Math.max(sum, maxOfAll);
    }
    return maxOfAll;
  }

  //方法2：对方法1的优化,优化在哪里？
  //Time complexity : O(nlgn)  Space complexity : O(lgn)
  public int maxSubArray2(int[] nums) {
    int max = Integer.MIN_VALUE, sum = 0;
    for(int i : nums){
      sum = sum + i;
      max = Math.max(max, sum);
      if(sum < 0)  sum = 0;
    }

    return max;
  }

}
