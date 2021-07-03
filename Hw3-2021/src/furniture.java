public class furniture {
    private String name;
    private String model;
    private String color;
    private Branch branchname;


    public furniture(String name){
        this.name=name;
        model=null;
        color=null;
        branchname=null;
    }
    /***
     * This is a constructor
     * @param name is string which show name of furniture
     * @param model is string which show model of furniture
     * @param color is a string which show color of furniture
     * @param branchname is a Branch
     */
    public furniture(String name, String model, String color, Branch branchname) {
        this.name=name;
        this.model = model;
        this.color = color;
        this.branchname = branchname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Branch getBranchname() {
        return branchname;
    }

    public void setBranchname(Branch branchname) {
        this.branchname = branchname;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return name +"/ " +model +"/ "+color+" /"+ branchname.getBranchname();
       // System.out.println();
    }

}
