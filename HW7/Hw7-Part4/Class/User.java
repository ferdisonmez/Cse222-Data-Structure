import java.util.Scanner;

public class User extends Person {
    public User(String name, String surname) {
        super(name, surname);
    }

    /***
     * looks for software in the data structure
     * @param store It is a tree structure
     */
    public void SearchSoftware(SoftwareStore store){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Name Of Software");
        String str=input.nextLine();
        Software wr=store.find(new Software(str));
        if (wr != null) {
            System.out.println("SoftwareName:"+wr.getNameWithVersion()+" /SoftwareQuantity:"+wr.getQuantity()+" /SoftwarePrice:"+wr.getPrice());
        }
        else
            System.out.println("Software is not found");
    }

    /***
     * The software is purchased by the user
     * @param store It is a tree structure
     */
    public void PurchaseSoftware(SoftwareStore store){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the Name of the software you want to purchase");
        String name=input.nextLine();
        Software str=store.find(new Software(name));
        if (str!=null){
            store.remove(str);
            System.out.println(str.getNameWithVersion()+" Software Purchased");
        }
        else
            System.out.println("Software is not found");

    }
    public void looksoftware(SoftwareStore store){
        System.out.println(store.toString());
    }
}
