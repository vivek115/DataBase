import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Update {
    // Main driver method
    public static  void main(String a[]) throws ClassNotFoundException {

        // Creating the connection using Oracle DB
        // Note: url syntax is standard, so do grasp
        String url = "jdbc:mysql://localhost:3306/test";

        // Username and password to access DB
        // Custom initialization
        String user = "root";
        String pass = "Welcome@123";

        // Entering the data
        Scanner k = new Scanner(System.in);

        // Inserting data using SQL query
        String sql = "UPDATE student " +
                "SET name='VIVEK' ,class = '9'" +
                " WHERE rollno in (123)"+
                "ORDER BY name";
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

