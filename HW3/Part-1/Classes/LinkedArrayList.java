import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
public class LinkedArrayList<T> extends AbstractList implements List {
    /***
     * Node structure
     * @param <T>
     */
    private class Node<T>{
        T[] data;
        Node<T> next;
        Node<T> prev;
        public Node(){
           this.data=(T[])new Object[10];
            next=null;
            prev=null;
        }

        /***
         * Constructor
         * @param newData is array
         * @param prev is previous node
         * @param next is next node
         */
        public Node (T[] newData, Node<T> prev,Node<T> next)
        {
            data = newData;
            this.next = next;
            this.prev=prev;
        }

        /***
         * Constructor
         * @param data is generic array
         */
        public Node(T[] data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }

        /***
         *
         * @param index is return of array element
         * @return element of array
         */
        public T get(int index){
            return this.data[index];
        }

        /***
         * This function can show of array all element
         */
        public void Show(){
            for (int i = 0; i <data.length; i++) {
                System.out.println(data[i]);
            }
        }

        /***
         * This method can return array size
         * @return array length
         */
        public int arraysize(){
            return this.data.length;
        }
        public boolean compare(T item){
            for (int i = 0; i <data.length; i++) {
                if (data[i].equals(item)) {
                    return true;
                }
            }
            return false;
        }

        /***
         * Deleted the last one of the elements in the array
         * @param elem is generic element
         * @param <E> is generic type
         */
        public <E> void elementdel(E elem){
            T[] newArr = (T[])new Object[data.length - 1];
            for(int j=0, k=0; j<data.length; j++) {
                if(data[j].equals(elem)){
                    continue;
                }
                newArr[k++] = (T) data[j];
            }
            this.data= (T[]) newArr;

        }

        /***
         *Adds to the very end of the array
         * @param elem is generic element
         * @param <E> is genneric type
         * @return true or false
         */
        public <E> boolean elementAdd(E elem){
            if (data.length==10){
                return false;
            }
            else {
                T[] newarr =(T[]) new Object[data.length + 1];
                for (int i = 0; i < data.length; i++)
                    newarr[i] = data[i];

                newarr[data.length] = (T) elem;
                this.data=(T[])newarr;
                return true;
            }
        }

        /***
         * This method can add specific index which is special place  of array
         * @param pos is specific place
         * @param element  is element which can add element
         * @param <E> is generic type
         */
        public <E> void addelement(int pos,E element){
            int n=data.length;
            T[] newarr = (T[])new Object[n + 1];
            for (int i = 0; i < n + 1; i++) {
                if (i < pos)
                    newarr[i] = data[i];
                else if (i == pos)
                    newarr[i] = (T) element;
                else
                    newarr[i] = data[i - 1];
            }
            this.data=(T[])newarr;
        }

    }///Node End

    /***
     * Constructor for LinkedArrayList
     */
    private Node<T> head;
    public LinkedArrayList(){
        head=null;
    }

    /***
     * Returns a node in a given index
     * @param index is specific element
     * @return desired Node
     */
    @Override
    public Object get(int index) {
        Node<T> current = head;
        int count = 0;
        while (current != null)
        {
            if (count == index)
                return current;
            count++;
            current = current.next;
        }
        return null;
    }

    /***
     * This method can add node which is start node
     * @param itemData is generic array
     */
    public void addToStart(T[] itemData)
    {
        head = new Node<T> (itemData,null,head);
    }

    /***
     * This method can return size of linkedlist
     * @return Linkedlist size
     */
    @Override
    public int size( )
        {
         int count = 0;
         Node<T> position = head;
         while (position != null)
             {
             count++;
             position = position.next;
             }
         return count;
        }

    /***
     * This method can check empty of linked list
     * @return true or false
     */
    public boolean isEmpty( )
     {
         return (head == null);
     }

    /***
     * iterator defined to navigate within this class
     */
    public class DoublyIterator implements Iterator{
        private Node<T> position;

        public DoublyIterator(){
            position=head;
        }
        public void restart(){
            position=head;
        }

        /***
         * Checks if the rover's next link is full
         * @return true or false
         */
        @Override
        public boolean hasNext( )
        {
            return (position != null);
        }

        /***
         * Use to go there if the next node is full
         * @return
         */
        @Override
        public Object next() {
            if (!hasNext( ))
                 throw new IllegalStateException( );
             Object toReturn = position.data;
             position = position.next;
             return toReturn;
        }

        /***
         * Shows elements in all nodes
         */
        public void outputList( )
            {
             Node<T> position = head;
             while (position != null)
                 {
                     for (int i = 0; i <position.data.length ; i++) {
                         System.out.println(position.data[i]);
                     }

                 position = position.next;
                 }
             }

        /***
         * Adds new nodes sequentially on linkedlist
         * @param newData is generic Array
         */
        public  void insertHere(T[] newData)
          {
             if (position == null && head != null)
                 { //sona add
                 Node<T> temp = head;
                 while (temp.next != null)
                     temp = temp.next;
                 temp.next = new Node<T>(newData, temp, null);
                 }
             else if (head == null || position.prev == null)
             LinkedArrayList.this.addToStart (newData);
             else
             {
                 Node<T> temp = new Node<T>(newData,position.prev, position);
                 position.prev.next = temp;
                 position.prev = temp;
                 }
          }

        /***
         * Add elements to the desired location in the array
         * @param index is specific place for array
         * @param newData is generic element
         */
        public void addindex(int index,T newData)
        {
            int count=0;
            int tut=0;
            position=head;
            count+=position.arraysize();

            if (count>index){
                position.addelement(index,newData);
            }
            else{
                for (int i = 0; i <size()-1; i++) {
                    tut+=position.arraysize();
                    position = position.next;
                    count+=position.arraysize();
                    if (count>index){
                        for (int j = 0; j <position.data.length ; j++) {
                            if(tut==index){
                                position.addelement(j,newData);
                            }
                            tut++;
                        }
                    }

                }
            }

        }
        /***
         * Node delete
         * @param index which is delete node in linkedlist
         */
        public void delete(int index)
         {
             Node<T> temp=head;
             for (int i = 0; i <index; i++) {
                 temp=temp.next;
             }
             position=temp;

             if (position == null)
                 throw new IllegalStateException( );
             else if (position.prev == null)
                 { // Deleting first node
                 head = head.next;
                 position = head;
                 }
             else if (position.next == null)
                 { // Deleting last node
                 position.prev.next = null;
                 position = null;
                 }
             else
             {
                 position.prev.next = position.next;
                 position.next.prev = position.prev;
                 position = position.next;
                 }
         }
        /***
         * Delete for node
         * @param temp
         */
        public void deleteNode(Node<T> temp)
        {
            position=temp;

            if (position == null)
                throw new IllegalStateException( );
            else if (position.prev == null)
            { // Deleting first node
                head = head.next;
                position = head;
            }
            else if (position.next == null)
            { // Deleting last node
                position.prev.next = null;
                position = null;
            }
            else
            {
                position.prev.next = position.next;
                position.next.prev = position.prev;
                position = position.next;
            }
        }

        /***
         * Finde Node in linkedlist
         * @param target
         * @return Node
         */
        private Node<T> find(T target)
        {
             Node<T> position = head;
             T itemAtPosition;
             while (position != null)
                 {
                 if (position.compare(target))
                     return position;
                 position = position.next;
                 }
             return null; //target was not found
        }

        /***
         * call find function
         * @param target
         * @return
         */
        public Node<T> findData(T target)
         {
             Node<T> result = find(target);
             if (result == null){
                 return null;
             }
             else
             return result;
         }

        /***
         * In the nodes, the item to be deleted is deleted.
         * @param tar
         */
         public void sil(T tar){
            if (findData(tar)==null){
                System.out.println("Not Found Elements");
            }
            else{
                Node<T> temp=findData(tar);
                if(temp.arraysize()==0){
                    System.out.println("Delete Node Because array is not fill");
                    deleteNode(temp);
                }
                else {
                    temp.elementdel(tar);
                    if (temp.arraysize()==0){
                        System.out.println("Delete Node Because array is not fill");
                        deleteNode(temp);
                    }
                }
            }
         }

    }///DoublyIterator
    public DoublyIterator iterator( )
    {
         return new DoublyIterator();
    }
    
}///Linkedlist

