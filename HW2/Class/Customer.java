public class Customer extends Person {

    public Customer(String name, String surname,String unvan) {
        super(name, surname,unvan);
    }

    /***
     *All information about shipping with tracking number
     * @param sistem is system class
     * @param takipno is string
     */
    public void findCargo(Sistem sistem,String takipno){
        int tut=-1;
        for (int i = 0; i <sistem.getPackets().size(); i++) {
            if (sistem.getPackets().get(i).getTakipNo().equals(takipno)) {
                tut=i;
                System.out.println("Receiver:" +sistem.getPackets().get(i).getAlici().getName()+" "+sistem.getPackets().get(i).getAlici().getSurname()+"\n"
                        +"Sender:" +sistem.getPackets().get(i).getGonderici().getName()+" "+sistem.getPackets().get(i).getGonderici().getSurname()+"\n"
                        +"TakipNo:" +takipno+"\n"
                         +"Current status of the package:"+sistem.getPackets().get(i).getDurum());
            }

        }

        if (tut == -1) {
            System.out.println("Cargo Tracking Number Incorrectly Entered");
        }

    }

}
