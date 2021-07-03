import java.util.*;
public class AVLTree<E extends Comparable<E>> implements NavigableSet<E>
{
    @Override
    public E lower(E e) {
        return null;
    }

    @Override
    public E floor(E e) {
        return null;
    }

    @Override
    public E ceiling(E e) {
        return null;
    }

    @Override
    public E higher(E e) {
        return null;
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }



    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public NavigableSet<E> descendingSet() {
        return null;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    @Override
    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        return null;
    }



    @Override
    public Comparator<? super E> comparator() {
        return null;
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        return null;
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        return null;
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        return null;
    }

    @Override
    public E first() {
        return null;
    }

    @Override
    public E last() {
        return null;
    }

    // create Node class to design the structure of the AVL Tree Node
    private class Node<E>
    {
        E element;
        int h;  //for height
        Node leftChild;
        Node rightChild;

        //default constructor to create null node
        public Node()
        {
            leftChild = null;
            rightChild = null;
            element = null;
            h = 0;
        }
        // parameterized constructor
        public Node(E element)
        {
            leftChild = null;
            rightChild = null;
            this.element = element;
            h = 0;
        }
    } ///İnner Class
        private Node rootNode;
        //Constructor to set null value to the rootNode
        public AVLTree()
        {
            rootNode = null;
        }

    /***
     * Create removeAll() method to make AVL Tree empty
     */
    public void removeAll()
        {
            rootNode = null;
        }

    /***
     * create checkEmpty() method to check whether the AVL Tree is empty or not
     * @return true or false
     */
    public boolean checkEmpty()
        {
            if(rootNode == null)
                return true;
            else
                return false;
        }

    /***
     * Create insertElement() to insert element to to the AVL Tree
     * @param element is added element
     */
    public boolean add(E element)
        {
            rootNode = insertElement(element, rootNode);
            return true;
        }

        //create getHeight() method to get the height of the AVL Tree
        private int getHeight(Node node )
        {
            return node == null ? -1 : node.h;
        }

    /***
     * Create maxNode() method to get the maximum height from left and right node
     * @param leftNodeHeight
     * @param rightNodeHeight
     * @return
     */
        private int getMaxHeight(int leftNodeHeight, int rightNodeHeight)
        {
            return leftNodeHeight > rightNodeHeight ? leftNodeHeight : rightNodeHeight;
        }

    /***
     * create insertElement() method to insert data in the AVL Tree recursively
     * @param element is insert element
     * @param node is a node
     * @return
     */
        private Node insertElement(E element, Node node)
        {
            //check whether the node is null or not
            if (node == null)
                node = new Node(element);
                //insert a node in case when the given element is lesser than the element of the root node
            else if (element.compareTo((E) node.element)<0)
            {
                node.leftChild = insertElement( element, node.leftChild );
                if( getHeight( node.leftChild ) - getHeight( node.rightChild ) == 2 )
                    if( element.compareTo((E) node.leftChild.element) <0)
                        node = rotateWithLeftChild( node );
                    else
                        node = doubleWithLeftChild( node );
            }
            else if( element.compareTo( (E) node.element) >0 )
            {
                node.rightChild = insertElement( element, node.rightChild );
                if( getHeight( node.rightChild ) - getHeight( node.leftChild ) == 2 )
                    if( element.compareTo((E)node.rightChild.element) > 0)
                        node = rotateWithRightChild( node );
                    else
                        node = doubleWithRightChild( node );
            }
            else
                ;  // if the element is already present in the tree, we will do nothing
            node.h = getMaxHeight( getHeight( node.leftChild ), getHeight( node.rightChild ) ) + 1;

            return node;

        }

    /***
     * creating rotateWithLeftChild() method to perform rotation of binary tree node with left child
     * @param node2 is Node
     * @return
     */
    private Node rotateWithLeftChild(Node node2)
        {
            Node node1 = node2.leftChild;
            node2.leftChild = node1.rightChild;
            node1.rightChild = node2;
            node2.h = getMaxHeight( getHeight( node2.leftChild ), getHeight( node2.rightChild ) ) + 1;
            node1.h = getMaxHeight( getHeight( node1.leftChild ), node2.h ) + 1;
            return node1;
        }

        // creating rotateWithRightChild() method to perform rotation of binary tree node with right child
        private Node rotateWithRightChild(Node node1)
        {
            Node node2 = node1.rightChild;
            node1.rightChild = node2.leftChild;
            node2.leftChild = node1;
            node1.h = getMaxHeight( getHeight( node1.leftChild ), getHeight( node1.rightChild ) ) + 1;
            node2.h = getMaxHeight( getHeight( node2.rightChild ), node1.h ) + 1;
            return node2;
        }

        //create doubleWithLeftChild() method to perform double rotation of binary tree node. This method first rotate the left child with its right child, and after that, node3 with the new left child
        private Node doubleWithLeftChild(Node node3)
        {
            node3.leftChild = rotateWithRightChild( node3.leftChild );
            return rotateWithLeftChild( node3 );
        }

        //create doubleWithRightChild() method to perform double rotation of binary tree node. This method first rotate the right child with its left child and after that node1 with the new right child
        private Node doubleWithRightChild(Node node1)
        {
            node1.rightChild = rotateWithLeftChild( node1.rightChild );
            return rotateWithRightChild( node1 );
        }

    /***
     * create getTotalNumberOfNodes() method to get total number of nodes in the AVL Tree
     * @return
     */
    public int getTotalNumberOfNodes()
        {
            return getTotalNumberOfNodes(rootNode);
        }
        private int getTotalNumberOfNodes(Node head)
        {
            if (head == null)
                return 0;
            else
            {
                int length = 1;
                length = length + getTotalNumberOfNodes(head.leftChild);
                length = length + getTotalNumberOfNodes(head.rightChild);
                return length;
            }
        }

    /***
     * Create searchElement() method to find an element in the AVL Tree
     * @param element
     * @return
     */
    public boolean searchElement(E element)
        {
            return searchElement(rootNode, element);
        }

        private boolean searchElement(Node head, E element)
        {
            boolean check = false;
            while ((head != null) && !check)
            {
                E headElement = (E) head.element;
                if (element.compareTo(headElement) <0)
                    head = head.leftChild;
                else if (element.compareTo(headElement) > 0)
                    head = head.rightChild;
                else
                {
                    check = true;
                    break;
                }
                check = searchElement(head, element);
            }
            return check;
        }

    /***
     * Create inorderTraversal() method for traversing AVL Tree in in-order form
     */
    public void inorderTraversal()
        {
            inorderTraversal(rootNode);
        }
        private void inorderTraversal(Node head)
        {
            if (head != null)
            {
                inorderTraversal(head.leftChild);
                System.out.print(head.element+" ");
                inorderTraversal(head.rightChild);
            }
        }

    /***
     * Create preorderTraversal() method for traversing AVL Tree in pre-order form
     */
    public void preorderTraversal()
        {
            preorderTraversal(rootNode);
        }
        private void preorderTraversal(Node head)
        {
            if (head != null)
            {
                System.out.print(head.element+" ");
                preorderTraversal(head.leftChild);
                preorderTraversal(head.rightChild);
            }
        }

    /***
     * Create postorderTraversal() method for traversing AVL Tree in post-order form
     */
    public void postorderTraversal()
        {
            postorderTraversal(rootNode);
        }

        private void postorderTraversal(Node head)
        {
            if (head != null)
            {
                postorderTraversal(head.leftChild);
                postorderTraversal(head.rightChild);
                System.out.print(head.element+" ");
            }
        }
    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }
    private class Itr<E> implements Iterator<E> {
        ArrayList<E> arrayList=new ArrayList<E>();
        Iterator iterator;
        Node<E> localNode = (Node<E>) rootNode;
        public Itr() {
            arrayList=new ArrayList<E>();
            Helperiter(localNode,arrayList);
            iterator=arrayList.iterator();

        }
        private void Helperiter(Node<E> myroot,ArrayList<E> temp){
            if(myroot!=null) {
                Helperiter(myroot.leftChild, temp);
                temp.add(myroot.element);
                Helperiter(myroot.rightChild, temp);
            }
        }

        public boolean hasNext() {
            return iterator.hasNext();
        }


        public E next() {
           return (E) iterator.next();
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    /***
     * Stores the smaller of the given element  them in the set.
     * @param toElement is searched element
     * @param inclusive Determines whether to include the element to be searched.
     * @return  NavigableSet
     */
    @Override
    public NavigableSet<E> headSet(E toElement, boolean inclusive) {
        Node<E> tempnode=rootNode;
        NavigableSet<E> ns=new TreeSet<E>();
        AddinorderTraversalForHeadset((TreeSet<E>)ns,tempnode,toElement,inclusive);
        return ns;
    }
    private void AddinorderTraversalForHeadset(TreeSet<E> temp,Node head,E elem,boolean inclusive) {
        if (head != null) {
            AddinorderTraversalForHeadset(temp,head.leftChild,elem,inclusive);
            if(elem.compareTo((E)head.element)>0) {
                temp.add((E) head.element);
            }
            if (elem.compareTo((E)head.element)==0 && inclusive){
                temp.add((E) head.element);
            }
            AddinorderTraversalForHeadset(temp,head.rightChild,elem,inclusive);
        }
    }

    /***
     * Stores the bigger of the given element  them in the set.
     * @param fromElement is searched element
     * @param inclusive Determines whether to include the element to be searched.
     * @return NavigableSet
     */
    @Override
    public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        NavigableSet<E> ns=new TreeSet<E>();
        AddinorderTraversalForTailset((TreeSet<E>)ns,this.rootNode,fromElement,inclusive);
        return ns;
    }
    private void AddinorderTraversalForTailset(TreeSet<E> temp,Node head,E elem,boolean inclusive) {
        if (head != null) {
            AddinorderTraversalForTailset(temp,head.leftChild,elem,inclusive);
            if(elem.compareTo((E)head.element)<0) {
                temp.add((E) head.element);
            }
            if (elem.compareTo((E)head.element)==0  && inclusive){
                temp.add((E) head.element);
            }
            AddinorderTraversalForTailset(temp,head.rightChild,elem,inclusive);
        }
    }

}
