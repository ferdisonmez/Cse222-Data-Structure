
public abstract class BinarySearchTree<E extends Comparable<E>>extends BinaryTree<E> implements SearchTree<E>{
    protected boolean addReturn;
    protected E deleteReturn;

    /***
     * @param item The object being inserted
     * @return true if object is inserted ,false
     * if the object already existin the tree
     */
    @Override
    public  boolean add(E item) {
        root = add(root, item);
        return addReturn;

    }
    private Node<E> add(Node<E> localRoot, E item) {
        if (localRoot == null) {
            addReturn = true;
            return new Node<E>(item);
        }
        else if (item.compareTo(localRoot.data) == 0) {
            addReturn = false;
            return localRoot;
        }
        else if (item.compareTo(localRoot.data) < 0) {
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        }
        else {
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }
    @Override
    public boolean contains(E target) {
        E temp=find(root,target);
        if(temp!=null){
            return true;
        }
        else {
            return false;
        }
    }

    /***
     * @param target The comparable object being sought
     * @return The object,if found ,otherwise null
     */
    @Override
    public E find(E target) {
        return find(root,target);
    }
    private E find(Node<E> localRoot,E target){
        if (localRoot==null){
            return null;
        }
        int comResult=target.compareTo(localRoot.data);
        if (comResult ==0) {
            return localRoot.data;
        }
        else if (comResult< 0) {
            return find(localRoot.left,target);
        }
        else {
            return find(localRoot.right,target);
        }
    }

    /***
     * @param target the object to be deleted
     * @return The object deleted from the tree or null if the object was not in the tree
     */
    @Override
    public E delete(E target) {
        root=delete(root,target);
        return deleteReturn;
    }
    private Node<E> delete(Node<E> localRoot,E item){
        if (localRoot == null) {
            deleteReturn=null;
            return localRoot;
        }
        int comResult=item.compareTo(localRoot.data);
        if (comResult<0) {
            localRoot.left=delete(localRoot.left,item);
            return localRoot;
        }
        else if (comResult>0) {
            localRoot.right=delete(localRoot.right,item);
            return localRoot;
        }
        else {
            deleteReturn=localRoot.data;
            if (localRoot.left==null){
                return localRoot.right;
            }
            else if(localRoot.right==null){
                return localRoot.left;
            }
            else {
                if(localRoot.left.right==null){
                    localRoot.data=localRoot.left.data;
                    localRoot.left=localRoot.left.left;
                    return localRoot;
                }
                else {
                    localRoot.data=findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }
    private E findLargestChild(Node<E> parent){
        if(parent.right.right==null){
            E returvalue=parent.right.data;
            parent.right=parent.right.left;
            return returvalue;
        }
        else {
            return findLargestChild(parent.right);
        }
    }

    /***
     * @param target item to be deleted
     * @return  true if deleted, return false if not deleted
     */
    @Override
    public boolean remove(E target) {
        Node<E> temp=delete(root,target);
        if(temp!=null){
            return true;
        }
        else {
            return false;
        }
    }

}
