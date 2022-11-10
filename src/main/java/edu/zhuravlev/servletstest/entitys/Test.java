package edu.zhuravlev.servletstest.entitys;

import edu.zhuravlev.sql.micro_orm.EntityManager;
import edu.zhuravlev.sql.micro_orm.db_connection.SimpleConnectionManagerImpl;

import javax.naming.ldap.PagedResultsControl;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("zurik.n", "Nikolay", "zurik.n@gmail.com", "RU", "pass");

        EntityManager em = EntityManager.createEntityManager();

        em.save(p1);
        Person nikolay = em.read("zurik.n", Person.class);
        System.out.println(nikolay);

        SimpleConnectionManagerImpl.close();
    }
}
