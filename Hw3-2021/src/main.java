import java.util.Scanner;
public class main {
    public static void main(String[] args){
        Sistem newsistem=new Sistem();
        Scanner scanner=new Scanner(System.in);
        int sayac=0;
        while (true) {
            System.out.println("---Choose which part to run---");
            System.out.println("1-Driver\n"
                    + "2-AdminMenu\n"
                    + "3-CustomerMenu\n"
                    + "4-Exit..");
            int secim=scanner.nextInt();
            if (secim == 1) {
                if (sayac ==0) {
                    Driver(newsistem);
                    sayac++;
                }
            }
            if (secim == 2) {
                if (sayac ==0) {
                    Driver(newsistem);
                    sayac++;
                }
                AdminMenu(newsistem);
            }
            if (secim == 3) {
                if (sayac ==0) {
                    Driver(newsistem);
                    sayac++;
                }
                CustomerMenu(newsistem);
            }
            if (secim == 4) {
                System.out.println("Exit All System.....");
                break;
            }
        }
    }
    public static void AdminMenu(Sistem newsistem) {
        while (true){
            int sec = -1;
        System.out.println("1-Add Admin\n" +
                "2-ShowAllProduct\n" +
                "3-ShowAllAdmin\n" +
                "4-AdminEnter\n"+
                "5-Exit");
        Scanner scanner = new Scanner(System.in);
        sec = scanner.nextInt();
        if (sec == 1) {
            String name, surname, mail, sifre;
            System.out.println("AdminAdd");
            scanner.nextLine();
            System.out.println("Enter Name of Admin");
            name = scanner.nextLine();
            System.out.println("Enter SurName of Admin");
            surname = scanner.nextLine();
            System.out.println("Enter e-mail of Admin");
            mail = scanner.nextLine();
            System.out.println("Enter Password of Admin");
            sifre = scanner.nextLine();
            newsistem.AdminAdd(new Admin(name, surname, mail, sifre));
        }
        if (sec == 2) {
            newsistem.sistemadmin.Showurun(newsistem);
        }
        if (sec ==3) {
            newsistem.sistemadmin.ShowAllAdmin(newsistem);
        }
        if(sec==4){
            String name, surname, mail, sifre;
            System.out.println("AdminAdd");
            scanner.nextLine();
            System.out.println("Enter Name of Admin");
            name = scanner.nextLine();
            System.out.println("Enter SurName of Admin");
            surname = scanner.nextLine();
            System.out.println("Enter e-mail of Admin");
            mail = scanner.nextLine();
            System.out.println("Enter Password of Admin");
            sifre = scanner.nextLine();
            newsistem.sistemadmin.AdminEnter(new Admin(name, surname, mail, sifre),newsistem);


        }
        if (sec ==5) {
                System.out.println("Exiting...");
                break;
        }
     }
    }//AdminMenu

    public static void CustomerMenu(Sistem newsistem){
        String sifre;
        int flag=-1;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Customer Password");
        sifre=scanner.nextLine();
        for (int i = 0; i <newsistem.getCustomerarray().size(); i++) {
            if (newsistem.getCustomerarray().get(i).getSifre().equals(sifre)) {
                flag=i;
                break;
            }
        }
        if (flag!=-1) {
            while (true) {
                System.out.println("1-Search Product\n"
                        + "2-ShowProductList\n"
                        + "3-ShowPastBuy\n"
                        +"4-Buy Product\n"
                        + "5-Exit");

                int secim = scanner.nextInt();
                if (secim == 1) {
                    System.out.println("Enter Name Of Product");
                    scanner.nextLine();
                    String productname = scanner.nextLine();
                    newsistem.getCustomerarray().get(flag).Searchurun(productname, newsistem);
                }
                if (secim == 2) {
                    newsistem.getCustomerarray().get(flag).ShowurunList(newsistem);
                }
                if (secim == 3) {
                    newsistem.getCustomerarray().get(flag).ShowPastBuy(newsistem, newsistem.getCustomerarray().get(flag).getCustomerid());
                }
                if (secim == 4) {
                    newsistem.sistemadmin.Showurun(newsistem);
                    scanner.nextLine();
                    System.out.println("Enter name of Product");
                    String name=scanner.nextLine();
                    System.out.println("Enter model of Product");
                    String model=scanner.nextLine();
                    System.out.println("Enter Color of Product");
                    String color=scanner.nextLine();
                    System.out.println("Enter The Name Of Branch");
                    String branchname=scanner.nextLine();
                    newsistem.getCustomerarray().get(flag).BuyProduct(newsistem,name,model,color,branchname);
                }
                if (secim ==5) {
                    System.out.println("Exiting...");
                    break;
                }
            }

        }
        else {
            System.out.println("Wrong Password...Exiting :((");
            return;
        }
    }//CustomerMenu

    public static void Driver(Sistem newsistem){

        Admin admin=new Admin("Ferdi","Sönmez","ferdi.17810@gmail.com","1610");
        newsistem.AdminAdd(admin);

        Customer customer1=new Customer("Osman","Kanat","OsmanKanat@gmail.com","2021",1);
        newsistem.CustomerAdd(customer1);

        admin.AdminEnter(admin,newsistem);

        Branch branch1=new Branch("Branch1");
        Branch branch2=new Branch("Branch2");
        Branch branch3=new Branch("Branch3");
        Branch branch4=new Branch("Branch4");

        admin.BranchAdd(branch1,newsistem);
        admin.BranchAdd(branch2,newsistem);
        admin.BranchAdd(branch2,newsistem);
        admin.BranchAdd(branch3,newsistem);
        admin.ShowAllBranch(newsistem);

        furniture furniture1=new furniture("Office Chair","Officechairmodel1","Blue",branch1);
        furniture furniture2=new furniture("Office Desk","Officedeskmodel2","Red",branch2);
        furniture furniture3=new furniture("Bookcase","Bookcasemodel2","Blue",branch3);
        furniture furniture4=new furniture("Office Cabinet","Officecabinetmodel1","Pink",branch4);
        furniture furniture5=new furniture("Meeting Table","Meetingtablemodel1","Blue",branch4);
        furniture furniture6=new furniture("Office Cabinet","Officecabinetmodel1","Pink",branch4);

        admin.furnitureAdd(furniture1,newsistem);
        admin.furnitureAdd(furniture2,newsistem);
        admin.furnitureAdd(furniture3,newsistem);
        admin.furnitureAdd(furniture4,newsistem);
        admin.furnitureAdd(furniture5,newsistem);
        admin.furnitureAdd(furniture6,newsistem);

        BranchEmployee branchEmployee1=new BranchEmployee("Ali","Kanat","Ali@gmail.com","1810",branch1);
        BranchEmployee branchEmployee2=new BranchEmployee("Veli","Çömez","Velicomez@gmail.com","1910",branch2);
        BranchEmployee branchEmployee3=new BranchEmployee("Ünal","Belikırık","unal@hotmail.com","2010",branch3);
        BranchEmployee branchEmployee4=new BranchEmployee("Murat","Çetin","murat@hotmail.com","2012",branch3);
        admin.BranchEmployeeAdd(branchEmployee1,newsistem,branch1);
        admin.BranchEmployeeAdd(branchEmployee2,newsistem,branch2);
        admin.BranchEmployeeAdd(branchEmployee3,newsistem,branch3);
        admin.BranchEmployeeAdd(branchEmployee4,newsistem,branch2);

        admin.ShowAllBranchEmployee(newsistem);

        customer1.ShowurunList(newsistem);

        customer1.Buyonline(newsistem);
        customer1.EnterTlfnAdress("Gebze Teknik Üniversitesi","0312 266 35 62");
        customer1.Buyonline(newsistem);
        customer1.BuyProduct(newsistem,"Office Chair","Officechairmodel1","Blue","Branch1");
    }

}
