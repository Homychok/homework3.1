package homework;

import java.sql.*;

public class Application {
    public static void main (String[] args) throws SQLException {

        final String user = "postgres";
        final String pass = "22091996cfif";
        final String url = "jdbc:postgresql://localhost:5432/sky-pro";

        try(final Connection connection = DriverManager.getConnection(url, user, pass);
            PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM employee WHERE city_id = (?)"
            )) {
            statement.setInt(1, 5);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String city_id = "City: " + resultSet.getInt("city_id");
                String first_name = "Name" + resultSet.getString("first_name");
                String age = "Age" + resultSet.getInt("age");

                System.out.println(city_id);
                System.out.println(first_name);
                System.out.println(age);
            }

        }
    }
}
