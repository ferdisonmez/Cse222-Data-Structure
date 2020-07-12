public interface IMaxHeap<E> {
    public void remove(E element);
    public void add(E element);
    public E find(E element);
    public int olderThan(int element);
    public int youngerThan(int element);

}
