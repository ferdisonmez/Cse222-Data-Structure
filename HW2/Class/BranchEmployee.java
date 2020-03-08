/***
 * This class show that personnel work in branch
 */
public class BranchEmployee extends Person implements Ipassword{
    private String password;
    public BranchEmployee(String name,String surname,String unvan,String password) {
        super(name,surname,unvan);
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void customerADD(Sistem s,Customer c){
        s.getCustomers().add(c);

    }

    /***
     *This function to delete the customer
     * @param name is string
     * @param surname is string
     * @param s is system class
     * @return 0 or -1
     */
    public int CustomerREMOVE(String name,String surname ,Sistem s){
        if (s.getCustomers().size() == 0) {
            System.out.println("Please Remove After Adding Customers To The System");
            return -1;
        }
        else {
            int tut=-1;
            for (int i = 0; i <s.getCustomers().size(); i++) {
                if (s.getCustomers().get(i).getName().equals(name ) && s.getCustomers().get(i).getSurname().equals(surname )){
                    s.getCustomers().remove(s.getCustomers().get(i));
                    tut=i;
                    return 0;
                }
            }
            if (tut == -1) {
                System.out.println("There is no Customer in this name");
                return -1;
            }

        }
        return -1;
    }

    /***
     *Fill packet information and return packet
     * @param gonderici is customer
     * @param alici is customer
     * @param takipNo is string
     * @param Durum is string
     * @param sistem is system class
     * @return paket is packet
     */
    public Paket sentPacket(int gonderici,int alici,String takipNo,String Durum,Sistem sistem){
        Paket paket=new Paket(sistem.getCustomers().get(gonderici),sistem.getCustomers().get(alici),takipNo,Durum);
        return paket;
    }

    /***
     *Shows the current status of the package
     * @param sistem is system class
     * @param paket is packet
     * @param status is string
     */
    public void cargoupdate(Sistem sistem,Paket paket,String status){
        paket.setDurum(status);
        System.out.println("Current Status of the Package:"+status);
    }

}
