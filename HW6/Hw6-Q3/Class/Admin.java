public class Admin extends Person implements IAdmin{
    private String password;
    public Admin(String name, String surname,String password) {
        super(name, surname);
        this.password=password;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
