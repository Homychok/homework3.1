package homework2;

import homework2.dao.EmployeeDAO;
import homework2.dao.EmployeeDAOImpl;
import homework2.model.Employee;

import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {

        final String user = "postgres";
        final String pass = "22091996cfif";
        final String url = "jdbc:postgresql://localhost:5432/sky-pro";

        try (final Connection connection = DriverManager.getConnection(url, user, pass)) {
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);

            Employee employee1 = new Employee("Elena", "Bobricova", "woman", 12, 4);
            System.out.println(employeeDAO.readById(4));
            List<Employee> employees = employeeDAO.readAll();
            for (Employee employee : employees) {
                System.out.println(employee);
                employeeDAO.updateById(4, 3);
                employeeDAO.deleteById(4);
            }
        }
    }
}


