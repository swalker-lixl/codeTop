package main.java.org.code.top;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * describe:
 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。

 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。

 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。

 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。

 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。

 注意:

 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 所有的目标基因序列必须是合法的。
 假定起始基因序列与目标基因序列是不一样的。
 示例 1:

 start: "AACCGGTT"
 end:   "AACCGGTA"
 bank: ["AACCGGTA"]

 返回值: 1
 示例 2:

 start: "AACCGGTT"
 end:   "AAACGGTA"
 bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

 返回值: 2
 示例 3:

 start: "AAAAACCC"
 end:   "AACCCCCC"
 bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

 返回值: 3

 * @author lixilong
 * @date 2019/12/22
 */
public class _lc_443_M_MinMutation {

  /**
   * 双向A* 解法
  */
    private int strDiff(String s1, String s2) {
      int minLen = Math.min(s1.length(), s2.length());
      int cnt = 0;

      for (int i = 0; i < minLen; i++) {
        if (s1.charAt(i) != s2.charAt(i)) {
          cnt++;
        }
      }

      return cnt;
    }

    private class Node implements Comparable {
      String curStr;
      int steps;
      String targetStr;

      public Node(String curStr, int steps, String targetStr) {
        this.curStr = curStr;
        this.steps = steps;
        this.targetStr = targetStr;
      }

      @Override
      public int compareTo(Object o) {
        Node node = (Node)o;
        return ((steps + strDiff(curStr, targetStr)) - (node.steps + strDiff(node.curStr, node.targetStr)));
      }
    }


    public int minMutation(String start, String end, String[] bank) {
      Set<String> bankString = new HashSet<>(Arrays.asList(bank));

      if (!bankString.contains(end)) {
        return -1;
      }

      Set<String> visited = new HashSet<>();

      final String startTargetStr = end;
      final String endTargetStr = start;

      PriorityQueue<Node> startHeap = new PriorityQueue<>();
      Set<String> startSet = new HashSet<>();
      PriorityQueue<Node> endHeap = new PriorityQueue<>();
      Set<String> endSet = new HashSet<>();


      startHeap.add(new Node(start, 0, startTargetStr));
      startSet.add(start);
      endHeap.add(new Node(end, 0, endTargetStr));
      endSet.add(end);
      visited.add(start);
      visited.add(end);

      int len = 0;
      while ((startHeap.size() != 0) && (endHeap.size() != 0)) {
        PriorityQueue<Node> expandHeap = null;
        Set<String> expandSet = null;
        Set<String> targetSet = null;

        if (startHeap.size() < endHeap.size()) {
          expandHeap = startHeap;
          expandSet = startSet;

          targetSet = endSet;
        } else {
          expandHeap = endHeap;
          expandSet = endSet;

          targetSet = startSet;
        }

        // 数值更少的一端进行状态拓展
        Node node = expandHeap.poll();
        String curStr = node.curStr;
        expandSet.remove(curStr);

        char[] charArr = curStr.toCharArray();
        for (int i = 0; i < curStr.length(); i++) {
          char oldChar = charArr[i];

          for (char ch : new char[] {'A', 'C', 'G', 'T'}) {
            if (ch == oldChar) {
              continue;
            }

            charArr[i] = ch;
            String s = new String(charArr);

            if (targetSet.contains(s)) {
              return len + 1;
            }

            if (!bankString.contains(s)) {
              continue;
            }

            if (visited.contains(s)) {
              continue;
            }

            expandHeap.add(new Node(s, node.steps+1, node.targetStr));
            expandSet.add(s);
            visited.add(s);
          }

          charArr[i] = oldChar;
        }

        len++;
      }

      return -1;
    }

    public static void main(String[] args) {
      System.out.println(new _lc_443_M_MinMutation().minMutation("AAAAACCC", "AACCCCCC", new String[] {"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }

}
