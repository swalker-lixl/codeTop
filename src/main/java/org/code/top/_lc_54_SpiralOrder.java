package main.java.org.code.top;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:

 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

 示例 1:

 输入:
 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 输出: [1,2,3,6,9,8,7,4,5]
 示例 2:

 输入:
 [
 [1, 2, 3, 4],
 [5, 6, 7, 8],
 [9,10,11,12]
 ]
 输出: [1,2,3,4,8,12,11,10,9,5,6,7]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/spiral-matrix
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 * @author lixilong
 * @date 2019/12/16
 */
public class _lc_54_SpiralOrder {


  public static void main(String[] args) {
    int[][] matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    //预期结果: [1,2,3,6,9,8,7,4,5]
    _lc_54_SpiralOrder spiralOrder = new _lc_54_SpiralOrder();
    System.out.println(spiralOrder.spiralOrder(matrix));
  }

/**
 *
 * 作者：LeetCode
  链接：https://leetcode-cn.com/problems/spiral-matrix/solution/luo-xuan-ju-zhen-by-leetcode/
  来源：力扣（LeetCode）
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

  public List<Integer> spiralOrder(int[][] matrix) {
    List ans = new ArrayList();
    if (matrix.length == 0)
      return ans;
    int r1 = 0, r2 = matrix.length - 1; //行
    int c1 = 0, c2 = matrix[0].length - 1; //列

    while (r1 <= r2 && c1 <= c2) {
      for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]); //相等的场景也加在首次遍历
      for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);  //绕过r1行，免重复
      if (r1 < r2 && c1 < c2) {
        for (int c = c2-1; c > c1; c--) ans.add(matrix[r2][c]); //绕过c2 免重复
        for (int r = r2; r > r1; r--) ans.add(matrix[r][c1]); //绕过r1免重复
      }
      r1++; r2--;
      c1++; c2--;
    }
    return ans;
  }
}
