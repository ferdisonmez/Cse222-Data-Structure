public class Sistem implements Sisteminterface {
    private KWArrayList<Admin> adminarray;
    private KWArrayList<Customer> customerarray;
    private KWLinkedList<Branch> brancharray;
    private HybridList<MyArrayList<furniture>> furnitures;
    private KWArrayList<BranchEmployee> branchEmployees;
    public  Admin sistemadmin;
    public Sistem() {
        this.furnitures =new HybridList<MyArrayList<furniture>>();
        this.adminarray = new KWArrayList<Admin>();
        this.customerarray = new KWArrayList<Customer>();
        this.brancharray = new KWLinkedList<Branch>();
        this.branchEmployees=new KWArrayList<BranchEmployee>();
        sistemadmin=new Admin("sistem","sistem","sistem","sistem");

    }


    public void AdminAdd(Admin temp){
        adminarray.add(temp);
    }

    public void CustomerAdd(Customer customer){
        customerarray.add(customer);
    }


    public void CustomerEnter(Customer customer){
        for (int i = 0; i <customerarray.size(); i++) {
            if (customerarray.get(i).getSifre() ==customer.getSifre()) {
                customer.showinformotion();
            }
        }
    }



    public KWArrayList<Admin> getAdminarray() {
        return adminarray;
    }

    public void setAdminarray(KWArrayList<Admin> adminarray) {
        this.adminarray = adminarray;
    }

    public KWArrayList<Customer> getCustomerarray() {
        return customerarray;
    }

    public void setCustomerarray(KWArrayList<Customer>  customerarray) {
        this.customerarray = customerarray;
    }

    public KWLinkedList<Branch> getBrancharray() {
        return brancharray;
    }

    public void setBrancharray(KWLinkedList<Branch>  brancharray) {
        this.brancharray = brancharray;
    }

    public HybridList<MyArrayList<furniture>> getFurnitures() {
        return furnitures;
    }

   /* public void setFurnitures(furniture[] furnitures) {
        this.furnitures = furnitures;
    }*/

    public KWArrayList <BranchEmployee> getBranchEmployees() {
        return branchEmployees;
    }

    public void setBranchEmployees(KWArrayList <BranchEmployee> branchEmployees) {
        this.branchEmployees = branchEmployees;
    }
}
