public class Main {
    public static void main(String[] args) {  ///TreeSet
        try {
            long startTime = System.currentTimeMillis();
            HashTableChainTree<Integer, String> hashTree = new HashTableChainTree<Integer, String>();
            hashTree.put(1, "Ali");
            hashTree.put(2, "Veli");
            hashTree.put(3, "Osman");
            hashTree.put(4, "Yakup");
            hashTree.put(4, "Unal");
            hashTree.remove(2);
            hashTree.Print();
            System.out.println("Size:" + hashTree.size());
            System.out.println("Isempty-->" + hashTree.isEmpty());
            long endTime = System.currentTimeMillis();
            TimeCalculate(startTime, endTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void TimeCalculate(long startTime,long endTime){
        long estimatedTime = endTime - startTime;
        double seconds = (double)estimatedTime/1000;
        System.out.println("*******Time-Seconds*******");
        System.out.println(seconds);
        System.out.println("***************************");
    }
}
