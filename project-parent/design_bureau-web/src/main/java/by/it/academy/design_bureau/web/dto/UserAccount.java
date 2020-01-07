package by.it.academy.design_bureau.web.dto;

import by.it.academy.design_bureau.model.Employee;

import java.util.Objects;

public class UserAccount {
    private final String userId;
    private final String userName;
    private final String role;

    public UserAccount(Employee employee) {
        this.userId = String.valueOf(employee.getId());
        this.userName = employee.getLogin();
        this.role = employee.getRole();
    }

    public UserAccount(String userId, String userName, String role) {
        this.userId = userId;
        this.userName = userName;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, role);
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
