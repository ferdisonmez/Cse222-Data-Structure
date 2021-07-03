import java.util.Iterator;
import java.util.NavigableSet;

public class Main {
    public static void main(String[] args) {
        SkipList<Integer> myskiplist = new SkipList<Integer>();
        AVLTree<Integer> myavlTree = new AVLTree<Integer>();
        System.out.println("********SkipList************");
        myskiplist.add(60);
        myskiplist.add(70);
        myskiplist.add(80);
        myskiplist.add(90);
        myskiplist.add(100);
        Iterator skiplistiterator=myskiplist.descendingIterator();
        while (skiplistiterator.hasNext()){
            System.out.println(skiplistiterator.next());
        }
        System.out.println("************AVLTREE***************");
        myavlTree.add(5);
        myavlTree.add(20);
        myavlTree.add(30);
        myavlTree.add(40);
        myavlTree.add(50);
        Iterator iter=myavlTree.iterator();
        System.out.println("FirsElement:"+iter.next());
        System.out.println("SecondElement:"+iter.next());
        System.out.println("****HeadSet****");
        NavigableSet<Integer> ns1=myavlTree.headSet(30,false);
        Iterator iterns1=ns1.iterator();
        while (iterns1.hasNext()){
            System.out.print(iterns1.next()+" ");
        }
        System.out.println("\n****TailSet****");
        NavigableSet<Integer> ns2=myavlTree.tailSet(30,true);
        Iterator iterns2=ns2.iterator();
        while (iterns2.hasNext()){
            System.out.print(iterns2.next()+" ");
        }
    }
}
