public  interface MyListinterface<E>{
    public int size();
    public boolean add(E e);
    public E get(int index);
    public E set(int index, E element);
    public E remove(int index);
    public int indexOf(E o);

}
