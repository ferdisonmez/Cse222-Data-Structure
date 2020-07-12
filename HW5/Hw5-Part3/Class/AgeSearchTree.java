import java.util.NoSuchElementException;

public class AgeSearchTree<E> extends BinarySearchTree<AgeData>{
    /***
     * It will add a node to the tree structure, if there is an age to be added, it will increase the number of people
     * @param item is the desired age to be added
     * @return false if not added true if added
     */
    @Override
    public boolean add(AgeData item) {
        AgeData temp=super.find(item);
        if (temp==null){
            super.add(item);
            return false;
        }
        else{
            temp.incrementoneData();
            return true;
        }
    }

    /***
     * Prints the value in the node and how many people there are
     * @return strings attached together
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }
    private void preOrderTraverse(Node<AgeData> node, int depth, StringBuilder sb) {
        if (node == null) {
            sb.append("null\n");
        }
        else {
            sb.append(node.data.getData()+"-"+node.data.getObjeCount());
            sb.append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }

    /***
     * This function search in tree a node
     * @param target is Agedata type
     * @return  the address if it finds the node it is looking for, or returns null if it cannot find it
     */
    @Override
    public AgeData find(AgeData target) {
        AgeData temp=super.find(target);
        if (temp==null){
            return null;
        }
        else{
            return temp;
        }
    }

    /***
     * Deletes a person in the desired node
     * @param target is Agedate Type(node to be deleted)
     * @return false if not deleted true if deleted
     */
    @Override
    public boolean remove(AgeData target) {
        AgeData temp=super.find(target);
        if (temp==null){
            return false;
        }
        else {
            if (temp.datasize()>1){
                temp.decrementoneData();
                return true;
            }
            else {
                super.remove(temp);
                return true;
            }
        }
    }

    /***
     * When adding small and large values, missing values ​​are added
     * @param root initial value of the tree
     * @param temp desired value
     *
     */
    public void travers(Node<AgeData> root,AgeData temp){
        if(root == null) {
            return;
        }
        else {
           temp.compareTo(root.data);
            if(root.left != null)
                travers(root.left,temp);
            if(root.right != null)
                travers(root.right,temp);
        }
    }

    /***
     *Find the number of people in nodes smaller than the desired node
     * @param number desired number(number of node)
     * @return the number of people in nodes smaller than the desired node
     */
    public int youngerThan(int number){
        AgeData temp=super.find(new AgeData(number));
        if (temp == null) {
            return 0;
        }
        else {
            travers(root, temp);
            return temp.smallBoyut();
        }
    }

    /***
     * Find the number of people in nodes larger than the desired node
     * @param number desired number(number of node)
     * @return  the number of people in nodes smaller than the desired node
     */
    public int olderThan(int number){
        AgeData temp=super.find(new AgeData(number));
        if (temp == null) {
            return 0;
        }
        else {
            travers(root, temp);
            return temp.bigBoyut();
        }
    }
}
