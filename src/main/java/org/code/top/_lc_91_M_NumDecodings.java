package main.java.org.code.top;

/**
 * describe:


 一条包含字母 A-Z 的消息通过以下方式进行了编码：

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 给定一个只包含数字的非空字符串，请计算解码方法的总数。

 示例 1:

 输入: "12"
 输出: 2
 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 示例 2:

 输入: "226"
 输出: 3
 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

 作者：reedfan
 链接：https://leetcode-cn.com/problems/decode-ways/solution/java-di-gui-dong-tai-gui-hua-kong-jian-ya-suo-by-r/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author lixilong
 * @date 2019/12/17
 */
public class _lc_91_M_NumDecodings {

  public int numDecodings(String s) {
    if (s == null || s.length() == 0)
        return 0;

    int len = s.length(), help = 1, res = 0;

    if (s.charAt(len - 1) != '0')
        res = 1;

    for (int i = len - 2; i >= 0; i--) {
      if (s.charAt(i) == '0') {
        help = res;
        res = 0;
        continue;
      }
      if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
        res += help; //help用来存储res以前的值
        help = res-help;
      } else {
        help = res;
      }
    }

    return res;
  }


}
