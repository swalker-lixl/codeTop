package main.java.org.code.top;


import main.java.org.code.top.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * describe:
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * @author lixilong
 * @date 2019/01/25
 */
public class _lc_102_M_LevelOrder {

    //方法1：循环
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            levels.add(new ArrayList<Integer>()); // start the current level

            int level_length = queue.size(); // number of elements in the current level
            for (int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();
                levels.get(level).add(node.val); // fulfill the current level

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            // go to next level
            level++;
        }
        return levels;
    }


    // BSF 递归写法：
    public List<List<Integer>> levelOrder1(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList();
        if (root == null) return res;
        helper(root, res, 0);
        return res;
    }

    private static void helper(TreeNode root, ArrayList<List<Integer>> res, int level) {
        if (res.size() < level + 1) res.add(new LinkedList());
        res.get(level).add(root.val);
        if (root.left != null) helper(root.left, res, level + 1);
        if (root.right != null) helper(root.right, res, level + 1);
    }

}
