package webapp.firstwebapp;

import jakarta.persistence.*;

@Entity
@Table(name = "todo_items")
public class ToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @Column(name = "completed")
    private boolean completed;

    // Default constructor required by JPA specifications
    public ToDoItem() {
    }

    // Constructor with description only, completed is set to false by default
    public ToDoItem(String description) {
        this.description = description;
        this.completed = false;
    }

    // ID - Getters and setters
    public Long getId() {
        return id;
    }
    // If title is the same as description, you can provide an alias setter for title
    public void setTitle(String title) {
        this.description = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // toString method for debugging purposes
    @Override
    public String toString() {
        return "ToDoItem{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }
}
