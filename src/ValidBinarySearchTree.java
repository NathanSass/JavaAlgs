import java.util.Stack;

/**
 * Created by nathansass on 9/16/16.
 */
public class ValidBinarySearchTree {
    public static void main(String[] args) {
        //Balanced
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

        System.out.println(new ValidBinarySearchTree().isValid(n100));
    }

    public boolean isValid(BinaryTreeNode treeRoot) {
        Stack<BinaryTreeNode> nodes = new Stack<>();
        nodes.push(treeRoot);

        while (!nodes.empty()) {
            BinaryTreeNode node = nodes.pop();


            if (node.left != null &&
                    (node.left.value > node.value)){
                return false;
            }

            if (node.right != null &&
                    node.right.value < node.value) {
                return false;
            }



            if (node.left != null) {
                nodes.push(node.left);
            }

            if (node.right != null) {
                nodes.push(node.right);
            }


        }
        return true;
    }


    public static class BinaryTreeNode {

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }
}
