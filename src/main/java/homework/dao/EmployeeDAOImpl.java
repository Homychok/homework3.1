package homework.dao;

import homework.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection connection;

    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Employee employee) {
        try(PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO employee (id, first_name, last_name, gender, age, city_id) VALUES ((?), (?), (?), (?),(?),(?))"
        )) {

        }
    }

    @Override
    public Employee readById(int id) {
        return null;
    }

    @Override
    public List<Employee> readAll() {
        return null;
    }

    @Override
    public void updateById(int id, int age) {

    }

    @Override
    public void deleteById(int id) {

    }

    enum Queries {
    GET("SELECT * FROM employee INNER JOIN city ON employee.city_id = city.city_id AND employee_id=(?)"),
        GET_ALL("SELECT * FROM employee INNER JOIN city ON employee.city_id = city.city_id"),
        INSERT("INSERT INTO employee(id, first_name, last_name, gender, age, city_id) VALUES ((?), (?), (?), (?),(?),(?))"),
        DELETE("DELETE FROM employee WHERE employee_id=(?)"),
        UPDATE("UPDATE employee SET age = (?) WHERE employee_id=(?)");

        String query;
    Queries(String query) {
        this.query = query;
    }
    }

}
