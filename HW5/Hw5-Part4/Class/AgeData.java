import java.util.ArrayList;
import java.util.Comparator;

public class AgeData implements Comparator<AgeData> {
       private int data;
       private int objeCount=0;
        public AgeData(){
        this.data=0;
        objeCount++;
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

    /***
     * Compares how many people are in the data
     * @param o1 is AgeDAta
     * @param o2 is AgeData
     * @return if first element big second element this function return 1,if second element big first element this function return -1
     * if two element equal this function can return 0
     */
    @Override
    public int compare(AgeData o1, AgeData o2) {
        if (o1.getObjeCount()-o2.getObjeCount()<0){
            return 1;
        }
        else if (o1.getObjeCount()-o2.getObjeCount()>0){
            return -1;
        }
        return (o1.getObjeCount()-o2.getObjeCount());
    }

}

