import java.util.ArrayList;

/**
 * I began by learning a bit about binary trees. I then went for a greedy and recursion based approach where I would keep track of the depths
 * and then return them all in an array. I would then parse this array and find the difference for max and min values.
 *
 * Things to consider Breadth first vs. depth first
 */
public class SuperbalancedBinaryTree {
    public static void main(String[] args) {

        // Unbalanced
//        BinaryTreeNode n1 = new BinaryTreeNode(1);
//        BinaryTreeNode n10 = new BinaryTreeNode(10);
//        BinaryTreeNode n11 = new BinaryTreeNode(11);
//        BinaryTreeNode n20 = new BinaryTreeNode(20);
//        BinaryTreeNode n21 = new BinaryTreeNode(21);
//        BinaryTreeNode n30 = new BinaryTreeNode(30);
//
//        n1.left = n10;
//        n1.right = n11;
//        n10.left = n20;
//        n10.right = n21;
//        n20.left = n30;

        //Balanced
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n10 = new BinaryTreeNode(10);
        BinaryTreeNode n11 = new BinaryTreeNode(11);
        BinaryTreeNode n20 = new BinaryTreeNode(20);
        BinaryTreeNode n21 = new BinaryTreeNode(21);
        BinaryTreeNode n22 = new BinaryTreeNode(22);
        BinaryTreeNode n23 = new BinaryTreeNode(23);

        n1.left = n10;
        n1.right = n11;
        n10.left = n20;
        n10.right = n21;
        n11.left = n22;
        n11.right = n23;

        SuperbalancedBinaryTree sbbt = new SuperbalancedBinaryTree();
        System.out.println(sbbt.isSuperBalanced(n1));

    }


    public boolean isSuperBalanced(BinaryTreeNode binaryTree) {
        ArrayList<Integer> depths;
        depths = findDepth(binaryTree, new ArrayList<>(), 0);
        if (getMax(depths) - getMin(depths) > 1){
            return false;
        } else {
            return true;
        }

    }

    public ArrayList<Integer> findDepth(BinaryTreeNode node, ArrayList<Integer> depths, int currentDepth){

        if (node == null) {
            depths.add(currentDepth);
            return depths;
        }

        currentDepth += 1;

        return union(findDepth(node.left, depths, currentDepth), findDepth(node.right, depths, currentDepth));
    }

    public ArrayList<Integer> union(ArrayList<Integer> a1, ArrayList<Integer> a2) {
        a1.addAll(a2);
        return a1;
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

    public int getMin(ArrayList<Integer> arr) {
        int min = arr.get(0);
        for (int item : arr) {
            min = Math.min(min, item);
        }

        return min;
    }

    public int getMax(ArrayList<Integer> arr) {
        int max = arr.get(0);
        for (int item : arr) {
            max = Math.max(max, item);
        }

        return max;
    }
}
