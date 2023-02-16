package homework2.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "city")
public class City {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "city_name")
private String cityName;
@Column(name = "city_id")
    private Integer cityId;
@OneToMany(mappedBy = "city_id", cascade = CascadeType.ALL)
private List<Employee> employee;
public City() {
}

    public City(String cityName, Integer cityId) {
        this.cityName = cityName;
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(getCityName(), city.getCityName()) && Objects.equals(getCityId(), city.getCityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCityName(), getCityId());
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
