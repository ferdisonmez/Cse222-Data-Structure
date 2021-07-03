import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();
            Database db=new Database();
            Scanner input=new Scanner(System.in);
            while (true) {
                System.out.println("###Make User Selection####");
                System.out.println("1-CustomerMenu\n"
                        + "2-TraderMenu\n"
                        + "3-DriverMenu\n"
                        + "4-Exit MainMenu");
                int sec = input.nextInt();
                if (sec == 1) {
                    CustomerMenu(db);
                }
                if (sec ==2) {
                   TraderMenu(db);
                }
                if (sec ==3) {
                    Driver(db);
                }
                if (sec ==4) {
                    System.out.println("Exiting...");
                    break;
                }
            }
            long endTime = System.currentTimeMillis();
            TimeCalculate(startTime, endTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void TimeCalculate(long startTime,long endTime){
        long estimatedTime = endTime - startTime;
        double seconds = (double)estimatedTime/1000;
        System.out.println("*******Time-Seconds*******");
        System.out.println(seconds);
        System.out.println("***************************");
    }
    public static void Driver(Database db){
        System.out.println("***% Customer %***");
        System.out.println("-----Search Product By Name-----");
        String productName="Alisha Solid Women's Cycling Shorts";
        for (int i = 0; i <db.getProducts().size(); i++) {
            if (db.getProducts().get(i).getProductname().equals(productName)){
                System.out.println("This Product Found Price:"+db.getProducts().get(i).getPrice()+" and discountedPrice:"+db.getProducts().get(i).getDiscounted_price()+" NETPRICE="+(db.getProducts().get(i).getPrice()-db.getProducts().get(i).getDiscounted_price()));
            }
        }

        System.out.println("-----Sort Product By Price-----");
        insertionSort(db.getProducts());
        for (int i=0;i<db.getProducts().size();i++){
            System.out.println("ID:"+db.getProducts().get(i).getId()+" Name:"+db.getProducts().get(i).getProductname()+" Price:"+ db.getProducts().get(i).getPrice());
        }

        System.out.println("-----Sort Product By Name-----");
        selectionSort(db.getProducts());
        for (int i=0;i<db.getProducts().size();i++){
            System.out.println("ID:"+db.getProducts().get(i).getId()+" Name:"+db.getProducts().get(i).getProductname()+" Price:"+ db.getProducts().get(i).getPrice());
        }

        System.out.println("----Filter----");
        int min=700;
        int max=750;
        for (int i = 0; i <db.getProducts().size(); i++) {
            if (db.getProducts().get(i).getPrice()>=min && db.getProducts().get(i).getPrice()<=max) {
                System.out.println("ID:"+db.getProducts().get(i).getId()+" Name:"+db.getProducts().get(i).getProductname()+" Price:"+ db.getProducts().get(i).getPrice()+" DiscountPrice:"+db.getProducts().get(i).getDiscounted_price());

            }
        }
        System.out.println("----Show Traders Product---");
        String traderName="Alisha";
        if (db.getTraders().containsKey(traderName)){
            db.getTraders().get(traderName).ShowAllProduct();
        }
        else
            System.out.println("This Name Not Found!!!");

        System.out.println("***% TRADER %***");
        String productID,productname,product_tree,description,tradername;
        Double price,discountedPrice;
        productID="ABCDEF12";
        productname="Laptop";
        product_tree="Elektronik >>Bilgisayar >> Laptop";
        description="Bu bir Monster Laptop";
        tradername="Monster";
        price=10000.0;
        discountedPrice=100.0;


        try {
            File file = new File("src/HW6File/Product.txt");
            FileWriter fr = null;
            fr = new FileWriter(file, true);
            fr.write(productID+"%"+productname+"%"+product_tree+"%"+price+"%"+discountedPrice+"%"+description+"%"+tradername);
            System.out.println("This Product is Added");
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void CustomerMenu(Database db){
        while(true) {
            String userid, password;
            int secim;
            System.out.println("***CustomerMenu***");
            System.out.println("**You Need To Enter UserID And Password For Customer Operation");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter UserId");
            userid = scanner.nextLine();
            System.out.println("Enter The Password");
            password = scanner.nextLine();
            if (db.getCustomers().containsKey(userid)) {
                System.out.println("1-Search Product By Name\n"
                        + "2-Sort Product\n"
                        + "3-Filter Product\n"
                        + "4-Show Traders Product\n"
                        + "5-Exit CustomerMenu");
                System.out.println("Enter The Choice");
                secim = scanner.nextInt();
                if (secim == 1) { ///Search Product
                    int flag=0;
                    String productName;
                    System.out.println("Enter The Name Of Product");
                    scanner.nextLine();
                    productName=scanner.nextLine();
                    for (int i = 0; i <db.getProducts().size(); i++) {
                        if (db.getProducts().get(i).getProductname().equals(productName)){
                            System.out.println("This Product Found Price:"+db.getProducts().get(i).getPrice()+" and discountedPrice:"+db.getProducts().get(i).getDiscounted_price()+" NETPRICE="+(db.getProducts().get(i).getPrice()-db.getProducts().get(i).getDiscounted_price()));
                            flag=1;
                        }
                    }
                    if (flag==0)
                        System.out.println("This Product Not Found");
                }
                if (secim == 2) { ///Sort Product
                    System.out.println("Choose How You Want to Sort the Products");
                    System.out.println("1-By Price\n"
                                        +"2-By Name\n"
                                        +"3-By Discount");
                    int chose=scanner.nextInt();
                    if (chose==1){ //By Price
                        insertionSort(db.getProducts());
                        for (int i=0;i<db.getProducts().size();i++){
                            System.out.println("ID:"+db.getProducts().get(i).getId()+" Name:"+db.getProducts().get(i).getProductname()+" Price:"+ db.getProducts().get(i).getPrice());
                        }
                    }
                    if (chose ==2) { //By Name
                        selectionSort(db.getProducts());
                        for (int i=0;i<db.getProducts().size();i++){
                            System.out.println("ID:"+db.getProducts().get(i).getId()+" Name:"+db.getProducts().get(i).getProductname()+" Price:"+ db.getProducts().get(i).getPrice());
                        }
                    }
                    if (chose ==3) { //By discount
                        Quicksort(db.getProducts(),0,db.getProducts().size()-1);
                        for (int i=0;i<db.getProducts().size();i++){
                            System.out.println("ID:"+db.getProducts().get(i).getId()+" Name:"+db.getProducts().get(i).getProductname()+" Price:"+ db.getProducts().get(i).getPrice()+" DiscountPrice:"+db.getProducts().get(i).getDiscounted_price());
                        }
                    }

                }
                if (secim == 3) { ///Filter Product
                    System.out.println("***Filter***");
                    System.out.println("1-Filter by price\n"
                                        +"2-Filter by category");
                    int ctgry=scanner.nextInt();
                    if (ctgry ==1) { //Price
                        Double min,max;
                        System.out.println("Enter Min Price");
                        min=scanner.nextDouble();
                        System.out.println("Enter Max Price");
                        max=scanner.nextDouble();
                        for (int i = 0; i <db.getProducts().size(); i++) {
                            if (db.getProducts().get(i).getPrice()>=min && db.getProducts().get(i).getPrice()<=max) {
                                System.out.println("ID:"+db.getProducts().get(i).getId()+" Name:"+db.getProducts().get(i).getProductname()+" Price:"+ db.getProducts().get(i).getPrice()+" DiscountPrice:"+db.getProducts().get(i).getDiscounted_price());

                            }
                        }
                    }
                    if (ctgry ==2) { //Category
                        System.out.println("Enter The Category Name");
                        String ct=scanner.nextLine();
                        //TODO kategoriye Göre ara
                    }

                }
                if (secim == 4) {///Show Traders Product
                    System.out.println("Enter The Trader Name");
                    scanner.nextLine();
                    String traderName=scanner.nextLine();
                    if (db.getTraders().containsKey(traderName)){
                        db.getTraders().get(traderName).ShowAllProduct();
                    }
                    else
                        System.out.println("This Name Not Found!!!");

                }
                if (secim == 5) {
                    System.out.println("Exiting CustomerMenu");
                    break;
                }
            } //if
            else{
                System.out.println("False Userid");
                break;
            }
        }

    } ///Customer
    public static void TraderMenu(Database db){
        while(true) {
            String userid, password;
            int secim;
            System.out.println("***TraderMenu***");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter UserId");
            userid = scanner.nextLine();
            System.out.println("Enter The Password");
            password = scanner.nextLine();
            if(db.getTraders().containsKey(userid)) {
                System.out.println("1-Add Product\n"
                        + "2-Remove Product\n"
                        + "3-Edit Product\n"
                        + "4-ListOf Orders\n"
                        + "5-Exit");
                System.out.println("Enter The Choice");
                secim = scanner.nextInt();
                if (secim == 1) {
                    String productID,productname,product_tree,description,tradername;
                    Double price,discountedPrice;
                    System.out.println("Enter ProductID");
                    scanner.nextLine();
                    productID=scanner.nextLine();
                    System.out.println("Enter ProductName");
                    productname=scanner.nextLine();
                    System.out.println("Enter Product_Tree With (>>)");
                    product_tree=scanner.nextLine();
                    System.out.println("Enter Product Description");
                    description=scanner.nextLine();
                    System.out.println("Enter TraderName Of Product");
                    tradername=scanner.nextLine();
                    System.out.println("Enter The Price");
                    price=scanner.nextDouble();
                    System.out.println("Enter The DiscountedPrice");
                    discountedPrice=scanner.nextDouble();
                    try {
                        File file = new File("src/HW6File/Product.txt");
                        FileWriter fr = null;
                        fr = new FileWriter(file, true);
                        fr.write(productID+"%"+productname+"%"+product_tree+"%"+price+"%"+discountedPrice+"%"+description+"%"+tradername);
                        System.out.println("This Product is Added");
                        fr.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (secim == 2) {  ///Remove
                    String uniq;
                    System.out.println("Enter Product UniqueID For Remove");
                    uniq=scanner.nextLine();
                    for (int i = 0; i <db.getProducts().size(); i++) {
                        if (db.getProducts().get(i).getId().equals(uniq)) {
                            db.getProducts().remove(uniq);
                        }
                    }

                }
                if (secim == 3) {  //Edit product

                }
                if (secim == 4) { ///List Of Order
                    System.out.println("Enter The UserID For Traders");
                    scanner.nextLine();
                    String useridenter=scanner.nextLine();
                    if (db.getTraders().containsKey(useridenter)){
                        db.getTraders().get(useridenter).ShowSiparis();
                    }
                    else{
                        System.out.println("This Trader Not Found İn the System");
                    }
                }
                if (secim == 5) {
                    System.out.println("Exiting TradersMenu");
                    break;
                }
            }
        }//while
    }///TraderMenu
    public static void selectionSort(List<Product> list)
    {
        for(int i=0; i<list.size() -1; i++)
        {
            int iSmallest = i;

            for(int j=i+1; j<list.size(); j++)
            {
                if(list.get(iSmallest).getProductname().compareTo((list.get(j).getProductname())) > 0  )
                {
                    iSmallest = j;
                }
            }
            Product iSwap = list.get(iSmallest);
            list.set(iSmallest,list.get(i));
            list.set(i,iSwap);
        }
    }///SelectionSort

    public static void mergeSort(List<Product> list) {
        if (list.size() > 1) {
            int q = list.size()/2;
            ArrayList<Product> leftList = new ArrayList<Product>();
            for(int i = 0; i > 0 && i <= q; i++){
                leftList.add(list.get(i));
            }
            ArrayList<Product> rightList = new ArrayList<Product>();
            for(int j = 0; j > q && j < list.size(); j++){
                rightList.add(list.get(j));
            }

            mergeSort(leftList);
            mergeSort(rightList);
            merge(list,leftList,rightList);
        }
    }

    public static void merge(List<Product> a,List<Product> l,List<Product> r) {
        int totElem = l.size() + r.size();
        int i,li,ri;
        i = li = ri = 0;
        while ( i < totElem) {
            if ((li < l.size()) && (ri<r.size())) {
                if (l.get(li).getDiscounted_price()< r.get(ri).getDiscounted_price()) {
                    a.set(i, l.get(li));
                    i++;
                    li++;
                }
                else {
                    a.set(i, r.get(ri));
                    i++;
                    ri++;
                }
            }
            else {
                if (li >= l.size()) {
                    while (ri < r.size()) {
                        a.set(i, r.get(ri));
                        i++;
                        ri++;
                    }
                }
                if (ri >= r.size()) {
                    while (li < l.size()) {
                        a.set(i, l.get(li));
                        li++;
                        i++;
                    }
                }
            }
        }
    }//MergeSort

    public static void insertionSort(List<Product> emailrecords)   //insertion sort, pass by parameter?
    {
        int i,j;
        Product key;
        ArrayList<Product> inputArray= (ArrayList<Product>) emailrecords;

        for (j=1; j<inputArray.size(); j++)
        {
            key = inputArray.get(j);
            i = j - 1;
            while (i >= 0)
            {
                if (key.getPrice().compareTo(inputArray.get(i).getPrice()) > 0) {
                    break;
                }
                Product element=inputArray.get(i+1);             //here
                inputArray.set(i+1,inputArray.get(i));          //here
                inputArray.set(i,element);                      //here
                i--;
            }
            key=inputArray.get(i+1);
        }
    }///İnsertionSort

    private static int partition(List<Product> arr, int low, int high)
    {
        Product pivot = arr.get(high);
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr.get(j).getDiscounted_price() <= pivot.getDiscounted_price())
            {
                i++;

                // swap arr[i] and arr[j]
                Product temp = arr.get(i);
                arr.set(i,arr.get(j));
                arr.set(j,temp);
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        Product temp = arr.get(i+1);
        arr.set(i+1,arr.get(high));
        arr.set(high,temp);

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public static void Quicksort(List<Product> arr, int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);
            // Recursively sort elements before
            // partition and after partition
            Quicksort(arr, low, pi-1);
            Quicksort(arr, pi+1, high);
        }
    }
}
