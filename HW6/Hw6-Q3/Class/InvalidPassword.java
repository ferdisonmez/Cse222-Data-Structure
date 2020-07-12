public class InvalidPassword extends Exception {
    public InvalidPassword(String msg){
        super(msg);
    }
    @Override
    public void printStackTrace() {
        System.out.println("Invalid Password");
    }
}
