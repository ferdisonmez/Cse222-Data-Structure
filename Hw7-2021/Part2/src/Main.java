import java.util.ArrayList;
import java.util.Vector;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree=new BinarySearchTree<Integer>();
        BinarySearchTree<Integer> binarySearchTree1=new BinarySearchTree<Integer>();
        System.out.println("*****AVLTREE******");
        binarySearchTree.add(10);
        binarySearchTree.add(5);
        binarySearchTree.add(3);
        binarySearchTree.add(20);
        binarySearchTree.add(30);
        binarySearchTree.add(40);
        binarySearchTree.add(50);
        findbalance(binarySearchTree,"AVLTREE");
        System.out.println("\n*****RedBlackTree****");
        binarySearchTree1.add(20);
        binarySearchTree1.add(30);
        binarySearchTree1.add(40);
        binarySearchTree1.add(50);
        isRed(binarySearchTree1);


    }

    /***
     * Binary Search decides if tree is avl tree
     * @param binarySearchTree is binarysearch tree
     * @param name of tree
     */
    public static void findbalance(BinarySearchTree<Integer> binarySearchTree,String name){
        boolean sonucavl=isavlorred(binarySearchTree);
        if (sonucavl){
            System.out.println("This Tree is a "+name);
        }
        else if (!sonucavl)
            System.out.println("This Tree isnot "+name);
    }
    public static boolean isavlorred(BinarySearchTree<Integer> gndr){
        return isBalanced(gndr.root);
    }
    private static boolean isLeaf(BinaryTree.Node root) {
        if (root.left == null && root.right == null)
            return true;
        return false;
    }

    /***
     * Checks if the tree is balanced
     * @param root is binarytree node
     * @return if this tree blanced true otherwise false
     */
    private static boolean isBalanced(BinaryTree.Node root) {
        if (root == null)
            return true;
        Vector<BinaryTree.Node> queue = new Vector<BinaryTree.Node>();
        int level = 1, minLevel = Integer.MAX_VALUE, maxLevel = Integer.MIN_VALUE;
        queue.add(root);
        while (!queue.isEmpty()) {
            int elementCount = queue.size();
            while (elementCount > 0) {
                BinaryTree.Node node = queue.remove(0);
                if (isLeaf(node)) {
                    if (minLevel > level)
                        minLevel = level;
                    if (maxLevel < level)
                        maxLevel = level;
                } else {
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                elementCount--;
            }
            if (abs(maxLevel - minLevel) > 1) {
                return false;
            }
            level++;
        }

        return true;
    }

    /***
     * Red black tree also determines root node color
     * @param temp
     */
    public static void isRed(BinarySearchTree<Integer> temp){
        RedBlackTree<Integer> redBlackTree=new RedBlackTree<Integer>();
        inOrderTraverse(temp.root,redBlackTree);
        System.out.println(redBlackTree.root.toString());
    }

    /**
     * Perform an inorder traversal, returning the tree in ascending order (new lines separate characters)
     * @param node The local root
     */
    private static void inOrderTraverse(BinaryTree.Node<Integer> node,RedBlackTree<Integer> ekle){
        if(node == null){
            //do nothing
        } else {
            inOrderTraverse(node.left,ekle);
            ekle.add(node.data);
            inOrderTraverse(node.right,ekle);
        }
    }

}
