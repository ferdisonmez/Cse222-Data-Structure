public class Node {
    private int value;
    private Node next;
    public Node(int value){
        next=null;
        this.value = value;
    }
    public void appendNode(Node node){this.next = node;}
    public void setValue(int value){this.value = value;}
    public Node returnNext(){return this.next;}
    public int returnValue(){return this.value;}
}
