public class Main {
    public static void main(String[] args) { ///LinkedList
        try {
            long startTime = System.currentTimeMillis();
            HashTableChain<Integer, String> myh = new HashTableChain<Integer, String>();
            myh.put(1, "Ferdi");
            myh.put(2, "Ali");
            myh.put(3, "Osman2");
            myh.put(4, "Osman1");
            myh.put(4, "Osman4");
            myh.remove(1);
            System.out.println("Size:" + myh.size());
            System.out.println("Isempty-->" + myh.isEmpty());
            myh.Print();
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
