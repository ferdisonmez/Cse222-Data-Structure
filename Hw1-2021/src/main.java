public class main {
    public static void main(String[] args) throws InterruptedException {
        Sistem newsistem=new Sistem();
        /*Admin registered in system */
        Admin admin=new Admin("Ferdi","Sönmez","ferdi.17810@gmail.com","1610");

        /*This admin added in system */
        newsistem.AdminAdd(admin);

        /* Customer created in system */
        Customer customer1=new Customer("Osman","Kanat","OsmanKanat@gmail.com","2021");
        Customer customer2=new Customer("Volkan","Demirel","volkan@hotmail.com","2022");

        /*This customer added in system   */
        customer1.setCustomerid(newsistem.CustomerAdd(customer1));
        customer2.setCustomerid(newsistem.CustomerAdd(customer2));

        /*This admin entered in system  */
        admin.AdminEnter(admin,newsistem);

        /* New branches created  */
        Branch istanbul=new Branch("istanbul");
        Branch malatya=new Branch("malatya");
        Branch kocaeli=new Branch("kocaeli");
        Branch bursa=new Branch("bursa");
        /*This branches added in system by admin */
        try {
            admin.BranchAdd(istanbul, newsistem);
            admin.BranchAdd(bursa, newsistem);
            admin.BranchAdd(kocaeli, newsistem);
            admin.BranchAdd(malatya, newsistem);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("***WARNING:You cannot add more than 4 branches!!!");
        }
        admin.ShowAllBranch(newsistem);
        /* New furnitures created */
        furniture furniture1=new furniture("Office Chair","Officechairmodel1","Blue");
        furniture furniture2=new furniture("Office Desk","Officedeskmodel2","Red");
        furniture furniture3=new furniture("Bookcase","Bookcasemodel2","Blue");
        furniture furniture4=new furniture("Office Cabinet","Officecabinetmodel1","Pink");
        furniture furniture5=new furniture("Meeting Table","Meetingtablemodel1","Blue");
        furniture furniture6=new furniture("Office Cabinet","Officecabinetmodel1","Pink");

        admin.BranchRemove(bursa,newsistem);
        System.out.println("******After the Branch Remove***********");
        admin.ShowAllBranch(newsistem);
        System.out.println("****************************************");

        /*This furnitures added in system by admin*/
        admin.furnitureAdd(furniture1,newsistem);
        admin.furnitureAdd(furniture2,newsistem);
        admin.furnitureAdd(furniture3,newsistem);
        admin.furnitureAdd(furniture4,newsistem);
        admin.furnitureAdd(furniture5,newsistem);
        admin.furnitureAdd(furniture6,newsistem);
        /*This furnitures added in different branches by admin*/
        admin.furnitureaddbranch(furniture1,istanbul);
        admin.furnitureaddbranch(furniture2,malatya);
        admin.furnitureaddbranch(furniture3,kocaeli);
        admin.furnitureaddbranch(furniture4,istanbul);
        admin.furnitureaddbranch(furniture5,malatya);
        admin.furnitureaddbranch(furniture6,kocaeli);

        /* New BranchEmployees created */
        BranchEmployee branchEmployee1=new BranchEmployee("Ali","Kanat","Ali@gmail.com","1810",istanbul);
        BranchEmployee branchEmployee2=new BranchEmployee("Veli","Çömez","Velicomez@gmail.com","1910",malatya);
        BranchEmployee branchEmployee3=new BranchEmployee("Ünal","Belikırık","unal@hotmail.com","2010",kocaeli);
        BranchEmployee branchEmployee4=new BranchEmployee("Mahmut","Kilic","mahmut@gmail.com","2110",malatya);

        /*This BranchEmployees added in system by admin*/
        admin.BranchEmployeeAdd(branchEmployee1,newsistem,istanbul);
        admin.BranchEmployeeAdd(branchEmployee2,newsistem,malatya);
        admin.BranchEmployeeAdd(branchEmployee3,newsistem,istanbul);
        admin.BranchEmployeeAdd(branchEmployee4,newsistem,malatya);

        /* Remove BranchEmployee */
        admin.BranchEmployeeRemove(branchEmployee4,newsistem,malatya);

        /* All company employees can be seen by the admin.*/
        admin.ShowAllBranchEmployee(newsistem);

        /*Customers can see all the products of the company and in which branch they are located. */
        customer1.ShowurunList(newsistem);

        /*The customer tries to log into the system for online shopping. */
        customer1.Buyonline(newsistem,"Office Chair","Officechairmodel1","Blue");

        /*Since the customer does not have a phone and address in the system, this information is required to be filled in and entered again. */
        customer1.EnterTlfnAdress("Gebze Teknik Üniversitesi","0312 266 35 62");

        /* After the customer has filled in the information completely, he / she can shop online from the system. */
        customer1.Buyonline(newsistem,"Office Chair","Officechairmodel1","Blue");
        /*  */
        customer1.ShowurunBranch("Office Chair",newsistem);
        branchEmployee1.RegisteredCustomer(customer1,newsistem);
        try {
            Customer customer3 = new Customer("Berat", "Ozdin", "Berat@gmail.com", "1674");
            branchEmployee2.RegisteredCustomer(customer3, newsistem);
        }catch (NullPointerException e){
            System.out.println("You want to add customers in the wrong place");
        }

        /* Shows the customer's previous orders */
        customer1.ShowPastBuy(newsistem,customer1.getCustomerid());


        branchEmployee2.ShowBuyFromCustomerid(customer2.getCustomerid(),newsistem);
        branchEmployee2.ShowBuyFromCustomerid(customer1.getCustomerid(),newsistem);
        branchEmployee2.BuyStok();
        branchEmployee2.QueryStokFromBranch();

    }

}
