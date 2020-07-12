import java.util.ArrayList;
import java.util.Scanner;

public class SoftwareStore extends BinarySearchTree<Software>{
    private ArrayList<Admin> admins;
    private ArrayList<User> users;

    public SoftwareStore(){
        admins=new ArrayList<Admin>();
        users=new ArrayList<User>();
    }

    /***
     * Administrator is added to the system
     */
    public void AddAdmin(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Name Of Administrator");
        String name=input.nextLine();
        System.out.println("Enter Surname Of Administrator");
        String surname=input.nextLine();
        System.out.println("Enter Password Of Administrator");
        String password=input.nextLine();
        Admin admin=new Admin(name,surname,password);
        admins.add(admin);
    }
    public void AddAdminBySystem(){
        String name="SystemAdmin";
        String surname="SystemAdmin";
        String password="Admin";
        Admin systemadmin=new Admin(name,surname,password);
        admins.add(systemadmin);
    }
    /***
     * User can be added to the system
     */
    public void AddUser(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Name Of User");
        String name=input.nextLine();
        System.out.println("Enter Surname Of User");
        String surname=input.nextLine();
        User user=new User(name,surname);
        users.add(user);
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<Admin> admins) {
        this.admins = admins;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    /***
     * It will add a node to the tree structure, if there is an age to be added, it will increase the number of people
     * @param item is the desired age to be added
     * @return false if not added true if added
     */
    @Override
    public boolean add(Software item) {
        Software temp=super.find(item);
        if (temp==null){
            super.add(item);
            return false;
        }
        else{
            temp.incrementQuantity();
            return true;
        }
    }

    /***
     * Prints the value in the node and how many people there are
     * @return strings attached together
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }
    private void preOrderTraverse(Node<Software> node, int depth, StringBuilder sb) {
        if (node == null) {
            return;
        }
        else {
            sb.append("Name:"+node.data.getNameWithVersion()+" /Quantity:"+node.data.getQuantity()+" /Price:"+node.data.getPrice());
            sb.append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }

    /***
     * This function search in tree a node
     * @param target is Agedata type
     * @return  the address if it finds the node it is looking for, or returns null if it cannot find it
     */
    @Override
    public Software find(Software target) {
        Software temp=super.find(target);
        if (temp==null){
            return null;
        }
        else{
            return temp;
        }
    }

    /***
     * Deletes a person in the desired node
     * @param target is Agedate Type(node to be deleted)
     * @return false if not deleted true if deleted
     */
    @Override
    public boolean remove(Software target) {
        Software temp=super.find(target);
        if (temp==null){
            return false;
        }
        else {
            if (temp.getQuantity()>1){
                temp.decrementQuantity();
                return true;
            }
            else {
                super.delete(super.find(temp));
                temp.decrementQuantity();
                return true;
            }
        }
    }

    /***
     * When adding small and large values, missing values ​​are added
     * @param root initial value of the tree
     * @param temp desired value
     *
     */
    public void travers(Node<Software> root,Software temp){
        if(root == null) {
            return;
        }
        else {
            temp.compareTo(root.data);
            if(root.left != null)
                travers(root.left,temp);
            if(root.right != null)
                travers(root.right,temp);
        }
    }
}
