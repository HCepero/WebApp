package webapp.firstwebapp;

import com.hibernate.ToDoItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddTodoServlet", urlPatterns = {"/add-todo"})
public class AddTodoServlet extends HttpServlet {
    private SessionFactory sessionFactory;

    @Override
    public void init() {
        sessionFactory = (SessionFactory) getServletContext().getAttribute("SessionFactory");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            ToDoItem newItem = new ToDoItem(description);
            session.save(newItem);

            transaction.commit();

            response.sendRedirect("list-todos");
        } catch (Exception e) {
            // Handle exceptions and rollback transaction if necessary
        }
    }
}
