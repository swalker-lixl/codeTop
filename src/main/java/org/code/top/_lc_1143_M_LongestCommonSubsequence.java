package main.java.org.code.top;

/**
 * describe:

 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。

 一个字符串的 子序列 是指这样一个新的字符串：
 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 例如，
 "ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。

 若这两个字符串没有公共子序列，则返回 0。

 示例 1:
 输入：text1 = "abcde", text2 = "ace"
 输出：3
 解释：最长公共子序列是 "ace"，它的长度为 3。

 示例 2:
 输入：text1 = "abc", text2 = "abc"
 输出：3
 解释：最长公共子序列是 "abc"，它的长度为 3。

 示例 3:
 输入：text1 = "abc", text2 = "def"
 输出：0
 解释：两个字符串没有公共子序列，返回 0。
  
 提示:
 1 <= text1.length <= 1000
 1 <= text2.length <= 1000
 输入的字符串只含有小写英文字符。

 * @author lixilong
 * @date 2019/11/17
 */
public class _lc_1143_M_LongestCommonSubsequence {

 /**
  * 1143
  经验，从最后一个字符看起，而不是从前面看起
  两个字符串对比问题，一般可以考虑二维数组表示，然后再按递推方程推导
  一个按行排列，一个按列排列
  */
  public int longestCommonSubsequence(String text1, String text2) {
    if (text1.isEmpty() || text2.isEmpty())
      return 0;
    int n = text1.length(), m = text2.length();
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i < m + 1; i++)
      for (int j = 0; j < n + 1; j++)
        if (text1.charAt(i - 1) == text2.charAt(j - 1))
          dp[i][j] = 1 + dp[i - 1][j - 1]; //最右一个字符相同，去掉两个字符
        else
          dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]); //最右一个字符不同，要么第一个去最后字符，要么第二个去最后字符

    return dp[m][n];
  }

}
