import javax.sound.midi.SysexMessage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Manipulation {
    public static void displayCustomers(Connection con) {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from customers");
            while (rs.next()) {
                System.out.print("ID : " + rs.getInt(1) + "    ");
                System.out.print("Name : " + rs.getString(2) + "    ");
                System.out.print("Phone : " + rs.getString(3) + "    ");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static boolean runQuery(Connection con, String query) {
        boolean flag = false;
        try {
            Statement st = con.createStatement();
            flag = st.executeUpdate(query) > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }

    public static void deleteVehicleByID(Connection con, Integer id) {
        String query = "delete from vehicles where v_id = '" + id + "'";
        boolean queryExecuted = runQuery(con, query);
        if (queryExecuted) {
            System.out.println("Vehicle deleted Successfully.");
        } else {
            System.out.println("Vehicle Not Found with the ID " + id);
        }
    }

        public static void updateVehicle(Connection con, Integer id,String category, String name,Integer year,float price,Integer quantity) {
        System.out.print("1.Customer\nVehicle\n3.Employ\n4.Sales\nWhat do you want to update : ");

        String cmd = "update vehicles set v_category = '" + category + "' ,v_name = '"+name+"',v_year = '"+year+"',v_price = '"+price+"',v_quantityinstock = '"+quantity+"' where v_id = '" + id + "' ";
        boolean queryEx = runQuery(con, cmd);
        if (queryEx) {
            System.out.println("Vehicle Updated");

        } else {
            System.out.println("Invalid ID!");
        }

    }

    public static void updateCustomer(Connection con, Integer id, String name, String phone) {
        String cmd = "update customers set c_name = '" + name + "',c_phone  = '" + phone + "' where c_id = '" + id + "'";
        boolean execute = runQuery(con, cmd);
        if (execute) {
            System.out.println("Customer Updated!");
        } else {
            System.out.println("Invalid ID!");
        }
    }
    public static void updateEmploy(Connection con,Integer id,String name ,String phone ,String position){
        String cmd = "update employs set em_name = '" + name + "',em_phone  = '" + phone + "',em_position = '"+position+"' where em_id = '" + id + "'";
        boolean execute = runQuery(con, cmd);
        if (execute) {
            System.out.println("Employ Updated!");
        } else {
            System.out.println("Invalid ID!");
        }
    }
    public static void updateSales(Connection con, Integer id,Integer em_id,Integer c_id,Integer v_id,Integer quantitySold, String saleDate,float totalAmount) {
        String cmd = "update sales set em_id = '" + em_id + "' ,c_id = '" + c_id + "',v_id = '" + v_id + "',quantitysold = '" + quantitySold + "',saledate = '" + saleDate + "',totalamount = '" + totalAmount + "' where s_id = '" + id + "' ";
        boolean execute = runQuery(con, cmd);
        if (execute) {
            System.out.println("Sale Updated!");
        } else {
            System.out.println("Invalid ID!");
        }
    }

    public static void insertIntoCustomers(Connection con, String name, String phone) {
        String cmd = "insert into customers (c_name , c_phone) values ('" + name + "','" + phone + "')";
        boolean execute = runQuery(con, cmd);
        if (execute) {
            System.out.println("Customers Added!");
        } else System.out.println("Not found!");

    }

    public static void displayVehicles(Connection con) {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from vehicles");
            while (rs.next()) {
                System.out.print("ID : " + rs.getInt(1) + "    ");
                System.out.print("Category : " + rs.getString(2) + "    ");
                System.out.print("Name : " + rs.getString(3) + "    ");
                System.out.print("Year : " + rs.getInt(4) + "    ");
                System.out.print("Price : " + rs.getFloat(5) + "    ");
                System.out.print("Available Pieces : " + rs.getInt(6) + "    ");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void displayEmploys(Connection con) {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from employs");
            while (rs.next()) {
                System.out.print("ID : " + rs.getInt(1) + "    ");
                System.out.print("Name : " + rs.getString(2) + "    ");
                System.out.print("Phone : " + rs.getString(3) + "    ");
                System.out.print("Position : " + rs.getString(4) + "    ");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void displaySales(Connection con) {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from sales");
            while (rs.next()) {
                System.out.print("ID : " + rs.getInt(1) + "    ");
                System.out.print("Employ ID  : " + rs.getInt(2) + "    ");
                System.out.print("Customer ID : " + rs.getInt(3) + "    ");
                System.out.print("Vehicle ID : " + rs.getInt(4) + "    ");
                System.out.print("Quantity Sold : " + rs.getInt(5) + "    ");
                System.out.print("Sale Date : " + rs.getString(6) + "    ");
                System.out.print("Total Amount : " + rs.getFloat(7) + "    ");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void addSale(Connection con, Integer em_id, Integer c_id, Integer v_id, Integer quantitySold, String saleDate, float totalAmount) {
        String cmd = "insert into sales (em_id,_id,v_id,quantitysold,saledate,totalamount) values('" + em_id + "','" + c_id + "','" + v_id + "','" + quantitySold + "','" + saleDate + "','" + totalAmount + "')";
        boolean execute = runQuery(con, cmd);
        if (execute) {
            System.out.println("Sales Added!");
        } else {
            System.out.println("Invalid Entry!");
        }
    }

    public static void addVehicles(Connection con, String category, String name, Integer year, float price, Integer quantityInStock) {
        String cmd = "insert into vehicles (v_category,v_name,v_year,v_price,v_quantityinstock) values ('" + category + "','" + name + "', '" + year + "','" + price + "','" + quantityInStock + "')";
        boolean execute = runQuery(con, cmd);
        if (execute) {
            System.out.println("Vehicles Added.");
        } else {
            System.out.println("Invalid Entry!");
        }

    }

    public static void addEmploy(Connection con, String name, String phone, String postion) {
        String cmd = "insert into employs (em_name,em_phone,em_position) values '" + name + "','" + phone + "','" + postion + "'";
        boolean execute = runQuery(con, cmd);
        if (execute) {
            System.out.println("Employs Added!");
        } else {
            System.out.println("Invalid Entry");
        }
    }
    public static void deleteCustomer(Connection con,Integer id){
        String cmd = "delete from customers where c_id = '"+id+"'";
        boolean execute = runQuery(con, cmd);
        if (execute) {
            System.out.println("Customer Deleted!");
        } else {
            System.out.println("Invalid Entry");
        }

    }
    public static void deleteSale(Connection con,Integer id){
        String cmd = "delete from sales where s_id = '"+id+"'";
        boolean execute = runQuery(con, cmd);
        if (execute) {
            System.out.println("Sale Deleted!");
        } else {
            System.out.println("Invalid Entry");
        }

    }
    public static void deleteEmploy(Connection con,Integer id){
        String cmd = "delete from employs where em_id = '"+id+"'";
        boolean execute = runQuery(con, cmd);
        if (execute) {
            System.out.println("Employ Fired!");
        } else {
            System.out.println("Invalid Entry");
        }

    }
}
