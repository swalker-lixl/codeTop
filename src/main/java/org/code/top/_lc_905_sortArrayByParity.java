package main.java.org.code.top;

/**
 * describe:
 给定一个非负整数数组 A，返回一个数组，


 在该数组中， A 的所有偶数元素之后跟着所有奇数元素。

 你可以返回满足此条件的任何数组作为答案。

  

 示例：

 输入：[3,1,2,4]
 输出：[2,4,3,1]
 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。

 * @author lixilong
 * @date 2019/12/29
 */
public class _lc_905_sortArrayByParity {


//  复杂度分析
//
//  时间复杂度：O(N)O(N)，其中 NN 是 A 的长度。
//  空间复杂度：O(N)O(N)，存储结果的数组。
    public int[] sortArrayByParity(int[] A) {
      int[] ans = new int[A.length];
      int t = 0;

      for (int i = 0; i < A.length; ++i)
        if (A[i] % 2 == 0)
          ans[t++] = A[i];

      for (int i = 0; i < A.length; ++i)
        if (A[i] % 2 == 1)
          ans[t++] = A[i];

      return ans;
    }

/*
  方法 3：原地算法
  4 种情况针对 (A[i] % 2, A[j] % 2)：

  如果是 (0, 1)，那么万事大吉 i++ 并且 j--。
  如果是 (1, 0)，那么交换两个元素，然后继续。
  如果是 (0, 0)，那么说明 i 位置是正确的，只能 i++。
  如果是 (1, 1)，那么说明 j 位置是正确的，只能 j--。
*/

  public int[] sortArrayByParity2(int[] A) {
    int i = 0, j = A.length - 1;
    while (i < j) {
      if (A[i] % 2 > A[j] % 2) {
        int tmp = A[i]; A[i] = A[j]; A[j] = tmp;
      }

      if (A[i] % 2 == 0) i++;
      if (A[j] % 2 == 1) j--;
    }

    return A;
  }

//  作者：LeetCode
//  链接：https://leetcode-cn.com/problems/sort-array-by-parity/solution/an-qi-ou-pai-xu-shu-zu-by-leetcode/
//  来源：力扣（LeetCode）
//  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



}
