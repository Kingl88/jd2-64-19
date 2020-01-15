package by.it.academy.design_bureau.model;

import java.util.Objects;

public class Employee {
    private Long id;
    private String firstName; //имя.
    private String middleName; //отчество.
    private String lastName; //фамилия.
    private String positionInCompany; //должность.
    private String phoneNumber; //номер телефона.
    private String login; //логин.
    private String password; //пароль.
    private String salt; //"соль".
    private String role; // права доступа.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(middleName, employee.middleName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(positionInCompany, employee.positionInCompany) &&
                Objects.equals(phoneNumber, employee.phoneNumber) &&
                Objects.equals(password, employee.password) &&
                Objects.equals(salt, employee.salt) &&
                Objects.equals(login, employee.login) &&
                Objects.equals(role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, middleName, lastName, positionInCompany, phoneNumber, password, salt, login, role);
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    public String getSalt() {
        return salt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Employee(Long id, String firstName, String middleName, String lastName, String positionInCompany, String phoneNumber, String login, String password, String salt, String role) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.positionInCompany = positionInCompany;
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.password = password;
        this.salt = salt;
        this.role = role;
    }
}
