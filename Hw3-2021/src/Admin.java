public class Admin extends Person {
    public Admin(String name, String surname, String email, String sifre) {
        super(name, surname, email, sifre);
    }

    /***
     * Shows the products in the system
     * @param sistem indicates the  furnitures system
     */
    public void Showurun(Sistem sistem){
        System.out.println("***All furnitures in All system*****");
        HybridList.Myiterator iter=sistem.getFurnitures().iterator();
          iter.ShowLinkedList();
    }

    /***
     * Shows all managers in the furniture system
     * @param sistem indicates the  furnitures system
     */
    public void ShowAllAdmin(Sistem sistem){
        System.out.println("********System Admin******");
        for (int i = 0; i <getadminarraysize(sistem.getAdminarray()) ; i++) {
            System.out.println(sistem.getAdminarray().get(i).toString());
        }
        System.out.println("***************************");
    }

    /***
     * Adds a new administrator to the system
     * @param temp is a administrator
     * @param sistem indicates the furniture system
     */
    public void AdminEnter(Admin temp,Sistem sistem){
        for (int i = 0; i <getadminarraysize(sistem.getAdminarray()); i++) {
            if (sistem.getAdminarray().get(i).getSifre().equals(temp.getSifre())) {
                System.out.println(temp.showinformotion() +" olarak sisteme giriş yaptı.");
            }
        }
    }

    /***
     *
     * @param temparray is administrator array
     * @return how much is array of admin
     */
    private int getadminarraysize(KWArrayList<Admin> temparray){
        int temp=0;
        for (int i = 0; i <temparray.size(); i++) {
            if (temparray.get(i) != null) {
                temp++;
            }
        }
        return temp;
    }
    @Override
    public String toString() {
        String temp="Yonetici "+ super.toString();
        return temp;
    }

    /***
     * Add the branch in the system
     * @param temp is a Branch
     * @param sistem indicates the furniture system
     */
    public void BranchAdd(Branch temp,Sistem sistem){
        sistem.getBrancharray().addLast(temp);
    }

    /***
     * This function remove Branch in this system
     * @param temp is a Branch
     * @param sistem indicates the furniture system
     */
    public void BranchRemove(Branch temp,Sistem sistem){
        KWLinkedList.KWListIter iter =sistem.getBrancharray().listIterator();
        while (iter.hasNext()){
            if (iter.equals(temp)){
                iter.remove();
            }
            iter.next();
        }
    }

    /***
     * This function add BranchEmployee in system and Branch
     * @param temp is a BranchEmployee
     * @param sistem indicates the furniture system
     */
    public void BranchEmployeeAdd(BranchEmployee temp,Sistem sistem,Branch branch){
        sistem.getBranchEmployees().add(temp);
        branch.BranchEmployeeAdd(temp);
    }
    public void BranchEmployeeRemove(BranchEmployee temp,Sistem sistem){
       sistem.getBranchEmployees().remove(sistem.getBranchEmployees().indexOf(temp));
    }
    /***
     * This function show all Branch in furniture system
     * @param sistem indicates the furniture system
     */
    public void ShowAllBranch(Sistem sistem){
        for (int i = 0; i <sistem.getBrancharray().getSize(); i++) {
            System.out.println(sistem.getBrancharray().get(i).getBranchname());
        }
    }

    public void ShowAllBranchEmployee(Sistem sistem){
        for (int i = 0; i <sistem.getBranchEmployees().size(); i++) {
            if (sistem.getBranchEmployees().get(i) != null) {
                System.out.println(sistem.getBranchEmployees().get(i).toString());
            }
        }

    }
    public void furnitureAdd(furniture temp,Sistem sistem){
        HybridList.Myiterator e= sistem.getFurnitures().iterator();
        e.add(temp);
    }

}
