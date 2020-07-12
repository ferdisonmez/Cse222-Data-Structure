public class LinkedListWrite {
    private Node head;
    private int length;
    public LinkedListWrite(){
        head=null;
    }
    public void addItem(int value){
        if(length==0)     // It means no element in the list
            head = new Node(value);
        else
            this.returnLastNode().appendNode(new Node(value));
        length++;
    }
    public Node returnLastNode(){
        Node tmp = head;
        while(tmp.returnNext()!=null){
            tmp = tmp.returnNext();
        }
        return tmp;
    }
    public void printList(){
        Node tmp = head;
        for(int i=0; i<length; i++){
            System.out.print(tmp.returnValue()+" ");
            tmp=tmp.returnNext();
        }
    }
    public Node returnNodeByIndex(int index){
        Node tmp = head;
        for(int i=0; i<index; i++){
            tmp = tmp.returnNext();
        }
        return tmp;
    }
    public int returnLength(){
        return this.length;
    }
}
