public class Node {
    int data;
    Node next;

    Node(int data){
        this.data = data;
        next = null;
    }

    void Add(Node head, int val){
        Node temp = new Node(val);
        Node cur = head;

        if(head == null)
        {
            return;
        }
        while(cur.next != null)
        {
            cur = cur.next;
        }
        cur.next = temp;
        return;

    }
    void display(){

        Node cur = this;
        while(cur != null)
        {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }
}
