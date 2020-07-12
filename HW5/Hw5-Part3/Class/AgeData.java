import java.util.ArrayList;

public class AgeData implements Comparable<AgeData> {
    private int data;
    private int objeCount=0;
    private ArrayList<AgeData> sizesmall;
    private ArrayList<AgeData> sizebig;
    public AgeData(){
        this.data=0;
        objeCount++;
        sizesmall=new ArrayList<AgeData>();
        sizebig=new ArrayList<AgeData>();
    }

    /***
     * The number of people field of the AgeData object in that node will be
     * increased 1
     */
    public void incrementoneData(){
        objeCount++;
    }

    /***
     *The number of people field of the AgeData object in that node will be
     * decreased 1
     */
    public void decrementoneData(){
        objeCount--;
    }

    /***
     *The number of people in the node
     * @return The number of people field
     */
    public int datasize(){
        return objeCount;
    }
    public AgeData(int data){
        this.data=data;
        objeCount++;
        sizesmall=new ArrayList<AgeData>();
        sizebig= new ArrayList<AgeData>();
    }
    public AgeData(int data,int count){
        this.data=data;
        objeCount=objeCount+count;
    }
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getObjeCount() {
        return objeCount;
    }

    public  void setObjeCount(int objeCount) {
        this.objeCount = objeCount;
    }

    /***
     * Calculates the number of people in the node
     * @param arr is Arraylist
     * @return the number of people in the node that small arraylist and big arraylist
     */
    public int boyut(ArrayList<AgeData> arr){
        int toplam=0;
        for (int i=0;i<arr.size();i++){
            toplam+=arr.get(i).objeCount;
        }
        return toplam;
    }

    /***
     * Adds smaller elements to arraylist(sizesmall)
     * @param temp the arraylist address holding small elements
     */
    public void smalleleman(AgeData temp){
        if (this.sizesmall.contains(temp)){
        }
        else {
            this.sizesmall.add(temp);
        }

    }

    /***
     * Adds bigger elements to arraylist(sizebig)
     * @param temp the arraylist address holding big elements
     */
    public void bigeleman(AgeData temp){
        if (this.sizebig.contains(temp)){
        }
        else {
            this.sizebig.add(temp);
        }

    }

    /***
     * Sum the number of people
     * @return number of people
     */
    public int smallBoyut(){
        return boyut(sizesmall);
    }

    /***
     *Sum the number of people
     * @return number of people
     */
    public int bigBoyut(){
        return boyut(sizebig);
    }

    /***
     * Compares the data in the node
     * Adds to sizebig if large, adds to sizesmall if not large
     * @param o is Agedata type
     * @return  1 if current data is greater than parameter else -1
     */
    @Override
    public int compareTo(AgeData o) {
        if (this.data<o.data) { ///this data small
            this.bigeleman(o);
            return -1;
        }
        else if (this.data>o.data) { //this data big
            this.smalleleman(o);
            return 1;
        }
        return 0;
    }

    /***
     *Prints the value in the node and how many people there are
     * @return  strings attached together
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(this, 1, sb);
        return sb.toString();
    }
    private void preOrderTraverse(AgeData node, int depth, StringBuilder sb) {
        if (node == null) {
            sb.append("null\n");
        }
        else {
            sb.append(node.getData()+"-"+node.getObjeCount());
            sb.append("\n");
        }
    }

}
