package mydatabase;

import java.sql.*;

public class DbOperation {
    String query;
    PreparedStatement pstm;
    Statement stm;
    Connection conn;

    DbOperation() {
        try {
            String url = "jdbc:mysql://localhost:3306";
            String username = "root";
            String password = "MyDatabase";
            conn = DriverManager.getConnection(url, username, password);
            stm = conn.createStatement();
            stm.executeUpdate("use StudentRecord");
        } catch (Exception e) {
            System.out.print("error inside constructor");
        }

    }

    public void insertData(int id, String name, String course) {
        try {
            query = "insert into information (Student_ID ,Name, Course) values(?,?,?)";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, id);
            pstm.setString(2, name);
            pstm.setString(3, course);
            pstm.execute();
            System.out.println("Data inserted sucessfully");
        } catch (Exception e) {
            System.out.println("error inside insert Data" + e);
        }

    }

    public void readData() throws SQLException {
        query = "select * from information";
        stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        System.out.println("Student_ID   Name        Course");
        while (rs.next()) {
            System.out.println("    " + rs.getInt(1) + "        " + rs.getString(2) + "        " + rs.getString(3));
        }

    }

    public void updateData(int oid, int nid, String name, String course) {
        try {
            query = """
                    update  information
                    set Student_ID = ?,name=?,course = ?
                    where Student_ID =?
                    """;
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, nid);
            pstm.setString(2, name);
            pstm.setString(3, course);
            pstm.setInt(4, oid);

            pstm.execute();
            System.out.println("Data updated sucessfully.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteData(int id) throws SQLException {
        query = "delete from information where Student_ID = " + id;
        stm.execute(query);
        System.out.println("Data deleted Seccessfully.");
    }
}
