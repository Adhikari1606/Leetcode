/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] desc) {
    int len = desc.length;
    if (len == 0) return null;
    
    Map<Integer, TreeNode> map = new HashMap<>();
    Set<Integer> children = new HashSet<>();
    TreeNode head = null;

    // First, identify all child nodes
    for (int[] relation : desc) {
        children.add(relation[1]);
    }

    for (int[] relation : desc) {
        int parent = relation[0];
        int child = relation[1];
        int flag = relation[2];

        TreeNode parentNode = map.getOrDefault(parent, new TreeNode(parent));
        TreeNode childNode = map.getOrDefault(child, new TreeNode(child));

        if (flag == 1) {
            parentNode.left = childNode;
        } else {
            parentNode.right = childNode;
        }

        map.put(parent, parentNode);
        map.put(child, childNode);

        
        if (!children.contains(parent) && head == null) {
            head = parentNode;
        }
    }

    return head;
}
}