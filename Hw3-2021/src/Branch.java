public class Branch implements Sisteminterface{
    private String Branchname;
    private HybridList<MyArrayList<furniture>> branchfurniture;
    private MyArrayList<BranchEmployee> branchEmployees;
    private HybridList<MyArrayList<furniture>> sellfurniture;

    public Branch(String branchname) {
        Branchname = branchname;
        branchfurniture=new HybridList<MyArrayList<furniture>>();
        branchEmployees=new MyArrayList<BranchEmployee>();
        this.sellfurniture=new HybridList<MyArrayList<furniture>>();
    }

    public Branch(String branchname, MyArrayList<BranchEmployee> branchEmployees,HybridList<MyArrayList<furniture>> furnitures) {
        Branchname = branchname;
        this.branchfurniture=furnitures;
        this.branchEmployees = branchEmployees;
    }

    public HybridList<MyArrayList<furniture>> getBranchfurniture() {
        return branchfurniture;
    }

    public void setBranchfurniture(HybridList<MyArrayList<furniture>> branchfurniture) {
        this.branchfurniture = branchfurniture;
    }

    public HybridList<MyArrayList<furniture>> getSellfurniture() {
        return sellfurniture;
    }

    public void setSellfurniture(HybridList<MyArrayList<furniture>> sellfurniture) {
        this.sellfurniture = sellfurniture;
    }

    public String getBranchname() {
        return Branchname;
    }

    public void setBranchname(String branchname) {
        Branchname = branchname;
    }

    public MyArrayList<BranchEmployee> getBranchEmployees() {
        return branchEmployees;
    }

    public void setBranchEmployees(MyArrayList<BranchEmployee> branchEmployees) {
        this.branchEmployees = branchEmployees;
    }

    /***
     * This function add BranchEmployee
     * @param temp is a BranchEmployee
     */
    public void BranchEmployeeAdd(BranchEmployee temp){
        branchEmployees.add(temp);
    }
    public void BranchEmployeeRemove(BranchEmployee temp){
        branchEmployees.remove(branchEmployees.indexOf(temp));
    }
}
