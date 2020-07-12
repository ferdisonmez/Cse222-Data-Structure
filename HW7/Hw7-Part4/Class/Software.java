public class Software implements Comparable<Software> {
    private String NameWithVersion;
    private int Quantity;
    private int Price;
    public Software(String name){
        this.NameWithVersion=name;
    }
    public Software(String nameWithVersion, int quantity, int price) {
        NameWithVersion = nameWithVersion;
        Quantity = quantity;
        Price = price;
    }
    public Software(String nameWithVersion,int price) {
        NameWithVersion = nameWithVersion;
        Quantity =0;
        Price =price;
    }

    /***
     * increases the quantity of software
     */
    public void incrementQuantity(){
        this.Quantity++;
    }

    /***
     * Decrease the quantity of software
     */
    public void decrementQuantity(){
        this.Quantity--;
    }

    public String getNameWithVersion() {
        return NameWithVersion;
    }

    public void setNameWithVersion(String nameWithVersion) {
        NameWithVersion = nameWithVersion;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    /***
     * Can compare by software names
     * @param o is data structure (Software)
     * @return Returns the comparison result
     */
    @Override
    public int compareTo(Software o) {
        return (this.NameWithVersion.compareTo(o.NameWithVersion));
    }
}
