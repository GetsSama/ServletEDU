package edu.zhuravlev.servletstest;

import edu.zhuravlev.servletstest.entitys.Person;
import edu.zhuravlev.sql.micro_orm.EntityManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

@WebServlet(name = "EntryHandler", value = "/entry")
public class EntryHandler extends HttpServlet {
    private EntityManager em;

    @Override
    public void init() throws ServletException {
        //em = EntityManager.createEntityManager();
        PoolProperties p = new PoolProperties();
        p.setUrl("jdbc:postgresql://localhost/crud_edu");
        p.setDriverClassName("org.postgresql.Driver");
        p.setUsername("postgres");
        p.setPassword("520621df");
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(100);
        p.setInitialSize(10);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors(
                "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
                        "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        DataSource datasource = new DataSource();
        datasource.setPoolProperties(p);

        em = EntityManager.createEntityManager(datasource);
        //em = EntityManager.createEntityManager();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login;
        String password;
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html><h1>");

        login = request.getParameter("login");
        password = request.getParameter("password");

        Person person = em.read(login, Person.class);

        if(person.getPassword().equals(password))
            printWriter.println("User exist!");
        else
            printWriter.println("User does not exist!");

        printWriter.println("</h1></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        em.freeResources();
    }
}
