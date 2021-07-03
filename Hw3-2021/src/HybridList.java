import java.util.NoSuchElementException;

public class HybridList<E> implements Value{
    private static class Node<E> {
        //data fields
        private E data; // reference to the data
        private Node<E> next; // reference to the next node

        //Constructors
        public Node() {
            data=null;
            next=null;
        }
        /**
         * Create a new node with a null next field.
         *
         * @param dataItem The data stored
         */
        private Node(E dataItem) {
            data = dataItem;
            next = null;

        }

        /**
         * Create a new node that references another node
         *
         * @param dataItem The data stored
         * @param nodeRef  The node referenced by new node
         */
        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }


    }

    //data fields
    private Node<MyArrayList<E>> head = null; //reference to the head of the list
    private int size = 0; // size of the list

    /***
     * An iterator is defined for movement in Hybritlist.
     */
    public class Myiterator {
        private Node<MyArrayList<E>> position;
        private Node<MyArrayList<E>> previous; //previous value of position

        public Myiterator() {
            this.position =head;
            this.previous=null;
        }

        /***
         * This function restarts the iterator.
         */
        public void restart(){
            this.position =head;
            this.previous=null;
        }

        /***
         * It collects the information in the next element of the elements in this structure.
         * @return information of next element
         */
        public String next( )
        {
            if (!hasNext( ))
                throw new NoSuchElementException( );
            String toReturn = position.data.toString();
            previous = position;
            position = position.next;
            return toReturn;
        }
        public boolean find(String name){
            restart();
            while (position!=null){
                for (int j = 0; j <MAX_NUMBER ; j++) {
                    String[] arr=position.data.get(j).toString().split("/");
                    if (arr[0].equals(name)) {
                        System.out.println(position.data.get(j).toString());
                        return true;
                    }
                }
                position=position.next;
            }
            return false;
        }

        /***
         * Checks if the next element is available
         * @return true or false
         */
        public boolean hasNext( )
        {
            return (position != null);
        }

        /***
         * Lists all items within this structure
         */
        public void ShowLinkedList() {
            restart();
            if (position == null) {
                System.out.println("This Linkedlist is not fill");
            } else {
                while (position != null) {
                    position.data.Show();
                    position = position.next;
                }
            }
        }


        public int size() {
            restart();
            Node<MyArrayList<E>> temp = position;
            int say = 0;
            while (temp != null) {
                say++;
                temp = temp.next;
            }
            return say;
        }
        public int mysize(){
            return size;
        }

        /***
         * Adds new elements to this structure
         * @param e E type
         * @return true or false
         */
        public boolean add(E e) {
            restart();
            Node<MyArrayList<E>> temp = position;
            if (temp == null) {
                MyArrayList<E> yeni = new MyArrayList<E>();
                yeni.add(e);
                addFirst(yeni);
                previous=null;
                size++;
                return true;
            } else {
                while (temp.next != null && temp.data.size() == MAX_NUMBER)
                    temp = temp.next;
                if (temp.data.size() != MAX_NUMBER) {
                    temp.data.add(e);
                    return true;
                } else if (temp.next == null) {
                    MyArrayList<E> yeni = new MyArrayList<E>();
                    yeni.add(e);
                    addAfter(temp, yeni);
                    size++;
                    return true;
                }
            }
            return false;
        }

        /***
         * Auxiliary function used to add elements to the top of this structure
         * @param item is a Myarraylist structure
         */
        private void addFirst(MyArrayList<E> item) {
            Node<MyArrayList<E>> temp = new Node<MyArrayList<E>>(item,head);
            head = temp;
        }

        /***
         * Auxiliary function used to add elements to the tail of this structure
         * @param node is Node structure
         * @param item is a MyArraylist structure
         */
        private void addAfter(Node<MyArrayList<E>> node, MyArrayList<E> item) {
            Node<MyArrayList<E>> temp = new Node<MyArrayList<E>>(item, node.next);
            node.next = temp;
            previous=node;
        }

        /***
         * Used to delete an element in the structure.
         * @param index is element which delete of in this structure
         * @return element of structure
         */
        public E remove(E index) {
            restart();
            E delete=null;
            if (position == null)
                throw new IllegalStateException( );
            else if (previous == null && position.data.indexOf(index)!=-1)
            {
                if (rmvarraylist(index,position)!=null && position.data.size()==0) {
                    E temp=rmvarraylist(index,position);
                    head = head.next;
                    position = head;
                    size--;
                    return temp;
                }
            }
            else // previous and position are consecutive nodes
            {
                delete=rmvarraylist(index,position);
                if (delete != null &&  position.data.size()==0) {
                    if (position.next == null) {
                        previous.next=null;
                        size--;
                        return delete;
                    }
                    else {
                        previous.next = position.next;
                        position = previous.next;
                        size--;
                    }
                    return delete;
                }

                return delete;
            }
            return delete;
        }

        /***
         * Helper function for remove function
         * @param index
         * @param position
         * @return
         */
        private E rmvarraylist(E index,Node<MyArrayList<E>> position){
            while (position!=null && position.data !=null) {
                if (position.data.indexOf(index)!=-1) {
                    E temp=position.data.remove(position.data.indexOf(index));
                    return temp;
                }
                position = position.next;
            }
            return null;
        }

        /***
         * Finds the element in the structure
         * @param o
         * @return
         */
        public int indexOf(E o) {
            restart();
            if (position == null) {
                return -1;
            }
            else {
                while (position!=null){
                    if (position.data.indexOf(o)!=-1) {
                        return  position.data.indexOf(o);
                    }
                    position=position.next;
                }
            }
            return -1;
        }
    }//Myiterator

    public Myiterator iterator( )
    {
        return new Myiterator();
    }
}

