public abstract class Person implements Icargo {
    private String name;
    private String surname;
    private String unvan;

    public Person(String name, String surname,String unvan) {
        this.name = name;
        this.surname = surname;
        this.unvan=unvan;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname=surname;
    }
    @Override
    public String getUnvan(){
        return this.unvan;
    }
    @Override
    public void setUnvan(String unvan){
        this.unvan=unvan;
    }

}
