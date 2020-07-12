import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args){
    LinkListWrite list=new LinkListWrite();
    LinkListWrite.LinkListWriteIterator iter=list.iterator();
    DequeWrite dq=new DequeWrite();


    try {

        dq.addFirst("Gebze Teknik Universitesi");
        dq.addFirst("Yildiz Teknik Universitesi");
        dq.outputListDequeRead();

        dq.addLast("Istanbul Teknik Universitesi");
        dq.outputListDequeRead();

        dq.offerFirst("Bogazici Universitesi");
        dq.outputListDequeRead();

        dq.offerLast("Sakarya Universitesi");
        dq.outputListDequeRead();
        System.out.println("**************************");
        dq.removeFirst();
        dq.outputListDequeRead();

        dq.pollFirst();
        dq.outputListDequeRead();

        dq.pollLast();
        dq.outputListDequeRead();
        System.out.println("********************");
        System.out.println("GETFIRST:" + dq.getFirst());
        System.out.println("GETLAST:" + dq.getLast());
        System.out.println("********************");

        dq.addFirst("Ege Universitesi");
        System.out.println("****************");
        System.out.println("PEEKFIRST:" + dq.peekFirst());
        System.out.println("PEEKLAST:" + dq.peekLast());
        System.out.println("*****************");
        dq.removeFirst();

        System.out.println("***removeFirstOccurrence****");
        String array = "Istanbul Teknik Universitesi";
        if (dq.removeFirstOccurrence(array))
            System.out.println(array + ": Founded and Delete");
        else
            System.out.println("Not Found so not Delete");
        System.out.println("****************************");
        dq.outputListDequeRead();

        System.out.println("***removeLastOccurrence****");
        String array1 = "Gebze Teknik Universitesi";
        if (dq.removeFirstOccurrence(array1))
            System.out.println(array1 + ": Founded and Delete");
        else
            System.out.println("Not Found so not Delete");
        System.out.println("****************************");
        dq.outputListDequeRead();

        System.out.println("************DEQUE-ALL-DELETE-AND-NEW-DEQUE*************** ");

        dq.offer("KAHRAMANMARAS");
        dq.offer("MALATYA");
        dq.outputListDequeRead();
        dq.offer("ADANA");
        dq.outputListDequeRead();

        dq.remove();
        dq.outputListDequeRead();

        dq.poll();
        dq.outputListDequeRead();
        dq.offer("ANTALYA");
        System.out.println("********ELEMENT*********");
        System.out.println("ELEMENT:" + dq.element());
        System.out.println("************************");
        dq.outputListDequeRead();

        dq.addFirst("ANKARA");
        dq.outputListDequeRead();
        System.out.println("******PEEK******");
        System.out.println("PEKK:" + dq.peek());
        System.out.println("****************");

        dq.push("KOCAELI");
        dq.outputListDequeRead();

        dq.pop();
        dq.outputListDequeRead();
    }catch (NullPointerException e){
        System.out.println("Null Pointer!!!");
    }
    catch (NoSuchElementException e){
        System.out.println("There is no such element!!!");
    }


    }
}
