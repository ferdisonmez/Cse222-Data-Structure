public class BranchEmployee extends Person implements Sisteminterface {
    private Branch BranchName;
    public BranchEmployee(String name, String surname, String email, String sifre,Branch BranchName) {
        super(name, surname, email, sifre);
        this.BranchName=BranchName;
    }

    /***
     * Inventory inquiry in the branch
     */
    public void QueryStokFromBranch(){
        System.out.println("***Inventory inquiry in the branch***");
        if (BranchName.getBranchdatabases().getOfficechairsize() > 0) {
            System.out.println("BranchName:"+BranchName.getBranchname()+"-->Office ChairSize:"+BranchName.getBranchdatabases().getOfficechairsize());
        }
        if (BranchName.getBranchdatabases().getBookcasesize() > 0) {
            System.out.println("BranchName:"+BranchName.getBranchname()+"-->BookCaseSize:"+BranchName.getBranchdatabases().getBookcasesize());
        }
        if (BranchName.getBranchdatabases().getMeetingtablesize() > 0) {
            System.out.println("BranchName:"+BranchName.getBranchname()+"-->MeetingTableSize:"+BranchName.getBranchdatabases().getMeetingtablesize());
        }
        if (BranchName.getBranchdatabases().getOfficecabinet() > 0) {
            System.out.println("BranchName:"+BranchName.getBranchname()+"-->OfficeCabinet:"+BranchName.getBranchdatabases().getOfficecabinet());
        }
        if (BranchName.getBranchdatabases().getOfficedesksize() > 0) {
            System.out.println("BranchName:"+BranchName.getBranchname()+"-->OfficeDesk:"+BranchName.getBranchdatabases().getOfficedesksize());
        }

    }

    /***
     * Reports to manager on store stocks
     */
    public void ReportAdmin(){
        if (BranchName.getSellfurniture().length>0) {
            System.out.println("***Report For Admin****");
            for (int i = 0; i <BranchName.getSellfurniture().length; i++) {
                if (BranchName.getSellfurniture()[i] != null) {
                    System.out.println("ProductName:"+BranchName.getSellfurniture()[i].getName()+ " Model:"+BranchName.getSellfurniture()[i].getModel()+ " Color:"+BranchName.getSellfurniture()[i].getColor());
                }
            }
            System.out.println("********************************");
        }
    }

    /***
     * Branch employee can increase stocks
     */
    public void BuyStok(){
        if (BranchName.getBranchdatabases().getOfficechairsize() < officechairsz) {
            System.out.println("You have to buy"+"-->Office Chair:"+(officechairsz-BranchName.getBranchdatabases().getOfficechairsize()));
        }
        if (BranchName.getBranchdatabases().getBookcasesize() < bookcasesz) {
            System.out.println("You have to buy"+"-->BookCase:"+(bookcasesz-BranchName.getBranchdatabases().getBookcasesize()));
        }
        if (BranchName.getBranchdatabases().getMeetingtablesize() <meetingtablesz) {
            System.out.println("You have to buy"+"-->MeetingTable:"+(meetingtablesz-BranchName.getBranchdatabases().getMeetingtablesize()));
        }
        if (BranchName.getBranchdatabases().getOfficecabinet() < officecabinetsz) {
            System.out.println("You have to buy"+"-->OfficeCabinet:"+(officecabinetsz-BranchName.getBranchdatabases().getOfficecabinet()));
        }
        if (BranchName.getBranchdatabases().getOfficedesksize() <officedesksz) {
            System.out.println("You have to buy"+"-->OfficeDesk:"+(officedesksz-BranchName.getBranchdatabases().getOfficecabinet()));
        }

    }

    /***
     * Branch employee deletes the sold product from the system.
     * @param temp is a furniture
     * @param sistem indicates the furniture system
     */
    public void ProductAddRemove(furniture temp,Sistem sistem){
        sistem.setFurnitures(removeTheElementfurniture(sistem.getFurnitures(),findindex(temp,sistem)));
    }
    private furniture[] removeTheElementfurniture(furniture[] arr, int index)
    {
        if (arr == null || index < 0  || index >= arr.length) {
            return arr;
        }
        furniture[] anotherArray = new furniture[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }
    private int findindex(furniture temp,Sistem sistem){
        for (int i = 0; i <sistem.getFurnitures().length; i++) {
            if (sistem.getFurnitures()[i].equals(temp) ) {
                return i;
            }
        }
        return -1;
    }

    /***
     * Branch employee lists the products purchased by the customer with the customer number.
     * @param Customerid is a customerid
     * @param sistem indicates the furniture system
     */
    public void ShowBuyFromCustomerid(int Customerid,Sistem sistem){
        Customer tempcustomer=null;
        for (int i = 0; i <sistem.getCustomerarray().length; i++) {
            if (sistem.getCustomerarray()[i] != null && (sistem.getCustomerarray()[i].getCustomerid()==Customerid)) {
                tempcustomer=sistem.getCustomerarray()[i];
                for (int j = 0; j <sistem.getCustomerarray()[i].getPastbuy().length; j++) {
                    if (sistem.getCustomerarray()[i].getPastbuy()[j] != null) {
                        System.out.println("Purchased products--> "+"ProductName:"+sistem.getCustomerarray()[i].getPastbuy()[j].getName()+" Model:"+sistem.getCustomerarray()[i].getPastbuy()[j].getModel());
                        return;
                    }
                }
            }
        }
        if (tempcustomer!=null) {
            System.out.println(tempcustomer.getName() + " has never bought a product before!!!");
        }
    }

    /***
     * It registers the customer in the system.
     * @param customer  is the customer who wants to shop
     * @param sistem indicates the furniture system
     */
    public void RegisteredCustomer(Customer customer,Sistem sistem){
        for (int i = 0; i <sistem.getCustomerarray().length; i++) {
            if (sistem.getCustomerarray()[i] !=null && sistem.getCustomerarray()[i].getCustomerid() == customer.getCustomerid() && sistem.getCustomerarray()[i].getName().equals(customer.getName())) {
                System.out.println("This customer has registered in the system before.");
                return;
            }
        }
        sistem.CustomerAdd(customer);
    }
    @Override
    public String toString() {
        String temp="BranchEmployee "+ super.toString();
        return temp;
    }

}
