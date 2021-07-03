import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree=new BinarySearchTree();
        RedBlackTree<Integer> redBlackTree=new RedBlackTree<Integer>();
        BTree bTree=new BTree(3);
        SkipList<Integer> skipList=new SkipList<Integer>();

        int secim;
        System.out.println("1-User Operation\n"
                +"2-Driver Operation");
        Scanner scanner=new Scanner(System.in);
        secim=scanner.nextInt();
        if (secim==1) {
            while (true){
                System.out.println("####User Operations####");
            System.out.println("1-Add BinarySearchTree\n"
                    + "2-Add ReadBlackTree\n"
                    + "3-Add Btree\n"
                    + "4-Add SkipList\n"
                     +"5-Exiting");
            int sec1 = scanner.nextInt();
            if (sec1 == 1) {
                System.out.println("Enter the Number For Add(BinarySearchTree)");
                int number = scanner.nextInt();
                binarySearchTree.add(number);
            }
            if (sec1 == 2) {
                System.out.println("Enter the Number For Add(ReadBlackTree)");
                int number = scanner.nextInt();
                redBlackTree.add(number);
            }
            if (sec1 == 3) {
                System.out.println("Enter the Number For Add(Btree)");
                int number = scanner.nextInt();
                bTree.Insert(number);
            }
            if (sec1 == 4) {
                System.out.println("Enter the Number For Add(SkipList)");
                int number = scanner.nextInt();
                skipList.add(number);
            }
                if (sec1 ==5) {
                    System.out.println("Exitng...");
                    break;
                }
          }
        }
        else if(secim==2) {
            while (true){
                System.out.println("###Driver Operations###");
            System.out.println("Please Your Choice");
            System.out.println("1-BinarySearchTree\n"
                    + "2-Red-BlackTree\n"
                    + "3-B-Tree\n"
                    + "4-SkipList\n"
                    + "5-Exit Driver");
            int sec = scanner.nextInt();
            if (sec == 1) {  ///BinarySearchTree
                int[] array = new int[10000];
                int[] array1 = new int[20000];
                int[] array2 = new int[40000];
                int[] array3 = new int[80000];
                array = OnK();
                array1 = YirmiK();
                array2 = KirkK();
                array3 = SeksenK();
                long binaryOnKTimestart = System.currentTimeMillis();
                for (int i = 0; i < array.length; i++) {
                    binarySearchTree.add(array[i]);
                }
                long endTime1 = System.currentTimeMillis();
                TimeCalculate(binaryOnKTimestart, endTime1, "BinarySearchTree10K");

                long binaryYirmiKTimestart = System.currentTimeMillis();
                for (int i = 0; i < array1.length; i++) {
                    binarySearchTree.add(array1[i]);
                }
                long endTime2 = System.currentTimeMillis();
                TimeCalculate(binaryYirmiKTimestart, endTime2, "BinarySearchTree20K");

                long binaryKirKTimestart = System.currentTimeMillis();
                for (int i = 0; i < array1.length; i++) {
                    binarySearchTree.add(array2[i]);
                }
                long endTime3 = System.currentTimeMillis();
                TimeCalculate(binaryKirKTimestart, endTime3, "BinarySearchTree40K");

                long binarySeksenKTimestart = System.currentTimeMillis();
                for (int i = 0; i < array1.length; i++) {
                    binarySearchTree.add(array3[i]);
                }
                long endTime4 = System.currentTimeMillis();
                TimeCalculate(binarySeksenKTimestart, endTime4, "BinarySearchTree80K");


            } else if (sec == 2) {   ///Red-Black Tree
                int[] array = new int[10000];
                int[] array1 = new int[20000];
                int[] array2 = new int[40000];
                int[] array3 = new int[80000];
                array = OnK();
                array1 = YirmiK();
                array2 = KirkK();
                array3 = SeksenK();
                long redblackOnKTimestart = System.currentTimeMillis();
                for (int i = 0; i < array.length; i++) {
                    redBlackTree.add(array[i]);
                }
                long endTime1 = System.currentTimeMillis();
                TimeCalculate(redblackOnKTimestart, endTime1, "RedBlackTree10K");

                long binaryYirmiKTimestart = System.currentTimeMillis();
                for (int i = 0; i < array1.length; i++) {
                    redBlackTree.add(array1[i]);
                }
                long endTime2 = System.currentTimeMillis();
                TimeCalculate(binaryYirmiKTimestart, endTime2, "RedBlackTree20K");

                long binaryKirKTimestart = System.currentTimeMillis();
                for (int i = 0; i < array1.length; i++) {
                    redBlackTree.add(array2[i]);
                }
                long endTime3 = System.currentTimeMillis();
                TimeCalculate(binaryKirKTimestart, endTime3, "RedBlackTree40K");

                long binarySeksenKTimestart = System.currentTimeMillis();
                for (int i = 0; i < array1.length; i++) {
                    redBlackTree.add(array3[i]);
                }
                long endTime4 = System.currentTimeMillis();
                TimeCalculate(binarySeksenKTimestart, endTime4, "RedBlackTree80K");
            } else if (sec == 3) { //B-Tree
                int[] array = new int[10000];
                int[] array1 = new int[20000];
                int[] array2 = new int[40000];
                int[] array3 = new int[80000];
                array = OnK();
                array1 = YirmiK();
                array2 = KirkK();
                array3 = SeksenK();
                long btreeOnKTimestart = System.currentTimeMillis();
                for (int i = 0; i < array.length; i++) {
                    bTree.Insert(array[i]);
                }
                long endTime1 = System.currentTimeMillis();
                TimeCalculate(btreeOnKTimestart, endTime1, "BTree10K");

                long btreeYirmiKTimestart = System.currentTimeMillis();
                for (int i = 0; i < array1.length; i++) {
                    bTree.Insert(array1[i]);
                }
                long endTime2 = System.currentTimeMillis();
                TimeCalculate(btreeYirmiKTimestart, endTime2, "BTree20K");

                long btreeKirKTimestart = System.currentTimeMillis();
                for (int i = 0; i < array1.length; i++) {
                    bTree.Insert(array2[i]);
                }
                long endTime3 = System.currentTimeMillis();
                TimeCalculate(btreeKirKTimestart, endTime3, "BTree40K");

                long bbtreeSeksenKTimestart = System.currentTimeMillis();
                for (int i = 0; i < array1.length; i++) {
                    bTree.Insert(array3[i]);
                }
                long endTime4 = System.currentTimeMillis();
                TimeCalculate(bbtreeSeksenKTimestart, endTime4, "BTree80K");
            }
            else if (sec == 4) { ///SkipList
                int[] array = new int[10000];
                int[] array1 = new int[20000];
                int[] array2 = new int[40000];
                int[] array3 = new int[80000];
                array = OnK();
                array1 = YirmiK();
                array2 = KirkK();
                array3 = SeksenK();
                long btreeOnKTimestart = System.currentTimeMillis();
                for (int i = 0; i < array.length; i++) {
                    skipList.add(array[i]);
                }
                long endTime1 = System.currentTimeMillis();
                TimeCalculate(btreeOnKTimestart, endTime1, "SkipList10K");

                long btreeYirmiKTimestart = System.currentTimeMillis();
                for (int i = 0; i < array1.length; i++) {
                    skipList.add(array1[i]);
                }
                long endTime2 = System.currentTimeMillis();
                TimeCalculate(btreeYirmiKTimestart, endTime2, "SkipList20K");

                long btreeKirKTimestart = System.currentTimeMillis();
                for (int i = 0; i < array1.length; i++) {
                    skipList.add(array2[i]);
                }
                long endTime3 = System.currentTimeMillis();
                TimeCalculate(btreeKirKTimestart, endTime3, "SkipList40K");

                long bbtreeSeksenKTimestart = System.currentTimeMillis();
                for (int i = 0; i < array1.length; i++) {
                    skipList.add(array3[i]);
                }
                long endTime4 = System.currentTimeMillis();
                TimeCalculate(bbtreeSeksenKTimestart, endTime4, "SkipList80K");


            }
            if (sec ==5) {
                System.out.println("Exiting...");
                break;
            }
        }
        }

    }//main

    /***
     * This function calculate time of function
     * @param startTime start time of function
     * @param endTime end time of function
     * @param Name Shows which function is being worked on
     */
    public static void TimeCalculate(long startTime,long endTime,String Name){
        long estimatedTime = endTime - startTime;
        double seconds = (double)estimatedTime/1000;
        System.out.println("####"+Name+"-Time-Seconds####");
        System.out.println(seconds);
        System.out.println("***************************");
    }
    public static void Menu(){


    }//Menu
    public static int[] OnK(){
        int[] array=new int[10000];
        array=fillArray(10000);
        return array;
    }
    public static int[] YirmiK(){
        int[] array=new int[20000];
        array=fillArray(20000);
        return array;
    }
    public static int[] KirkK(){
        int[] array=new int[40000];
        array=fillArray(40000);
        return array;
    }
    public static int[] SeksenK(){
        int[] array=new int[80000];
        array=fillArray(80000);
        return array;
    }

    /***
     * Generate ramdom number
     * @return is random number
     */
    public static int randnumber(){
        Random r=new Random(); //random sınıfı
        int a=r.nextInt(80000);
        return a;
    }

    /***
     * This function fill in the array
     * @param size is size of array
     * @return is filled array
     */
    public static int[] fillArray(int size){
        int i=0;
        int[] arr=new int[size];
        while (i<arr.length) {
            arr[i] = randnumber();
            i++;
        }
        return arr;
    }
}
