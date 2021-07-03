public class Main {
    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();
            CoalescedHash<Integer> ch = new CoalescedHash<Integer>();
            ch.put(20);
            ch.put(30);
            ch.put(40);
            ch.put(35);
            ch.put(50);
            ch.put(60);
            ch.put(45);
            ch.remove(40);
            ch.Print();
            System.out.println("Size:" + ch.size());
            System.out.println("IsEmpty-->" + ch.isEmpty());
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
