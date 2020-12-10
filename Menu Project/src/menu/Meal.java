package menu;

public class Meal {

    private String name;
    private String description;
    private Double cost;
    private int calories;
    private Type type;

    public Meal(String name, String description, Double cost, int calories, Type type) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.calories = calories;
        this.type = type;
    }

    enum Type {
        STARTER,
        MAIN,
        DESSERT,
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type + ": " + name;
    }

}
