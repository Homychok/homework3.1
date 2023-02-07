package homework2.model;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private Integer cityId;
    private Integer id;
public Employee() {

}
//
//    public Employee(Integer id) {
//        this.id = id;
//    }

    public Employee(Integer id, String firstName, String lastName, String gender, Integer age, Integer cityId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.cityId = cityId;
        this.id = id;
    }

    public Employee(String firstName, String lastName, String gender, Integer age, Integer cityId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.cityId = cityId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName()) && Objects.equals(getGender(), employee.getGender()) && Objects.equals(getAge(), employee.getAge()) && Objects.equals(getCityId(), employee.getCityId()) && Objects.equals(getId(), employee.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getGender(), getAge(), getCityId(), getId());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", city_id=" + cityId +
                ", id=" + id +
                '}';
    }
}
