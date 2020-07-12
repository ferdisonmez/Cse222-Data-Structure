public class HeapSort {
    private LinkedListWrite list;
    private int length;
    public HeapSort(){}
    public void init(LinkedListWrite list){
        this.list = list;
        this.length = list.returnLength();
    }
    public void startSort(){
        for(int i=length/2-1; i>=0; i--){
            heapify(i, length);
        }
        for(int i=length-1; i>0 ; i--){
            swap(0, i);           // swap the first element(biggest) to the sorted group in each time
            heapify(0, i);        // check maxHeap's properties with unsorted group
        }
    }
    public void heapify(int root, int length){
        int left = root*2+1;          // left Child  -> n*2+1
        int right = root*2+2;         // Right Child -> n*2+2
        int maxHeap = root;           // assume root is largest

        /* check whether it fulfills the maxHeap's properties */
        maxHeap = left<length && list.returnNodeByIndex(left).returnValue()>list.returnNodeByIndex(maxHeap).returnValue() ? left : maxHeap;
        maxHeap = right<length &&list.returnNodeByIndex(right).returnValue()>list.returnNodeByIndex(maxHeap).returnValue() ? right : maxHeap;

        if(maxHeap!=root){            // It means not fulfill
            swap(root, maxHeap);       // swap
            heapify(maxHeap, length);  // check again
        }
    }
    public void swap(int i, int j){
        int tmp = list.returnNodeByIndex(i).returnValue();
        list.returnNodeByIndex(i).setValue(list.returnNodeByIndex(j).returnValue());
        list.returnNodeByIndex(j).setValue(tmp);
    }
}
