package Test;

import com.hibernate.ToDoItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

    public static void main(String[] args) {
        // Create a session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Create a session
        Session session = sessionFactory.openSession();

        // Begin a transaction
        Transaction tx = session.beginTransaction();

        // Create a new To-Do item
        ToDoItem newItem = new ToDoItem();
        newItem.setTitle("Learn Hibernate");
        newItem.setCompleted(false);

        // Save the To-Do item
        session.save(newItem);

        // Commit the transaction
        tx.commit();

        // Close the session and session factory
        session.close();
        sessionFactory.close();
    }
}
