public class Admin extends Person {
    public Admin(String name, String surname, String email, String sifre) {
        super(name, surname, email, sifre);
    }

    /***
     * Shows the products in the system
     * @param sistem indicates the  furnitures system
     */
    public void Showurun(Sistem sistem) {
        System.out.println("***All furnitures in All system*****");
        for (int i = 0; i < sistem.getFurnitures().length; i++) {
            System.out.println("Model: " + sistem.getFurnitures()[i].getModel() + "Color:" + sistem.getFurnitures()[i].getColor());
        }
    }

    /***
     * Shows all managers in the furniture system
     * @param sistem indicates the  furnitures system
     */
    public void ShowAllAdmin(Sistem sistem) {
        System.out.println("********System Admin******");
        for (int i = 0; i < getadminarraysize(sistem.getAdminarray()); i++) {
            System.out.println(sistem.getAdminarray()[i].toString());
        }
        System.out.println("***************************");
    }

    /***
     * Adds a new administrator to the system
     * @param temp is a administrator
     * @param sistem indicates the furniture system
     */
    public void AdminEnter(Admin temp, Sistem sistem) {
        for (int i = 0; i < getadminarraysize(sistem.getAdminarray()); i++) {
            if (sistem.getAdminarray()[i].getSifre().equals(temp.getSifre())) {
                System.out.println(temp.showinformotion() + " enter in the system as Admin.");
            }
        }
    }

    /***
     *
     * @param temparray is administrator array
     * @return how much is array of admin
     */
    private int getadminarraysize(Admin[] temparray) {
        int temp = 0;
        for (int i = 0; i < temparray.length; i++) {
            if (temparray[i] != null) {
                temp++;
            }
        }
        return temp;
    }

    @Override
    public String toString() {
        String temp = "Yonetici " + super.toString();
        return temp;
    }

    /***
     * Add the branch in the system
     * @param temp is a Branch
     * @param sistem indicates the furniture system
     */
    public void BranchAdd(Branch temp, Sistem sistem) {
        int i;
        for (i = 0; i < sistem.getBrancharray().length; i++) {
            if (sistem.getBrancharray()[i] == null)
                break;
        }
        if (i <= sistem.getBrancharray().length) {
            sistem.getBrancharray()[i] = temp;
            System.out.println(this.showinformotion() + " added  " + temp.getBranchname() + " as branch in System");
        }
    }

    /***
     * This function remove Branch in this system
     * @param temp is a Branch
     * @param sistem indicates the furniture system
     */
    public void BranchRemove(Branch temp, Sistem sistem) {
        sistem.setBrancharray(removeTheElementBranch(sistem.getBrancharray(), findindex(temp, sistem)));
    }

    private Branch[] removeTheElementBranch(Branch[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            System.out.println("!!!WARNING:This Branch cannot find in system!!!");
            return arr;
        }
        Branch[] anotherArray = new Branch[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }

        return anotherArray;
    }

    private int findindex(Branch temp, Sistem sistem) {
        for (int i = 0; i < sistem.getBrancharray().length; i++) {
            if (sistem.getBrancharray()[i].getBranchname() != null && sistem.getBrancharray()[i].getBranchname().equals(temp.getBranchname())) {
                return i;
            }
        }
        return -1;
    }

    /***
     * This function add BranchEmployee in system and Branch
     * @param temp is a BranchEmployee
     * @param sistem indicates the furniture system
     * @param branch is a Branch
     */
    public void BranchEmployeeAdd(BranchEmployee temp, Sistem sistem, Branch branch) {
        int i;
        for (i = 0; i < sistem.getBranchEmployees().length; i++) {
            if (sistem.getBranchEmployees()[i] == null)
                break;
        }
        if (i <= sistem.getBranchEmployees().length) {
            sistem.getBranchEmployees()[i] = temp;
            branch.BranchEmployeeAdd(temp);
            System.out.println(this.showinformotion() + " added  " + temp.getName() + " to " + branch.getBranchname()+" branch as BranchEmployee");
        }
    }

    /***
     * Remove BranchEmployee
     * @param temp is a BranchEmployee
     * @param sistem indicates the furniture system
     * @param branch  is the branch where the branch employee will be removed.
     */
    public void BranchEmployeeRemove(BranchEmployee temp, Sistem sistem, Branch branch) {
        sistem.setBranchEmployees(removeTheElementBranchEmployee(sistem.getBranchEmployees(), findindex(temp, sistem)));
    }

    private BranchEmployee[] removeTheElementBranchEmployee(BranchEmployee[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
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

    private int findindex(BranchEmployee temp, Sistem sistem) {
        for (int i = 0; i < sistem.getBranchEmployees().length; i++) {
            if ((sistem.getBranchEmployees()[i].getName().equals(temp.getName()) && sistem.getBranchEmployees()[i].getSurname().equals(temp.getSurname()))) {
                return i;
            }
        }
        return -1;
    }

    /***
     * This function show all Branch in furniture system
     * @param sistem indicates the furniture system
     */
    public void ShowAllBranch(Sistem sistem) {
        for (int i = 0; i < sistem.getBrancharray().length; i++) {
            System.out.println(sistem.getBrancharray()[i].getBranchname());
        }
    }

    /***
     * Shows all employees working in the system
     * @param sistem indicates the furniture system
     */
    public void ShowAllBranchEmployee(Sistem sistem) {
        for (int i = 0; i < sistem.getBranchEmployees().length; i++) {
            if (sistem.getBranchEmployees()[i] != null) {
                System.out.println(sistem.getBranchEmployees()[i].toString());
            }
        }

    }

    /***
     * adds new furniture to the system
     * @param temp is a furniture
     * @param sistem indicates the furniture system
     */
    public void furnitureAdd(furniture temp, Sistem sistem) {
        int i;
        for (i = 0; i < sistem.getFurnitures().length; i++) {
            if (sistem.getFurnitures()[i] == null)
                break;
        }
        sistem.getFurnitures()[i] = temp;
        sistem.getDatabases().incrementfunction(temp);
    }

    public void furnitureaddbranch(furniture temp,Branch branch) {
        int i;
        for (i = 0; i < branch.getBranchfurniture().length; i++) {
            if (branch.getBranchfurniture()[i] == null)
                break;
        }
        branch.getBranchfurniture()[i] = temp;
        branch.getBranchdatabases().incrementfunction(temp);
    }
    /***
     * Tells the manager about the missing furniture in the system
     * @param sistem indicates the furniture system
     */

    public void Missfurniture(Sistem sistem) {
        for (int i = 0; i < sistem.getBrancharray().length; i++) {
            if (sistem.getBrancharray()[i] != null) {
                for (int j = 0; j < sistem.getBrancharray()[i].getSellfurniture().length; j++) {
                    if (sistem.getBrancharray()[i].getSellfurniture()[j] != null) {
                        System.out.println("MissProductName:" + sistem.getBrancharray()[i].getSellfurniture()[j].getName() + " MissProductModel:" + sistem.getBrancharray()[i].getSellfurniture()[j].getModel());
                    }
                }
            }

        }

    }
}