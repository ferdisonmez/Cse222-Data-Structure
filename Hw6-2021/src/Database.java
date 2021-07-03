import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
public final class Database {
    private List<Product> products;  //LinkedList
    private Hashtable<String,Customer> customers;
    private Hashtable<String,Trader> traders;
    private Tree<String> stringTree;

    public Database() throws IOException {
        this.customers=new Hashtable<String,Customer>();
        this.traders=new Hashtable<String,Trader>();
        this.products = readProduct("src/HW6File/e-commerce-samples.csv");
        stringTree=new Tree<String>("root");
        ReadCustomer();
        ReadTrader();
        ReadTree();
    }
    public void Show(){
        for (int i = 0; i <this.products.size(); i++) {
            System.out.println("Id:"+products.get(i).getId()+"ProductName:"+products.get(i).getProductname());
        }
    }

    public Hashtable<String, Trader> getTraders() {
        return traders;
    }

    public Hashtable<String, Customer> getCustomers() {
        return customers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public int sizecustomer(){
        return this.customers.size();
    }

    /***
     * Reads the given cvs file and creates other files.
     * @param fileName is file name
     * @return
     * @throws IOException
     */
    public List<Product> readProduct(String fileName) throws IOException {
        List<Product> result = new ArrayList<Product>();
        BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
        try {
            // Read first line
            String line = br.readLine();
            // Make sure file has correct headers
            if (line==null) throw new IllegalArgumentException("File is empty");
            if (!line.equals("id;product_name;product_category_tree;price;discounted_price;description;trader"))
                throw new IllegalArgumentException("File has wrong columns: "+line);
            // Run through following lines
            while ((line = br.readLine()) != null) {
                String[] items = line.split(";");
                try {
                    // If there are too many entries, throw a dummy exception, if
                    // there are too few, the same exception will be thrown later
                    if (items.length>7) throw new ArrayIndexOutOfBoundsException();
                    // Convert data to person record
                    Product pr = new Product();
                    pr.setId    (                     items[0] );
                    pr.setProductname (                     items[1] );
                    String str =(items[2]);
                    String result1 = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
                    char ch='"';
                    String result2 = result1.substring(result1.indexOf(ch) +2, result1.indexOf(ch)+result1.length()-2); //Clean the string
                    pr.setProduct_category_tree(result2);
                    pr.setPrice (Double.parseDouble(items[3]));
                    pr.setDiscounted_price(Double.parseDouble(items[4]));
                    pr.setDescription (                     items[5] );
                    pr.setTrader(items[6]);
                    result.add(pr);
                } catch (ArrayIndexOutOfBoundsException|NumberFormatException|NullPointerException e) {
                   // System.out.println("Invalid line: "+ line+line.indexOf(line));
                }
            }
            PrintWriter out1 =new PrintWriter(new FileWriter("src/HW6File/Trader.txt"));
            for (int i = 0; i <result.size(); i++) {
                // The get(int) method throws IndexOutOfBoundsException, which must be caught.
                out1.println("Traderr"+i+","+result.get(i).getTrader()+","+result.get(i).getProductname());
            }
            out1.close();

            PrintWriter out2 =new PrintWriter(new FileWriter("src/HW6File/Product.txt"));
            for (int i = 0; i <result.size(); i++) {
                // The get(int) method throws IndexOutOfBoundsException, which must be caught.
                out2.println(result.get(i).getId()+"%"+result.get(i).getProductname()+"%"+result.get(i).getProduct_category_tree()+"%"+result.get(i).getPrice()+"%"+result.get(i).getDiscounted_price()+"%"+result.get(i).getDescription()+"%"+result.get(i).getTrader());
            }
            out2.close();
            return result;
        } finally {
            br.close();
        }
    }///ReadProduct

    /***
     * Reads the Customer.txt file and stores it in the database class.
     */
    public void ReadCustomer(){
        try {
            FileInputStream fstream = null;
            try {
                fstream = new FileInputStream("src/HW6File/Customer.txt");
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine = null;
            while (true) {
                try {
                    if (!((strLine = br.readLine()) != null)) break;
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                String[] tokens = strLine.split(" ");
                Customer record = new Customer(tokens[0], tokens[1], tokens[2]);//process record , etc
                customers.put(tokens[0],record); //UserId Customer
            }
            try {
                in.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        catch(Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }

    }///ReadCustomer

    /****
     * Reads the Trader.txt file and stores it in the database class.
     */
    public void ReadTrader(){
        try {
            FileInputStream fstream = null;
            try {
                fstream = new FileInputStream("src/HW6File/Trader.txt");
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine = null;
            while (true) {
                try {
                    if (!((strLine = br.readLine()) != null)) break;
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                String[] tokens = strLine.split(",");
                Trader record = new Trader(tokens[0], tokens[1]);//process record , etc
                int i;
                for (i = 0; i <products.size()-1; i++) {
                    if (products.get(i).getProductname().equals(tokens[2])) {
                       break;
                    }
                }
                record.AddProduct(products.get(i));
                traders.put(tokens[0],record); //UserId Customer
            }
            try {
                in.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        catch(Exception e)
        {
            System.err.println("Error-TraderFile:" + e.getMessage());
        }

    }///ReadTrader

    /***
     * It reads Product.txt and stores the products in the category tree.
     */
     public void ReadTree(){
         try {
             FileInputStream fstream = null;
             try {
                 fstream = new FileInputStream("src/HW6File/Product.txt");
             } catch (FileNotFoundException fileNotFoundException) {
                 fileNotFoundException.printStackTrace();
             }
             DataInputStream in = new DataInputStream(fstream);
             BufferedReader br = new BufferedReader(new InputStreamReader(in));
             String strLine = null;
             while (true) {
                 try {
                     if (!((strLine = br.readLine()) != null)) break;
                 } catch (IOException ioException) {
                     ioException.printStackTrace();
                 }
                 String[] tokens = strLine.split("%");
                     String[] token = tokens[2].split(">>");
                     if (token.length<2)
                            stringTree.insert("root",token[0]);    ///Default İnsert
                     else {
                         int flag=0;
                         for (int i=0; i < token.length - 2; i++) {
                             if (flag==0){
                                 stringTree.insert("root",token[i]);
                                 flag=1;
                             }
                             else{
                                 if (flag==1){
                                     stringTree.insert("root",token[1]);
                                     flag=2;
                                 }
                                 stringTree.insert(token[i], token[i + 1]);
                             }
                         }
                     }
             }
             try {
                 in.close();
             } catch (IOException ioException) {
                 ioException.printStackTrace();
             }
         }
         catch(Exception e)
         {
             System.err.println("Error: " + e.getMessage());
         }

     }

    /***
     * Shows how many traders there are in the database.
     * @return size of trader
     */
    public int SizeTrader(){
        return traders.size();
    }
}
