import java.util.AbstractCollection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DequeWrite<E> extends AbstractCollection implements Deque {
    private LinkListWrite<E> readlist;
    private  LinkListWrite<E> deletelist;

    public DequeWrite(){
        readlist=new LinkListWrite<>();
        deletelist=new LinkListWrite<>();
    }
    public class DequeIterator implements Iterator<E>{
        private LinkListWrite<E> position;
        @Override
        public boolean hasNext() {
            return (position != null);
        }

        @Override
        public E next() {
            if (!hasNext())
                return null;
            position =deletelist;
            return  (E) deletelist;
        }
    }
    public class DequeIteratorReverse implements Iterator<E>{
        private LinkListWrite<E> position;
        @Override
        public boolean hasNext() {
            return (position != null);
        }

        @Override
        public E next() {
            if (!hasNext())
                return null;
            position = readlist;
            return (E) readlist;
        }
    }

    @Override
    public Iterator iterator() {

        return new DequeIterator();
    }

    @Override
    public Iterator descendingIterator() {

        return new DequeIteratorReverse();
    }

    /***
     * Adds an element to the beginning of the Deque structure
     * @param o is the element to be added
     */
    @Override
    public void addFirst(Object o) {
        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        LinkListWrite.LinkListWriteIterator iter1=deletelist.iterator();
        int flag=-1;
            while (iter1.hasNext()){
                if (iter1.takenext().equals(o)){
                    flag=1;
                    break;
                }

                iter1.next();
            }
        iter.restart();
            if (iter==null){
                throw new NullPointerException("Hw4");
            }
            if (flag==1){
                iter.addToStart(iter1.takenext());
                iter1.delete();
            }
            else
                iter.addToStart(o);
    }

    /***
     * Adds an element to the end of the Deque structure
     * @param o is the element to be added
     */
    @Override
    public void addLast(Object o) {
        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        LinkListWrite.LinkListWriteIterator iter1=deletelist.iterator();
        int flag=-1;
        while (iter.hasNext()){
            iter.next();
            if (iter==null)
                break;
        }
        while (iter1.hasNext()){
            if (iter1.takenext().equals(o)){
                flag=1;
                break;
            }
            iter1.next();
        }
        if (flag==1){
            iter.insertHere(iter1.takenext());
            iter1.delete();
        }
        else
            iter.insertHere(o);
    }

    /***
     * Adds an element to the beginning of the Deque structure
     * @param o is the element to be added
     * @return the wrong value if the item is not  added correctly if it is added
     */
    @Override
    public boolean offerFirst(Object o) {
        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        LinkListWrite.LinkListWriteIterator iter1=deletelist.iterator();
        int flag=-1;
        while (iter1.hasNext()){
            if (iter1.takenext().equals(o)){
                flag=1;
                break;
            }
            iter1.next();
        }
        iter.restart();
        if (iter==null && iter.size()>0)
            return false;
        if (flag==1){
            iter.insertHere(iter1.takenext());
            iter1.delete();
            return true;
        }
        else{
            iter.insertHere(o);
            return true;
        }

    }

    /***
     * Adds an element to the end of the Deque structure
     * @param o is the element to be added
     * @return the wrong value if the item is not  added correctly if it is added
     */
    @Override
    public boolean offerLast(Object o) {
        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        LinkListWrite.LinkListWriteIterator iter1=deletelist.iterator();
        while (iter.hasNext()){
            iter.next();
        }
        int flag=-1;
        while (iter1.hasNext()){
            if (iter1.takenext().equals(o)){
                flag=1;
                break;
            }
            iter1.next();
        }
        if (iter==null && iter.size()>0)
            return false;
        if (flag==1){
            iter.insertHere(iter1.takenext());
            iter1.delete();
            return true;
        }
        else{
            iter.insertHere(o);
            return true;
        }
    }

    /***
     *Delete the element at the beginning of the Deque structure
     * @return deleted item
     */
    @Override
    public Object removeFirst() {
        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        LinkListWrite.LinkListWriteIterator iter1=deletelist.iterator();
        iter.restart();
        if (iter.size()<0){
            throw new NoSuchElementException();
        }
        if(iter.size()==1){
            E temp=(E) iter.takenext();
            iter1.insertHere(temp);
            iter.onedelete();
            return temp;
        }
        else {
            E temp= (E) iter.takenext();
            iter.delete();
            iter1.insertHere(temp);
            return temp;

        }

    }

    /***
     * Delete the element at the end of the Deque structure
     * @return deleted item
     */
    @Override
    public Object removeLast() {
        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        LinkListWrite.LinkListWriteIterator iter1=deletelist.iterator();
        if (iter.size()<0){
            throw new NoSuchElementException();
        }
        if(iter.size()==1){
            E temp=(E) iter.takenext();
            iter1.insertHere(temp);
            iter.onedelete();
            return temp;
        }
        while (iter.hasNext()){
            if (iter.nexttonext())
                 break;
            iter.next();
        }
        iter.next();
        E temp=(E) iter.takenext();
       iter1.insertHere(temp);
        iter.delete();
        return temp;
    }

    /***
     * Delete the element at the beginning of the Deque structure
     * @return deleted item
     */
    @Override
    public Object pollFirst() {
        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        LinkListWrite.LinkListWriteIterator iter1=deletelist.iterator();
        iter.restart();
        if (iter.size()<0){
            return null;
        }
        if(iter.size()==1){
            E temp=(E) iter.takenext();
            iter1.insertHere(temp);
            iter.onedelete();
            return temp;
        }
        else {
            E temp= (E) iter.takenext();
            iter.delete();
            iter1.insertHere(temp);
            return temp;
        }

    }

    /***
     * Delete the element at the end of the Deque structure
     * @return deleted item of end of linkedlist
     */
    @Override
    public Object pollLast() {
        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        LinkListWrite.LinkListWriteIterator iter1=deletelist.iterator();
        if (iter.size()<0){
            return null;
        }
        if(iter.size()==1){
            E temp=(E) iter.takenext();
            iter1.insertHere(temp);
            iter.onedelete();
            return temp;
        }
        while (iter.hasNext()){
            if (iter.nexttonext())
                break;
            iter.next();
        }
        iter.next();
        E temp=(E) iter.takenext();
        iter1.insertHere(temp);
        iter.delete();
        return temp;
    }

    /***
     * Shows the leading item in the deque structure
     * @return  the first item
     */
    @Override
    public Object getFirst() {
        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        iter.restart();
        if (iter.size()<0){
            throw new NoSuchElementException();
        }
        return iter.next();
    }

    /***
     * Shows the end item in the deque structure
     * @return the last item
     */
    @Override
    public Object getLast() {
        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        if (iter.size()<0){
            throw new NoSuchElementException();
        }
        if(iter.size()==1){
            E temp=(E) iter.takenext();
            iter.delete();
            return temp;
        }
        while (iter.hasNext()){
            if (iter.nexttonext())
                break;
            iter.next();
        }
        iter.next();
        E temp=(E) iter.takenext();
        return temp;
    }

    /***
     * Shows the leading item in the deque structure
     * @return the first item
     */
    @Override
    public Object peekFirst() {
        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        iter.restart();
        if (iter.size()<0){
            return null;
        }
        return iter.next();
    }

    /***
     * Shows the end item in the deque structure
     * @return the last item
     */
    @Override
    public Object peekLast() {
        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        if (iter.size()<0){
            return null;
        }
        if(iter.size()==1){
            E temp=(E) iter.takenext();
            iter.delete();
            return temp;
        }
        while (iter.hasNext()){
            if (iter.nexttonext())
                break;
            iter.next();
        }
        iter.next();
        return iter.takenext();
    }

    /***
     * Deletes the first item requested from the beginning of the tail
     * @param o is the item to be deleted
     * @return the false value if the item is not  deleted true if it is deleted
     */
    @Override
    public boolean removeFirstOccurrence(Object o) {
        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        LinkListWrite.LinkListWriteIterator iter1=deletelist.iterator();
        if (iter.size()<0){
            return false;
        }
        int flag=-1;
        if (iter.size()==1){
            if (iter.takenext().equals(o)){
                iter1.insertHere(iter.takenext());
                iter.onedelete();
                return true;
            }
            else
                return false;
        }
        while (iter.hasNext()){
            if (iter.takenext().equals(o)){
                flag=0;
                break;
            }
            iter.next();
        }
        if (flag==0){
            E temp=(E) iter.takenext();
            iter1.insertHere(temp);
            iter.delete();
            return true;
        }
        else{
            return false;
        }

    }

    /***
     * Deletes the first item requested from the end of the tail
     * @param o is the item to be deleted
     * @return the false value if the item is not  deleted true if it is deleted
     */
    @Override
    public boolean removeLastOccurrence(Object o) {
        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        LinkListWrite.LinkListWriteIterator iter1=deletelist.iterator();
        if (iter.size()<0){
            return false;
        }
        if (iter.size()==1){
            if (iter.takenext().equals(o)){
                iter1.insertHere(iter.takenext());
                iter.onedelete();
                return true;
            }
             else
                 return false;
        }

        while (iter.hasNext()){
            if (iter.nexttonext())
                break;
            iter.next();
        }
        iter.next();
        if (iter.takenext().equals(o)){
            E temp=(E) iter.takenext();
            iter1.insertHere(temp);
            iter.delete();
            return true;
        }
       else
        return false;
    }

    /***
     *Adds an element the Deque structure
     * @param o is the item to be added
     * @return the wrong value if the item is not  added correctly if it is added
     */
    @Override
    public boolean offer(Object o) {
        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        if(o==null)
            return false;
        else{
            while (iter.hasNext()){
                iter.next();
            }
            iter.insertHere(o);
            return true;
        }
    }

    /***
     * Deletes the first element in the Deque structure
     * @return is deleted item
     */
    @Override
    public Object remove() {
        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        LinkListWrite.LinkListWriteIterator iter1=deletelist.iterator();
        if (iter.size()<0){
            return null;
        }
        if(iter.size()==1){
            E temp=(E) iter.takenext();
            iter1.insertHere(temp);
            iter.onedelete();
            return temp;
        }
        while (iter.hasNext()){
            if (iter.nexttonext())
                break;
            iter.next();
        }
        iter.next();
        E temp=(E) iter.takenext();
        iter1.insertHere(temp);
        iter.delete();
        return temp;
    }

    /***
     * Deletes the first element in the Deque structure
     * @return is deleted item
     */
    @Override
    public Object poll() {
        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        LinkListWrite.LinkListWriteIterator iter1=deletelist.iterator();
        if (iter.size()<0){
            return null;
        }
        if(iter.size()==1){
            E temp=(E) iter.takenext();
            iter1.insertHere(temp);
            iter.onedelete();
            return temp;
        }
        while (iter.hasNext()){
            if (iter.nexttonext())
                break;
            iter.next();
        }
        iter.next();
        E temp=(E) iter.takenext();
        iter1.insertHere(temp);
        iter.delete();
        return temp;
    }

    /***
     *Shows the first item in the Deque structure
     * @return is first item
     */
    @Override
    public Object element() {
        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        return iter.takenext();
    }

    /***
     *Shows the first item in the Deque structure
     * @return is first item
     */
    @Override
    public Object peek() {
        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        iter.restart();
        return iter.takenext();
    }

    /***
     * Adds an element to the end of the Deque structure
     * @param o is added item
     */
    @Override
    public void push(Object o) {

        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        while (iter.hasNext()){
            iter.next();
            }
        iter.insertHere(o);
    }

    /***
     *The last element in the Deque structure is deleted
     * @return deleted element
     */
    @Override
    public Object pop() {
        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        LinkListWrite.LinkListWriteIterator iter1=deletelist.iterator();
        if (iter.size()<0){
            return null;
        }
        while (iter.hasNext()){
            if (iter.nexttonext())
                break;
            iter.next();
        }
        iter.next();
        E temp=(E) iter.takenext();
        iter1.insertHere(temp);
        iter.delete();
        return temp;
    }

    /***
     * Shows linkedlist size held in Deque structure
     * @return Linkedlist size
     */

    @Override
    public int size() {
        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        int count=0;
        while (iter.hasNext()){
            count++;
            iter.next();
        }
        return count;
    }

    /***
     * shows items in the linked list(READ)
     */
    public void outputListDequeRead()
    {
        System.out.println("**Deque Read**");
        LinkListWrite.LinkListWriteIterator iter=readlist.iterator();
        while (iter.hasNext())
        {
            System.out.println(iter.next());
        }
    }

    /***
     *shows items in the linked list(DELETE)
     */
    public void outputListDequeDelete()
    {
        System.out.println("**Deque Delete**");
        LinkListWrite.LinkListWriteIterator iter=deletelist.iterator();
        while (iter.hasNext())
        {
            System.out.println(iter.next());
        }
    }
}
