import java.util.*;
public class MyHeap<E> implements Iterator<E> {
    private PriorityQueue<E> pQueue;

    public MyHeap() {
        pQueue = new PriorityQueue<E>();
    }

    // Adding items to the pQueue using add()
    public void HeapAdd(E temp){
        pQueue.offer(temp);
    }

    /***
     * Shows the root element of the heap structure
     * @return peek element
     */
    public E HeapPeek() {
        System.out.println("Head value using peek function:" + pQueue.peek());
        return pQueue.peek();
    }

    /***
     * Indicates how many elements are in the heap structure
     * @return
     */
    public int size(){
        int count=0;
        Iterator itr = pQueue.iterator();
        while (itr.hasNext()){
            count++;
            itr.next();
        }
        return count;
    }

    public PriorityQueue<E> getpQueue() {
        return pQueue;
    }

    /***
     * Merge two different heap structures
     * @param temp is a MyHeap structure
     */
    public void MergeHeap(MyHeap<E> temp){
        Iterator itr = temp.getpQueue().iterator();
        while (itr.hasNext()){
            this.pQueue.add((E) itr.next());
        }
    }

    /***
     * Shows the elements contained in the heap structure
     */
    public void Show() {
        Iterator itr = pQueue.iterator();
        while (itr.hasNext())
            System.out.print(itr.next()+" ");
    }
    /***
     * Checks for next element in heap structure to be null
     * @return is next element
     */
    @Override
    public boolean hasNext() {
        Iterator itr = pQueue.iterator();
        return itr.hasNext();
    }

    /***
     * Takes the Iterator to the next element
     * @return is next element
     */
    @Override
    public E next() {
        Iterator itr = pQueue.iterator();
        return (E) itr.next();
    }

    /***
     * Deletes the root element in the heap structure
     */
    @Override
    public void remove() {
        this.pQueue.remove();
    }

    /***
     *Deletes largest ith element in heap structure
     * @param index ith largest element from the Heap
     * @return delete element
     */
    public E RemoveTh(int index){
        if (index>this.pQueue.size()) {
            throw new IndexOutOfBoundsException();
        }
        else {
            ArrayList<E> arrayList = new ArrayList<E>(this.pQueue);
            Collections.sort(arrayList, Collections.reverseOrder());
            this.pQueue.remove(arrayList.get(index));
            E tmp=arrayList.remove(index);

            return tmp;
        }
    }

    /***
     * Checks if the searched item is in the heap structure
     * @param elem is Searched element
     * @return Returns true if element exists, false otherwise
     */
    public boolean findelement(E elem){
        return this.pQueue.contains(elem);
    }
    public Myiter<E> iterator(){
        return new Myiter<>();
    }

    public class Myiter<E> implements Iterator<E> {
        private PriorityQueue<E> mypq;
        public Myiter(){
            mypq=(PriorityQueue<E>)getpQueue();
        }
        @Override
        public boolean hasNext() {
            Iterator itr = mypq.iterator();
            return itr.hasNext();
        }

        @Override
        public E next() {
            Iterator itr = mypq.iterator();
            return (E) itr.next();
        }

        /***
         * It goes to the end of the PriorityQueue, deletes the element and adds the element to be set.
         * @param temp2 is element of add
         */
        public void LastSet(E temp2){
            E temp1=null;
            E y=(E) temp2;
            int i=0;
            Iterator itr = mypq.iterator();
            while (itr.next()!=null){
                temp1= (E) itr.next();
                if (!itr.hasNext()){
                   break;
                }
                i++;
            }
            getpQueue().remove(temp1);
            mypq.offer(y);
        }
    }
}
