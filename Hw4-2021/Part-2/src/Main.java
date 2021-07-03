import java.util.Random;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] arg)
    {

        BSTHeapTree<Integer> bstHeapTree=new BSTHeapTree<Integer>();
        try {


            int array[] = new int[3000];
            int notarray[] = new int[10];

            for (int i = 0; i < 3000; i++) {
                array[i] = GENERATENUMBER(0, 5000);
            }
            for (int i = 0; i < 10; i++) {
                notarray[i] = GENERATENUMBER(6000, 10000);
            }

            BSTADD(bstHeapTree, array);
            BSTSEARCH(bstHeapTree, array, notarray);
            BSTREMOVE(bstHeapTree, array, notarray);
            bstHeapTree.find_mode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void BSTADD(BSTHeapTree<Integer> bstHeapTree,int[] array){
        System.out.println("***ADD***");
        for (int i = 0; i <3000; i++) {
           bstHeapTree.add(array[i]);
        }

    }
    public static void BSTSEARCH(BSTHeapTree<Integer> bstHeapTree,int[] array,int[] notarray){
        System.out.println("***NUMBERSARRAYSEARCH***");
        for (int i = 0; i <100; i++) {
            bstHeapTree.find(array[i]);
        }
        System.out.println("***NUMBERS-NOT-ARRAYSEARCH***");
        for (int i = 0; i <10; i++) {
            bstHeapTree.find(notarray[i]);
        }

    }
    public static void BSTREMOVE(BSTHeapTree<Integer> bstHeapTree,int[] array,int[] notarray){
        System.out.println("***NUMBERREMOVE***");
        for (int i = 0; i <100; i++) {
            bstHeapTree.remove(array[i]);
        }

        System.out.println("***NUMBERREMOVENOTARRAY***");
        for (int i = 0; i <10; i++) {
            bstHeapTree.remove(notarray[i]);
        }

    }

    public static int GENERATENUMBER(int low,int high){
        Random r = new Random();
        int result = r.nextInt(high-low) + low;
        return result;
    }


}
