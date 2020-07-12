public class LinkListWrite<E> {
    /***
     * inner class
     * @param <E> is generic type
     */
    private class Node<E>
    {
         private E item;
         private Node<E> previous;
         private Node<E> next;
         public Node()
         {
             item = null;
             next = null;
             previous = null;
             }
         public Node(E newItem, Node<E> previousNode, Node<E> nextNode)
         {
             item = newItem;
             next = nextNode;
             previous = previousNode;
             }
    } //End of TwoWayNode inner class

        private Node<E> head;

        public LinkListWrite(){
            head=null;
        }

    /***
     * Add new nodes per linked list
     * @param itemName is the item to be added to the node
     */
    public void addToStart(E itemName)
        {
         Node<E> newHead = new Node(itemName, null, head);
         if (head != null)
             {
             head.previous = newHead;
             }
         head = newHead;
         }

    public class LinkListWriteIterator{
        private Node<E> position = null;

            public LinkListWriteIterator( )
            {
             position = head;
            }
            public void restart( )
            {
             position = head;
            }
             public boolean hasNext( )
            {
             return (position != null);
            }
            public E peek( )
            {
             if (!hasNext())
                 throw new IllegalStateException( );
             return position.item;
             }
        /***
         * Add new nodes per linked list with iterator
         * @param itemName is the item to be added to the node
         */
        public void addToStart(E itemName)
        {
            Node<E> newHead = new Node(itemName, null, head);
            if (head != null)
            {
                head.previous = newHead;
            }
            head = newHead;
        }

        /***
         * Returns the number of nodes in linked list
         * @return number of nodes in linked list
         */
        public int size(){
            int count=0;
            Node<E> temp=head;
           while (temp!=null){
               temp=temp.next;
               count++;
           }
            return count;
        }

        /***
         * Go to the next node in linked list
         * @return next node
         */
            public E next( )
            {
             if (!hasNext())
                 return null;
             E toReturn = position.item;
             position = position.next;
             return toReturn;
             }

        /***
         * Go to the previous node in linked list
         * @return previous node
         */
        public E prev(){
                Node<E> temp=position;
                if(temp!=null && temp.previous!=null)
                    temp=temp.previous;

                return temp.item;
             }

        /***
         * returns the value in the node
         * @return value in the node
         */
        public E takenext(){
            Node<E> temp=position;
            return temp.item;
        }

        /***
         * Returns whether linked list is in the last node
         * @return whether linked list is in the last node
         */
        public boolean nexttonext( )
        {
            if (position.next.next==null)
                    return true;
                else{
                    return false;
                }
        }

        /***
         * adding a new node to linked list
         * @param newData is generic type
         */
        public void insertHere(E newData)
            {
             if (position == null && head != null)
                 {
                 Node<E> temp = head;
                 while (temp.next != null)
                     temp = temp.next;
                 temp.next = new Node(newData, temp, null);
                 }
             else if (head == null || position.previous == null)
             LinkListWrite.this.addToStart (newData);
             else
             {
                 Node<E> temp = new Node(newData, position.previous, position);
                 position.previous.next = temp;
                 position.previous = temp;
                 }
             }

        /***
         * Indicates nodes in linkedlist
         */
        public void outputList( )
        {
            Node<E> position = head;
            while (position != null)
            {
                    System.out.println(position.item);
                position = position.next;
            }
        }

        /***
         * Delete item in linked list
         */
        public void delete( )
        {
             if (position == null)
                 throw new IllegalStateException( );
             else if (position.previous == null)
                 {
                 head = head.next;
                 head.previous=null;
                 position = head;
                 }
             else if (position.next == null)
                 {
                 position.previous.next = null;
                 position = null;
                 }
             else
             {
                 position.previous.next = position.next;
                 position.next.previous = position.previous;
                 position = position.next;
                 }
        }

        /***
         * Linked list delete the item at the beginning
         */
        public void onedelete(){
                if (position.previous == null)
                {
                head = head.next;
                position = head;
                }
        }

    }///LinkListWriteIterator
        public LinkListWriteIterator iterator( )
        {
         return new LinkListWriteIterator();
         }

}
