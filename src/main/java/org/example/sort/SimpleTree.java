package org.example.sort;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleTree {
    private TreeNode root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private TreeNode addRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    public void traverseDepthFirst() {
        traverseDepthFirstRecursive(root);
    }

    private void traverseDepthFirstRecursive(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            traverseDepthFirstRecursive(node.left);
            traverseDepthFirstRecursive(node.right);
        }
    }

    public void traverseBreadthFirst() {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.value + " ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
