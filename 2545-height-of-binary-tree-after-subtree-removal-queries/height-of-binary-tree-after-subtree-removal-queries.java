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

/*class pair {
    TreeNode node;
    int height;

    pair(TreeNode node, int height) {
        this.node = node;
        this.height = height;
    }
}
class pair{
    int val;
    int height;
     
    pair(int val,int height)
    {
        this.val=val;
        this.height=height;
    }
}

class Solution {
    /*public int findIndex(TreeNode root, int val) {
        Queue<pair> que = new LinkedList<>();
        int level = 0;
        que.add(new pair(root, level));
        while (!que.isEmpty()) {
            pair current = que.poll();
            TreeNode temp = current.node;
            int h = current.height;
            if (temp.left != null && temp.left.val != val) {
                que.add(new pair(temp.left, h + 1));
            }
            if (temp.right != null && temp.right.val != val) {
                que.add(new pair(temp.right, h + 1));
            }
            level = Math.max(level, h + 1);
        }
        return level-1;
    }
    public Set allLevel(TreeNode root)
    {
        Queue<TreeNode>que=new LinkedList<>();
        Set<pair>set=new HashSet
        que.add()
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] answer = new int[queries.length];
        int i = 0;
        for (int x : queries) {
            answer[i++] = findIndex(root, x);
        }
        return answer;
    }
}
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int[] po = new int[100001];
    int[] po_ = new int[100001];
    int maxH = 0;

    private void preOrder(TreeNode root, int height) {
        // edge
        if (root == null) {
            return;
        }

        po[root.val] = maxH;
        maxH = Math.max(maxH, height);
        preOrder(root.left, height + 1);
        preOrder(root.right, height + 1);
    }

    private void postOrder(TreeNode root, int height) {
        // edge
        if (root == null) {
            return;
        }

        po_[root.val] = maxH;
        maxH = Math.max(maxH, height);
        postOrder(root.right, height + 1);
        postOrder(root.left, height + 1);
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        preOrder(root, 0);
        maxH = 0;
        postOrder(root, 0);

        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Math.max(po[queries[i]], po_[queries[i]]);
        }
        return res;
    }
}
