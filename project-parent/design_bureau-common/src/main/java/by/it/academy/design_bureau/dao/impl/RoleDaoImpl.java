package by.it.academy.design_bureau.dao.impl;

import by.it.academy.design_bureau.dao.EmployeeDao;
import by.it.academy.design_bureau.dao.RoleDAO;
import by.it.academy.design_bureau.model.Employee;
import org.slf4j.LoggerFactory;

import javax.management.relation.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class RoleDaoImpl extends AbstractDao implements RoleDAO {
    private static final RoleDaoImpl INSTANCE = new RoleDaoImpl();
    public static RoleDaoImpl getInstance() {
        return INSTANCE;
    }
    private RoleDaoImpl() {
        super(LoggerFactory.getLogger(RoleDaoImpl.class));
    }

    public static final String SELECT_ALL_ROLE = "SELECT * FROM role";

    @Override
    public Long create(HashMap<Integer, String> integerStringHashMap) throws SQLException {
        return null;
    }

    @Override
    public Optional<HashMap<Integer, String>> read(Long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public int update(HashMap<Integer, String> integerStringHashMap) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Long id) throws SQLException {
        return 0;
    }

    @Override
    public List<HashMap<Integer, String>> getAll() throws SQLException {
        return null;
    }

    @Override
    public HashMap<Integer, String> getRole() throws SQLException {
        ResultSet resultSet = null;
        HashMap<Integer, String> result = new HashMap<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ROLE)) {
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.put(resultSet.getInt(1), resultSet.getString(2));
            }
        }
        finally {
            closeQuietly(resultSet);
        }
        return result;

    }
}
