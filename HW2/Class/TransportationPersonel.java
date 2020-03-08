public class TransportationPersonel extends Person implements Ipassword {
    private String password;
    public TransportationPersonel(String name, String surname, String unvan,String password) {
        super(name, surname,unvan);
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /***
     * Update the latest status of the cargo
     * @param sistem is system class
     * @param index is integer number
     */
    public void CargoUpdate(Sistem sistem,int index){
        if (sistem.getPackets().get(index).getDurum().equals("Transportation Process")) {
            sistem.getPackets().get(index).setDurum("Deliver");
            System.out.println(sistem.getPackets().get(index).getTakipNo()+" TakipNo Cargo "+sistem.getPackets().get(index).getAlici().getName()+" "+sistem.getPackets().get(index).getAlici().getSurname() + " named receiver delivered!!!");
        }
        else if (sistem.getPackets().get(index).getDurum().equals("Deliver")) {
            System.out.println("Cargo has already been delivered!!!");
        }
        else {
            System.out.println("Package has not been distributed yet!");
        }

    }

}
