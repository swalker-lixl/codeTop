package main.java.org.code.top;

/**
 * describe:
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 *
 * @author lixilong
 * @date 2019/10/29
 */
public class _lc_11_M_MaxArea {

  //方法一：暴力法 O(n^2)/O(1)
  public int maxArea(int[] height) {
    int maxarea = 0;
    for (int i = 0; i < height.length; i++)
      for (int j = i + 1; j < height.length; j++)
        maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
    return maxarea;
  }


  //方法二：双指针法 O(n)/O(1)
/**
  在每一个状态下，无论长板或短板收窄 1 格，都会导致水槽 底边宽度 −1：
  若向内移动短板，水槽的短板 min(h[i], h[j]) 可能变大，因此水槽面积 S(i, j)S(i,j) 可能增大。
  若向内移动长板，水槽的短板 min(h[i], h[j] 不变或变小，下个水槽的面积一定小于当前水槽面积。 //剪枝

  作者：jyd
  链接：https://leetcode-cn.com/problems/container-with-most-water/solution/container-with-most-water-shuang-zhi-zhen-fa-yi-do/
  来源：力扣（LeetCode）*/
  public int maxArea1(int[] height) {
    int maxarea = 0, l = 0, r = height.length - 1;
    while (l < r) {
      maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l)); //左边和右边权衡取 ，Math.min(height[l], height[r]) 去两者最低的一个
      if (height[l] < height[r]) l++; //过滤掉没用l: 遍历，不断消去不可能成为最大值的状态
      else  r--;//过滤掉没用r: 我们每次向内移动短板，所有的消去状态都不会导致丢失面积最大值 。
    }
    return maxarea;
  }

}
