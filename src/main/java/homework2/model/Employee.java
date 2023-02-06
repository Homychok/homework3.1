package homework2.model;

import java.util.Objects;

public class Employee {
    private String first_name;
    private String last_name;
    private String gender;
    private Integer age;
    private Integer city_id;
    private Integer id;
public Employee() {

}

    public Employee(Integer id, String first_name, String last_name, String gender, int age, int city_id) {
        this.id = id;
    }

    public Employee(String first_name, String last_name, String gender, Integer age, Integer city_id, Integer id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.city_id = city_id;
        this.id = id;
    }

    public Employee(String first_name, String last_name, String gender, Integer age, Integer city_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.city_id = city_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getFirst_name(), employee.getFirst_name()) && Objects.equals(getLast_name(), employee.getLast_name()) && Objects.equals(getGender(), employee.getGender()) && Objects.equals(getAge(), employee.getAge()) && Objects.equals(getCity_id(), employee.getCity_id()) && Objects.equals(getId(), employee.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst_name(), getLast_name(), getGender(), getAge(), getCity_id(), getId());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", city_id=" + city_id +
                ", id=" + id +
                '}';
    }
}
