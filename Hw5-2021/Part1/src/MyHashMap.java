import java.security.NoSuchAlgorithmException;
import java.util.*;
public class MyHashMap<K,V>{
    private HashMap<K,V> hashMap;
    K head;

    public MyHashMap(){
        head=null;
        hashMap=new HashMap<K,V>();
    }
    public MyHashMap(HashMap<K, V> hashMap) {
        this.hashMap = hashMap;
    }
    public MapIterator iterator(K key) {
        return new MapIterator(key);
    }

    /***
     * This function can add element in hashmap structure.
     * @param key is element for add in hashmap(KEY)
     * @param value is element for add in hashmap(VALUE)
     */
    public void ADD(K key,V value){
        if (head == null) {
            hashMap.put(key,value);
            head=key;
            return;
        }
        hashMap.put(key,value);
    }
    public class MapIterator implements MyIteratorinterface{  //Second Class
        Iterator it;
        K ithead;

        public MapIterator() {  ///Zero parameter constructor
            Set entrySet = hashMap.entrySet();
            it = entrySet.iterator();
        }

        /***
         * Starts the iterator from the given Key value.
         * @param key is Key value
         */
        public MapIterator(K key) {
            ithead=null;
            int flag=0;
            Set entrySet = hashMap.entrySet();
            it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (pair.getKey().equals(key)) {
                    ithead=key;
                    head=key;
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                System.out.println("Key Not Founded");
        }

        /***
         * Takes the iterator to the beginning
         */
        public void restartiterator(){
             it=hashMap.entrySet().iterator();
        }

        /***
         * Checks if the next element of the given key is present.
         * @return if key has a next element return true otherwise false
         */
        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        /***
         * Goes to the next element
         * @return next element
         */
        @Override
        public Object next() {
            try{
                return it.next();
            }
            catch (NoSuchElementException e){
                restartiterator();
                return it.next();
            }
        }

        /***
         * oes to the previous element
         * @return previous element
         */
        @Override
        public Object prev(){
            Object rtrobj;
            int i=0,index=-1;
            Iterator it1=hashMap.entrySet().iterator();
            Object obj=head;
           List<K> list=new LinkedList<K>();
            while (it1.hasNext()){
                Map.Entry pair11 = (Map.Entry)it1.next();
                list.add(i,(K) pair11.getKey());
                i++;
            }
            for (i = 0; i <list.size(); i++) {
                if (obj.equals(list.get(i))) {
                    index=i;
                    break;
                }
            }
            if(index==0){
                rtrobj=HelperPrev(list.get(list.size()-1));
            }
            else {
                rtrobj=HelperPrev(list.get(index-1));
            }
            return rtrobj;
        }
        private Object HelperPrev(Object key){
            Object obj=null;
            restartiterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (pair.getKey().equals(key)) {
                    obj=pair.getKey();
                    break;
                }
            }
            return obj;
        }

        /***
         * This function show all element in hashmap
         */
        public void Print(){
            while (it.hasNext()) {
                System.out.println(it.next());
            }
            restartiterator();
        }

    }///MapIterator

}
