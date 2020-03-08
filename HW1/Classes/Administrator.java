
/**
 * it is class for system administrator
 * @author Ferdi Sönmez
 */
public class Administrator extends Person{
    private String password;
    private Branch[] branchs;

    /**
     * it is a constructor for Administrator class
     * @param password
     * @param isim
     * @param surname
     */
    public Administrator(String password, String isim, String surname) {//constructor
        super(isim, surname);
        this.password = password;
    }

    /**
     * Getter Function
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter Function
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
 
}
