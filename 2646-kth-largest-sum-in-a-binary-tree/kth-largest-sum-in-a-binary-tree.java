class pair {
    TreeNode t;
    int i;

    pair(TreeNode t, int i) {
        this.t = t;
        this.i = i;
    }
}

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;

        Map<Integer, Long> map = new HashMap<>();
        Queue<pair> que = new LinkedList<>();
        que.add(new pair(root, 0));
        map.put(0, (long) root.val);

        while (!que.isEmpty()) {
            pair p = que.poll();
            TreeNode temp = p.t;
            int level = p.i;

            if (temp.left != null || temp.right != null) {
                int leftVal = (temp.left != null) ? temp.left.val : 0;
                int rightVal = (temp.right != null) ? temp.right.val : 0;
                long sum = (long) (leftVal + rightVal);

                map.put(level + 1, map.getOrDefault(level + 1, 0L) + sum);

                if (temp.left != null) que.add(new pair(temp.left, level + 1));
                if (temp.right != null) que.add(new pair(temp.right, level + 1));
            }
        }

        List<Long> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());

        if (k > list.size()) return -1;

        return list.get(k - 1);
    }
}
