
public class SelectionSortLinkList {
    private Node head;

    public SelectionSortLinkList(){
        head=null;
    }
    public Node getHead(){
        return head;
    }
    public void addNode(int data)
    {
        if(head == null)
        {
            head = new Node(data);
            return;
        }

        Node curr = head;
        while(curr.next != null)
            curr = curr.next;

        Node newNode = new Node(data);
        curr.next = newNode;
    }

    public void printList(Node n)
    {
        while(n != null)
        {
            System.out.print(n.data);
            System.out.print(" ");
            n = n.next;
        }
    }

    void selectionSort(Node head)
    {
        Node temp = head;

        // Traverse the List
        while (temp!=null) {
            Node min = temp;
            Node r = temp.next;

            // Traverse the unsorted sublist
            while (r!=null) {
                if (min.data > r.data)
                    min = r;

                r = r.next;
            }

            // Swap Data
            int x = temp.data;
            temp.data = min.data;
            min.data = x;
            temp = temp.next;
        }
    }
}
