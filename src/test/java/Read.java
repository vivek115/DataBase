import java.sql.*;
public class Read {
    public static void main(String a[]) throws ClassNotFoundException {

        // Step 2: Making connection using
        // Connection type and inbuilt function on
        PreparedStatement p = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/test";

        // Username and password to access DB
        // Custom initialization
        String user = "root";
        String pass = "Welcome@123";

        Connection con = null;

        // Try block to catch exception/s
        try {
            Class.forName(
                    "com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println(
                    "Connection Established successfully");


            // SQL command data stored in String datatype
            String sql = "select * from student";
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            // Printing ID, name, email of customers
            // of the SQL command above
            System.out.println("id\t\tname\t\temail");
            // Condition check
            while (rs.next()) {

                String name = rs.getString("name");
                int rollno = rs.getInt("rollno");
                int classname = rs.getInt("class");
                System.out.println(name + "\t\t" + rollno + "\t\t" + classname);
            }
        }

        // Catch block to handle exception
        catch (SQLException e) {

            // Print exception pop-up on screen
            System.out.println(e);
        }
    }
}
