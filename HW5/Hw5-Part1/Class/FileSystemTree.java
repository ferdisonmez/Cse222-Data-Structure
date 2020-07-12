import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSystemTree<E>implements ITree {
    private class FileNode<E>{
        private E data;
        private FileNode<E> parent;
        private List<FileNode<E>> child;

        FileNode(){
            data=null;
            this.parent=null;
            child=new ArrayList<FileNode<E>>();
        }
        FileNode(E name){
            data=name;
            this.parent=null;
            child=new ArrayList<FileNode<E>>();
        }
        public void setParent(FileNode<E> parent) {
            this.parent = parent;
        }
        public FileNode<E> getParent() {
            return parent;
        }
        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }
        public void setChildren(List<FileNode<E>> children)
        {
            this.child = children;
        }

        /***
         * Indicates the reference of elements in a FileNode
         * @return Elements in the node
         */
        public List<FileNode<E>> getChildren() {
            return child;
        }

        /***
         * indicates the number of elements in a node
         * @return size of element in a FileNode
         */
        public int getNumberOfChildren()
        {
            if(child == null)
            {
                return 0;
            }
            return child.size();
        }

        /***
         * Checks whether the node has elements
         * @return Returns true if there are wedding elements, false if there are no knot elements
         */
        public boolean hasChildren() {
            return (getNumberOfChildren() > 0);
        }

        /***
         *Adds an element to the node that is
         * @param child is FileNode
         * @return new FileNode
         */
        public FileNode<E> addChild(FileNode<E> child) {
            child.setParent(this);
            this.child.add(child);
            return child;
        }

        /***
         *
         * @param data is Generic Type
         */
        public void addChild(E data) {
            FileNode<E> child = new FileNode<E>(data);
            child.setParent(this);
            this.child.add(child);
        }

        /***
         * Check whether the node is a leaf
         * @return if node is leaf this expression is correct
         */
        public boolean isLeaf()
        {
            if(getNumberOfChildren() == 0)
                return true;
            return false;
        }

        /***
         * Check whether the node is a root
         * @return if node is root this expression is correct
         */
        public boolean isRoot() {
            return (this.parent == null);
        }

        /***
         * This method searches in the tree structure
         * @param data is Generic Type
         * @return refers to the node location found
         */
        public FileNode<E> find(E data) {
            if (this.data.equals(data)) {
                return this;
            }
            for (FileNode<E> node : child) {
                FileNode<E> found = node.find(data);
                if (found != null) {
                    return found;
                }
            }
            return null; // Not found.
        }

    }///FileNode inner class

    private FileNode<E> root;

    public FileSystemTree(E name){
        root=new FileNode(name);
    }
    public FileNode<E> find(E data) {
        return root == null ? null : root.find(data);
    }

    /***
     * Prints the tree structure on the screen
     * @param node is FileNode=root is start node of tree
     * @param appender This is the structure we want to have when printing on the screen(-)
     * @param <E> is generic type
     */
    public <E> void printTree(FileNode<E> node, String appender) {
        System.out.println(appender + node.getData());
        node.getChildren().forEach(each->printTree(each, appender + appender));
    }

    /***
     * Number of all nodes in the tree structure
     * @return  Number of all nodes
     */
    public int getNumberOfNodes() {
        int numberOfNodes = 0;

        if(root != null) {
            numberOfNodes = GetNumberOfNodes(root) + 1; //1 for the root!
        }

        return numberOfNodes;
    }

    /***
     * helper metod for getNumberOfNodes()
     * @param node is FileNode structure
     * @return Number of all nodes
     */
    private int GetNumberOfNodes(FileNode<E> node) {
        int numberOfNodes = node.getNumberOfChildren();

        for(FileNode<E> child : node.getChildren()) {
            numberOfNodes +=GetNumberOfNodes(child);
        }

        return numberOfNodes;
    }

    /***
     * this method can split the given string
     * @param Path is the string to be split
     * @return parts of the string
     */
    public String[] parse(String Path){
        String[] output = Path.split("\\/");
        return output;
    }

    /***
     * Adds files or directories
     * @param oldadd is name of FileNode
     * @param newadd is name of new FileNode
     */
    private void addelement(String oldadd,String newadd){
        FileNode<E> kok=find((E) oldadd);
        if (find((E) newadd)==null)
         kok.addChild((E)newadd);
    }

    /***
     *Add Directory
     * @param Path is address of the directory to be added
     */
    @Override
    public void addDir(String Path){
        String[] output=parse(Path);
        for (int i = 0; i <output.length-1; i++) {
            addelement(output[i],output[i+1]);
        }
    }

    /***
     * Add File
     * @param Path is address of the file to be added
     */
    @Override
    public void addFile(String Path){
        String[] output=parse(Path);
        for (int i = 0; i <output.length-1; i++) {
            addelement(output[i],output[i+1]);
        }
    }

    /***
     * used to delete the desired directory and file
     * @param Path is address of the file or directory to be deleted
     */
    @Override
    public void remove(String Path){
        String[] output=parse(Path);
            removefnk(find((E)output[output.length-1]));
    }

    /***
     * helper metod for remove(String Path)
     * @param nodetemp is node of the file or directory to be deleted
     */
    private void removefnk(FileNode<E> nodetemp){
        if (nodetemp==null){
            System.out.println("File or Directory Not Found");
            return;
        }
        else if (nodetemp.isRoot()){
            System.out.println("***%%%-Root-Cannot-Be-Deleted-%%%***");;
        }
        else{
            if (nodetemp.parent != null) {
                int index = nodetemp.parent.getChildren().indexOf(nodetemp);
                if (nodetemp.hasChildren()) {
                    System.out.println("********These-Elements-Will-Be-Deleted******");
                   printTree(nodetemp,"");
                    System.out.println("***********************");
                }
                System.out.println("0-Delete the Above Files Precisely:\n"
                                    +"1-Exit");
                Scanner input=new Scanner(System.in);
                int secim=input.nextInt();
                if (secim==0) {
                    nodetemp.parent.getChildren().remove(nodetemp);
                    nodetemp.getChildren().clear();
                }
                if (secim==1){
                    System.out.println("File Or Directorys is Not Deleted");
                    return;
                }
            }
      }
    }

    /***
     * Checks desired directory and file in tree structure
     * @param Path  is directory or file to search
     */
    @Override
    public void search(String Path){
            TraversTree(root,Path);
    }

    /***
     * Helper metod for search(String Path)
     * @param node is FileNode
     * @param appender is string to search
     */
    private void TraversTree(FileNode<E> node, String appender) {
        String yeni=(String)node.getData();
        if(yeni.contains(appender) && (yeni.contains("File") || yeni.contains("file"))){
            System.out.print("File--->");
            searchpr(node);
            System.out.println();

        }
        else if(yeni.contains(appender) && (yeni.contains("Directory") || yeni.contains("directory"))){
            System.out.print("Directory--->");
            searchpr(node);
            System.out.println();
        }
        node.getChildren().forEach(each->TraversTree(each, appender));
    }

    /***
     * shows exactly the address of the given FileNode struct
     * @param node  address is the desired node structure
     */
    private void searchpr(FileNode<E> node){
        if (node==null){
            return;
        }
        else {
            searchpr(node.parent);
            System.out.print(node.data +"/");
        }
    }

    /***
     * Prints the tree on the screen
     */
    @Override
    public void printFileSystem(){
        printTree(root, "-");
    }
}
