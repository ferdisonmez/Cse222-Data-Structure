public class BranchEmployee extends Person {
    private Branch BranchName;
    public BranchEmployee(String name, String surname, String email, String sifre,Branch BranchName) {
        super(name, surname, email, sifre);
        this.BranchName=BranchName;
    }
    /***
     * 
     */
    public void ReportAdmin(){
        HybridList.Myiterator iter=BranchName.getSellfurniture().iterator();
            System.out.println("***Report For Admin****");
            iter.restart();
           while (iter!=null){
               System.out.println(iter.next());
           }
            System.out.println("********************************");

    }
    public void ProductAddRemove(furniture temp,Sistem sistem){
        HybridList.Myiterator e= sistem.getFurnitures().iterator();
        e.remove(temp);
    }

    public void ShowBuyFromCustomerid(int Customerid,Sistem sistem){
        for (int i = 0; i <sistem.getCustomerarray().size(); i++) {
            if (sistem.getCustomerarray() != null && (sistem.getCustomerarray().get(i).getCustomerid()==Customerid)) {
                for (int j = 0; j <sistem.getCustomerarray().get(i).getPastbuy().getSize(); j++) {
                    System.out.println(sistem.getCustomerarray().get(i).getPastbuy().get(j).toString() );
                }
            }
        }
    }
    public void RegisteredCustomer(Customer customer,Sistem sistem){
        sistem.CustomerAdd(customer);
    }
    @Override
    public String toString() {
        String temp="BranchEmployee "+ super.toString();
        return temp;
    }

}
