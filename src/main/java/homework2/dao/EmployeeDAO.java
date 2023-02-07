package homework2.dao;

import homework2.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void create (Employee employee);
    Employee readById(int id);

//    Employee readById(Integer id, String first_name, String last_name, String gender, Integer age, Integer city_id);

    List<Employee> readAll();
    void updateById (int id, int age);
    void deleteById (int id);
}
