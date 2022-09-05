import java.sql.*;

public class DataBase {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url
                = "jdbc:mysql://localhost:3306/test";
        String username = "root"; // MySQL credentials
        String password = "Welcome@123";
        Class.forName(
                "com.mysql.cj.jdbc.Driver");
        String query
                = "select * from employee";
        // DriverManager.registerDriver(new mysql.jdbc.driver.OracleDriver());
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println(
                "Connection Established successfully");
        Statement st = con.createStatement();
        ResultSet rs
                = st.executeQuery(query); // Execute query
        rs.next();
        String name
                = rs.getString("employeename"); // Retrieve name from db
        System.out.println(name); // Print result on console
        st.close(); // close statement
        con.close(); // close connection
        System.out.println("Connection Closed....");
    }
}
