/***
 * is the class that holds the data of the whole system
*/
import java.util.ArrayList;
public class Sistem {
    private ArrayList<Person> persons;
    private ArrayList<Paket> packets;
    private ArrayList<Branch> branches;
    private ArrayList<Administrator> administrators;
    private ArrayList<BranchEmployee> branchEmployees;
    private ArrayList<TransportationPersonel> transportationPersonels;
    private ArrayList<Customer> customers;

    public Sistem(ArrayList<Person> persons, ArrayList<Paket> packets,ArrayList<Branch> branches,ArrayList<Administrator> administrators,ArrayList<BranchEmployee> branchEmployees,ArrayList<TransportationPersonel> transportationPersonels,ArrayList<Customer> customers) {
        this.persons = persons;
        this.packets = packets;
        this.branches=branches;
        this.administrators=administrators;
        this.branchEmployees=branchEmployees;
        this.transportationPersonels=transportationPersonels;
        this.customers=customers;
    }

    /***
     * Default Constructor
     */
    public Sistem(){
        this.persons=new ArrayList<Person>();
        this.packets=new ArrayList<Paket>();
        this.branches=new ArrayList<Branch>();
        this.administrators=new ArrayList<Administrator>();
        this.branchEmployees=new ArrayList<BranchEmployee>();
        this.transportationPersonels=new ArrayList<TransportationPersonel>();
        this.customers=new ArrayList<Customer>();
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public void setBranches(ArrayList<Branch> branches) {
        this.branches = branches;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public ArrayList<Paket> getPackets() {
        return packets;
    }

    public ArrayList<Administrator> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(ArrayList<Administrator> administrators) {
        this.administrators = administrators;
    }

    public ArrayList<BranchEmployee> getBranchEmployees() {
        return branchEmployees;
    }

    public void setBranchEmployees(ArrayList<BranchEmployee> branchEmployees) {
        this.branchEmployees = branchEmployees;
    }

    public ArrayList<TransportationPersonel> getTransportationPersonels() {
        return transportationPersonels;
    }

    public void setTransportationPersonels(ArrayList<TransportationPersonel> transportationPersonels) {
        this.transportationPersonels = transportationPersonels;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public void AddPacket(Paket b){///Sistemdeki paketleri ekler
        packets.add(b);
    }

    /***
     * Show the people registered in the system
     */

    public void showPerson(){
        if (persons.size() == 0) {
            System.out.println("Nobody Registered to the System");
        }
        else {
            System.out.println("****Registry Persons in System****");
            for (int i = 0; i <persons.size(); i++) {
                System.out.println(persons.get(i).getName()+" " +persons.get(i).getSurname()+" "+persons.get(i).getUnvan());
            }
        }

    }
    /***
     * Show the packages registered in the system
     */
    public void showPacket(){
        if (packets.size() == 0) {
            System.out.println("There Is No Registered Package in the System");
        }
        else {
            System.out.println("****Registry Packets in System");
            for (int i = 0; i <packets.size(); i++) {

                System.out.println(packets.get(i));
            }

        }

    }

    /***
     *Shows the number of packages registered in the system
     * @return paket size
     */
    public int showPacketSize(){
        return packets.size();
    }

}
