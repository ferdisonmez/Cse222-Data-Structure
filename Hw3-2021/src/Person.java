public class Person implements Personinterface {
    private String name;
    private String surname;
    private String email;
    private String sifre;

    public Person(String name, String surname, String email, String sifre) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.sifre = sifre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", sifre=...";
    }
    public String showinformotion(){
        return toString();
    }
}
