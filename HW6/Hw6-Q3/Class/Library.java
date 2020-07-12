import java.util.*;
public class Library {
    private List<User> users;
    private List<Admin> admins;
    private Map<String,HashMap<String,HashSet<String>>> map; //1-AuthorName  2-BookName  3-Location

    public Library(){
        map=new HashMap<String, HashMap<String,HashSet<String>>>();
        users=new ArrayList<User>();
        admins=new ArrayList<Admin>();


        for (Map.Entry<String,HashMap<String,HashSet<String>> >entry:map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
    public boolean CheckedPassword(String pass){
        for (int i = 0; i <admins.size(); i++) {
            if (admins.get(i).getPassword().equals(pass)) {
                System.out.println(admins.get(i).getName()+" "+admins.get(i).getSurname()+" logged into the system");
                return true;
            }
        }
        return false;
    }

    /***
     * This function adds a book
     */
    public void AddBook(){
        Scanner input=new Scanner(System.in);
        System.out.println("Name Of Writer");
        String Authorname=input.nextLine();
        System.out.println("Name Of Book");
        String bookName=input.nextLine();
        System.out.println("Enter The Place of Book");
        String bookplace=input.nextLine();
        HashSet<String> lines=new HashSet<>();
        lines.add(bookplace);
        HashMap<String,HashSet<String>> temp = new HashMap<>();
        temp.put(bookName,lines);
       if (map.containsKey(Authorname)){
           if (map.get(Authorname).containsKey(bookName)){
               map.get(Authorname).get(bookName).add(bookplace);
           }
           else
           map.get(Authorname).put(bookName,lines);
       }
       else
        map.put(Authorname,temp);
    }

    /***
     * This function deletes a book
     */
    public void DeleteBook() {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Name of Book");
        String bookname=input.nextLine();
        System.out.println("Enter Name of Author");
        String authorname=input.nextLine();
        if (findauthor(bookname)!=null)
         map.get(authorname).remove(bookname);
        else
            System.out.println("Invalid AuthorName");
    }

    /***
     * This function updates the status of the book
     */
    public void Updateinformation(){
        Scanner input=new Scanner(System.in);
            System.out.println("***Update Location Of Book***");
            System.out.println("Enter Name Of Book");
            String oldName=input.nextLine();
            System.out.println("Enter New Location Of BookTitle");
            String newName=input.nextLine();
            HashSet temp=new HashSet();
            temp.add(newName);
            String authorname1=findauthor(oldName);
            if(authorname1 != null)
             map.get(authorname1).replace(oldName,map.get(authorname1).get(oldName),temp);
            else
                System.out.println("Invalid Author Name");

    }

    /***
     * Adds admin person to the system
     * @param name name of person to add
     * @param surname surname of person to add
     * @param password Password of person to add
     */
    public void AddAdmin(String name,String surname,String password){
        Admin temp=new Admin(name,surname,password);
        admins.add(temp);
    }

    /***
     * Deletes administrators from the system
     * @param id Administrator's password
     */
    public void RemoveAdmin(String id){
        for (int i = 0; i <admins.size(); i++) {
            if (admins.get(i).getPassword() ==id) {
                admins.remove(admins.get(i));
                return;
            }
        }
        System.out.println("Invalid AdminID");
        return;
    }

    /***
     * Add users to the system
     * @param name name of the user to be added
     * @param surname surname of the user to be added
     * @param password password of the user to be added
     */
    public void AddUser(String name,String surname,String password){
         User temp=new User(name,surname);
         users.add(temp);
    }

    /***
     * Will search for books with the name of the author who is in the system
     * @param AuthorName The name of the author to search for
     */
    public void lookBookWithAuthorName(String AuthorName) {  ///Kitablar listelenecek sonra biri secilip yeri gosterilecek
        Scanner input = new Scanner(System.in);
        int sayac = 1;
        if (map.containsKey(AuthorName)) {
            System.out.println("***" + AuthorName + " Books****");
            for (Map.Entry<String, HashMap<String, HashSet<String>>> letterEntry : map.entrySet()) {
                for (Map.Entry<String, HashSet<String>> nameEntry : letterEntry.getValue().entrySet()) {
                    String name = nameEntry.getKey();
                    if (map.get(AuthorName).containsKey(name))
                        System.out.println("->"+name);
                }
            }
        }
        System.out.println("Enter the Title of the Book you want to learn location:");
        String kitap = input.nextLine();
        for (Map.Entry<String, HashMap<String, HashSet<String>>> letterEntry : map.entrySet()) {
            for (Map.Entry<String, HashSet<String>> nameEntry : letterEntry.getValue().entrySet()) {
                String name = nameEntry.getKey();
                System.out.println((map.get(AuthorName).get(kitap)));
                return;
            }
        }
    }

    /***
     * Find author and book location
     * @param BookTitle book title to search
     */
    public void lookBookWithTitle(String BookTitle){ //Location And Writer

        Scanner input = new Scanner(System.in);
            String str=findauthor(BookTitle);
            if (str!=null) {
                for (Map.Entry<String, HashMap<String, HashSet<String>>> writerEntry : map.entrySet()) {
                    String AuthorName = writerEntry.getKey();
                    for (Map.Entry<String, HashSet<String>> bookEntry : writerEntry.getValue().entrySet()) {
                        if (str != null && bookEntry.getKey().equals(BookTitle)) {
                            Iterator iter = bookEntry.getValue().iterator();
                            while (iter.hasNext())
                                System.out.println("Writer:" + str + "--" + "Location:" + iter.next());
                        }
                    }
                }///For
            }
            else
                System.out.println("There is no such book");
    }

    /***
     * Finds the author of the book
     * @param book Name of the book to be searched
     * @return author's name
     */
    private String findauthor(String book){
        for (Map.Entry<String, HashMap<String, HashSet<String>>> writeEntry : map.entrySet()) {
            String AuthorName=writeEntry.getKey();
            for (Map.Entry<String, HashSet<String>> bookEntry : writeEntry.getValue().entrySet()){
                if (bookEntry.getKey().equals(book))
                    return AuthorName;
            }
        }
        return null;
    }



}
