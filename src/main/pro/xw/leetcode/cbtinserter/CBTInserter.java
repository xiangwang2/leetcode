package src.main.pro.xw.leetcode.cbtinserter;



import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class CBTInserter {
    private Queue<TreeNode> queue;
    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
        this.queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> temp = new LinkedList<>();
        temp.add(root);
        while (!temp.isEmpty()) {
            List<TreeNode> nextNodes = new LinkedList<>();
            for (TreeNode cur : temp) {
                if (cur.left != null) {
                    queue.add(cur.left);
                    nextNodes.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    nextNodes.add(cur.right);
                }
            }
            temp = nextNodes;
        }
    }

    public int insert(int val) {
        while (!queue.isEmpty()) {
            TreeNode head = queue.peek();
            if (head.left != null && head.right != null) {
                queue.remove();
            } else {
                break;
            }
        }
        TreeNode cur = new TreeNode(val);
        queue.add(cur);
        TreeNode head = queue.peek();
        if (head.left == null) {
            head.left = cur;
        } else {
            head.right = cur;
        }
        return head.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
