package test2024;

import java.util.*;

/**
 * Author: Xiyao Li
 * Date: 2024/2/13 0:39
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Test987 {

    TreeMap<Integer, TreeMap<Integer, List<Integer>>> map;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        map = new TreeMap<>();
        traverse(root, 0, 0);
        for(Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entry : map.entrySet()) {
            List<Integer> innerRes = new ArrayList<>();
            int rootCol = entry.getKey();
            TreeMap<Integer, List<Integer>> innerMap = entry.getValue();
            for(Map.Entry<Integer, List<Integer>> innerEntry : innerMap.entrySet()) {
                List<Integer> valueList = innerEntry.getValue();
                if(valueList.size() == 1) {
                    innerRes.add(valueList.get(0));
                }else{
                    Collections.sort(valueList);
                    for(Integer value : valueList) {
                        innerRes.add(value);
                    }
                }
            }
            res.add(innerRes);
        }

        return res;
    }

    private void traverse(TreeNode root, int rootRow, int rootCol) {
        if(root == null) {
            return;
        }
        if(map.containsKey(rootCol)) {
            TreeMap<Integer, List<Integer>> innerMap = map.get(rootCol);
            if(innerMap.containsKey(rootRow)) {
                List<Integer> innerList = innerMap.get(rootRow);
                innerList.add(root.val);
            }else{
                List<Integer> innerList = new ArrayList<>();
                innerList.add(root.val);
                innerMap.put(rootRow, innerList);
            }
        }else{
            TreeMap<Integer, List<Integer>> innerMap = new TreeMap<>();
            List<Integer> innerList = new ArrayList<>();
            innerList.add(root.val);
            innerMap.put(rootRow, innerList);

            map.put(rootCol, innerMap);
        }

        traverse(root.left, rootRow + 1, rootCol - 1);
        traverse(root.right, rootRow + 1, rootCol + 1);
    }

    public static void main(String[] args) {
        Test987 test987 = new Test987();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode rootRight = new TreeNode(20);
        root.right = rootRight;
        rootRight.left = new TreeNode(15);
        rootRight.right = new TreeNode(7);

        List<List<Integer>> lists = test987.verticalTraversal(root);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
