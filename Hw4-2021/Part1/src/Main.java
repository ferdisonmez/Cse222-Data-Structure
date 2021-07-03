import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        MyHeap<Integer> myHeap=new MyHeap<Integer>();
        MyHeap<Integer> myHeap1=new MyHeap<Integer>();
        myHeap.HeapAdd(130);
        myHeap.HeapAdd(40);
        myHeap.HeapAdd(150);
        myHeap1.HeapAdd(35);
        myHeap1.HeapAdd(45);
        myHeap1.HeapAdd(55);

        MyHeapMenu(myHeap,myHeap1); ///Menu
    }
    public static void MyHeapMenu(MyHeap<Integer> myHeap,MyHeap<Integer> myHeap1){
        Scanner scanner=new Scanner(System.in);
        int secim;
        while (true) {
            System.out.println("\n1-Add Element\n"
                    + "2-Merge Another Heap\n"
                    + "3-Remove ith Element\n"
                    + "4-Search Element\n"
                    + "5-Show All Element\n"
                    +"6-Exit...");
            secim=scanner.nextInt();
            if (secim ==1) {
                System.out.println("***Add Element System***");
                System.out.println("Enter The Element For Add");
                int sayi=scanner.nextInt();
                myHeap.HeapAdd(sayi);
                System.out.println("Number is Added");
            }//if 1
            if (secim ==2) {
                System.out.println("***Merge Another Heap Structure***");
                myHeap.Show();
                System.out.println();
                myHeap1.Show();
                System.out.println("Do you want to this two heap?(Y/N)");
                scanner.nextLine();
                String temp=scanner.nextLine();
                if (temp.equals("Y") | temp.equals("y")) {
                    myHeap.MergeHeap(myHeap1);
                    System.out.println("Two Heap Merged");
                    myHeap.Show();
                }
                else {
                    System.out.println("Two Heap Not Merged");
                    myHeap.Show();
                    System.out.println();
                    myHeap1.Show();
                }

            }///if 2
            if (secim ==3) {
                System.out.println("***Remove ith Element***");
                System.out.println("Enter The Number For Removing ith Largest Element");
                int deger=-1;
                int index=scanner.nextInt();
                try {
                    deger=myHeap.RemoveTh(index);
                    System.out.println(deger+" is Delete");
                }catch (Exception IndexOutOfBoundsException){
                    System.out.println("This İndex is Very Big!!!");
                }

            }//İf 3

            if (secim ==4) {
                System.out.println("***Search Element***");
                System.out.println("Enter Element For Search");
                int search=scanner.nextInt();
                if(myHeap.findelement(search)){
                    System.out.println("Number is Founded");
                }
                else
                    System.out.println("Number is not Founded");
            }//İf 4

            if (secim ==5) {
                System.out.println("***Show The All Element***");
                myHeap.Show();
            }//İf 5

            if (secim ==6) {
                System.out.println("Exiting...");
                break;
            }

        }

    }

}
