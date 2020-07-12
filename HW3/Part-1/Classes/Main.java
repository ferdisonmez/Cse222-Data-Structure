
public class Main {
    public static void main(String[] args){
      String[] array={"GTU","ITU","KTU","BOGAZICI","ISTANBUL"};
      String[] array1={"SAKARYA","INONU"};
        String[] array2={"ERCIYES","HACETTEPE"};

    LinkedArrayList<String> list=new LinkedArrayList<String>();
    LinkedArrayList.DoublyIterator i=list.iterator();

        try {
            i.insertHere(array);
            i.insertHere(array2);
            i.insertHere(array1);
            System.out.println("***All Nodes Add***");
            i.outputList();
            System.out.println("********************");

            i.addindex(5,"EKLENDI!!!");
            i.outputList();
            System.out.println("***New Element Add Index=5***");
            System.out.println("*********************");
            i.delete(0);
            i.outputList();
            System.out.println("***Node 0 Delete****");
            System.out.println("**********************");
            i.sil("SAKARYA");
            i.outputList();
            System.out.println("Specific Element Delete in arrays=SAKARYA");
            System.out.println("**************END********************");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exceeded the size of the array");
        }
        catch (IllegalStateException e){
            System.out.println("There is no node in the next");
        }
        catch (NullPointerException e){
            System.out.println("Null pointer error");
        }


    }

}
