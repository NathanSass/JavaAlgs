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

        System.out.println(new BinaryTreeSecondLargest().findSecondLargest(n100));


    }

    public int findSecondLargest(BinaryTreeNode treeRoot) {
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
