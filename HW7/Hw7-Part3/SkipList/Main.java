import java.util.Random;

public class Main {
    public static void main(String[] args){
        SkipList<Integer> skipList=new SkipList<Integer>();
        boolean flag=true;
        int boyut=40000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <fillArray(boyut).length; i++) {
            skipList.add(fillArray(boyut)[i]);
        }
        long endTime = System.currentTimeMillis();
        TimeCalculate(startTime,endTime);
        for (int i = 0; i <10; i++) {
            skipList.add(randnumber());
        }
        System.out.println("**********Delete****************");
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i <10; i++) {
            while (flag){
                if(skipList.remove(randnumber()))
                    break;
            }
        }
        long endTime1 = System.currentTimeMillis();
        TimeCalculate(startTime1,endTime1);

    }///main
    public static int randnumber(){
        Random r=new Random(); //random sınıfı
        int a=r.nextInt(100);
        return a;
    }
    public static int[] fillArray(int size){
        int i=0;
        int[] arr=new int[size];
        while (i<arr.length) {
            arr[i] = randnumber();
            i++;
        }
        return arr;
    }
    public static void TimeCalculate(long startTime,long endTime){
        long estimatedTime = endTime - startTime;
        double seconds = (double)estimatedTime/1000;
        System.out.println("*******Time-Seconds*******");
        System.out.println(seconds);
        System.out.println("***************************");
    }
}
