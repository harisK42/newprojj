import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    static final String DB_URL = "jdbc:mysql://localhost:3306/carrental";
    static final String USER = "root";
    static final String PASS = "42747414";

    public static void main(String[] args) {
        try{Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            getData(stmt);
            insertData(stmt,"samibank","sami babe","sami@gamil.com");
            getData(stmt);
//            deleteData(stmt,"samibank");
//            getData(stmt);
            updateData(stmt,"samibank","nigga");
            getData(stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateData(Statement stmt,String custID,String custName){
        try{
            stmt.executeUpdate("update customer set custName = '"+custName+"' where customerID='"+custID+"';");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void deleteData(Statement stmt,String custID){
        try{
            stmt.executeUpdate("delete from customer where customerID='"+custID+"'");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void insertData(Statement stmt,String custID,String custName,String custEmail){
        try {
            stmt.executeUpdate("insert into CUSTOMER values('" + custID + "','" + custName + "','" + custEmail + "')");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void getData(Statement stmt){
        try {
            ResultSet rs = stmt.executeQuery("select * from CUSTOMER");
            System.out.println("CustomerID sami baig      CustomerName      CustomerEmail");
            while (rs.next()) {
                //Display values
                System.out.print(rs.getString("customerID") + "      ");
                System.out.print(rs.getString("custName") + "      ");
                System.out.println(rs.getString("custEmail"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
