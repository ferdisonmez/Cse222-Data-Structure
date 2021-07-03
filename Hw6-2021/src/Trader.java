import java.util.*;

public class Trader extends User {
    private String Name;
    private Queue<Product> orders;
    private List<Product> productList;
    public Trader(String userId, String password) {
        super(userId, password);
        orders=new PriorityQueue<Product>();
        productList=new LinkedList<Product>();
    }
    public void AddProduct(Product product){
        productList.add(product);
    }
    public void RemoveProduct(Product product){
        productList.remove(product);
    }

    public void AddOrder(Product product){
        orders.add(product);
    }
    public void RemoveOrder(Product pr){
        orders.remove();
    }
    public void EditProduct(){

    }
    public void ShowAllProduct(){
        for (int i = 0; i <productList.size(); i++) {
            System.out.println("TraderProduct:"+productList.get(i).getId()+" ProductName:"+productList.get(i).getProductname()+" Price:"+productList.get(i).getPrice());
        }
    }
    public void ShowSiparis(){
        Iterator iter=orders.iterator();
            while (iter.hasNext()){
                System.out.println("Order:"+iter.next());
            }
    }
}
