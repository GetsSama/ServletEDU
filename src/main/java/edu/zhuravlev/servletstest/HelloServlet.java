package edu.zhuravlev.servletstest;



import edu.zhuravlev.servletstest.entitys.Person;
import edu.zhuravlev.sql.micro_orm.EntityManager;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private Person person;

    public void init() {
        message = "Hello World!";
        EntityManager em = EntityManager.createEntityManager();
        person = em.read("1", Person.class);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<p>" + person + "</p>");
        out.println("</body></html>");
    }

    public void destroy() {

    }
}