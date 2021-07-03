import java.io.*;
import java.util.Hashtable;

public class Customer extends User {
    String Name;
    public Customer(String userId, String password,String Name) {
        super(userId, password);
        this.Name=Name;
    }
}
