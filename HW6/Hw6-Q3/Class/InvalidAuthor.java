public class InvalidAuthor extends Exception {
    public InvalidAuthor(String msg){
        super(msg);
    }
    public InvalidAuthor() {
    }
    @Override
    public void printStackTrace() {
        System.out.println("Invalid AuthorName");
    }
}
