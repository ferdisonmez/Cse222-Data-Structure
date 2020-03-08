

/**
 *  This class can hold that branch registry customer in the system
 * @author Ferdi Sönmez
 */
public class Customer extends Person{
    private String tracking_no;

    /**
     *  it is constructor for customer class
     * @param isim
     * @param surname
     * @param tracking_no
     */
    public Customer(String isim, String surname,String tracking_no) {
        super(isim, surname);
        this.tracking_no = tracking_no;       
    }
    
    /**
     *  Getter function for trackingNo
     * @return trackingNo
     */
    public String getTracking_no() {
        return tracking_no;
    }

    /**
     *  Setter function for trackingNo
     * @param tracking_no
     */
    public void setTracking_no(String tracking_no) {
        this.tracking_no = tracking_no;
    }
    
    /**
     * this function can show that customer has a packet and this packet status
     * @param a
     * @param b
     */
    public void paket_info(String a,Sistem b){ ///Brnach ve takip no
        for (int i = 0; i < b.getPakets().length; i++) {
            if (b.getPakets()[i].getTakip_no().equals(a)) {
                System.out.println("Alici= " + b.getPakets()[i].getAlici().getIsim() + " \n" 
                        +"Gonderici= " + b.getPakets()[i].getAlici().getSurname() + " \n"
                        +"Paket Durumu= "+ b.getPakets()[i].getPaketdurum());
            }
        }
    }
  
}
