import java.util.ArrayList;
public class MaxHeap<E extends Comparable<E>> implements Comparable<MaxHeap<E>> {
    @Override
    public int compareTo(MaxHeap o) {
        return this.Heap.get(0).compareTo((MyValue) o.Heap.get(0));
    }

    private class MyValue<E extends Comparable<E>> implements Comparable<MyValue<E>>{
        private E value;
        private int freq;

        public MyValue(E value){
            this.value=value;
            this.freq=0;
        }
        public MyValue(E value, int freq) {
            this.value = value;
            this.freq = freq;
        }

        public E getValue() {
            return value;
        }

        public int getFreq() {
            return freq;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }
        public void incFreq(){
            this.freq++;
        }
        public void decFreq(){
            this.freq--;
        }
        @Override
        public String toString() {
            return "value=" + value + ", freq=" + freq + '}';
        }

        @Override
        public int compareTo(MyValue<E> o) {
            return this.value.compareTo(o.value);
        }
    }//MyValue

    private ArrayList<MyValue> Heap;

    public MaxHeap()
    {
        Heap = new ArrayList<MyValue>();
    }
    public MaxHeap(E temp){
        MyValue myValue=new MyValue(temp);
        Heap = new ArrayList<MyValue>();
        Heap.add(myValue);
    }

    /***
     * Returns position of parent
     * @param pos
     * @return
     */
    private int parent(int pos) {
        return pos / 2;
    }


    /***
     * This functions return left children
     * @param pos
     * @return
     */
    private int leftChild(int pos) { return (2 * pos); }

    /***
     * This functions return right children
     * @param pos
     * @return
     */
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    /***
     * Returns true of given node is leaf
     * @param pos is leaf position
     * @return boolean value
     */
    private boolean isLeaf(int pos)
    {
        if (pos > (Heap.size() / 2) && pos <= Heap.size()) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos)
    {
        MyValue tmp;
        tmp = Heap.get(fpos);
        Heap.set(fpos,Heap.get(spos));
        Heap.set(spos,tmp);
    }

    /***
     * A recursive function to max heapify the given subtree.
     * @param pos is position
     */
    private void maxHeapify(int pos)
    {
        if (isLeaf(pos))
            return;

        if (Heap.get(pos).compareTo(Heap.get(leftChild(pos)))==1
                || Heap.get(pos).compareTo(Heap.get(rightChild(pos)))==1) {

            if (Heap.get(leftChild(pos)).compareTo(Heap.get(rightChild(pos)))==-1) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    /***
     * Inserts a new element to max heap
     * @param  element is insert element
     */
    public void insert(E element)
    {
        for (int i = 0; i <Heap.size(); i++) {
            if (Heap.get(i).value.compareTo(element) ==0) {
                Heap.get(i).incFreq();
                return;
            }
        }
        Heap.add(new MyValue(element,1));
        int current = Heap.size()-1;
        while (Heap.get(current).compareTo(Heap.get(parent(current)))==1) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    /***
     * Print all Heap structure
     */
    public void print()
    {
        for (int i = 0; i <=Heap.size()-1; i++) {
            System.out.println("Element:"+Heap.get(i));
        }
    }

    /***
     * Remove an element from max heap
     * @return delete top(peek) elemenet
     */
    public MyValue extractMax()
    {
        MyValue popped = Heap.get(0);
        Heap.set(0,Heap.get(Heap.size()-1));
        Heap.remove(0);
        return popped;
    }

    /***
     * Shows the largest element in the heap structure
     * @return largest element in heap
     */
    public MyValue returnMax(){
        System.out.println("Max:"+Heap.get(0).toString());
        maxHeapify(0);
        return Heap.get(0);
    }
    public int HeapSize(){
        return Heap.size();
    }

    /***
     * It decreases the frequency of the element we want to delete, if its frequency is 1, it deletes it completely.
     * @param elem delete element
     */
    public int MyRemove(E elem){
        for (int i = 0; i <Heap.size(); i++) {
            if (Heap.get(i).value.compareTo(elem)==0) {
                if (Heap.get(i).freq>1) {
                    Heap.get(i).decFreq();
                    return 1;
                }
                else if(Heap.get(i).value.compareTo(elem)==0){
                    Heap.remove(Heap.get(i));
                    return 1;
                }
            }
         }
        return -1;
    }

    /***
     * Finds the most frequent element in the Max Heap structure
     * @return Most frequent element
     */
    public int BigMode(){
        int mode=0;
        MyValue temp;
        for (int i = 0; i <Heap.size(); i++) {
            if (Heap.get(i).freq>mode) {
                mode=Heap.get(i).freq;
                temp=Heap.get(i);
            }
        }
        return mode;
     }

    /***
     * Calculates the frequent amount of the required element in the Max Heap structure.
     * @param item is element
     * @return frequent amount
     */
    public int findElementSize(E item){
        for (int i = 0; i <Heap.size(); i++) {
            if (Heap.get(i).value.compareTo(item)==0) {
                return Heap.get(i).freq;
            }
        }
        return -1;
    }
    public boolean findHeap(E item){
        for (int i = 0; i <Heap.size(); i++) {
            if (Heap.get(i).value.compareTo(item) ==0) {
                return true;
            }
        }
        return false;
    }

}
