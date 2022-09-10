package main.java.org.code.top;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *
 *
 *
 * @author lixilong
 * @date 2019/11/25
 */
public class _lc_1091_M_ShortestPathBinaryMatrix {
//解法
//    Dp

//    BFS
private class State {
  int i;
  int j;

  public State(int i, int j) {
    this.i = i;
    this.j = j;
  }
}

  static final int[][] direc = new int[][]{{1,0},{-1,0},{1,1},{-1,1}, {0,1},{1,-1},{-1,-1},{0,-1}};

  public int shortestPathBinaryMatrix(int[][] grid) {
    if (grid.length == 0) {
      return -1;
    }

    if (grid.length == 1) {
      return grid[0][0] == 0 ? 1 : -1;
    }

    final int N = grid.length;

    if ((grid[0][0] == 1) || (grid[N-1][N-1] == 1)) {
      return -1;
    }

    List<State> startSta = new ArrayList<>(N*N);
    List<State> endSta = new ArrayList<>(N*N);
    startSta.add(new State(0, 0));
    endSta.add(new State(N-1, N-1));

    boolean[][] visited = new boolean[N][N];
    visited[0][0] = true;
    visited[N-1][N-1] = true;

    boolean[][] startVisited = new boolean[N][N];
    boolean[][] endVisited = new boolean[N][N];
    startVisited[0][0] = true;
    endVisited[N-1][N-1] = true;

    int len = 1;

    while (!startSta.isEmpty() && !endSta.isEmpty()) {

      if (startSta.size() > endSta.size()) {
        List<State> tmp = startSta; startSta = endSta; endSta = tmp;
        boolean[][] tmpA = startVisited; startVisited = endVisited; endVisited = tmpA;
      }

      List<State> newStaSet = new ArrayList<>();
      for (State curSta : startSta) {
        int i = curSta.i, j = curSta.j;
        for (int[] pos : direc) {
          int new_i = i + pos[0], new_j = j + pos[1];
          if (new_i >= 0 && new_i < N && new_j >= 0 && new_j < N && grid[new_i][new_j] == 0) {
            State newSta = new State(new_i, new_j);

            if (endVisited[newSta.i][newSta.j]) {
              return len + 1;
            }

            if (visited[newSta.i][newSta.j]) {
              continue;
            }

            newStaSet.add(newSta);
            visited[newSta.i][newSta.j] = true;
            startVisited[newSta.i][newSta.j] = true;
          }
        }
      }

      startSta = newStaSet;
      len++;
    }

    return -1;
  }

  /*作者：hao-shou-bu-juan
  链接：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/solution/java-shuang-xiang-bfs-ji-bai-100-by-hao-shou-bu-ju/
  来源：力扣（LeetCode）
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

  /**
   int[][] directions = new int[][]{{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};

   public int shortestPathBinaryMatrix(int[][] grid) {
   if(grid == null || grid.length == 0) return -1;
   if(grid[0][0] == 1) return -1;

   Queue<int[]> q = new LinkedList<>();
   boolean[][] visited = new boolean[grid.length][grid[0].length];

   q.offer(new int[]{0,0,1});
   visited[0][0] = true;

   int rowTarget = grid.length - 1;
   int colTarget = grid[0].length - 1;

   while(!q.isEmpty()) {
   int[] current = q.poll();

   int row = current[0];
   int col = current[1];
   int currentDistance = current[2];

   if(row == rowTarget && col == colTarget) {
   return currentDistance;
   }

   for(int[] d : directions) {
   int nextRow = d[0] + row;
   int nextCol = d[1] + col;
   if(nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[nextRow].length
   && !visited[nextRow][nextCol] && grid[nextRow][nextCol] == 0) {
   q.offer(new int[]{nextRow, nextCol, currentDistance + 1});
   visited[nextRow][nextCol] = true;
   }
   }
   }

   return -1;
   }
   */

//    A*

}
