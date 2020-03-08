
/**
 *This class can hold packet in transportation process and he o she can deliver in the customer
 * @author Ferdi Sönmez
 */
public class Transportation_personnel extends Person{

    /**
     *This function is a constructor for Transportation_personnel
     * @param isim
     * @param surname
     */
    public Transportation_personnel(String isim, String surname) {
        super(isim, surname);
    }
    
    /**
     *if packet in transportation process ,transportation personnel must deliver in customer so this status must update
     * @param a
     * @param branch
     */
    public void gonderi_durum_update(String a,Sistem branch){ ///Transport process Paket durumu girildi
        for (int i = 0; i <branch.getPaketsize(); i++) {
            if (branch.getPakets()[i].getPaketdurum().equals(a)) {
                branch.getPakets()[i].setPaketdurum("Transport Process");
            }
        }
        
    }
}
