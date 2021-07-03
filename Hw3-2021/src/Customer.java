import java.util.Scanner;

public class Customer extends Person {
    private int Customerid;
    private KWLinkedList pastbuy;
    private String Tlfn;
    private String Adress;
    private final int productsize=100;

    public Customer(String name, String surname, String email, String sifre, int customerid) {
        super(name, surname, email, sifre);
        Customerid = customerid;
        pastbuy=new KWLinkedList<furniture>();
    }

    public void Searchurun(String urunname,Sistem sistem){
        HybridList.Myiterator e= sistem.getFurnitures().iterator();
        e.find(urunname);
    }
    public void BuyProduct(Sistem sistem,String name,String model,String color,String branchname){
        int i;
        for (i = 0; i <sistem.getBrancharray().getSize(); i++) {
            if (sistem.getBrancharray().get(i).getBranchname().equals(branchname)) {
                break;
            }
        }
         this.pastbuy.addLast(new furniture(name,model,color,sistem.getBrancharray().get(i)));
    }


    public void ShowurunList(Sistem sistem){

        sistem.getFurnitures().iterator().ShowLinkedList();
    }

    public void ShowurunBranch(String Productname,Sistem sistem){
        HybridList.Myiterator e= sistem.getFurnitures().iterator();

        if (e.indexOf(new furniture(Productname))!=-1){
            System.out.println(e.next().toString());
        }
    }
    public void Buyonline(Sistem sistem){
        System.out.println("*****BuyOnline-All Furniture****");
        if (this.Tlfn==null || this.Adress ==null){
            System.out.println("You have to enter your phone number and your adress!!!Please Enter All Information");
            return;
        }
        this.ShowurunList(sistem);
        System.out.println("*************************************");

    }
    public void EnterTlfnAdress(String adress,String tlfn){
        this.Adress=adress;
        this.Tlfn=tlfn;
    }
    public void ShowPastBuy(Sistem sistem,int Customeridtemp){
        int flag=-1;
        for (int i = 0; i <sistem.getCustomerarray().size(); i++) {
            if ((sistem.getCustomerarray().get(i) != null) && (sistem.getCustomerarray().get(i).Customerid == Customeridtemp)) {
                for (int j = 0; j <sistem.getCustomerarray().get(i).pastbuy.getSize() && sistem.getCustomerarray().get(i).pastbuy.get(j) !=null ; j++) {
                    System.out.println(sistem.getCustomerarray().get(i).pastbuy.get(j).toString());
                    flag=0;
                }
            }
        }
        if (flag ==-1) {
            System.out.println("No product received");
            return;
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

    public KWLinkedList<furniture> getPastbuy() {
        return pastbuy;
    }

    public void setPastbuy(KWLinkedList<furniture> pastbuy) {
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
}
