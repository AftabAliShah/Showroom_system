import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_NAME = "showroom_managment_system";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String uid = "root";
    private static final String pass = "root";
    public static Connection connection = null;

    public static Connection getConnection(){
        try {
            if(connection == null){
                Class.forName(driver);
                connection = DriverManager.getConnection(URL+ DATABASE_NAME, uid, pass);
            }
        }catch (SQLException sqlException){
            System.out.println("SQl Exception");
        }catch (ClassNotFoundException exception){
            System.out.println("Jar File Not Found");
        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
