package edu.zhuravlev.servletstest.entitys;

import edu.zhuravlev.sql.micro_orm.annotations.Entity;
import edu.zhuravlev.sql.micro_orm.annotations.Id;

import java.util.Objects;

@Entity("Users")
public class Person {
    @Id
    private String login;
    private String name;
    private String email;
    private String country;
    private String password;

    public Person() {};
    public Person(String login, String name, String email, String country, String password) {
        this.login = login;
        this.name = name;
        this.email = email;
        this.country = country;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return login == person.login && name.equals(person.name) && email.equals(person.email) && country.equals(person.country) && password.equals(person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, name, email, country, password);
    }

    @Override
    public String toString() {
        return "Person = {login=" + login + ", name=" + name +
                ", email=" + email + ", country=" + country +
                ", password=" + password + "}";
    }
}
