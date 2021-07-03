import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {

            MyHashMap<Integer, String> myHashMap = new MyHashMap<Integer, String>();
            myHashMap.ADD(10, "ferdi");
            myHashMap.ADD(20, "Osman");
            myHashMap.ADD(30, "Veli");
            myHashMap.ADD(40, "Veli1");
            myHashMap.ADD(50, "Veli2");
            myHashMap.ADD(60, "Veli3");
            myHashMap.ADD(70, "Veli4");
            myHashMap.ADD(80, "Veli45");
            MyHashMap.MapIterator iter = myHashMap.iterator(80);
            System.out.println("iter-prev:" + iter.prev());
            System.out.println("İter-next:" + iter.next());
            iter.Print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
