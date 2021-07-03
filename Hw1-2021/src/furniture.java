public class furniture {
    private String name;
    private String model;
    private String color;

    /***
     * This is a constructor
     * @param name is string which show name of furniture
     * @param model is string which show model of furniture
     * @param color is a string which show color of furniture
     */
    public furniture(String name, String model, String color) {
        this.name=name;
        this.model = model;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
