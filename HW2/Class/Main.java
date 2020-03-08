import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Sistem sistem=new Sistem();
        AsilAdmin(sistem);
        while (true) {
            Scanner input = new Scanner(System.in);
            try {

                Arayuz();
                int secim = input.nextInt();
                if (secim == 1) { ///Admin
                    AdministratorFunction(sistem);
                }///Admin

                if (secim == 2) {//BranchEmployee
                    BranchEmployeeFunction(sistem);
                }//BranchEmployee

                if (secim == 3) {
                    Transportation(sistem);
                }

                if (secim == 4) {
                    CustomerFunction(sistem);
                }

                if (secim == 5) {
                    System.out.println("System Exit");
                    break;
                }
            }catch (Exception InputMismatchException){
                System.out.println("Incorrect Input Try Again");
            }

        }//While
    }///Main


    public static void Arayuz(){
        System.out.println("*******|General--Cargo--System|***********");
        System.out.println("1-Administrator System Enter.\n"
                +"2-BranchEmpoyee System Enter.\n"
                +"3-TransportaionPersonnel Enter.\n"
                +"4-Customer Enter.\n"
                +"5-System Exit");
        System.out.println("*********************************");
    }
    public static void AdministratorArayuz(){
        System.out.println("*******|Administrator System|********");
        System.out.println("1-Branch Add Or Remove\n"
                +"2-BranchEmployee Add Or Remove\n"
                +"3-TransportaionPersonnel Add Or Remove\n"
                +"4-Administrator System Exit... \n");
        System.out.println("*******************************");


    }

    public static void BranchEmployeeArayuz(){

        System.out.println("*****|BranchEmployee System|*******");
        System.out.println("1-Customer Add Or Remove.\n"
                +"2-Accept Cargo From Customer.\n"
                +"3-Cargo Information Update.\n"
                +"4-BranchEmployee System Exit");
        System.out.println("*********************************");

    }
    public static void TransportationPersonelArayuz(){

        System.out.println("*****|TransportationPersonel System|*******");
        System.out.println("1-Update Cargo.\n"
                +"2-Transportation Personel System Exit");
        System.out.println("*********************************");

    }
    public static void CustomerArayuz(){

        System.out.println("*****|Customer System|*******");
        System.out.println("1-Packet Status With TrackingNo.\n"
                +"2-Customer System Exit");
        System.out.println("*********************************");

    }
    public static String Random_uret(){
        Random r=new Random();
        int x=r.nextInt(10000);
        String a=String.valueOf(x);
        return a;
    }

    /***
     * The system registers an administrator
     * @param sistem
     */
    public static void AsilAdmin(Sistem sistem){

        while (true) {
            Scanner input = new Scanner(System.in);
            try {
            System.out.println("*****Administrators Add******");
            System.out.println("1-Administrator Add\n"
                    + "2-General Cargo System Go");
            int ad_sec = input.nextInt();
            if (ad_sec == 1) {
                System.out.println("***Please Add Administrator***");
                System.out.println("Administrator Name Enter");
                input.nextLine();
                String name = input.nextLine();
                System.out.println("Administrator SurName Enter");
                String surname = input.nextLine();
                System.out.println("Create Administrator Password");
                String password = input.nextLine();
                Administrator admin = new Administrator(name, surname, "administrator", password);
                sistem.getAdministrators().add(admin);


            } else if (ad_sec == 2) {
                System.out.println("************************");
                System.out.println("--Administrator Add System Exitt--");
                System.out.println("************************");
                break;
            }
            }catch (Exception InputMismatchException){
                System.out.println("Incorrect Input.Please Again");
            }
        }


    }

    /***
     * Allows the carrier to call the functions it should perform
     * @param sistem
     */
    public static void Transportation(Sistem sistem){
        Scanner input1=new Scanner(System.in);
        int tut3=-1;
        System.out.println("TransportationPersonel Password Enter:");
        String sifre=input1.nextLine();
        for (int i = 0; i <sistem.getTransportationPersonels().size(); i++) {
            if (sistem.getTransportationPersonels().get(i).getPassword().equals(sifre)) {
                tut3=i;
            }
        }
        if (tut3 ==-1) {
            System.out.println("There Is No Wrong Password Or Such Transportation Personnels.");
        }
        else {
            System.out.println("Systeme "+sistem.getTransportationPersonels().get(tut3).getName()+" "+sistem.getTransportationPersonels().get(tut3).getSurname()+" named TransportationPersonnel Logged In");
            int index;
            while (true){
                Scanner input=new Scanner(System.in);
                try {

                    TransportationPersonelArayuz();
                    int trSec = input.nextInt();
                    if (trSec == 1) {
                        for (int i = 0; i < sistem.getPackets().size(); i++) {
                            System.out.println(i + "-Nolu Cargo" +" TakipNo->"+sistem.getPackets().get(i).getTakipNo());
                        }
                        System.out.println("Choose Which to give to Transportation Personnel.");
                        index = input.nextInt();
                        sistem.getTransportationPersonels().get(tut3).CargoUpdate(sistem, index);

                    }
                    if (trSec == 2) {
                        System.out.println("TransportationPersonnel System Exittt...");
                        break;
                    }

                }catch (Exception InputMismatchException){
                    System.out.println("Incorrect Input Try Again!!!");
                }
            }

        }
    }

    /***
     * Allows customers registered to the system to take action
     * @param sistem
     */
    public static void CustomerFunction(Sistem sistem){

        while (true){
            Scanner input=new Scanner(System.in);
            try {

                int index1 =-1;
                CustomerArayuz();
                int seCus = input.nextInt();

                if (seCus == 1) {
                    System.out.println("Please Enter the Cargo Tracking Number:");
                    input.nextLine();
                    String takipno = input.nextLine();
                    for (int i = 0; i < sistem.getPackets().size(); i++) {
                        if (sistem.getPackets().get(i).getTakipNo().equals(takipno)) {
                            index1 = i;
                        }
                    }
                    if (index1 != -1) {
                        int indexim = -2;
                        for (int i = 0; i < sistem.getCustomers().size(); i++) {
                            if (sistem.getPackets().get(index1).getTakipNo().equals(takipno)) {

                                indexim = i;
                            }
                        }
                        if (indexim != -2) {
                            sistem.getCustomers().get(indexim).findCargo(sistem, takipno);
                        }

                    }
                    if (index1 ==-1) {
                        System.out.println("Cargo Tracking Number Incorrectly Entered");
                    }

                }
                if (seCus == 2) {
                    System.out.println("Customer System Exit..");
                    break;
                }
            }catch (Exception InputMismatchException){
                System.out.println("Incorrect Input Try Again!!!");
            }
        }

    }

    /***
     * Allows branch employees registered in the system to take action
     * @param sistem
     */
    public static void BranchEmployeeFunction(Sistem sistem){
        Scanner input1=new Scanner(System.in);
        if (sistem.getBranches().size() == 0) {
            System.out.println("First of all, you can do Branch Employee operations after adding a branch to the system.");
        }
        else {
            int tut = -1;
            for (int i = 0; i < sistem.getBranchEmployees().size(); i++) {
                if (sistem.getBranchEmployees().get(i).getUnvan().equals("BranchEmployee")) {
                    tut = i;
                }
            }
            if (tut == -1) {

                System.out.println("There is no Branch Employee Registration in the system.");
            } else if (tut != -1) {
                int tut2 = -1;
                System.out.println("Enter your Branch Employee Password");
                String sifre = input1.nextLine();

                for (int i = 0; i < sistem.getBranchEmployees().size(); i++) {
                    if (sistem.getBranchEmployees().get(i).getPassword().equals(sifre)) {
                        tut2 = i;
                    }
                }
                if (tut2 != -1) {
                    System.out.println("Sisteme " + sistem.getBranchEmployees().get(tut2).getName() + " " + sistem.getBranchEmployees().get(tut2).getSurname() + " Log in as");
                    while (true) {
                        Scanner input=new Scanner(System.in);
                        BranchEmployeeArayuz();
                        try {
                        int secenek = input.nextInt();

                        if (secenek == 1) {
                            System.out.println("******Customer Add Or Remove*****");
                            System.out.println("1-Customer Add\n"
                                    + "2-Customer Remove");
                            int customerSec = input.nextInt();
                            if (customerSec == 1) {
                                System.out.println("***Customer Add***");
                                System.out.println("Customer Name Enter");
                                input.nextLine();
                                String customername = input.nextLine();
                                System.out.println("Customer Surname Enter");
                                String customersurname = input.nextLine();
                                String unvan="Customer";

                                Customer customer = new Customer(customername, customersurname,unvan);
                                sistem.getBranchEmployees().get(tut2).customerADD(sistem,customer);
                            }
                            if (customerSec == 2) {
                                int flag;
                                System.out.println("***Customer Remove***");
                                System.out.println("Customer Name Enter");
                                input.nextLine();
                                String name=input.nextLine();
                                System.out.println("Customer Surname Enter");
                                String surname=input.nextLine();
                                flag=sistem.getBranchEmployees().get(tut2).CustomerREMOVE(name,surname,sistem);
                                if (flag ==0) {
                                    System.out.println(name +" " +surname+ " named Customer " +sistem.getBranchEmployees().get(tut2).getName()+" Deleted by Branch Employee");
                                }

                            }
                        }

                        if (secenek == 2) {
                            System.out.println("***Accept Cargo From Customer");
                            if (sistem.getCustomers().size() == 0) {
                                System.out.println("There must be at least 2 customers registered in the system");
                            }
                            else {
                                System.out.println("***Customers in System**");
                                for (int i = 0; i < sistem.getCustomers().size(); i++) {
                                    System.out.println(i+"-"+sistem.getCustomers().get(i).getName()+ " "+sistem.getCustomers().get(i).getSurname());
                                }
                                System.out.println("Select Sender(Example= 0 1 2... )");
                                int gonderici=input.nextInt();
                                for (int i = 0; i < sistem.getCustomers().size(); i++) {
                                    if (i == gonderici)
                                        continue;
                                    System.out.println(i+"-"+sistem.getCustomers().get(i).getName()+ " "+sistem.getCustomers().get(i).getSurname());
                                }
                                System.out.println("Select Receiver(Example= 0 1 2... )");
                                int alici=input.nextInt();
                                System.out.println(  "1-Branch\n"
                                        +"2-Transportation Process");
                                System.out.println("Select Status of Packet:");
                                int status=input.nextInt();
                                String status1="Branch";
                                if (status == 2) {
                                    status1="Transportation Process";
                                }
                                String takipno=Random_uret();
                                sistem.getPackets().add(sistem.getBranchEmployees().get(tut2).sentPacket(alici,gonderici,takipno,status1,sistem));
                                System.out.println("Packet TakipNo=" + takipno);


                            }
                        }
                        if (secenek == 3) {
                            int index=-1;
                            System.out.println("****Cargo Information Update");
                            System.out.println("Enter Cargo Tracking Number");
                            input.nextLine();
                            String kargodrm=input.nextLine();
                            for (int i = 0; i <sistem.getPackets().size(); i++) {
                                if (sistem.getPackets().get(i).getTakipNo().equals(kargodrm)) {
                                    index=i;
                                }
                            }
                            if (index==-1){
                                System.out.println("Cargo TakipNo Wrong Entry Try Again");
                            }
                            else {
                                System.out.println("1-Branch\n"
                                        + "2-Transportation Process");
                                System.out.println("Paket Durumunu Seciniz:");
                                int status = input.nextInt();
                                String status1 = "Branch";
                                if (status == 2) {
                                    status1 = "Transportation Process";
                                }
                                sistem.getBranchEmployees().get(tut2).cargoupdate(sistem, sistem.getPackets().get(index), status1);
                            }
                        }

                        if (secenek == 4) {
                            System.out.println("****BranchEmployee System Exit");
                            break;
                        }


                                }catch (Exception InputMismatchException){
                            System.out.println("Incorrect Input Try Again!!!");
                                }
                    }
                } else {
                    System.out.println("BranchEmployee Password Wrong");
                }
            }
        }
    }

    /***
     * Allows administrators registered to the system to take action
     * @param sistem
     */
    public static void AdministratorFunction(Sistem sistem){
        Scanner input2=new Scanner(System.in);
        int tut=-1;
        if (sistem.getAdministrators().size()==0){
            System.out.println("There is No Administrator in the System");
        }
        else if (sistem.getAdministrators().size()!=0) {
            System.out.println("Enter of Administrator Password");
            String sifre=input2.nextLine();

            for (int i = 0; i <sistem.getAdministrators().size(); i++) {
                if (sistem.getAdministrators().get(i).getPassword().equals(sifre)) {
                    tut=i;
                }
            }

            if (tut != -1 ) {
                System.out.println("System " + sistem.getAdministrators().get(tut).getName()+" "+sistem.getAdministrators().get(tut).getSurname() +" Logged In As Administrator!!!");
                while (true) {
                    Scanner input=new Scanner(System.in);
                     try {
                    AdministratorArayuz();
                    int ad_sec = input.nextInt();
                    if (ad_sec == 1) {
                        System.out.println("1-Branch Add\n"
                                + "2-Branch Remove");
                        int sec = input.nextInt();
                        if (sec == 1) {
                            System.out.println("****Branch Add*****");
                            System.out.println("Branch Name Enter");
                            input.nextLine();
                            String name = input.nextLine();
                            Branch branch = new Branch(name);
                            sistem.getBranches().add(branch);

                        }
                        if (sec == 2) {
                            int flag=-2;
                            System.out.println("****Branch Remove****");
                            for (int i = 0; i <sistem.getBranches().size() ; i++) {
                                System.out.println(i+"-"+sistem.getBranches().get(i).getName());
                            }
                            System.out.println("Enter the Branch Name you want to remove");
                            input.nextLine();
                            String branchName = input.nextLine();
                            flag=sistem.getAdministrators().get(tut).RemoveBranch(branchName,sistem);
                            if (flag ==0 ) {
                                System.out.println(sistem.getAdministrators().get(tut).getName()+" "+sistem.getAdministrators().get(tut).getSurname()+" isimli Yonetici trarafindan "+branchName+" isimli Branch Kaldirildi");
                            }

                        }

                    }

                    if (ad_sec == 2) {///BranchEmployee
                        System.out.println("1-BranchEmployee Add\n"
                                + "2-BranchEmployee Remove");
                        int sec = input.nextInt();
                        if (sec == 1) {
                            if (sistem.getBranches().size()==0) {
                                System.out.println("First of all, you can do Branch Employee add operations after adding a branch to the system!");
                            }
                            else {
                                System.out.println("****BranchEmployee Add*****");
                                System.out.println("BranchEmploye Name Enter");
                                input.nextLine();
                                String name = input.nextLine();
                                System.out.println("BranchEmploye Surname Enter");
                                String surname = input.nextLine();
                                System.out.println("Create Password for Branch Employee");
                                String password = input.nextLine();
                                String unvan = "BranchEmployee";
                                BranchEmployee p = new BranchEmployee(name, surname, unvan, password);
                                sistem.getAdministrators().get(tut).BranchEmployeeADD(p, sistem);
                            }

                        }
                        if (sec == 2) {
                            int flag=-2;
                            System.out.println("****BranchEmployee Remove****");
                            System.out.println("BranchEmploye Name Enter For Remove");
                            input.nextLine();
                            String name = input.nextLine();
                            System.out.println("BranchEmploye Surname Enter For Remove");
                            String surname = input.nextLine();
                            flag=sistem.getAdministrators().get(tut).BranchEmployeeREMOVE(name,surname,sistem);
                            if (flag ==0) {
                                System.out.println(name+" "+surname+" named BranchEmployee " +sistem.getAdministrators().get(tut).getName() +" was deleted from the system by the administrator");
                            }

                        }
                    }
                    if (ad_sec == 3) {///TransportationPersonnel
                        System.out.println("1-TransportaionPersonnel Add\n"
                                + "2-TransportaionPersonnel Remove");
                        int sec = input.nextInt();
                        if (sec == 1) {
                            System.out.println("****TransportaionPersonnel Add*****");
                            System.out.println("TransportaionPersonnel Name Enter");
                            input.nextLine();
                            String name = input.nextLine();
                            System.out.println("TransportaionPersonnel Surname Enter");
                            String surname = input.nextLine();
                            System.out.println("Creating a Password for TransportationPersonnel");
                            String sifre1=input.nextLine();
                            String unvan = "TransportaionPersonnel";
                            TransportationPersonel p = new TransportationPersonel(name, surname, unvan,sifre1);
                            sistem.getAdministrators().get(tut).TransportationPersonelADD(p,sistem);


                        }
                        if (sec == 2) {
                            int flag=-2;
                            System.out.println("****TransportaionPersonnel Remove****");
                            System.out.println("TransportaionPersonnel Name Enter For Remove");
                            input.nextLine();
                            String name = input.nextLine();
                            System.out.println("TransportaionPersonnel Surname Enter For Remove");
                            String surname = input.nextLine();
                            flag=sistem.getAdministrators().get(tut).TransportationPersonelREMOVE(name,surname,sistem);
                            if (flag == 0) {
                                System.out.println(name+" " + surname+ " named TransportationPersonel "+sistem.getAdministrators().get(tut).getName()+" was deleted from the System by Administrator");
                            }

                        }
                    }
                    if (ad_sec == 4) {
                        System.out.println("Administrator System Exit...");
                        break;
                    }
                        }catch (Exception InputMismatchException){
                            System.out.println("Incorrect Input Try Again!!!");
                        }

                }
            }
            else {
                System.out.println("Administrator Password Wrong.");
            }
        }

    }


}


