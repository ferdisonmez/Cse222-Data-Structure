
/**
 *  This class can hold branch employees, transportation personnel and customers for Cargo system
 * @author Ferdi Sönmez
 */
public class Branch {
   
    private Branch_employee[] branch_employee;
    private Transportation_personnel[] transportation_personnels;
    private Customer[] customers;
    private String branch_name;
    
    /**
     * it is constructor for Branch class
     * @param branch_employee
     * @param transportation_personnels
     * @param customers
     * @param branch_name
     */
    public Branch(Branch_employee[] branch_employee, Transportation_personnel[] transportation_personnels,Customer[] customers,String branch_name) {
        this.branch_employee = branch_employee;
        this.transportation_personnels = transportation_personnels;
        this.customers=customers;
        this.branch_name=branch_name;
    }

    /**
     *  it is constructor for Branch class,include one element for create new constructor
     * @param branch_name
     */
    public Branch(String branch_name) {
        this.branch_name = branch_name;
        this.branch_employee=new Branch_employee[0];
        this.transportation_personnels=new Transportation_personnel[0];
        this.customers=new Customer[0];
    }

    /**
     * Array has been increased for you to add customer
     */
    public void customer_sizeartir(){ 
        Customer[] newarray = new  Customer[customers.length+1];
   
        System.arraycopy(customers, 0, newarray, 0, customers.length);
   
        this.customers=newarray;   
    }

    /**
     *it is function which add new customer in branch class
     * @param a
     */
    public void add_customer(Customer a){
        if (this.customers.length==1) {
            customers[0]=a;
        }
        else{
           
            this.customers[customers.length-1]=a;
        }
    }

    /**
     *  Getter function for customer Array
     * @return
     */
    public Customer[] getCustomers() {
        return customers;
    }

    /**
     * Setter function for customer Array
     * @param customers
     */
    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }
    
    /**
     *if this function may come element(element name ) ,it can remove element in array
     * @param b
     */
    public void remove_customer(String b){///customer remove islemi 
        int index=-1;
        for (int i = 0; i <customers.length; i++) {
            if (customers[i].getIsim().equals(b)) {
                index=i;
            }
        }       
        if (index > -1) {
         Customer[] newArr = new Customer[customers.length-1];     
        for(int j=0, k=0; j<customers.length; j++) {
                if(j == index){
                    continue;
                }
                newArr[k++] = customers[j];            
            }
        this.customers=newArr;
        }
        else{
            System.out.println("Boyle bir Customer  yoktur...");
        }
   }

    /**
     *  Getter function for BranchEmployee array
     * @return
     */
    public Branch_employee[] getBranch_employee() {
        return branch_employee;
    }

    /**
     *Setter function for BranchEmployee array
     * @param branch_employee
     */
    public void setBranch_employee(Branch_employee[] branch_employee) {
        this.branch_employee = branch_employee;
    }

    /**
     *Getter function for Transportation_personnel array
     * @return
     */
    public Transportation_personnel[] getTransportation_personnels() {
        return transportation_personnels;
    }

    /**
     *  Setter function for Transportation_personnel array
     * @param transportation_personnels
     */
    public void setTransportation_personnels(Transportation_personnel[] transportation_personnels) {
        this.transportation_personnels = transportation_personnels;
    }
    
    /**
     *Array has been increased for you to add branch_employee
     */
    public void branch_employee_sizeartir(){
       Branch_employee[] newarray = new  Branch_employee[branch_employee.length+1];
   
        System.arraycopy(branch_employee, 0, newarray, 0, branch_employee.length);
   
        this.branch_employee=newarray;   
    }

    /**
     *Array has been increased for you to add transportation_personnel
     */
    public void transportation_personnel_sizeartir(){
       Transportation_personnel[] newarray = new  Transportation_personnel[transportation_personnels.length+1];
   
        System.arraycopy(transportation_personnels, 0, newarray, 0, transportation_personnels.length);
   
        this.transportation_personnels=newarray;   
    }

    /**
     *  Getter function for Branch_name
     * @return branch_name
     */
    public String getBranch_name() {
        return branch_name;
    }

    /**
     *  Setter function for Branch_name
     * @param branch_name
     */
    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    /**
     * if this function may come element(Branch_employee) ,it can add element in array
     * @param a
     */
    public void add_branch_employee(Branch_employee a){

        if (this.branch_employee.length==1) {
            branch_employee[0]=a;
        }
        else{
           
            this.branch_employee[branch_employee.length-1]=a;
        }   
   }

    /**
     *if this function may come element(Transportation_personnel) ,it can add element in array
     * @param a
     */
    public void add_transportation_personnel(Transportation_personnel a){
        if (this.transportation_personnels.length==1) {
            transportation_personnels[0]=a;
        }
        else{
           
            this.transportation_personnels[transportation_personnels.length-1]=a;
        }
   }

    /**
     *if this function may come element(element name) ,it can remove element in array
     * @param b
     */
    public void remove_branch_employee(String b){///Branch remove islemi 
        int index=-1;
        for (int i = 0; i <branch_employee.length; i++) {
            if (branch_employee[i].getIsim().equals(b)) {
                index=i;
            }
        }       
        if (index > -1) {
         Branch_employee[] newArr = new Branch_employee[branch_employee.length-1];     
        for(int j=0, k=0; j<branch_employee.length; j++) {
                if(j == index){
                    continue;
                }
                newArr[k++] = branch_employee[j];            
            }
        this.branch_employee=newArr;
        }
        else{
            System.out.println("Boyle bir Branch_employee  yoktur...");
        }
   }
      
    /**
     *if this function may come element(element name ) ,it can remove element in array
     * @param b
     */
    public void remove_transportation_personnel(String b){///Branch remove islemi 
        int index=-1;
        for (int i = 0; i <transportation_personnels.length; i++) {
            if (transportation_personnels[i].getIsim().equals(b)) {
                index=i;
            }
        }       
        if (index > -1) {
         Transportation_personnel[] newArr = new Transportation_personnel[transportation_personnels.length-1];     
        for(int j=0, k=0; j<transportation_personnels.length; j++) {
                if(j == index){
                    continue;
                }
                newArr[k++] = transportation_personnels[j];            
            }
        this.transportation_personnels=newArr;
        }
        else{
            System.out.println("Boyle bir Transportation_personnel  yoktur...");
        }
   }   

    /**
     *  This function return in custom array size
     * @return customers array size
     */
    public int get_customers_size(){
           return customers.length;
       }
 
    
 
}
