package main.java.org.code.top;

/**
 * describe:
 *
 *
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 *
 *
 *  python版本：python，set+回溯超过95%
 *
 *   def solveSudoku(self, board: List[List[str]]) -> None:
 *         row = [set(range(1, 10)) for _ in range(9)]  # 行剩余可用数字
 *         col = [set(range(1, 10)) for _ in range(9)]  # 列剩余可用数字
 *         block = [set(range(1, 10)) for _ in range(9)]  # 块剩余可用数字
 *
 *         empty = []  # 收集需填数位置
 *         for i in range(9):
 *             for j in range(9):
 *                 if board[i][j] != '.':  # 更新可用数字
 *                     val = int(board[i][j])
 *                     row[i].remove(val)
 *                     col[j].remove(val)
 *                     block[(i // 3)*3 + j // 3].remove(val)
 *                 else:
 *                     empty.append((i, j))
 *
 *         def backtrack(iter=0):
 *             if iter == len(empty):  # 处理完empty代表找到了答案
 *                 return True
 *             i, j = empty[iter]
 *             b = (i // 3)*3 + j // 3
 *             for val in row[i] & col[j] & block[b]:
 *
 *                 row[i].remove(val)
 *                 col[j].remove(val)
 *                 block[b].remove(val)
 *
 *                 board[i][j] = str(val)
 *                 if backtrack(iter+1):
 *                     return True
 *                 row[i].add(val)  # 回溯
 *                 col[j].add(val)
 *                 block[b].add(val)
 *             return False
 *
 *         backtrack()
 *
 * 作者：yybeta
 * 链接：https://leetcode-cn.com/problems/sudoku-solver/solution/pythonsethui-su-chao-guo-95-by-mai-mai-mai-mai-zi/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author lixilong
 * @date 2019/01/26
 */
public class _lc_37_RolveSudoku {

  public void solveSudoku(char[][] board) {
    // 三个布尔数组 表明 行, 列, 还有 3*3 的方格的数字是否被使用过
    boolean[][] rowUsed = new boolean[9][10];
    boolean[][] colUsed = new boolean[9][10];
    boolean[][][] boxUsed = new boolean[3][3][10];
    // 初始化
    for(int row = 0; row < board.length; row++){
      for(int col = 0; col < board[0].length; col++) {
        int num = board[row][col] - '0';
        if(1 <= num && num <= 9){
          rowUsed[row][num] = true;
          colUsed[col][num] = true;
          boxUsed[row/3][col/3][num] = true;
        }
      }
    }
    // 递归尝试填充数组
    recusiveSolveSudoku(board, rowUsed, colUsed, boxUsed, 0, 0);
  }

  private boolean recusiveSolveSudoku(char[][]board, boolean[][]rowUsed, boolean[][]colUsed, boolean[][][]boxUsed, int row, int col){
    // 边界校验, 如果已经填充完成, 返回true, 表示一切结束
    if(col == board[0].length){
      col = 0;
      row++;
      if(row == board.length){
        return true;
      }
    }
    // 是空则尝试填充, 否则跳过继续尝试填充下一个位置
    if(board[row][col] == '.') {
      // 尝试填充1~9
      for(int num = 1; num <= 9; num++){
        boolean canUsed = !(rowUsed[row][num] || colUsed[col][num] || boxUsed[row/3][col/3][num]);
        if(canUsed){
          rowUsed[row][num] = true;
          colUsed[col][num] = true;
          boxUsed[row/3][col/3][num] = true;

          board[row][col] = (char)('0' + num);
          if(recusiveSolveSudoku(board, rowUsed, colUsed, boxUsed, row, col + 1)){
            return true;
          }
          board[row][col] = '.';

          rowUsed[row][num] = false;
          colUsed[col][num] = false;
          boxUsed[row/3][col/3][num] = false;
        }
      }
    } else {
      return recusiveSolveSudoku(board, rowUsed, colUsed, boxUsed, row, col + 1);
    }
    return false;
  }

//  作者：I_use_python
//  链接：https://leetcode-cn.com/problems/sudoku-solver/solution/hui-su-fa-jie-shu-du-by-i_use_python/
//  来源：力扣（LeetCode）
//  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


}
