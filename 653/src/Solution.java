import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int len = list.size();
        int l = 0;
        int r = len - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);

            if (sum > k) {
                r--;
            } else if (sum < k) {
                l++;
            } else {
                assert sum == k;
                return true;
            }
        }
        return false;
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
}