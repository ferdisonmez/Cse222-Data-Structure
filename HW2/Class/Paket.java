import java.util.ArrayList;
public class Paket {
    private Customer alici;
    private Customer gonderici;
    private String takipNo;
    private String durum;

    public Paket(Customer alici, Customer gonderici, String takipNo, String durum) {
        this.alici = alici;
        this.gonderici = gonderici;
        this.takipNo = takipNo;
        this.durum = durum;
    }

    public Customer getAlici() {
        return alici;
    }

    public Customer getGonderici() {
        return gonderici;
    }

    public String getTakipNo() {
        return takipNo;
    }

    public String getDurum() {
        return durum;
    }

    public void setAlici(Customer alici) {
        this.alici = alici;
    }

    public void setGonderici(Customer gonderici) {
        this.gonderici = gonderici;
    }

    public void setTakipNo(String takipNo) {
        this.takipNo = takipNo;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    /***
     *Find owner of the package(the title of the person to whom the package belongs)
     * @param a
     * @param b
     * @return null or owner of the package
     */
    public String findCustomer(String a,Sistem b){
        for (int i = 0; i <b.showPacketSize(); i++) {
                if (a.equals(b.getPersons().get(i))) {
                    return b.getPersons().get(i).getUnvan();
                }
        }
        return null;
    }

    /***
     * Finds the information of the cargo with the tracking number
     * @param sistem is system class
     * @param takipNo is string
     */
    public void ShowPacket(Sistem sistem,String takipNo){
        int tut=-1;
        for (int i = 0; i <sistem.getPackets().size(); i++) {
            if (sistem.getPackets().get(i).takipNo.equals(takipNo)) {
                tut=i;
            }
        }
        if (tut ==-1) {
            System.out.println("Tracking No Wrong");
        }
        else if (tut !=-1) {
            System.out.println("Receiver:" +sistem.getCustomers().get(tut).getName()+" "+sistem.getCustomers().get(tut).getSurname()+"\n"
                    +"Sender:" +sistem.getCustomers().get(tut).getName()+" "+sistem.getCustomers().get(tut).getSurname()+"\n"
                    +"TakipNo:" +sistem.getPackets().get(tut).takipNo);
        }

    }

}
