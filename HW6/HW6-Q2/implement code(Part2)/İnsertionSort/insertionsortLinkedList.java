public class insertionsortLinkedList {
    private Node head;
    private Node sorted;

    public void add(int val)  {
        //allocate a new node
        Node newNode = new Node(val);
        //link new node to list
        newNode.next = head;
        //head points to new node
        head = newNode;
    }
    public void insertion_Sort(Node headref)   {
        // initially, no nodes in sorted list so its set to null
        sorted = null;
        Node current = headref;
        // traverse the linked list and add sorted node to sorted list
        while (current != null)  {
            // Store current.next in next
            Node next = current.next;
            // current node goes in sorted list
            Insert_sorted(current);
            // now next becomes current
            current = next;
        }
        // update head to point to linked list
        head = sorted;
    }
    public void Insert_sorted(Node newNode)   {
        //for head node
        if (sorted == null || sorted.val >= newNode.val)    {
            newNode.next = sorted;
            sorted = newNode;
        }
        else  {
            Node current = sorted;
            //find the node and then insert
            while (current.next != null && current.next.val < newNode.val)   {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }
    public void printList(Node head)   {
        while (head != null)   {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
    public Node getHead(){
        return head;
    }

}
