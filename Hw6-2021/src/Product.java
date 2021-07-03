public class Product {
    private String id;
    private String productname;
    private String product_category_tree;
    private Double price;
    private Double discounted_price;
    private String description;
    private String trader;

    public Product(){}
    public Product(String id, String productname, String product_category_tree, Double price, Double discounted_price, String description, String trader) {
        this.id = id;
        this.productname = productname;
        this.product_category_tree = product_category_tree;
        this.price = price;
        this.discounted_price = discounted_price;
        this.description = description;
        this.trader = trader;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public void setProduct_category_tree(String product_category_tree) {
        this.product_category_tree = product_category_tree;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDiscounted_price(Double discounted_price) {
        this.discounted_price = discounted_price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTrader(String trader) {
        this.trader = trader;
    }

    public String getId() {
        return id;
    }

    public String getProductname() {
        return productname;
    }

    public String getProduct_category_tree() {
        return product_category_tree;
    }

    public Double getPrice() {
        return price;
    }

    public Double getDiscounted_price() {
        return discounted_price;
    }

    public String getDescription() {
        return description;
    }

    public String getTrader() {
        return trader;
    }
    public Double NetPrice(){
        return price-discounted_price;
    }
}
