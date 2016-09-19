import java.util.Stack;

/**
 * Created by nathansass on 9/19/16.
 */
public class BinaryTreeSecondLargest {

    public static void main(String[] args) {
        BinaryTreeNode n100 = new BinaryTreeNode(100);
        BinaryTreeNode n50 = new BinaryTreeNode(50);
        BinaryTreeNode n200 = new BinaryTreeNode(200);
        BinaryTreeNode n30 = new BinaryTreeNode(30);
        BinaryTreeNode n80 = new BinaryTreeNode(80);
        BinaryTreeNode n150 = new BinaryTreeNode(150);
        BinaryTreeNode n250 = new BinaryTreeNode(250);

        n100.left = n50;
        n100.right = n200;

        n50.left = n30;
        n50.right = n80;

        n200.left = n150;
        n200.right = n250;

//        System.out.println(new BinaryTreeSecondLargest().findSecondLargest_greedy(n100));
        System.out.println(new BinaryTreeSecondLargest().findSecondLargest_Recursive(n100));


    }

    public Integer findLargest(BinaryTreeNode node) {
        if (node.right != null) {
            return findLargest(node.right);
        }

        return node.value;
    }

    public Integer findSecondLargest_Recursive(BinaryTreeNode treeNode) {

        // Case: Empty tree
        if(treeNode == null) {
            return null;
        }

        // Case: Second to last value in a balanced tree
        if(treeNode.right != null
                && treeNode.right.left == null
                && treeNode.right.right == null ) {
            return treeNode.value;
        }

        // Case: The largest value has a left subtree
        if (treeNode.right == null &&
                treeNode.left != null) {
            return findLargest(treeNode.left);
        }

        return findSecondLargest_Recursive(treeNode.right);

    }

    public int findSecondLargest_greedy(BinaryTreeNode treeRoot) {
        Stack<BinaryTreeNode> nodes = new Stack<>();
        int highest = treeRoot.value;
        int secondHighest = Integer.MIN_VALUE;
        nodes.push(treeRoot);

        while(!nodes.empty()) {
            BinaryTreeNode node = nodes.pop();

            if (node.value > highest) {
                secondHighest = highest;
                highest = node.value;
            }

            if(node.left != null) {
                nodes.push(node.left);
            }

            if(node.right != null) {
                nodes.push(node.right);
            }
        }

        return secondHighest;
    }

    public static class BinaryTreeNode {

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

    }
}
