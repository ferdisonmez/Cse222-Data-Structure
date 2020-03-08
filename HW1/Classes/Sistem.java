
/**
 *This class hold administrators and customers packets in the system
 * @author Ferdi Sönmez
 */
public class Sistem {
    private Administrator[] administrators;
    private Branch[] branchs;
     private Paket[] pakets;
    
    /**
     *it is default constructor for System class because you must initialize array that in class
     */
    public Sistem(){
        this.administrators=new Administrator[0];
        this.branchs=new Branch[0];
         this.pakets=new Paket[0];
    }
    
    /**
     *  Array has been increased for you to add paket
     */
    public void pakets_sizeartir(){
       Paket[] newarray = new  Paket[pakets.length+1];
   
        System.arraycopy(pakets, 0, newarray, 0, pakets.length);
   
        this.pakets=newarray;   
    }

    /**
     *it is function which add new paket in Sistem class
     * @param a
     */
    public void add_pakets(Paket a){

        if (this.pakets.length==1) {
            pakets[0]=a;
        }
        else{
           
            this.pakets[pakets.length-1]=a;
        }   
   }

    /**
     *
     * @return pakets array
     */
    public Paket[] getPakets() {
        return pakets;
    }

    /**
     *
     * @return pakets array size
     */
    public int getPaketsize(){
        return this.pakets.length;
    }

    /**
     *Setter function 
     * @param pakets
     */
    public void setPakets(Paket[] pakets) {
        this.pakets = pakets;
    }

    /**
     *Array has been increased for you to add administrator
     */
    public void administrator_sizeartir(){///Administrator icersiindeki array size artirir
       Administrator[] newarray = new  Administrator[administrators.length+1];
   
        System.arraycopy(administrators, 0, newarray, 0, administrators.length);
   
        this.administrators=newarray;   
    }

    /**
     *
     * @return administrators
     */
    public Administrator[] getAdministrators() {
        return administrators;
    }

    /**
     *
     * @param administrators
     */
    public void setAdministrators(Administrator[] administrators) {
        this.administrators = administrators;
    }
    
    /**
     *Array has been increased for you to add Branch
     */
    public void branch_sizeartir(){
       Branch[] newarray = new  Branch[branchs.length+1];
   
        System.arraycopy(branchs, 0, newarray, 0, branchs.length);
   
        this.branchs=newarray;   
    }

    /**
     *
     * @param a
     */
    public void administrator_add(Administrator a){///Administratore branch ekler
        if (this.administrators.length==1) {
            administrators[0]=a;
        }
        else{ 
            this.administrators[administrators.length-1]=a;
        }
   }

    /**
     *it is function which add new Branch in Sistem class
     * @param a
     */
    public void branch_add(Branch a){///Administratore branch ekler
        if (this.branchs.length==1) {
            branchs[0]=a;
        }
        else{ 
            this.branchs[branchs.length-1]=a;
        }
   }

    /**
     *
     * @param b
     */
    public void branch_remove(String b){///Branch remove islemi 
        int index=-1;
        for (int i = 0; i <branchs.length; i++) {
            if (branchs[i].getBranch_name().equals(b)) {
                index=i;
            }
        }       
        if (index > -1) {
         Branch[] newArr = new Branch[branchs.length-1];     
        for(int j=0, k=0; j<branchs.length; j++) {
                if(j == index){
                    continue;
                }
                newArr[k++] = branchs[j];            
            }
        this.branchs=newArr;
        }
        else{
            System.out.println("Boyle bir Branch yoktur...");
        }
   }

    /**
     *This function will  show  that  system include branch
     */
    public void branch_show(){
       System.out.println("*************");
       System.out.println("Branch isimleri");
       System.out.println("*************");
       for (int i = 0; i <branchs.length; i++) {
           System.out.println(branchs[i].getBranch_name());
       }
   }
   
    /**
     *
     * @return branchs array size
     */
    public int branch_size(){
       return branchs.length;
   }

    /**
     *Getter function for Branchs
     * @return branchs Array
     */
    public Branch[] getBranchs() {
        return branchs;
    }

    /**
     *  Getter function for Branchs
     * @param branchs
     */
    public void setBranchs(Branch[] branchs) {
        this.branchs = branchs;
    }
    
    /**
     *if BranchEmployee or Transportation Personnel will update cargo status ,system must call this function
     * @param a
     * @param cargo_index
     */
    public void update(String a,int cargo_index){
        pakets[cargo_index].setPaketdurum(a);
    }
    
}
