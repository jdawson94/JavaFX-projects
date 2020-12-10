package phonebook;

import java.util.ArrayList;

public class PhoneBook {
    private ArrayList<String> names;
    private ArrayList<String> numbers;

    public PhoneBook(){
        names = new ArrayList<>();
        numbers = new ArrayList<>();

        names.add("Alison");
        names.add("Bob");
        names.add("Carl");
        names.add("David");
        names.add("Edith");

        numbers.add("000001");
        numbers.add("000002");
        numbers.add("000003");
        numbers.add("000004");
        numbers.add("000005");
    }

    public void addNewEntry(String name, String number){
        names.add(name);
        numbers.add(number);
    }

    public String getNumber(String name){
        for (int i = 0; i < names.size(); i++){
            if (names.get(i).equals(name)){
                return numbers.get(i);
            }
        }

        // if no match found then return null
        return null;
    }

}
