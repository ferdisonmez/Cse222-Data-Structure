public interface ITree<E> {
    public void addDir(String Path);
    public void addFile(String Path);
    public void remove(String Path);
    public void search(String Path);
    public void printFileSystem();
}
