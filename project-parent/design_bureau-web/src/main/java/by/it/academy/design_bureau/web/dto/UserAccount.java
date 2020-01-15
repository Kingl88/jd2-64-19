package by.it.academy.design_bureau.web.dto;

import by.it.academy.design_bureau.model.Employee;

import java.util.Objects;

public class UserAccount { // будем использовать в куки и везде где нужен только логин и права доступа.
    private final String userId;
    private final String userNameLogin;
    private final String role;

    public UserAccount(Employee employee) {
        this.userId = String.valueOf(employee.getId());
        this.userNameLogin = employee.getLogin();
        this.role = employee.getRole();
    }

    public String getUserId() {
        return userId;
    }

    public String getUserNameLogin() {
        return userNameLogin;
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
                Objects.equals(userNameLogin, that.userNameLogin) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userNameLogin, role);
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "userId='" + userId + '\'' +
                ", userName='" + userNameLogin + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
