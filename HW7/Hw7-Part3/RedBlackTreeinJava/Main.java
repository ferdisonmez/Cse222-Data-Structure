import java.util.Random;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args){
        TreeMap<Integer,String> treemap=new TreeMap<Integer, String>();
        boolean flag=true;
        int boyut=80000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <fillArray(boyut).length; i++) {
            treemap.put(fillArray(boyut)[i],"Integer");
    }
        long endTime = System.currentTimeMillis();
        TimeCalculate(startTime,endTime);
        for (int i = 0; i <10; i++) {
            treemap.put(fillArray(boyut)[i],"Integer");
            treemap.put(randnumber(),"Integer");
        }
        System.out.println("**********Delete****************");
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i <10; i++) {
                treemap.remove(randnumber());
        }
        long endTime1 = System.currentTimeMillis();
        TimeCalculate(startTime1,endTime1);

    }
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
