package homework2.dao;

import homework2.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection connection;

    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Employee employee) {
        try(PreparedStatement statement = connection.prepareStatement(
                Queries.INSERT.query)) {
            statement.setString(1, employee.getFirst_name());
            statement.setString(2, employee.getLast_name());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCity_id());
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee readById(int id) {
        Employee employee = new Employee();

        try (PreparedStatement statement = connection.prepareStatement(
                Queries.GET.query)) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
//                employee.setId(resultSet.getInt("id"));
                employee.setFirst_name(resultSet.getString("first_name"));
                employee.setLast_name(resultSet.getString("last_name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setAge(resultSet.getInt("age"));
                employee.setCity_id(resultSet.getInt("city_id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Employee> readAll() {
        List<Employee> employees = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.INSERT.query)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int city_id = resultSet.getInt("city_id");
                employees.add(new Employee());



            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    @Override
    public void updateById(int id, int age) {
try(PreparedStatement statement = connection.prepareStatement(Queries.UPDATE.query)) {
    statement.setInt(1, age);
    statement.setInt(2, id);
    statement.execute();
} catch (SQLException e) {
    throw new RuntimeException(e);
}
    }

    @Override
    public void deleteById(int id) {
try (PreparedStatement statement = connection.prepareStatement(Queries.DELETE.query)){
    statement.setInt(1,id);
    statement.execute();
} catch (SQLException e) {
    throw new RuntimeException(e);
}
    }

    enum Queries {
    GET("SELECT * FROM employee INNER JOIN city ON employee.city_id = city.city_id AND id=(?)"),
        GET_ALL("SELECT * FROM employee INNER JOIN city ON employee.city_id = city.city_id"),
        INSERT("INSERT INTO employee(first_name, last_name, gender, age, city_id) VALUES ((?), (?), (?),(?),(?))"),
        DELETE("DELETE FROM employee WHERE id=(?)"),
        UPDATE("UPDATE employee SET age = (?) WHERE id=(?)");

        String query;
    Queries(String query) {
        this.query = query;
    }
    }

}
