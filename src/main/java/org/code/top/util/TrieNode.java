package main.java.org.code.top.util;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/10
 */
public class TrieNode {


  //Definition for binary tree
    public char val;
    public boolean isWord;

    public TrieNode[] children = new TrieNode[26];
    public TrieNode () {}

    public TrieNode (char c) {
       TrieNode node = new TrieNode();
       node.val = c;
    }
}
