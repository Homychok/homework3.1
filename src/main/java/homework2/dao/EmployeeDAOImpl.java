package homework2.dao;

import homework2.config.HibernateSessionFactoryUtil;
import homework2.model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection connection;

//    public EmployeeDAOImpl(Connection connection) {
//        this.connection = connection;
//    }
    public EmployeeDAOImpl() {

    }

    @Override
    public void create(Employee employee) {
//        try(PreparedStatement statement = connection.prepareStatement(
//                Queries.INSERT.query)) {
//            statement.setString(1, employee.getFirstName());
//            statement.setString(2, employee.getLastName());
//            statement.setString(3, employee.getGender());
//            statement.setInt(4, employee.getAge());
//            statement.setInt(5, employee.getCityId());
//            statement.execute();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee readById(int id) {
//        Employee employee = new Employee();
//
//        try (PreparedStatement statement = connection.prepareStatement(
//                Queries.GET.query)) {
//            statement.setInt(1,id);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                employee.setId(Integer.parseInt(resultSet.getString("id")));
//                employee.setFirstName(resultSet.getString("first_name"));
//                employee.setLastName(resultSet.getString("last_name"));
//                employee.setGender(resultSet.getString("gender"));
//                employee.setAge(resultSet.getInt("age"));
//                employee.setCityId(resultSet.getInt("city_id"));
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return employee;
//    }

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        }
    }
    @Override
    public List<Employee> readAll() {
        List<Employee> employees = new ArrayList<>();
//        try (PreparedStatement statement = connection.prepareStatement(Queries.GET_ALL.query)){
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                int id = Integer.parseInt(resultSet.getString("id"));
//                String first_name = resultSet.getString("first_name");
//                String last_name = resultSet.getString("last_name");
//                String gender = resultSet.getString("gender");
//                int age = resultSet.getInt("age");
//                int city_id = resultSet.getInt("city_id");
//                employees.add(new Employee(id, first_name, last_name, gender, age, city_id));
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return employees;
//    }

    try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
    return session.createQuery("From Employee").list();}
     }
    @Override
    public void updateById(Employee employee) {
try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
    Transaction transaction = session.beginTransaction();
    session.update(employee);
    transaction.commit();

}
    }

    @Override
    public void deleteById(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
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
