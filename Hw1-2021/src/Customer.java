import java.util.concurrent.TimeUnit;

public class Customer extends Person {
    private int Customerid;
    private furniture[] pastbuy;
    private String Tlfn;
    private String Adress;
    private  int productsize=1;

    public Customer(String name, String surname, String email, String sifre) {
        super(name, surname, email, sifre);
        pastbuy=new furniture[productsize];
    }

    /***
     * Searches for the product in the system
     * @param urunname name of the product name
     * @param sistem indicates the furniture system
     */
   public void Searchurun(String urunname,Sistem sistem){
        for (int i = 0; i <sistem.getFurnitures().length; i++) {
            if (urunname.equals(sistem.getFurnitures()[i].getName())) {
                ShowurunBranch(urunname,sistem);
                return;
            }
        }
       System.out.println("Sorry This Product Cannot Find");
    }

    /***
     *Lists all products in the system
     * @param sistem indicates the furniture system
     */
    public void ShowurunList(Sistem sistem){
        for (int i = 0; i <sistem.getFurnitures().length; i++) {
            if (sistem.getFurnitures()[i]!=null) {
                System.out.println("Product-Name:" + sistem.getFurnitures()[i].getName() + " Model:" + sistem.getFurnitures()[i].getModel() + " Color:" + sistem.getFurnitures()[i].getColor());
            }
        }


    }

    /***
     *Lists all products in the branch
     * @param Productname
     * @param sistem indicates the furniture system
     */
    public void ShowurunBranch(String Productname,Sistem sistem){
        for (int i = 0; i <sistem.getBrancharray().length; i++) {
            for (int j = 0; j <sistem.getBrancharray()[i].getBranchfurniture().length; j++) {
                if (sistem.getBrancharray()[i].getBranchfurniture()[j]!=null && sistem.getBrancharray()[i].getBranchfurniture()[j].getName().equals(Productname)){
                    System.out.println("This Product in Branch:"+sistem.getBrancharray()[i].getBranchname());
                }
            }
        }
    }

    /***
     *Online shopping in the system
     * @param sistem indicates the furniture system
     * @param ProductName is name of the product
     * @param ProductModel is model of the product
     * @param ProductColor is color of the product
     */
    public void Buyonline(Sistem sistem,String ProductName,String ProductModel,String ProductColor){
        System.out.println("*****BuyOnline****");
        if (this.Tlfn==null || this.Adress ==null){
            System.out.println("WARNING!!!--You have to enter your phone number and your adress!!!Please Enter All Information--");
            return;
        }
        System.out.println("ALL INFORMATION OKEY");
        System.out.println("*********Product List****************");
        this.ShowurunList(sistem);
        System.out.println("You have to enter productname for buy!!!");
        try {
            System.out.println("Searching.....");
            TimeUnit.SECONDS.sleep(3);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <sistem.getFurnitures().length; i++) {
            if (sistem.getFurnitures()[i] != null && (sistem.getFurnitures()[i].getName().equals(ProductName) && sistem.getFurnitures()[i].getModel().equals(ProductModel) && sistem.getFurnitures()[i].getColor().equals(ProductColor))) {
                this.furniturepastbuy(sistem.getFurnitures()[i],sistem);
                System.out.println(sistem.getFurnitures()[i].getName()+" is buyed by "+this.getName());
                this.furniturepastbuy(sistem.getFurnitures()[i],sistem);
                sistem.ProductRemove(sistem.getFurnitures()[i],sistem);
            }
        }

        System.out.println("*************************************");

    }

    /***
     * Saves the customer's address and phone in the system
     * @param adress Customer's address
     * @param tlfn Customer's phone
     */
    public void EnterTlfnAdress(String adress,String tlfn){
        this.Adress=adress;
        this.Tlfn=tlfn;
    }

    /***
     *List all products purchased by the customer
     * @param sistem indicates the furniture system
     * @param Customeridtemp is a Customer's id
     */
    public void ShowPastBuy(Sistem sistem,int Customeridtemp){
        for (int i = 0; i <sistem.getCustomerarray().length; i++) {
            if ((sistem.getCustomerarray()[i] != null) && (sistem.getCustomerarray()[i].Customerid == Customeridtemp)) {
                for (int j = 0; j <sistem.getCustomerarray()[i].pastbuy.length; j++) {
                    System.out.println("ProductName: "+sistem.getCustomerarray()[i].pastbuy[j].getName()+"ProductModel: "+sistem.getCustomerarray()[i].pastbuy[j].getModel() );
                }
            }
        }
    }

    public int getCustomerid() {
        return Customerid;
    }

    public void setCustomerid(int customerid) {
        Customerid = customerid;
    }

    @Override
    public String toString() {
        String temp="Customer "+ super.toString();
        return temp;
    }

    public furniture[] getPastbuy() {
        return pastbuy;
    }

    public void setPastbuy(furniture[] pastbuy) {
        this.pastbuy = pastbuy;
    }

    public String getTlfn() {
        return Tlfn;
    }

    public void setTlfn(String tlfn) {
        Tlfn = tlfn;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    /***
     *
     * @param temp is a furniture
     * @param sistem indicates the furniture system
     */
    public void furniturepastbuy(furniture temp, Sistem sistem) {
        if (this.pastbuy.length == 1) {
            pastbuy[0]=temp;
        }
        else {
            int i=0;

            while (this.pastbuy[i]!=null){
                i++;
            }
            productsize++;
            this.pastbuy[i]=temp;

        }
    }
}
