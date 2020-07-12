import java.io.Serializable;
import java.util.Scanner;

public class BinaryTree<E> {
    protected static class Node<E> implements Serializable {
        protected E data;
        protected Node<E> left;
        protected Node<E> right;

        public Node(E data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
        public String toString(){
            return data.toString();
        }
    }//inner class
    protected Node<E> root;

    public BinaryTree(){
        root=null;
    }
    protected BinaryTree(Node<E> root){
        this.root=root;
    }
    public BinaryTree(E data,BinaryTree<E> leftTree,BinaryTree<E> rightTree){
        root=new Node<E>(data);
        if (leftTree!=null){
            root.left=leftTree.root;
        }else {
            root.left=null;
        }
        if(rightTree!=null){
            root.right=rightTree.root;
        }else {
            root.right=null;
        }
    }

    /***
     *
     * @return the left subtree
     */
    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree<E>(root.left);
        } else {
            return null;
        }
    }

    /***
     *
     * @return the right subtreee
     */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<E>(root.right);
        } else {
            return null;
        }
    }

    /***
     *
     * @return true if this tree is leaf,false otherwise
     */
    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }

    /***
     *
     * @return String representation of the tree
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }
    private void preOrderTraverse(Node<E> node, int depth,
                                  StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append(" "); // indentation
        }
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }
}