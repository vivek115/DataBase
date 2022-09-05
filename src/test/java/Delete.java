import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Delete {
    public static void main(String a[]) throws ClassNotFoundException {

        // Creating the connection using Oracle DB
        // Note: url syntax is standard, so do grasp
        String url = "jdbc:mysql://localhost:3306/test";

        // Username and password to access DB
        // Custom initialization
        String user = "root";
        String pass = "Welcome@123";

        // Inserting data using SQL query
        String sql = "DELETE FROM student " +
                "WHERE rollno = 988";
        // Connection class object
        Connection con = null;
        try {

            // Registering drivers
            Class.forName(
                    "com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println(
                    "Connection Established successfully");

            // Creating a statement
            Statement st = con.createStatement();

            // Executing query
            int m = st.executeUpdate(sql);
            if (m == 1)
                System.out.println(
                        "inserted successfully : " + sql);
            else

                System.out.println("insertion failed");

            // Closing the connections
            con.close();
        }

        // Catch block to handle exceptions
        catch (Exception ex) {
            // Display message when exceptions occurs
            System.err.println(ex);
        }
    }
}
