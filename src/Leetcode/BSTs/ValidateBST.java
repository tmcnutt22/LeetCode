package Leetcode.BSTs;
import Grokking.TreeBFS.TreeNode;

public class ValidateBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        System.out.println(isValidBST(root));

    }
    public static boolean isValidBST(TreeNode root) {
        return isValidHelper(root, null, null);
    }
    public static boolean isValidHelper(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            //System.out.println("Returns here ");
            return true;
        }

        System.out.println("Low: " + low);
        System.out.println("Node val: " + node.val);
        System.out.println("High: " + high);
        System.out.println("\nNew recursive call");


        if ((low != null && node.val <= low) || (high != null && node.val >= high)) {

//            System.out.println("Returns here: <= low || >= high ");
            return false;
        }

        return isValidHelper(node.left, low, node.val) && isValidHelper(node.right, node.val, high);
    }
}
