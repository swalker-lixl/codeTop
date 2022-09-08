package main.java.org.code.top;

import java.util.PriorityQueue;

/**
 * describe:
 * describe:
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * @author lixilong
 * @author lixilong
 * @date 2019/10/25
 */
public class _lc_215_M_FindKthLargest {

  //方法1：大顶堆
  public int findKthLargest(int[] nums, int k) {
    // init heap 'the smallest element first'
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

    // keep k largest elements in the heap
    for (int n: nums) {
      heap.add(n);
      if (heap.size() > k)
        heap.poll();
    }

    // output
    return heap.poll();
  }

  //方法2：预处理再DFS：
  // 候选词入Tire，得字典树  board中的每个元素作为起点搜索字典树


  /*public List<String> findWords(char[][] board, String[] words) {

  }*/

//
//  //Runtime: 18 ms, faster than 72.73%
//  public List<String> findWords(char[][] board, String[] words) {
//    List<String> res = new ArrayList();
//    TrieNode root = buildTrie(words);
//    for (int i = 0; i < board.length; i++) {
//      for (int j = 0; j < board[0].length; j++) {
//        dfs (board, i, j, root, res);
//      }
//    }
//    return res;
//  }
//
//  public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
//    char c = board[i][j];
//    if (c == '#' || p.next[c - 'a'] == null) return;
//    p = p.next[c - 'a'];
//    if (p.word != null) {   // found one
//      res.add(p.word);
//      p.word = null;     // de-duplicate
//    }
//
//    board[i][j] = '#';
//    if (i > 0) dfs(board, i - 1, j ,p, res);
//    if (j > 0) dfs(board, i, j - 1, p, res);
//    if (i < board.length - 1) dfs(board, i + 1, j, p, res);
//    if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
//    board[i][j] = c;
//  }
//
//  public TrieNode buildTrie(String[] words) {
//    TrieNode root = new TrieNode();
//    for (String w : words) {
//      TrieNode p = root;
//      for (char c : w.toCharArray()) {
//        int i = c - 'a';
//        if (p.next[i] == null) p.next[i] = new TrieNode();
//        p = p.next[i];
//      }
//      p.word = w;
//    }
//    return root;
//  }
//
//  class TrieNode {
//    TrieNode[] next = new TrieNode[26];
//    String word;
//  }
//
//
//  // Runtime: 13 ms, faster than 95.80%
//  List<String> res;
//  public List<String> findWords(char[][] board, String[] words) {
//    res = new ArrayList<>();
//    Node root = buildTrie(words);
//    int m= board.length, n=board[0].length;
//    for(int i=0; i<m; i++) {
//      for(int j=0; j<n; j++) {
//        dfs(i, j, board, root, m, n);
//      }
//    }
//    return res;
//  }
//
//  public void dfs(int i, int j, char[][] board, Node node, int m, int n) {
//    char c = board[i][j];
//    if(board[i][j] == '#') return; // this position has visited
//    node = node.next[c- 'a'];
//    if(node == null) return; // no such node in trie after this root
//    if(node.word != null) {
//      res.add(node.word);  // found one
//      node.word= null;     // de-duplicate
//      // return;  // No return, this is the key
//    }
//    board[i][j] = '#'; // mark this position is visited and continue searching
//    if(i+1 < m && board[i+1][j] != '#') dfs(i+1, j, board, node, m, n);
//    if(j+1 < n && board[i][j+1] != '#') dfs(i, j+1, board, node, m, n);
//    if(i-1 >=0 && board[i-1][j] != '#') dfs(i-1, j, board, node, m, n);
//    if(j-1 >=0 && board[i][j-1] != '#') dfs(i, j-1, board, node, m, n);
//    board[i][j] = c; // restore its orginal state
//  }
//
//  public Node buildTrie(String[] words) {
//    Node root = new Node();
//    for(String word : words) {
//      Node cur = root;
//      for(char c: word.toCharArray()) {
//        if(cur.next[c-'a'] == null) {
//          cur.next[c-'a'] = new Node();
//        }
//        cur = cur.next[c-'a'];
//      }
//      cur.word = word;
//    }
//    return root;
//  }
//
//  class Node {
//    String word;
//    Node[] next= new Node[26];
//  }
}
