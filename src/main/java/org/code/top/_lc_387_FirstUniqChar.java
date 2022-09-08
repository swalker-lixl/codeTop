package main.java.org.code.top;

/**
 * describe:

 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

 案例:

 s = "leetcode"
 返回 0.

 s = "loveleetcode",
 返回 2.
  

 注意事项：您可以假定该字符串只包含小写字母。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


 * @author lixilong
 * @date 2019/12/08
 */
public class _lc_387_FirstUniqChar {


  //      第一次遍历字符串求得各字符出现次数.
  //      第二次遍历字符串找出第一个出现次数为1的字符.

    public static int firstUniqChar(String s) {
      int[] letter=new int[26];//存储各字符出现次数
      for (char c:s.toCharArray())//第一次遍历
        letter[c-'a']++;
      for (int i = 0; i <s.length() ; i++) {//第二次遍历
        if(letter[s.charAt(i)-'a']==1) return i;
      }
      return -1;//无解
    }

}
