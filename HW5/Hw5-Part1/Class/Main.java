public class Main {
    public static void main(String[] args){
       try{
            FileSystemTree<String> tree=new FileSystemTree("root");
            tree.addDir("root/first_directory");
            tree.addDir("root/second_directory");
            tree.addDir("root/first_directory/new_file.doc");
            tree.addFile("root/second_directory/new_directory/data.txt");
            tree.printFileSystem();
            System.out.println("***************");
            tree.search("new");
            System.out.println();
            tree.remove("root/second_directory");
            tree.printFileSystem();
       } catch (IndexOutOfBoundsException e) {
           System.out.println("Array's size exceeded");
       }
       catch (NullPointerException e){
           System.out.println("You wanted to reach a value that is not in the tree structure");
       }

    }
}
