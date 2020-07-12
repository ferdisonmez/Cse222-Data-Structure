import java.util.Random;
public class Main {
    public static void main(String[] args){
        MergeSortLinkedList tmp = new MergeSortLinkedList();
        Node head = new Node(5);

        for (int i = 0; i <180000; i++)
            head.Add(head,Rdm());

        System.out.println("Linked List before sorting");
        head.display();
        long tStart = System.nanoTime();
        Node result = tmp.mergeSort(head);
        long tEnd = System.nanoTime();
        Time(tEnd,tStart);
        System.out.println("\nLinked List after sorting");
        result.display();



    }
    public static void Time(long tEnd,long tStart){
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000000;
        System.out.println("\nTime:"+elapsedSeconds);
    }
    public static int Rdm(){
        Random rand = new Random();
        // Generate random integers in range 0 to 999
        int rand_int1 = 1+rand.nextInt(1000);
        return rand_int1;
    }

}
