import java.util.Scanner;

public class Admin extends Person {
    private String password;

    public Admin(String name, String surname, String password) {
        super(name, surname);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    /***
     * The desired software is added by the administrator
     * @param store It is a tree structure
     */
    public void AddSoftware(SoftwareStore store){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Name Of Software");
        String softwarename=input.nextLine();
        System.out.println("Enter Quantity Of Software");
        int quantity=input.nextInt();
        System.out.println("Enter Price Of Sofware");
        int price=input.nextInt();
        Software newstore=new Software(softwarename,quantity,price);
        store.add(newstore);
    }

    /***
     * The desired software is deleted by the administrator
     * @param store It is a tree structure
     */
    public void DeleteSoftware(SoftwareStore store){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Name Of Software For Delete");
        String name=input.nextLine();
        if(store.remove(new Software(name))){
            System.out.println("Delete: "+name);
            return;
        }
        else{
            System.out.println("Not Delete Because Cannot Find");
        }
    }

    /***
     * The desired software can be updated by the administrator
     * @param store It is a tree structure
     */
    public void UpdateStore(SoftwareStore store){
        Scanner input=new Scanner(System.in);
        while (true) {
            System.out.println(store.toString());
            System.out.println("1-Update Qualitity\n"
                    + "2-Update Price\n"
                    + "3-Exit Update System");
            System.out.println("Make Your Choice");
            int secim = input.nextInt();
            if (secim == 1) {
                System.out.println("Enter Name Of Software For Update");
                input.nextLine();
                String name = input.nextLine();
                Software str = store.find(new Software(name));
                if (str != null) {
                    System.out.println("Enter The New Qualitity");
                    int gir = input.nextInt();
                    str.setQuantity(gir);
                }
                else
                    System.out.println("Software is not Found");
            }
            if (secim == 2) {
                System.out.println("Enter Name Of Software For Update");
                input.nextLine();
                String name = input.nextLine();
                Software str = store.find(new Software(name));
                if (str != null) {
                    System.out.println("Enter The New Price");
                    int gir1 = input.nextInt();
                    str.setPrice(gir1);
                }
                else
                    System.out.println("Software is not Found");
            }
            if (secim ==3) {
                System.out.println("Exit Update System...");
                break;
            }
        }
    }//Update

}
