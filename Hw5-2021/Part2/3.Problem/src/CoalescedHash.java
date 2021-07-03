import java.util.LinkedList;

public class CoalescedHash<K extends Comparable<K>> implements KWHashMap<K>{
    private LinkedList<Entry<K>>[] table;
    private final Entry<K> DELETED=new Entry<K>(null,null);
    private int numKeys;
    private int numDeletes;
    private static final int CAPACITY=10;
    private static final double LOAD_THRESHOLD=3.0;


    private class Entry<K extends Comparable<K>> implements Comparable<Entry<K>>{
        private K key;
        int next;
        int flag;

        public Entry(K key){
            this.key=key;
            this.next=-1;
            flag=-1;
        }

        public int getNext() {
            return next;
        }

        public void setNext(int next) {
            this.next = next;
        }

        public Entry(K key, K value) {
            this.key = key;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }


        @Override
        public int compareTo(Entry<K> o) {
            if (this.key.equals(o.key))
                return 0;
            if (key.compareTo(o.key)==-1)
                return -1;
            return 1;
        }
    }///İnner Class

    public CoalescedHash() {
        this.table = new LinkedList[CAPACITY];
        this.numKeys = 0;
        this.numDeletes = 0;
    }

    /***
     * This function can return next of the element
     * @param key is a object
     * @return next element
     */
    @Override
     public K get(Object key) {
        int index=key.hashCode()%table.length;
        if (index<0) {
            index+=table.length;
        }
        if (table[index] == null) {
            return null;
        }
        for(Entry<K> nexItem :table[index]){
            if (nexItem.key.equals(key)) {
                return nexItem.key;
            }
        }
        return null;
     }

    /***
     * Returns whether the structure is empty
     * @return if this structure is empty return true,otherwise false
     */
     @Override
     public boolean isEmpty() {

         return (numKeys==0);
     }

    /***
     * Calculates the hashcodes of the elements you want to add to the structure.
     * @return 1
     */
    @Override
    public int hashCode() {
        return 1;
    }

    /***
     * Adds elements inside the structure
     * @param key is KEY
     * @return added element
     */
    @Override
     public K put(K key) {
        int index= key.hashCode() % table.length;
         if (index<0) {
             index+= table.length;
         }

         if (table[index] == null) {
             table[index]=new LinkedList<Entry<K>>();
             table[index].add(new Entry<K>(key));
             numKeys++;
             return key;
         }
         for(LinkedList<Entry<K>> nexItem :table){
             if (nexItem!=null && (nexItem.get(0).key.hashCode()%table.length)==(key.hashCode()% table.length) && table[index].size()==1 && nexItem.get(0).flag==-1) {
                 nexItem.get(0).flag=1;
                 int cl=emptyplace();
                 nexItem.get(0).setNext(cl);
                 if (table[cl] == null) {
                     table[cl]=new LinkedList<Entry<K>>();
                     table[cl].addFirst(new Entry<K>(key));
                     numKeys++;
                     return key;
                 }
                 else
                     System.out.println("Program dont have any place");
             }
         }


         return null;
     }

     private int emptyplace(){
         for (int i = 0; i <table.length; i++) {
             if (table[i] == null) {
                 return i;
             }
         }
         return 0;
     }

    /***
     * Deletes the elements desired to be deleted in the structure.
     * @param key is a element
     * @return delete element
     */
     @Override
     public K remove(Object key) {
         int index= key.hashCode() % table.length;
         if (index<0) {
             index+= table.length;
         }
         if (table[index] == null) {
             System.out.println("Not Found this Key");
             return null;
         }
        if (table[index].get(0).key.equals(key)) {
             table[index].set(0,table[table[index].get(0).next].get(0));
             table[index].remove(key);
             table[index]=null;
             return (K) key;
         }
         for(LinkedList<Entry<K>> nexItem :table){
             if (nexItem!=null ) {
                 if (nexItem.get(0).next ==-1 && nexItem.get(0).key.equals(key)) {
                     table[findindex(nexItem)]=null;
                 }
                 else if(table[nexItem.get(0).next].get(0).key.equals(key)) {
                     nexItem.get(0).next=table[nexItem.get(0).next].get(0).next;
                     table[nexItem.get(0).next].remove(0);
                     return (K) key;
                 }
             }
         }


        return null;
     }
     private int findindex(LinkedList<Entry<K>> nexitem){
         for (int i = 0; i < table.length; i++) {
             if (table[i] != null && table[i].get(0).key.equals(nexitem.get(0).key)) {
                 return i;
             }
         }
         return -1;
     }

    /***
     * Shows how many elements are in the structure
     * @return size of this structure
     */
     @Override
     public int size() {
         int size=0;
         for (int i = 0; i <table.length; i++) {
             if (table[i]!=null){
                 size+=table[i].size();
             }
         }
         return size;
     }

    /***
     * Print all element of structure
     */
    public void Print(){
        for (int i = 0; i <table.length; i++) {
            if (table[i]!=null){
                for (int j = 0; j <table[i].size(); j++) {
                    System.out.println("Key:"+table[i].get(j).key +" Next "+(table[i].get(j).next==-1 ? "null":table[i].get(j).next));
                }
            }
        }
    }
 }
