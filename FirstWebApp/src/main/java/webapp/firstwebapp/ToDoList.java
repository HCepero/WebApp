package webapp.firstwebapp;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<ToDoItem> items;

    public ToDoList() {
        this.items = new ArrayList<>();
    }

    public void addItem(String description) {
        ToDoItem newItem = new ToDoItem(description);
        items.add(newItem);
    }

    public boolean deleteItem(int id) {
        return items.removeIf(item -> item.getId() == id);
    }

    public List<ToDoItem> getItems() {
        return items;
    }
}
