package prev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Test1457 {

    List<Integer> path;
    int res;

    public int pseudoPalindromicPaths(TreeNode root) {
        path = new ArrayList<>();
        res = 0;
        if (root == null) {
            return 0;
        }
        path.add(root.val);
        traverse(root);
        return res;
    }

    public void traverse(TreeNode cur) {
        if (cur.left == null && cur.right == null && isPermutationalPalindromic(path)) {
            res++;

            return;
        }
        if (cur.left == null && cur.right == null) {
            return;
        }
        if (cur.left != null) {
            path.add(cur.left.val);
            traverse(cur.left);
            path.remove(path.size() - 1);
        }
        if (cur.right != null) {
            path.add(cur.val);
            traverse(cur.left);
            path.remove(path.size() - 1);
        }

        return;
    }

    public boolean isPermutationalPalindromic(List<Integer> path) {
        if (path.size() <= 1) {
            return true;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer nodeVal : path) {
            map.put(nodeVal, map.getOrDefault(nodeVal, 0) + 1);
        }
        boolean hasOne = false;
        for (Integer key : map.keySet()) {
            if (map.get(key) % 2 != 0 && hasOne == false) {
                hasOne = true;
            } else if (map.get(key) % 2 != 0 && hasOne == true) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Test1457 test1457 = new Test1457();
        TreeNode root = new TreeNode(2);

        TreeNode n1 = new TreeNode(3);
        root.left = n1;
        TreeNode n2 = new TreeNode(1);
        root.right = n1;
        TreeNode n3 = new TreeNode(3);
        n1.left = n3;
        TreeNode n4 = new TreeNode(1);
        n1.right = n3;
        TreeNode n5 = new TreeNode(1);
        n2.right = n5;
        int paths = test1457.pseudoPalindromicPaths(root);
        System.out.println("paths = " + paths);
    }
}
