package webapp.firstwebapp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class ToDoListApplication {

    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        int option;
        do {
            System.out.println("\n--- To-Do List Application ---");
            System.out.println("1. Add a to-do item");
            System.out.println("2. Delete a to-do item");
            System.out.println("3. View to-do items");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    addToDoItem();
                    break;
                case 2:
                    deleteToDoItem();
                    break;
                case 3:
                    viewToDoItems();
                    break;
                case 0:
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (option != 0);
    }

    private void addToDoItem() {
        System.out.print("Enter the description of the to-do item: ");
        String description = scanner.nextLine();
        ToDoItem item = new ToDoItem(description);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(item);
            transaction.commit();
            System.out.println("To-do item added successfully!");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    private void deleteToDoItem() {
        viewToDoItems();
        System.out.print("Enter the ID of the to-do item to delete: ");
        Long id = scanner.nextLong();

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            ToDoItem item = session.get(ToDoItem.class, id);
            if (item != null) {
                session.remove(item);
                System.out.println("To-do item deleted successfully!");
            } else {
                System.out.println("To-do item not found!");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    private void viewToDoItems() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<ToDoItem> items = session.createQuery("from ToDoItem", ToDoItem.class).list();
            if (items.isEmpty()) {
                System.out.println("No to-do items found.");
            } else {
                for (ToDoItem item : items) {
                    System.out.println(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ToDoListApplication().start();
    }
}

