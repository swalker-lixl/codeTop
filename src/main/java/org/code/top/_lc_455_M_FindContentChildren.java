package main.java.org.code.top;

import java.util.Arrays;

/**
 * describe:
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；
 * 并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * 注意：
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/assign-cookies
 *
 * @author lixilong
 * @date 2019/01/25
 */
public class _lc_455_M_FindContentChildren {
  //难度为easy自己初稿

  //难度为easy： for写法
  public int findContentChildren2(int[] g, int[] s) {
    if (s.length == 0)
      return 0; //return条件判断，加速返回

    Arrays.sort(g);
    Arrays.sort(s);
    int i = 0;
    for (int j = 0; i < g.length && j < s.length; j++) {
      if (g[i] <= s[j]) i++;
    }
    return i;
  }


  //难度为easy：while写法
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int count = 0, i = 0, j = 0;

    while (i < g.length && j < s.length) {
      if (s[j] >= g[i]) {
        count++; i++; j++;
      } else {
        j++; //无论如何，每遍历一遍，s都要向前推进一个，但是g不一定
      }
    }

    return count;
  }



}
