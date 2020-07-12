import java.util.Scanner;

public class Main {
    public static void main(String[] args){

            Library a = new Library();
            while (true) {
                try {
                Scanner input = new Scanner(System.in);
                Menu();
                int secim = input.nextInt();

                if (secim == 1) {
                    System.out.println("Administrator Record System");
                    System.out.println("Enter the Name of Admin");
                    input.nextLine();
                    String name = input.nextLine();
                    System.out.println("Enter the Surname of Admin");
                    String surname = input.nextLine();
                    System.out.println("Enter the Password of Admin");
                    String password = input.nextLine();
                    a.AddAdmin(name, surname, password);
                }
                if (secim == 2) {
                    System.out.println("Enter Password");
                    input.nextLine();
                    String sifre = input.nextLine();
                    if (a.CheckedPassword(sifre)) {
                        while (true) {
                            AdminMenu();
                            int adminsecim = input.nextInt();
                            if (adminsecim == 1) {
                                a.AddBook();
                            }
                            if (adminsecim == 2) {
                                a.DeleteBook();
                            }
                            if (adminsecim == 3) {
                                a.Updateinformation();
                            }
                            if (adminsecim == 4) {
                                System.out.println("Exiting Administrator System");
                                break;
                            }


                        }
                    } else
                        throw new InvalidPassword("Not Correct Password");

                }
                if (secim == 3) {
                    System.out.println("Book Search With AuthorName");
                    input.nextLine();
                    System.out.println("Enter The Your Name");
                    String name = input.nextLine();
                    System.out.println("Enter The Your Surname");
                    String surname = input.nextLine();
                    User temp1 = new User(name, surname);
                    System.out.println("Enter the AuthorName");
                    String authorname = input.nextLine();
                    a.lookBookWithAuthorName(authorname);

                }
                if (secim == 4) {
                    System.out.println("Book Search With BookTitle");
                    input.nextLine();
                    System.out.println("Enter The Your Name");
                    String name = input.nextLine();
                    System.out.println("Enter The Your Surname");
                    String surname = input.nextLine();
                    User temp1 = new User(name, surname);
                    System.out.println("Enter the BookTitle");
                    String BookTitle = input.nextLine();
                    a.lookBookWithTitle(BookTitle);

                }
                if (secim == 5) {
                    System.out.println("Exiting System");
                    break;
                }
            }//try
                catch (InvalidPassword e){
                e.printStackTrace();
             }
                catch (NullPointerException e){
                    System.out.println("You have made a wrong transaction");
                }
            }///While

    }

    /***
     * Shows the action menu
     */
    public static void Menu(){
        System.out.println("****Menu*****");
        System.out.println("1-Administrator Add\n"
                            +"2-Enter Administrator System\n"
                            +"3-Book Search With AuthorName\n"
                            +"4-Book Search With BookTitle\n"
                            +"5-Exit");

    }

    /***
     * Shows the actions the administrator can take
     */
    public static void AdminMenu(){
        System.out.println("****AdminMenu*****");
        System.out.println("1-Add Books\n"
                            +"2-Delete Books\n"
                            +"3-Update Information\n"
                            +"4-Exit AdminMenu");
    }
}
