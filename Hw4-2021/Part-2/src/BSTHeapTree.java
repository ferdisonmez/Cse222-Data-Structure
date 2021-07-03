public class BSTHeapTree<E extends Comparable<E>>{
    private BinarySearchTree<MaxHeap<E>> binarySearchTree;
    private int TreeMode;  //Tree Mode Element
    public BSTHeapTree(){
        binarySearchTree=new BinarySearchTree<MaxHeap<E>>();
        binarySearchTree.root=null;
        TreeMode=0;
    }
    public BSTHeapTree(BinarySearchTree<MaxHeap<E>> binarySearchTree) {
        this.binarySearchTree = binarySearchTree;
        binarySearchTree.root=null;
        TreeMode=0;
    }

    /***
     * If it finds empty space in maxHeap it can insert into maxheap,otherwise  it creates a new node and adds
     * @param item is added element
     * @return the number of occurrences of the item after insertion
     */
    public int add(E item){
        HelperAdd(this.binarySearchTree.root,item);
        return 0;
    }
    public int HelperAdd(Node<MaxHeap<E>> node,E item){
        if (node==null){
            MaxHeap<E> maxHeap1=new MaxHeap<E>();
            maxHeap1.insert(item);
            binarySearchTree.add(maxHeap1);
            return 1;
        }
         if(node.data.HeapSize()>=1){
            node.data.insert(item);
            if (node.data.HeapSize()%7==0 && node.data.HeapSize()>=7){

                int compare=node.data.compareTo(new MaxHeap<E>(item));
                if (compare<0) {
                    return HelperAdd(node.left,item);
                }
                return HelperAdd(node.right,item);
            }

        }
        return node.data.HeapSize();
    }

    /***
     * Deletes the desired item from within the structure.
     * @param item is deleted element
     * @return the number of occurrences of the item after removal
     */
    public int remove(E item){
        int kalan=0,flag=0;
        flag+=HelperRemove(this.binarySearchTree.root,item,kalan,flag);
        if (flag==0){
            System.out.println("Element Not Found For Delete");
        }
        return 0;

    }
    private int HelperRemove(Node<MaxHeap<E>> node,E item,int kalan,int flag){
        if (node == null) {
            return 0; }
       flag+= HelperRemove(node.left,item,kalan,flag);
        flag+=HelperRemove(node.right,item,kalan,flag);
        if (node.data.HeapSize()>1){
            if (node.data.MyRemove(item)==1){
                flag++;
            }
            kalan=node.data.findElementSize(item);
            return flag;
        }
        if (node.data.findHeap(item) && node.data.HeapSize()==1) {
            this.binarySearchTree.delete((new MaxHeap(item)));
            System.out.println("Delete:"+item);
            flag++;
            return flag;
        }
        return flag;
    }

    /***
     *Finds how much of the searched item is in the structure
     * @param item which is  searched element
     * @return the number of occurrences of the item in the BSTHeapTree
     */
    public int find(E item){
        int sayac=0;
        sayac+=HelperFind(this.binarySearchTree.root,item,sayac);
        if (sayac == 0) {
            System.out.println("NOT FOUND");
            return 0;
        }
        else {
            System.out.println("FOUNDED:"+sayac);
            return sayac;
        }
    }
    private int HelperFind(Node<MaxHeap<E>> node,E item,int sayac){
        if (node == null) {
            return 0; }
        if (node.data.findElementSize(item)!=-1){
                int a=node.data.findElementSize(item);
                if(a>0)
                  sayac+=a;
            return sayac;
        }
        if(node.left!=null && node.left.data.compareTo(new MaxHeap(item))<1) {
           return sayac+HelperFind(node.left, item, sayac);
        }
        return sayac+HelperFind(node.right,item,sayac);
    }

    /***
     * Finds the most recurring element of the BSTHeapTree structure
     */
    public void find_mode(){
        System.out.println("Mode: "+mode(this.binarySearchTree.root));
    }
    private int mode(Node<MaxHeap<E>> node){
        if (node == null) {
            return 0; }
        mode(node.left);
        if (node.data.BigMode()>TreeMode)
            TreeMode=node.data.BigMode();
        mode(node.right);
        return TreeMode;
    }

    /***
     * Prints the BSTHeapTree structure to the screen
     */
    public void PrintTree(){
        SHOW(this.binarySearchTree.root);
    }
    private void SHOW(Node<MaxHeap<E>> node){
        if (node == null) {
            return; }
        SHOW(node.left);
        node.data.print();
        SHOW(node.right);
    }

}
