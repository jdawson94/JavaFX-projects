package menu;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.FXCollections;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Customer extends ObservableListWrapper<Meal> {

    private ArrayList<Meal> customer;

    public Customer() {
        super(FXCollections.observableArrayList());
        this.customer = new ArrayList<>();
    }

    public void addMeal(Meal newMeal) {
        this.customer.add(newMeal);
    }

    public void addMeal(String name, String description, Double cost, int calories, Meal.Type type) {
        super.add(new Meal(name, description, cost, calories, type));
    }

    public void removeMeal(Meal meal) {
        super.remove(meal);
    }

    public int calculateCost() {
        Meal temp;
        int total = 0;
        for (int i = 0; i < super.size(); i++) {
            temp = super.get(i);
            total += temp.getCost();
        }
        return total;
    }

    public int calculateCalories() {
        Meal temp;
        int total = 0;
        for (int i = 0; i < super.size(); i++) {
            temp = super.get(i);
            total += temp.getCalories();
        }
        return total;
    }

}
