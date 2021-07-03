import java.util.LinkedList;
public class HashTableChain<K,V> implements KWHashMap<K,V>{
    private LinkedList<Entry<K,V>>[] table;
    private final Entry<K,V> DELETED=new Entry<K,V>(null,null);
    private int numKeys;
    private int numDeletes;
    private static final int CAPACITY=101;
    private static final double LOAD_THRESHOLD=3.0;

    private class Entry<K,V>{
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V val) {
            V oldval=value;
            value=val;
            return oldval;
        }
    }

    public HashTableChain() {
        this.table=new LinkedList[CAPACITY];
    }
    private void rehash(){
        LinkedList<Entry<K,V>>[] oldtable=table;
        table=new LinkedList[2*oldtable.length+1];
        numKeys=0;
        numDeletes=0;
        for (int i = 0; i <oldtable.length; i++) {
            if ((oldtable[i] != null) && (oldtable[i].get(0)!=DELETED)) {
                put(oldtable[i].get(0).key,oldtable[i].get(0).value);
            }
        }
     }

    /***
     * Indicates the value of the key to be reached
     * @param key is first parameter
     * @return  value of the key
     */
    @Override
    public V get(Object key) {
        int index=key.hashCode()%table.length;
        if (index<0) {
            index+=table.length;
        }
        if (table[index] == null) {
            return null;
        }
        for(Entry<K,V> nexItem :table[index]){
            if (nexItem.key.equals(key)) {
                return nexItem.value;
            }
        }
        return null;
    }

    /***
     * Indicates whether the building is full
     * @return if structure is empty true otherwise false
     */
    @Override
    public boolean isEmpty() {
        return (numKeys==0);
    }

    /***
     * Adds new elements inside this structure.
     * @param key is a first parameter (KEY)
     * @param value is second parameter (VALUE)
     * @return Value of added key
     */
    @Override
    public V put(K key, V value) {
        int index=key.hashCode()% table.length;
        if (index<0) {
            index+= table.length;
        }
        if (table[index] == null) {
            table[index]=new LinkedList<Entry<K,V>>();
        }

        for(Entry<K,V> nexItem :table[index]){
            if (nexItem.key.equals(key)) {
                table[index].add(new Entry<K,V>(key, value));
                return value;
            }
        }
        table[index].addFirst(new Entry<K,V>(key, value));
        numKeys++;
        if (numKeys>LOAD_THRESHOLD * table.length) {
            rehash();
        }
        return null;
    }

    /***
     * Deletes the desired key value in the structure
     * @param key is parameter
     * @return The value of the deleted key
     */
    @Override
    public V remove(Object key) {
        V val=null;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                for (int j = 0; j <table[i].size(); j++) {
                    if (table[i].get(j).key.equals(key)){
                        val=table[i].get(j).value;
                        table[i].remove(j);
                    }
                }
            }
        }
        return val;
    }

    /***
     * Indicates how many elements are in the structure
     * @return size of this structure
     */
    @Override
    public int size() {
        int size=0;
        for (int i = 0; i < table.length; i++) {
            if (table[i]==null)
                size+=0;
            else
                size+=table[i].size();
        }

        return size;
    }

    /***
     *Print all element
     */
    public void Print(){
        for (int i = 0; i <table.length; i++) {
           if (table[i]!=null){
               for (int j = 0; j <table[i].size(); j++) {
                   System.out.println("Key:"+table[i].get(j).key +" Value:"+table[i].get(j).value);
               }
           }
        }
    }
}
