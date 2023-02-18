package homework2;

import homework2.dao.CityDAO;
import homework2.dao.CityDAOImpl;
import homework2.dao.EmployeeDAO;
import homework2.dao.EmployeeDAOImpl;
import homework2.model.City;
import homework2.model.Employee;

import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
EmployeeDAO employeeDAO = new EmployeeDAOImpl();
            CityDAO cityDAO = new CityDAOImpl();
            Employee employee1 = new Employee(6,"Elena", "Bobricova", "woman", 12);
Employee employee2 = new Employee(6,"Elena", "Bobricova", "woman", 17);
//    employeeDAO.updateById(employee2);
//    employeeDAO.deleteById(employee2);
        Employee employee3 = new Employee("Vlad", "Kurochkin", "man", 43, 7);
        City city1 = new City("Orel");
        City city2 = new City("Magadan");
                cityDAO.create(city1);
        cityDAO.create(city2);
       City city3 = cityDAO.getCity(4);
        employee1.setCityId(city1);
        employee3.setCityId(city3);
        System.out.println(cityDAO.getAllCities());
        System.out.println(city2.getEmployee());
        employeeDAO.create(employee2);
        employeeDAO.create(employee3);
//        cityDAO.create(city1);
//        cityDAO.create(city2);
//        System.out.println(cityDAO.getCity(4));
//        System.out.println(cityDAO.getAllCities());
//        cityDAO.updateCity(city2);
//        cityDAO.deleteCity(cityDAO.getCity(7));
    }
}
//
//        final String user = "postgres";
//        final String pass = "22091996cfif";
//        final String url = "jdbc:postgresql://localhost:5432/sky-pro";
//
//        try (final Connection connection = DriverManager.getConnection(url, user, pass)) {
//            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);
//
//            Employee employee1 = new Employee("Elena", "Bobricova", "woman", 12, 4);
//            System.out.println(employeeDAO.readById(5));
//            List<Employee> employees = employeeDAO.readAll();
//            for (Employee employee : employees) {
//                System.out.println(employee);
//                employeeDAO.updateById(4, 3);
//                employeeDAO.deleteById(4);
//            }
//        }
//    }



