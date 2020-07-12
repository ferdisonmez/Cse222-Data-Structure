import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        SoftwareStore store=new SoftwareStore();
        startTree(store);
        try {
        while (true){
                AnaMenu();
                int secim = input.nextInt();
                if (secim == 1) {
                    System.out.println("Enter The Password");
                    input.nextLine();
                    String password = input.nextLine();
                    if (FindAdmin(store, password) != null) {
                        System.out.println(FindAdmin(store, password).getName() + " " + FindAdmin(store, password).getSurname() + " Logged into the system");
                        while (true) {
                            AdminMenu();
                            int adminsecim = input.nextInt();
                            if (adminsecim == 1) {
                                Admin newadmin = FindAdmin(store, password);
                                newadmin.AddSoftware(store);
                            }
                            if (adminsecim == 2) {
                                Admin newadmin = FindAdmin(store, password);
                                newadmin.DeleteSoftware(store);
                            }
                            if (adminsecim == 3) {
                                Admin newadmin = FindAdmin(store, password);
                                newadmin.UpdateStore(store);
                            }
                            if (adminsecim == 4) {
                                System.out.println("---Exiting AdminMenu---");
                                break;
                            }
                        }//While
                    } else
                        System.out.println("Not Correct Password");

                }//AdminMenu
                if (secim == 2) {
                    while (true) {
                        UserOperation();
                        System.out.println("Make Your Choice");
                        int secuser = input.nextInt();
                        if (secuser == 1) {
                            System.out.println("Enter Name Of User");
                            input.nextLine();
                            String name = input.nextLine();
                            User usr = FindUser(store, name);
                            if (usr != null) {
                                usr.SearchSoftware(store);
                            } else
                                System.out.println("User is Not Found");
                            break;
                        }
                        if (secuser == 2) {
                            System.out.println("Enter Name Of User");
                            input.nextLine();
                            String name = input.nextLine();
                            User usr = FindUser(store, name);
                            if (usr != null) {
                                usr.PurchaseSoftware(store);
                            } else
                                System.out.println("User is Not Found");
                            break;
                        }
                        if (secuser == 3) {
                            System.out.println("Enter Name Of User");
                            input.nextLine();
                            String name = input.nextLine();
                            User usr = FindUser(store, name);
                            if (usr != null) {
                                usr.looksoftware(store);
                            } else
                                System.out.println("User is Not Found");
                            break;
                        }
                        if (secuser == 4) {
                            System.out.println("Exiting UserOperationMenu...");
                            break;
                        }


                    }
                }///UserOperation
                if (secim == 3) {
                    while (true) {
                        AddAdminOrUser();
                        int sec = input.nextInt();
                        if (sec == 1) {
                            store.AddAdmin();

                        }
                        if (sec == 2) {
                            store.AddUser();
                        }
                        if (sec == 3) {
                            System.out.println("Exit AddAdminOrUserMenu");
                            break;
                        }
                    }
                }///AddAdminOrUser
                if (secim == 4) {
                    System.out.println("---Exiting SoftwareStore System---");
                    break;
                }

        }//While
        } catch (InputMismatchException e) {
            System.out.println("Please enter the input form correctly.(Otherwise, the program closes.)");
        }
        catch (NullPointerException e){
            System.out.println("You tried to access an empty space");
        }
    }///Main
    public static void AnaMenu(){
        System.out.println("*****SoftwareStoreSystem****");
          System.out.println("1-Admin Operations\n"
                            +"2-User Operations\n"
                            +"3-Add Admin Or User\n"
                            +"4-Exit");
        System.out.println("***********************");
    }
    public static void AdminMenu(){
        System.out.println("***AdminOperationMenu****");
         System.out.println("1-Add Software\n"
                            +"2-Delete Software\n"
                            +"3-Update Software\n"
                            +"4-Exiting Admin Operation");
        System.out.println("***********************");
        }
        public static void AddAdminOrUser(){
            System.out.println("***AddAdminOrUserOperation***");
             System.out.println("1-Add Admin\n"
                                +"2-Add User\n"
                                +"3-Exit AddAdminOrUserMenu");
            System.out.println("***********************");

         }
         public static void UserOperation(){
             System.out.println("*******UserOperation*******");
             System.out.println("1-Search Software\n"
                                +"2-Purchase Software\n"
                                +"3-Look All Software in Store\n"
                                +"4-Exit UserOperationMenu");
             System.out.println("*****************************");
         }

    /***
     * Finds who owns the password
     * @param store It is a tree structure
     * @param password Called password
     * @return Administrator to whom the password belongs
     */
        public static Admin FindAdmin(SoftwareStore store,String password){
            for (int i = 0; i <store.getAdmins().size(); i++) {
                if (store.getAdmins().get(i).getPassword().equals(password)) {
                    return store.getAdmins().get(i);
                }
            }
            return null;
        }

    /***
     *Finds who the user is
     * @param store It is a tree structure
     * @param name user's name
     * @return Who owns the username
     */
        public static User FindUser(SoftwareStore store,String name){
            for (int i = 0; i <store.getUsers().size(); i++) {
                if(store.getUsers().get(i).getName().equals(name)){
                    return store.getUsers().get(i);
                }
            }
            return null;
        }

    /***
     * Tree structure is started
     * @param store It is a tree structure
     */
    public static void startTree(SoftwareStore store){
            String[] arr={"Adobe Photoshop 6.0","Adobe Photoshop 6.2", "Norton 4.5", "Norton 5.5", "Adobe Flash 3.3", "Adobe Flash 4.0"};
            for (int i = 0; i <arr.length; i++) {
                store.add(new Software(arr[i],2,100));
            }
        }
}
