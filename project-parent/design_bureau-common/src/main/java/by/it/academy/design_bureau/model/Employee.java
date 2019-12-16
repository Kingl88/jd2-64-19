package by.it.academy.design_bureau.model;

import java.util.Objects;

public class Employee {
    private Long id;
    private String firstName; //имя.
    private String lastName; //фамилия.
    private String positionInCompany; //должность.
    private String phoneNumber; //номер телефона.
    private String password; //пароль.
    private String login; //логин
    private boolean isAdmin; // права доступа.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return isAdmin == employee.isAdmin &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(positionInCompany, employee.positionInCompany) &&
                Objects.equals(phoneNumber, employee.phoneNumber) &&
                Objects.equals(password, employee.password) &&
                Objects.equals(login, employee.login);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", positionInCompany='" + positionInCompany + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, positionInCompany, phoneNumber, password, login, isAdmin);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPositionInCompany() {
        return positionInCompany;
    }

    public void setPositionInCompany(String positionInCompany) {
        this.positionInCompany = positionInCompany;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Employee(Long id, String firstName, String lastName, String positionInCompany, String phoneNumber, String password, String login, boolean isAdmin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.positionInCompany = positionInCompany;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.login = login;
        this.isAdmin = isAdmin;
    }
}
