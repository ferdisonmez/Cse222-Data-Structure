public class Branch implements Sisteminterface{
    private String Branchname;
    private furniture[] branchfurniture;
    private BranchEmployee[] branchEmployees;
    private furniture[] sellfurniture;
    private Databases branchdatabases;

    /***
     * This is a constructor
     * @param branchname is string
     */
    public Branch(String branchname) {
        Branchname = branchname;
        branchfurniture=new furniture[furnituressize];
        branchEmployees=new BranchEmployee[arraysize];
        this.sellfurniture=new furniture[0];
        this.branchdatabases=new Databases();
    }

    public Branch(String branchname, BranchEmployee[] branchEmployees,furniture[] furnitures) {
        Branchname = branchname;
        this.branchfurniture=furnitures;
        this.branchEmployees = branchEmployees;
    }

    public Databases getBranchdatabases() {
        return branchdatabases;
    }

    public void setBranchdatabases(Databases branchdatabases) {
        this.branchdatabases = branchdatabases;
    }

    public furniture[] getBranchfurniture() {
        return branchfurniture;
    }

    public void setBranchfurniture(furniture[] branchfurniture) {
        this.branchfurniture = branchfurniture;
    }

    public furniture[] getSellfurniture() {
        return sellfurniture;
    }

    public void setSellfurniture(furniture[] sellfurniture) {
        this.sellfurniture = sellfurniture;
    }

    public String getBranchname() {
        return Branchname;
    }

    public void setBranchname(String branchname) {
        Branchname = branchname;
    }

    public BranchEmployee[] getBranchEmployees() {
        return branchEmployees;
    }

    public void setBranchEmployees(BranchEmployee[] branchEmployees) {
        this.branchEmployees = branchEmployees;
    }

    /***
     * This function add BranchEmployee
     * @param temp is a BranchEmployee
     */
    public void BranchEmployeeAdd(BranchEmployee temp){
        int i;
        for (i = 0; i <branchEmployees.length; i++) {
            if (branchEmployees[i]==null)
                break;
        }
        branchEmployees[i]=temp;
    }

    /***
     * Remove the branch employee
     * @param temp
     */
    public void BranchEmployeeRemove(BranchEmployee temp){
        setBranchEmployees(removeTheElementBranchEmployee(getBranchEmployees(),findindex(temp)));
    }
    private BranchEmployee[] removeTheElementBranchEmployee(BranchEmployee[] arr, int index)
    {
        if (arr == null || index < 0  || index >= arr.length) {
            return arr;
        }
        BranchEmployee[] anotherArray = new BranchEmployee[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }
    private int findindex(BranchEmployee temp){
        for (int i = 0; i <getBranchEmployees().length; i++) {
            if ((getBranchEmployees()[i].getName().equals(temp.getName()) && getBranchEmployees()[i].getSurname().equals(temp.getSurname()))) {
                return i;
            }
        }
        return -1;
    }
}
