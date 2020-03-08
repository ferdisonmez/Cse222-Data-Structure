

/**
 *This class can include in Branch Employee which may work in branch 
 * @author Ferdi Sönmez
 */
public class Branch_employee extends Person{
   
    /**
     *  It is constructor for BranchEmployee
     * @param isim
     * @param surname
     * @param customers
     */
    public Branch_employee(String isim, String surname,Customer[] customers) {
        super(isim, surname);
       
    }
    
    /**
     *  It is constructor for BranchEmployee
     * @param isim
     * @param surname
     */
    public Branch_employee(String isim, String surname) {
        super(isim, surname);   
    }
    
    /**
     * This function can update status that packets
     * @param alici
     * @param gonderici
     * @param paket
     * @param sistem
     */
    public void gonderi_info_enter(Customer alici,Customer gonderici,Paket paket,Sistem sistem){ ///Gonderen ve alici bilgileri kaydedildi
           sistem.getPakets()[sistem.getPakets().length+1].setAlici(alici);
           sistem.getPakets()[sistem.getPakets().length+1].setGonderici(gonderici);
           sistem.pakets_sizeartir();
           sistem.add_pakets(paket);      
    }
    
    /**
     * Branch employee can add customer on the  Branch
     * @param x
     * @param a
     * 
     */
    public void Add_Branch_Customer(Branch x,Customer a){
       x.add_customer(a);
   }

    /**
     *Branch employee can remove customer on the  Branch
     * @param x
     * @param a
     */
    public void Remove_Branch_Customer(Branch x,String a){
       x.remove_customer(a);
   }

    /**
     *Branch employee can add packet on the System
     * @param x
     * @param alici
     * @param gonderici
     * @param paket
     */
    public void Add_Paket(Sistem x,Customer alici,Customer gonderici,Paket paket){
       x.pakets_sizeartir();
       x.add_pakets(paket);
   }
}
