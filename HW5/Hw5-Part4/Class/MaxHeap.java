import java.util.ArrayList;
import java.util.Comparator;
public class MaxHeap<E extends AgeData> implements Comparator<AgeData> ,IMaxHeap{
    private ArrayList<E> liste;
    public MaxHeap(){
        liste=new ArrayList<E>();
    }
    public ArrayList<E> getListe(){
        return liste;
    }

    private int parent(int pos)
    {
        return pos / 2;
    }

    /***
     * Function to return the position of the
     * left child for the node currently at pos
     * @param pos  address of desired location
     * @return parent shows her first child
     */
    private int leftChild(int pos)
    {
        return (2 * pos);
    }

    /***
     *Function to return the position of
     * The right child for the node currently
     * @param pos address of desired location
     * @return  parent shows her second child
     */
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    /***
     * Function that returns true if the passed
     * Node is a leaf node
     * @param pos address of desired location
     * @return shows parent address
     */
    private boolean isLeaf(int pos)
    {
        if (pos >= (liste.size() / 2) && pos <= liste.size()) {
            return true;
        }
        return false;
    }

    /***
     * Prints heap elements to the screen
     * @return heap's all elements
     */
    @Override
    public String toString()
    {
        String temp="";
        System.out.println("*******MaxHeap*********");
       for (int i = 0; i <liste.size(); i++) {
            temp+=liste.get(i);
        }
       return temp;
    }

    /***
     * Editing data if the element is deleted in the heap
     * @param pos is the heap directory to be edited
     */
    private void maxHeapify(int pos)
    {
        if (!isLeaf(pos)) {
            if (compare(liste.get(pos) ,liste.get(leftChild(pos)))==-1 || compare(liste.get(pos),liste.get(rightChild(pos)))==-1) {

                if (compare(liste.get(leftChild(pos)),liste.get(rightChild(pos)))==1) {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                }
                else {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }

    /***
     * Deletes items to delete in the heap
     * @param element is the item to be deleted
     */

    public void remove(Object element)
    {
        int index=-1;
        for (int i = 0; i <liste.size(); i++) {
            if (liste.get(i).getData() == ((E) element).getData()) {
                index=i;
            }
        }
        if (index !=-1) {

            if(liste.get(index).getObjeCount()>1){
                liste.get(index).decrementoneData();
                maxHeap();

            }
            else if (liste.get(index).getObjeCount()<=1) {
                liste.remove(index);
                maxHeap();
            }

        }
        if (index == -1) {
            System.out.println("Element Not Found");
        }
    }
    public void maxHeap()
    {
        for (int pos = (liste.size() / 2); pos >=0;pos--) {
            maxHeapify(pos);
        }
    }

    /***
     * Repositioning items in the heap
     * @param fpos first position
     * @param spos second position
     */
    private void swap(int fpos, int spos)
    {
        E tmp;
        tmp = liste.get(fpos);
        liste.set(fpos, liste.get(spos));
        liste.set(spos, tmp);
    }

    /***
     *Heap adds new element
     * @param element is the item to add
     */
    public void add(Object element)
    {
        int index=0;
        for (int i = 0; i <liste.size(); i++) {
            if (liste.get(i).getData()==((E) element).getData()){
                liste.get(i).incrementoneData();
                index=1;
            }
        }
        if (index==0)
        liste.add((E) element);

        int current = bul(liste,(E)element);
        while (current!=-1 && compare(liste.get(current),liste.get(parent(current)))==1) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    /***
     * Find index of items
     * @param arr searched place
     * @param data searched element
     * @return if element is finded it is returned index of element place
     */
    private int bul(ArrayList<E> arr,E data){
        for (int i = 0; i <arr.size(); i++) {
            if (arr.get(i).getData() == data.getData()) {
                return i;
            }
        }
        return -1;
    }

    /***
     * Searches for the desired element in the heap
     * @param element searched element
     * @return if element is finded it is returned index of element place
     */
    public Object find(Object element){
        int flag=-1;
        for (int i = 0; i <liste.size(); i++) {
            if (liste.get(i).getData() ==((E) element).getData()) {
                flag=i;
                break;
            }
        }
        if(flag!=-1){
            return liste.get(flag);
        }
        else
            throw new NullPointerException("Not find element of heap");
    }

    /***
     * Shows the number of people older than the desired age
     * @param element searched age
     * @return  the number of people
     */
    public int olderThan(int element){
        int toplam=0;
        boolean flag=false;

        for (int i = 0; i <liste.size(); i++) {
            if (liste.get(i).getData() ==element) {
                flag=true;
            }
        }
        if (flag) {
            for (int i = 0; i <liste.size(); i++) {
                if (liste.get(i).getData()>element) {
                    toplam+=liste.get(i).getObjeCount();
                }
            }
        }
        return toplam;
    }

    /***
     *Shows the number of people younger than the desired age
     * @param element searched age
     * @return  the number of people
     */
    public int youngerThan(int element){
        int toplam=0;
        boolean flag=false;
        for (int i = 0; i <liste.size(); i++) {
            if (liste.get(i).getData() ==element) {
                flag=true;
            }
        }
        if (flag) {
            for (int i = 0; i <liste.size(); i++) {
                if(liste.get(i).getData()<element){
                    toplam+=liste.get(i).getObjeCount();
                }
            }
        }
        return toplam;
    }
    /***
     * Compares how many people are in the data
     * @param o1 is AgeDAta
     * @param o2 is AgeData
     * @return if first element big second element this function return 1,if second element big first element this function return -1
     * if two element equal this function can return 0
     */
    @Override
    public int compare(AgeData o1, AgeData o2) {
        if (o1.getObjeCount()>o2.getObjeCount())
            return 1;
        if (o1.getObjeCount()<o2.getObjeCount())
            return -1;
        return 0;
    }
}
