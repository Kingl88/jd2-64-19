package by.it.academy.design_bureau.dao.impl;

import by.it.academy.design_bureau.dao.EmployeeDao;
import by.it.academy.design_bureau.model.Employee;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao {

    private static final EmployeeDaoImpl INSTANCE = new EmployeeDaoImpl();

    public static final String INSERT_EMPLOYEE = "INSERT INTO employees (first_name, middle_name, last_name, position_in_company, phone, login, password, salt, role_id) VALUE (?,?,?,?,?,?,?,?,?)";
    public static final String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employees e JOIN role r on e.role_id = r.id WHERE e.id = ?";
    public static final String SELECT_ALL_EMPLOYEE = "SELECT * FROM employees e JOIN role r on e.role_id = r.id";
    public static final String UPDATE_EMPLOYEE = "UPDATE employees  SET first_name = ? , middle_name = ?, last_name = ?, phone = ?, position_in_company = ? WHERE id = ?";
    public static final String DELETE_EMPLOYEE_BY_ID = "DELETE FROM employees WHERE id = ?";
    public static final String SELECT_BY_EMPLOYEE_LOGIN = "SELECT * FROM employees e JOIN role r on e.role_id = r.id WHERE e.login = ?";


    private EmployeeDaoImpl() {
        super(LoggerFactory.getLogger(EmployeeDaoImpl.class));
    }

    public static EmployeeDao getInstance() {
        return INSTANCE;
    }

    @Override
    public Long create(Employee employee) throws SQLException {
        ResultSet resultSet = null; // интерфейс для работы с результатом запроса
        Long result = null;
        try (Connection connection = getConnection();
             //PreparedStatement - класс используется для выполнения SQL-запросов с или без входных параметров; добавляет методы управления входными параметрами.
             //Statement.RETURN_GENERATED_KEYS - флаг говорящий о том что сгенерированный ключ должен быть доступен для "извлечения".
             PreparedStatement statement = connection.prepareStatement(INSERT_EMPLOYEE, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, employee.getFirstName()); // записываем имя.
            statement.setString(2, employee.getMiddleName()); // записываем отчество.
            statement.setString(3, employee.getLastName()); // записываем фамилию.
            statement.setString(4, employee.getPhoneNumber()); // записываем номер телефона.
            statement.setString(5, employee.getPositionInCompany()); // записываем должность.
            statement.setString(6, employee.getLogin()); // записываем логин.
            statement.setString(7, employee.getPassword()); // записываем пароль.
            statement.setString(8, employee.getSalt()); // записываем "соль".
            statement.setInt(9,Integer.parseInt(employee.getRole())); // записываем "роль".
            statement.executeUpdate(); // метод для завершения выполнения запросов.

            resultSet = statement.getGeneratedKeys(); // метод для получения сгенерированных ключей.

            while (resultSet.next()) {
                result = resultSet.getLong(1);
            }
        } finally {
            closeQuietly(resultSet); // закрываем resultSet.
        }
        return result; // результатом возвращаем автоматически сгенерированный id.
    }

    @Override
    public Optional<Employee> read(Long id) throws SQLException {
        ResultSet resultSet = null;
        Optional<Employee> result = Optional.empty(); // создаем пустой объект Optional.
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) { // входной параметр id.

            statement.setLong(1, id);
//Для метода executeQuery, возвращающий набор данных, оператор считается завершенным,
//если считаны все строки соответствующего объекта ResultSet.
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                result = Optional.of(mapEmployee(resultSet));
            }
        } finally {
            closeQuietly(resultSet);
        }
        return result;
    }

    @Override
    public int update(Employee employee) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE)) {

            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getMiddleName());
            statement.setString(3, employee.getLastName());
            statement.setString(4, employee.getPhoneNumber());
            statement.setString(5, employee.getPositionInCompany());
            statement.setLong(6, employee.getId());

            return statement.executeUpdate();
        }
    }

    @Override
    public int delete(Long id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_BY_ID)) {
            statement.setLong(1, id);
            return statement.executeUpdate();
        }
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        ResultSet resultSet = null;
        List<Employee> result = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);) {
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.add(mapEmployee(resultSet));
            }
        }
        finally {
            closeQuietly(resultSet);
        }

        return result;
    }

    private Employee mapEmployee(ResultSet resultSet) throws SQLException { // метод создает Employee на основании данных в таблице.
        long userId = resultSet.getLong("id");
        String firstName = resultSet.getString("first_name");
        String middleName = resultSet.getString("middle_name");
        String lastName = resultSet.getString("last_name");
        String phone = resultSet.getString("phone");
        String position_in_company = resultSet.getString("position_in_company");
        String login = resultSet.getString("login");
        String role = resultSet.getString("role_name");
        return new Employee(userId, firstName, middleName, lastName, position_in_company, phone, login, null, null, role);
    }

    @Override
    public Optional<Employee> getByEmployeeLogin(String login) throws SQLException {
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = getConnection().prepareStatement(SELECT_BY_EMPLOYEE_LOGIN);
            statement.setString(1, login);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Employee employee = new Employee(resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("middle_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("position_in_company"),
                        resultSet.getString("phone"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("salt"),
                        resultSet.getString("role_name")
                        );
                return Optional.of(employee);
            }
        } finally {
            closeQuietly(resultSet);
        }
        return Optional.empty();
    }
}
