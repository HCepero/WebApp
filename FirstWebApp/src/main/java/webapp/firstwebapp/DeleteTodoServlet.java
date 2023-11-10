package webapp.firstwebapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.IOException;

@WebServlet(name = "DeleteTodoServlet", urlPatterns = {"/delete-todo"})
public class DeleteTodoServlet extends HttpServlet {
    private SessionFactory sessionFactory;

    @Override
    public void init() {
        sessionFactory = (SessionFactory) getServletContext().getAttribute("SessionFactory");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            ToDoItem todoItem = session.get(ToDoItem.class, id);
            if (todoItem != null) {
                session.delete(todoItem);
            }

            transaction.commit();

            response.sendRedirect("list-todos");
        } catch (Exception e) {
            // Handle exceptions and rollback transaction if necessary
        }
    }
}
