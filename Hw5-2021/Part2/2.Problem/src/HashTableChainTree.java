import java.util.TreeSet;
public class HashTableChainTree<K extends Comparable<K>,V  extends Comparable<V>> implements KWHashMap<K,V>{
    private TreeSet<Entry<K,V>>[] table;
    private final Entry<K,V> DELETED=new Entry<K,V>(null,null);
    private int numKeys;
    private int numDeletes;
    private static final int CAPACITY=101;
    private static final double LOAD_THRESHOLD=3.0;

    private class Entry<K extends Comparable<K>,V extends Comparable<V>> implements Comparable<Entry<K,V>>{
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

        @Override
        public int compareTo(Entry<K, V> o) {
            if (this.key.equals(o.key))
                    return 0;
            if (key.compareTo(o.key)==-1)
                return -1;
            return 1;
        }
    }///İnner Class

    public HashTableChainTree() {
        this.table = new TreeSet[CAPACITY];
        this.numKeys = 0;
        this.numDeletes = 0;
    }

    /***
     * Shows the value of the key
     * @param key is first parameter (KEY)
     * @return the value of the key
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
    private void rehash(){
        TreeSet<Entry<K,V>>[] oldtable=table;
        table=new TreeSet[2*oldtable.length+1];
        numKeys=0;
        numDeletes=0;
        for (int i = 0; i <oldtable.length; i++) {
            if ((oldtable[i] != null) && (oldtable[i].first()!=DELETED)) {
                put(oldtable[i].first().key,oldtable[i].first().value);
            }
        }
    }

    /***
     * Indicates whether the structure is empty
     * @return if this structure is empty return true otherwise false
     */
    @Override
    public boolean isEmpty() {
         return (numKeys==0);
    }

    /***
     * Adds elements to the structure
     * @param key is first parameter (KEY)
     * @param value value of KEY
     * @return value of the key
     */
    @Override
    public V put(K key, V value) {
        int index=key.hashCode()% table.length;
        if (index<0) {
            index+= table.length;
        }
        if (table[index] == null) {
            table[index]=new TreeSet<Entry<K,V>>();
        }
        for(Entry<K,V> nexItem :table[index]){
            if (nexItem.key.equals(key)) {
                table[index].add(new Entry<K,V>(key, value));
                return value;
            }
        }
        table[index].add(new Entry<K,V>(key, value));
        numKeys++;
        if (numKeys>LOAD_THRESHOLD * table.length) {
            rehash();
        }
        return null;
    }

    /***
     * Deletes items in the structure
     * @param key is first parameter
     * @return value of the key
     */
    @Override
    public V remove(Object key) {
        V returnval=null;
        for (int i = 0; i <table.length; i++) {
            if (table[i]!=null){
                for (Entry<K,V> element:table[i]){
                    if (element.key.equals(key)) {
                        returnval=element.value;
                        table[i].remove(new Entry<K,V>(element.key,element.value));
                    }
                }
            }
        }

        return returnval;
    }

    /***
     * This function can give the sizeof the this structure
     * @return size of the this structure
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
     * This function can show all element of the structure
     */
    public void Print(){
        for (int i = 0; i <table.length; i++) {
            if (table[i]!=null){
                for (Entry<K,V> element:table[i]){
                    System.out.println(element.key +" "+element.value);
                }
            }
        }
    }
}
