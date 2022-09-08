package main.java.org.code.top;

/**
 * describe:

 给定一个非负整数数组，你最初位于数组的第一个位置。
 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 判断你是否能够到达最后一个位置。

 示例 1:
 输入: [2,3,1,1,4]
 输出: true
 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。

 示例 2:
 输入: [3,2,1,0,4]
 输出: false
 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

 *
 * 作者：LeetCode
 *   链接：https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode/
 */
public class _lc_55_M_CanJump {

  /**
   这是一个动态规划问题，通常解决并理解一个动态规划问题需要以下 4 个步骤：

  利用递归回溯解决问题
  利用记忆表优化（自顶向下的动态规划）
  移除递归的部分（自底向上的动态规划）
  使用技巧减少时间和空间复杂度

  作者：LeetCode
  链接：https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode/
  来源：力扣（LeetCode）
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  //方法1：暴力搜索

  //方法2：待实现，维护一个数组，表示能否到达的状态，最后更新完毕看最右一个节点是否是 true,否则就表示无法到达
  public boolean canJump3(int[] nums) {
//    if (nums == null || nums.length < 1)
//      return false;
//
//    for (int i = 0; i < nums.length ; i++) {
//      if (nums[i] + i >= canReachable)
//        canReachable = i;
//    }
//    return canReachable == 0 ? true : false;
    return false;
  }

  //证明贪心算法可以得到最优解
  //方法3：倒序
  // 贪心算法 O(n)时间复杂度，节省状态数组存储空间
  public boolean canJump(int[] nums) {
    if (nums == null || nums.length < 1)
      return false;

    int canReachable = nums.length -1;
    for (int i = nums.length -1; i >= 0; i--) {
      if (nums[i] + i >= canReachable)
        canReachable = i;
    }
    return canReachable == 0 ? true : false;
  }

  //方法3：顺序
  //核心特性：如果一个位置能够到达，那么这个位置左侧所有位置都能到达。
  public boolean canJump2(int[] nums) {
    if (nums == null || nums.length < 1)
      return false;

    int k = 0;  //最远到达下标
    for (int i = 0; i < nums.length && k >= nums.length; i++) {
      if (i > k) return false;
      k = Math.max(k, i + nums[i]);
    }
    return true ;
  }

//
//  //方法 2：自顶向下的动态规划
//  enum Index {
//    GOOD, BAD, UNKNOWN
//  }
//
//  Index[] memo;
//
//  public boolean canJumpFromPosition(int position, int[] nums) {
//    if (memo[position] != Index.UNKNOWN) {
//      return memo[position] == Index.GOOD ? true : false;
//    }
//
//    int furthestJump = Math.min(position + nums[position], nums.length - 1);
//    for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
//      if (canJumpFromPosition(nextPosition, nums)) {
//        memo[position] = Index.GOOD;
//        return true;
//      }
//    }
//
//    memo[position] = Index.BAD;
//    return false;
//  }
//
//  public boolean canJump2(int[] nums) {
//    memo = new Index[nums.length];
//    for (int i = 0; i < memo.length; i++) {
//      memo[i] = Index.UNKNOWN;
//    }
//    memo[memo.length - 1] = Index.GOOD;
//    return canJumpFromPosition(0, nums);
//  }


}
