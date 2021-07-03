public class Sistem implements Sisteminterface {
    private Admin[] adminarray;
    private Customer[] customerarray;
    private Branch[] brancharray;
    private furniture[] furnitures;
    private BranchEmployee[] branchEmployees;
    private Databases databases;

    public Sistem() {
        this.furnitures =new furniture[furnituressize];
        this.adminarray = new Admin[arraysize];
        this.customerarray = new Customer[arraysize];
        this.brancharray = new Branch[branchsize];
        this.branchEmployees=new BranchEmployee[arraysize];
        this.databases=new Databases();
    }

    /***
     * Adds administrators to the system
     * @param temp is administrator
     */
    public void AdminAdd(Admin temp){
        int i;
        for (i = 0; i <adminarray.length; i++) {
            if (adminarray[i]==null)
                break;
        }
        if (i <=adminarray.length) {
            adminarray[i]=temp;
            System.out.println(temp.toString()+" added as Admin");
        }

    }
    private int myrandom(){
        int k=1;
        for (int i = 0; i <this.customerarray.length; i++) {
            if (this.customerarray[i].getCustomerid() != k) {
                return k;
            }
            k++;
        }
        return 1 ;
    }

    /***
     * Adds customers to the system
     * @param customer is a customer
     * @return customerid
     */
    public int CustomerAdd(Customer customer){
        int i;
        for (i = 0; i <customerarray.length; i++) {
            if (customerarray[i]==null)
                break;
        }
        customerarray[i]=customer;
        int a=myrandom();
        System.out.println("CustomerName:"+customer.getName()+" CustomerSurname:"+ customer.getSurname()+" Customerid:"+a);
        return a;
    }

    /***
     * The customer logs into the system
     * @param customer is a customer
     */
    public void CustomerEnter(Customer customer){
        for (int i = 0; i <customerarray.length; i++) {
            if (customerarray[i].getSifre() ==customer.getSifre()) {
                customer.showinformotion();
            }
        }
    }

    /***
     * Deletes products received in the system
     * @param temp is a furniture
     * @param sistem
     */
    public void ProductRemove(furniture temp, Sistem sistem) {
        sistem.setFurnitures(removeTheElementfurniture(sistem.getFurnitures(), findindex(temp, sistem)));
    }

    private furniture[] removeTheElementfurniture(furniture[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            System.out.println("!!!WARNING:This product cannot find in system!!!");
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

    private int findindex(furniture temp, Sistem sistem) {
        for (int i = 0; i < sistem.getFurnitures().length; i++) {
            if (sistem.getFurnitures()[i] != null && (sistem.getFurnitures()[i].getName().equals(temp.getName()) && sistem.getFurnitures()[i].getModel().equals(temp.getModel()))) {
                return i;
            }
        }
        return -1;
    }

    public Databases getDatabases() {
        return databases;
    }


    public Admin[] getAdminarray() {
        return adminarray;
    }

    public void setAdminarray(Admin[] adminarray) {
        this.adminarray = adminarray;
    }

    public Customer[] getCustomerarray() {
        return customerarray;
    }

    public void setCustomerarray(Customer[] customerarray) {
        this.customerarray = customerarray;
    }

    public Branch[] getBrancharray() {
        return brancharray;
    }

    public void setBrancharray(Branch[] brancharray) {
        this.brancharray = brancharray;
    }

    public furniture[] getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(furniture[] furnitures) {
        this.furnitures = furnitures;
    }

    public BranchEmployee[] getBranchEmployees() {
        return branchEmployees;
    }

    public void setBranchEmployees(BranchEmployee[] branchEmployees) {
        this.branchEmployees = branchEmployees;
    }
}
