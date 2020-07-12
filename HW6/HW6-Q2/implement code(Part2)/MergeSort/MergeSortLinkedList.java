public class MergeSortLinkedList {
    public Node findMiddle(Node head){
        if(head == null )
            return null;

        Node slow, fast;
        slow = head;
        fast = head;

        while(fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public Node merge(Node first, Node second){

        Node head = null;
        while(first != null && second != null){

            if(first.data < second.data){
                if(head == null){
                    head = new Node(first.data);
                }
                else
                    head.Add(head,first.data);
                first = first.next;
            }
            else if(second.data < first.data){
                if(head == null){
                    head = new Node(second.data);
                }
                else
                    head.Add(head,second.data);
                second = second.next;
            }
            else{
                if(head == null){
                    head = new Node(first.data);
                    head.Add(head,second.data);
                }
                else{
                    head.Add(head,first.data);
                    head.Add(head,second.data);
                }
                second = second.next;
                first = first.next;
            }
        }
        while(first != null){
            if(head == null){
                head = new Node(first.data);
            }
            else
                head.Add(head,first.data);
            first = first.next;
        }

        while(first != null){
            if(head == null){
                head = new Node(first.data);
            }
            else
                head.Add(head,first.data);
            first = first.next;
        }

        while(second != null){
            if(head == null){
                head = new Node(second.data);
            }
            else
                head.Add(head,second.data);
            second = second.next;
        }


        return head;
    }

    public Node mergeSort(Node head){

        if(head == null)
            return null;

        if(head.next == null)
            return head;

        Node first = head;
        Node mid = findMiddle(first);
        Node second = mid.next;
        mid.next = null;
        Node left = mergeSort(first);
        Node right = mergeSort(second);
        Node result = merge(left, right);
        return result;

    }
}
