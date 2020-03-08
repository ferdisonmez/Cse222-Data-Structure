

/**
 *This class is base class other classes can derive
 * @author Ferdi Sönmez
 */
public class Person {
    private String isim;
    private String surname;

    /**
     *it is constructor for Person class
     * @param isim
     * @param surname
     */
    public Person(String isim, String surname) {
        this.isim = isim;
        this.surname = surname;
    }

    /**
     *Getter function for isim feature
     * @return isim
     */
    public String getIsim() {
        return isim;
    }

    /**
     *Setter function for isim feature
     * @param isim
     */
    public void setIsim(String isim) {
        this.isim = isim;
    }

    /**
     *Getter function for surname feature in the Person class
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     *Setter function for surname feature in the Person class
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
  
}
