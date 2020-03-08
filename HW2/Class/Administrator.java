/***
 * This class include system administrators
 */
public class Administrator extends Person implements Ipassword {
    private String password;
    public Administrator(String name, String surname, String unvan,String password) {
        super(name, surname,unvan);
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void AddBranch(Branch c,Sistem s){
        s.getBranches().add(c);
    }

    /***
     * This function is to delete the branches of the cargo
     * @param name is string
     * @param b is system
     * @return 0 or -1 to understand that branches have been deleted
     */

    public int RemoveBranch(String name, Sistem b){
        if (b.getBranches().size() == 0) {
            System.out.println("Please Remove After Adding a Branch to the System");
            return -1;
        }
        else {
            int tut=-1;
            for (int i = 0; i <b.getBranches().size(); i++) {
                if (b.getBranches().get(i).getName().equals(name)){
                    b.getBranches().remove(b.getBranches().get(i));
                    tut=i;
                    return 0;
                }
            }
            if (tut == -1) {
                System.out.println("There is no branch in this name");
                return -1;
            }

        }
        return -1;
    }

    /***
     * This function target that  to add transportation personnel
     * @param t is transportation personnel
     * @param s is system
     */
    public void TransportationPersonelADD(TransportationPersonel t,Sistem s){
        s.getTransportationPersonels().add(t);
    }

    /***
     *This function is to delete the TransportationPersonnel of the Branch
     * @param name is String
     * @param surname is String
     * @param s is system
     * @return 0 or -1 to understand that transportationPersonnel have been deleted
     */
    public int TransportationPersonelREMOVE(String name,String surname ,Sistem s){
        if (s.getTransportationPersonels().size() == 0) {
            System.out.println("Please Remove After Adding Transportation Personnel to the System");
            return -1;
        }
        else {
            int tut=-1;
            for (int i = 0; i <s.getTransportationPersonels().size(); i++) {
                if (s.getTransportationPersonels().get(i).getName().equals(name ) && s.getTransportationPersonels().get(i).getSurname().equals(surname )){
                    s.getTransportationPersonels().remove(s.getTransportationPersonels().get(i));
                    tut=i;
                    return 0;
                }
            }
            if (tut == -1) {
                System.out.println("There is no TransportationPersonnel in this name");
                return -1;
            }

        }
        return -1;
    }

    /**
     *  This function target that  to add BranchEmployee
     * @param b is BranchEmployee
     * @param s is System
     */
    public void BranchEmployeeADD(BranchEmployee b,Sistem s){
        s.getBranchEmployees().add(b);
    }

    /**
     *This function is to delete the BranchEmployee of the Branch
     * @param name is string
     * @param surname is string
     * @param s is sistem
     * @return 0 or -1 to understand that BranchEmployee have been deleted
     */

    public int BranchEmployeeREMOVE(String name,String surname ,Sistem s){
            if (s.getBranchEmployees().size() == 0) {
                System.out.println("Please Remove After Adding Branch Employee To The System");
                return -1;
            }
            else {
                int tut=-1;
                for (int i = 0; i <s.getBranchEmployees().size(); i++) {
                    if (s.getBranchEmployees().get(i).getName().equals(name ) && s.getBranchEmployees().get(i).getSurname().equals(surname )){
                        s.getBranchEmployees().remove(s.getBranchEmployees().get(i));
                        tut=i;
                        return 0;
                    }
                }
                if (tut == -1) {
                    System.out.println("There is no Branch Employee in this name");
                    return -1;
                }

            }
            return -1;
    }


}
