import java.util.Stack;

/**
 * Get a node:
 * Check validity of left & right subtree
 * If item is valid, evaluate it
 */
public class SuperBalancedBinaryTreeTWO {
    public static void main(String[] args) {
        BinaryTreeNode balancedNode = BinaryTreeNode.getBalancedNode();
        BinaryTreeNode unBalancedNode = BinaryTreeNode.getUnbalancedNode();

        System.out.println(isBalanced(balancedNode) == true);
        System.out.println(isBalanced(unBalancedNode) == false);
    }

    public static boolean isBalanced(BinaryTreeNode root) {
        Stack<BinaryTreeNode> nodes = new Stack<>();
        root.lowerBound = Integer.MIN_VALUE;
        root.upperBound = Integer.MAX_VALUE;
        nodes.push(root);

        while (nodes.size() > 0) {
            BinaryTreeNode node = nodes.pop();

            // if it is invalid
            if (node.value <= node.lowerBound || node.value >= node.upperBound)
                return false;

            // evaluate left
            if (node.left != null) {
                if (node.left.value < node.value) {
                    node.left.lowerBound = node.lowerBound;
                    nodes.push(node.left);
                } else {
                    return false;
                }
            }

            // evaluate right
            if (node.right != null) {
                if (node.right.value > node.value) {
                    node.right.upperBound = node.upperBound;
                    nodes.push(node.right);
                } else {
                    return false;
                }
            }
        }

        return true;

    }
}
