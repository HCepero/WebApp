package webapp.firstwebapp;

import com.hibernate.ToDoItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListTodoServlet", urlPatterns = {"/list-todos"}) // urlPatterns is more descriptive than value
public class ListTodoServlet extends HttpServlet {
    private SessionFactory sessionFactory;

    @Override
    public void init() {
        // Assuming SessionFactory is initialized in ContextListener and stored in ServletContext
        sessionFactory = (SessionFactory) getServletContext().getAttribute("SessionFactory");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Auto-closable try block to ensure session is closed after operation
        try (Session session = sessionFactory.openSession()) {
            // Fetch all to-do items
            Query<ToDoItem> query = session.createQuery("from ToDoItem", ToDoItem.class);
            List<ToDoItem> todoList = query.list();

            // Add the todoList to the request and forward to JSP
            request.setAttribute("todos", todoList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/listTodos.jsp");
            dispatcher.forward(request, response);
        } // Session is automatically closed here
    }
}
