package main.java.org.code.top;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * describe:
 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.

 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.

 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。

 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。

 示例：

 输入：board = [[1,2,3],[4,0,5]]
 输出：1
 解释：交换 0 和 5 ，1 步完成
 输入：board = [[1,2,3],[5,4,0]]
 输出：-1
 解释：没有办法完成谜板
 输入：board = [[4,1,2],[5,0,3]]
 输出：5
 解释：
 最少完成谜板的最少移动次数是 5 ，


 一种移动路径:
 尚未移动: [[4,1,2],[5,0,3]]
 移动 1 次: [[4,1,2],[0,5,3]]
 移动 2 次: [[0,1,2],[4,5,3]]
 移动 3 次: [[1,0,2],[4,5,3]]
 移动 4 次: [[1,2,0],[4,5,3]]
 移动 5 次: [[1,2,3],[4,5,0]]
 输入：board = [[3,2,4],[1,5,0]]
 输出：14

 * @author lixilong
 * @date 2019/11/24
 */
public class _lc_773_H_SlidingPuzzle {

//  解法
//  BFS
 /* queue = collections.deque([(start, 0)])
  seen = {start}
  while queue:
    node, depth = queue.popleft()
        if node == target: return depth
      for nei in neighbors(node):
        if nei not in seen:
        seen.add(nei)
        queue.append((nei, depth+1))

  作者：LeetCode
  链接：https://leetcode-cn.com/problems/sliding-puzzle/solution/hua-dong-mi-ti-by-leetcode/
  来源：力扣（LeetCode）
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

 public int slidingPuzzle(int[][] board) {
   int R = board.length, C = board[0].length;
   int sr = 0, sc = 0;
   search:
   for (sr = 0; sr < R; sr++)
     for (sc = 0; sc < C; sc++)
       if (board[sr][sc] == 0)
         break search;

   int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
   Queue<Node1> queue = new ArrayDeque();
   Node1 start = new Node1(board, sr, sc, 0);
   queue.add(start);

   Set<String> seen = new HashSet();
   seen.add(start.boardstring);

   String target = Arrays.deepToString(new int[][]{{1,2,3}, {4,5,0}});

   while (!queue.isEmpty()) {
     Node1 node = queue.remove();
     if (node.boardstring.equals(target))
       return node.depth;

     for (int[] di: directions) {
       int nei_r = di[0] + node.zero_r;
       int nei_c = di[1] + node.zero_c;

       if ((Math.abs(nei_r - node.zero_r) + Math.abs(nei_c - node.zero_c) != 1) ||
           nei_r < 0 || nei_r >= R || nei_c < 0 || nei_c >= C)
         continue;

       int[][] newboard = new int[R][C];
       int t = 0;
       for (int[] row: node.board)
         newboard[t++] = row.clone();
       newboard[node.zero_r][node.zero_c] = newboard[nei_r][nei_c];
       newboard[nei_r][nei_c] = 0;

       Node1 nei = new Node1(newboard, nei_r, nei_c, node.depth+1);
       if (seen.contains(nei.boardstring))
         continue;
       queue.add(nei);
       seen.add(nei.boardstring);
     }
   }

   return -1;
 }


  //  DFS
  //  A.com
  public int slidingPuzzle2(int[][] board) {
    int R = board.length, C = board[0].length;
    int sr = 0, sc = 0;

    //Find sr, sc
    search:
    for (sr = 0; sr < R; sr++)
      for (sc = 0; sc < C; sc++)
        if (board[sr][sc] == 0)
          break search;

    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    PriorityQueue<Node_Ap> heap = new PriorityQueue<Node_Ap>((a, b) ->
        (a.heuristic + a.depth) - (b.heuristic + b.depth));
    Node_Ap start = new Node_Ap(board, sr, sc, 0);
    heap.add(start);

    Map<String, Integer> cost = new HashMap();
    cost.put(start.boardstring, 9999999);

    String target = Arrays.deepToString(new int[][]{{1,2,3}, {4,5,0}});
    String targetWrong = Arrays.deepToString(new int[][]{{1,2,3}, {5,4,0}});

    while (!heap.isEmpty()) {
      Node_Ap node = heap.poll();
      if (node.boardstring.equals(target))
        return node.depth;
      if (node.boardstring.equals(targetWrong))
        return -1;
      if (node.depth + node.heuristic > cost.get(node.boardstring))
        continue;

      for (int[] di: directions) {
        int nei_r = di[0] + node.zero_r;
        int nei_c = di[1] + node.zero_c;

        // If the neighbor is not on the board or wraps incorrectly around rows/cols
        if ((Math.abs(nei_r - node.zero_r) + Math.abs(nei_c - node.zero_c) != 1) ||
            nei_r < 0 || nei_r >= R || nei_c < 0 || nei_c >= C)
          continue;

        int[][] newboard = new int[R][C];
        int t = 0;
        for (int[] row: node.board)
          newboard[t++] = row.clone();

        // Swap the elements on the new board
        newboard[node.zero_r][node.zero_c] = newboard[nei_r][nei_c];
        newboard[nei_r][nei_c] = 0;

        Node_Ap nei = new Node_Ap(newboard, nei_r, nei_c, node.depth+1);
        if (nei.depth + nei.heuristic >= cost.getOrDefault(nei.boardstring, 9999999))
          continue;
        heap.add(nei);
        cost.put(nei.boardstring, nei.depth + nei.heuristic);
      }
    }

    return -1;
  }
}


class Node1 {

  int[][] board;
  String boardstring;
  int zero_r;
  int zero_c;
  int depth;

  Node1(int[][] B, int r, int c, int d) {
    board = B;
    boardstring = Arrays.deepToString(board);
    zero_r = r;
    zero_c = c;
    depth = d;
  }
}


class Node_Ap {

  int[][] board;
  String boardstring;
  int heuristic;
  int zero_r;
  int zero_c;
  int depth;

  Node_Ap(int[][] B, int zr, int zc, int d) {
    board = B;
    boardstring = Arrays.deepToString(board);

    //Calculate heuristic
    heuristic = 0;
    int R = B.length, C = B[0].length;
    for (int r = 0; r < R; ++r) {
      for (int c = 0; c < C; ++c) {
        if (board[r][c] == 0) {
          continue;
        }
        int v = (board[r][c] + R * C - 1) % (R * C);
        // v/C, v%C: where board[r][c] should go in a solved puzzle
        heuristic += Math.abs(r - v / C) + Math.abs(c - v % C);
      }
    }
    heuristic /= 2;
    zero_r = zr;
    zero_c = zc;
    depth = d;
  }
}
