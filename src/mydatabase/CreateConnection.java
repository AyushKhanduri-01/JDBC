package mydatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateConnection {
    CreateConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306";
        String username = "root";
        String password = "MyDatabase";

        Connection conn = DriverManager.getConnection(url, username, password);

        Statement stm = conn.createStatement();

        String query = "Create database if not exists StudentRecord";
        stm.executeUpdate(query);
        stm.executeUpdate("use StudentRecord");
        query = "Create table if not exists information(Student_ID int primary key,Name varchar(50) not null, Course varchar(50) not null)";
        stm.executeUpdate(query);
    };

}
