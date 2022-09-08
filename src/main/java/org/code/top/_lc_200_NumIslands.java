package main.java.org.code.top;

/**
 * describe:
 *
 *
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 *
 * @author lixilong
 * @date 2019/11/02
 */
public class _lc_200_NumIslands {


  // 递归方式1：Runtime: 3 ms, faster than 100.00%
  private static int n;
  private static int m;

  /**
   *
   * 方法1：DFS
   *
   * 直觉
   *
   * 将二维网格看成一个无向图，竖直或水平相邻的 1 之间有边。
   *
   * 算法
   *
   * 线性扫描整个二维网格，如果一个结点包含 1，则以其为根结点启动深度优先搜索。
   * 在深度优先搜索过程中，每个访问过的结点被标记为 0。计数启动深度优先搜索的根结点的数量，即为岛屿的数量。
   *
   * 作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/number-of-islands/solution/dfs-bfs-bing-cha-ji-python-dai-ma-java-dai-ma-by-l/
   *
   * */

  //解法有问题
  public static int numIslands(char[][] grid) {
    int count = 0, n = grid.length;
    if (n == 0) return 0;
    m = grid[0].length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++){
        if (grid[i][j] == '1') {
          DFSMarking(grid, i, j);
          ++count;
        }
      }
    }

    return count;
  }

  //填岛操作
  private static void DFSMarking(char[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
    grid[i][j] = '0';
    DFSMarking(grid, i + 1, j);
    DFSMarking(grid, i - 1, j);
    DFSMarking(grid, i, j + 1);
    DFSMarking(grid, i, j - 1);
  }


  // 深度优先： Runtime: 3 ms, faster than 100.00%

  // 并查集： Runtime: 3 ms, faster than 100.00%
  public static void main(String[] args) {
    char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };

    System.out.println(numIslands(grid));
  }

}
