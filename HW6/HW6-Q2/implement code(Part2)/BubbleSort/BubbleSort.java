public class BubbleSort {
    private  Node head;
    private int size;

    public BubbleSort(){
        this.head = null;
        this.size = 0;
    }

    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node currentNode = head;
            while(currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = node;
        }
        size++;
    }

    public void bubblesort() {
        if (size > 1) {
            boolean degs;
            do {
                Node current = head;
                Node previous = null;
                Node next = head.next;
                degs = false;

                while ( next != null ) {
                    if (current.data > next.data) {
                        degs = true;

                        if ( previous != null ) {
                            Node temp = next.next;

                            previous.next = next;
                            next.next = current;
                            current.next = temp;
                        } else {
                            Node sig = next.next;

                            head = next;
                            next.next = current;
                            current.next = sig;
                        }

                        previous = next;
                        next = current.next;
                    } else {
                        previous = current;
                        current = next;
                        next = next.next;
                    }
                }
            } while(degs);
        }
    }

    public void printData() {
        Node currentNode = head;
        while(currentNode != null) {
            int data = currentNode.getData();
            System.out.print(data+" ");
            currentNode = currentNode.next;
        }
    }
}
