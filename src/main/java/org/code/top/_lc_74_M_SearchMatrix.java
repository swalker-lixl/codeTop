package main.java.org.code.top;

/**
 * describe:
 * 写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 *
 * @author lixilong
 * @date 2019/11/03
 */
public class _lc_74_M_SearchMatrix {


    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        // 二分查找
        // 注意到输入的 m x n 矩阵可以视为长度为 m x n的有序数组。
        // 虚数组 和 二位矩阵的转换
        // row = idx // n ， col = idx % n。

        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];  // 行坐标：pivotIdx / n   列坐标：pivotIdx % n
            if (target == pivotElement) return true;
            else {
                if (target < pivotElement) right = pivotIdx - 1; //有序找值用二分查找
                else left = pivotIdx + 1;
            }
        }

        return false;
    }


}
