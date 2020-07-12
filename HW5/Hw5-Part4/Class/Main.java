public class Main {
    public static void main(String[] args){
        try {
            MaxHeap<AgeData> heap = new MaxHeap<AgeData>();
            heap.add(new AgeData(10));
            heap.add(new AgeData(5));
            heap.add(new AgeData(70));
            heap.add(new AgeData(10));
            heap.add(new AgeData(50));
            heap.add(new AgeData(5));
            heap.add(new AgeData(15));
            heap.remove(new AgeData(10));
            String temp = heap.toString();
            System.out.println(temp);
            System.out.println("****OlderThan****");
            System.out.println(heap.olderThan(10));
            System.out.println(heap.olderThan(2000));
            System.out.println("****YoungerThan****");
            System.out.println(heap.youngerThan(10));
            System.out.println(heap.youngerThan(1520));
            System.out.println("***Find****");
            System.out.println(heap.find(new AgeData(10)).toString());
            System.out.println(heap.find(new AgeData(1000)).toString());
        }catch (NullPointerException e){
            System.out.println("You searched non-element");
        }
    }
}
