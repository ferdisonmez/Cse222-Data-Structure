

/**
 * This class hold packet information that customer will take or send
 * @author Ferdi Sönmez
 */
public class Paket {
    private Customer alici;
    private Customer gonderici;
    private String takip_no;
    private String paket_durum;

    /**
     *  it is constructor for Paket class
     * @param alici
     * @param gonderici
     * @param takip_no
     * @param paket_durum
     */
    public Paket(Customer alici, Customer gonderici, String takip_no,String paket_durum) {
        this.alici = alici;
        this.gonderici = gonderici;
        this.takip_no = takip_no;
        this.paket_durum=paket_durum;
    }

    /**
     *Getter function for PaketDurum
     * @return paket_durum
     */
    public String getPaketdurum(){
        return paket_durum;
    }
    
    /**
     *  Setter function for PaketDurum
     * @param paket_durum
     */
    public void setPaketdurum(String paket_durum){
        this.paket_durum=paket_durum;
    }

    /**
     *  Getter function for customer that this class in the alici array 
     * @return alici
     */
    public Customer getAlici() {
        return alici;
    }

    /**
     *   Setter function for customer that this class in the alici array
     * @param alici
     */
    public void setAlici(Customer alici) {
        this.alici = alici;
    }

    /**
     * Getter function for customer that this class in the gonderici array
     * @return
     */
    public Customer getGonderici() {
        return gonderici;
    }

    /**
     *  Setter function for customer that this class in the gonderici array
     * @param gonderici
     */
    public void setGonderici(Customer gonderici) {
        this.gonderici = gonderici;
    }

    /**
     *This function return that packet tracking no
     * @return takipNo
     */
    public String getTakip_no() {
        return takip_no;
    }

    /**
     *This function set that packet tracking no for packet
     * @param takip_no
     */
    public void setTakip_no(String takip_no) {
        this.takip_no = takip_no;
    }

    /**
     *This function return packet information with tracking no
     * @param a
     */
    public void find_customer(String a){
     if (alici.getTracking_no().equals(a)) {
         System.out.println("Paket alicisi= " + this.getAlici().getIsim()+" " +this.getAlici().getSurname());
         System.out.println("Paket Gondericisi= " +this.getGonderici().getIsim() +" " +this.getGonderici().getSurname());
         System.out.println("Paketin Durumu= " + paket_durum);
     }
 
 }
    
    
    
    
}
