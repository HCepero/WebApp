package webapp.firstwebapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateTodoServlet", urlPatterns = {"/update-todo"})
public class UpdateTodoServlet extends HttpServlet {
    private SessionFactory sessionFactory;

    @Override
    public void init() {
        sessionFactory = (SessionFactory) getServletContext().getAttribute("SessionFactory");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        String description = request.getParameter("description");
        boolean isCompleted = Boolean.parseBoolean(request.getParameter("completed"));

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            ToDoItem todoItem = session.get(ToDoItem.class, id);
            if (todoItem != null) {
                todoItem.setDescription(description);
                todoItem.setCompleted(isCompleted);
                session.update(todoItem);
            }

            transaction.commit();

            response.sendRedirect("list-todos");
        } catch (Exception e) {
            // Handle exceptions and rollback transaction if necessary
        }
    }
}
