public class Main {
    public static void main(String[] args){
        try {
            AgeSearchTree<AgeData> ageTree = new AgeSearchTree<AgeData>();
            boolean flag=false;
            ageTree.add(new AgeData(10));
            ageTree.add(new AgeData(20));
            ageTree.add(new AgeData(5));
            ageTree.add(new AgeData(15));
            ageTree.add(new AgeData(10));
            ageTree.add(new AgeData());
            ageTree.remove(new AgeData(0));
            flag=ageTree.remove(new AgeData(1500));
               if (flag){
                   System.out.println("Element Delete");
               }
               else
                   System.out.println("There is no such element in the tree structure");

            System.out.println("****Tree--Print****");
            String treeStr = ageTree.toString();
            System.out.println(treeStr);
            System.out.println("***YoungerThan-OlderThan********");
            System.out.println("youngerThan: " + ageTree.youngerThan(15));
            System.out.println("youngerThan: " + ageTree.youngerThan(1523));
            System.out.println("olderThan: " + ageTree.olderThan(20));
            System.out.println("olderThan: " + ageTree.olderThan(5));

            System.out.println("****Find*****");
            System.out.println(ageTree.find(new AgeData(10)).toString());
            System.out.println(ageTree.find(new AgeData(1700)).toString());

            System.out.println("***search for non-element****");
            System.out.println("youngerThan: " + ageTree.youngerThan(150));
        }
        catch (NullPointerException e){
            System.out.println("There is no this element");
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Arraylist Size exceeded");
        }
    }
}
