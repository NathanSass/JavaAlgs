/**
 * Created by nathans on 10/3/17.
 */
public class BinaryTreeNode {

    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    /**
     *         10
     *         / \
     *        4  15
     *       /\  /\
     *      1 5 12 17
     */
    public static BinaryTreeNode getBalancedNode() {
        BinaryTreeNode n10 = new BinaryTreeNode(10);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n15 = new BinaryTreeNode(15);
        BinaryTreeNode n12 = new BinaryTreeNode(12);
        BinaryTreeNode n17 = new BinaryTreeNode(17);

        n10.left = n4;
        n10.right = n15;
        n4.left = n1;
        n4.right = n5;

        n15.left = n12;
        n15.right = n17;

        return n10;
    }
    public static BinaryTreeNode getUnbalancedNode() {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n10 = new BinaryTreeNode(10);
        BinaryTreeNode n11 = new BinaryTreeNode(11);
        BinaryTreeNode n20 = new BinaryTreeNode(20);
        BinaryTreeNode n21 = new BinaryTreeNode(21);
        BinaryTreeNode n30 = new BinaryTreeNode(30);

        n1.left = n10;
        n1.right = n11;
        n10.left = n20;
        n10.right = n21;
        n20.left = n30;

        return n1;
    }
}