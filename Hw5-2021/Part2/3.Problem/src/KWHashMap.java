public interface KWHashMap<K>{
    public K get(Object key);
    public boolean isEmpty();
    public K put(K key);
    public K remove(Object key);
    public int size();
}