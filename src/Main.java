import java.awt.*;
import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String ch = "";
        Scanner sc = new Scanner(System.in);
        int count = 0;
        do {
            final Connection connection = DataBaseConnection.getConnection();
            if (connection != null) {
                System.out.println("Database Connected");
                System.out.println("======Showroom Management System======\n" +
                        "1. Show all customers.\n" +
                        "2. Show all vehicles.\n" +
                        "3. Show all employs.\n" +
                        "4. Show all sales.\n" +
                        "5. Add customers.\n" +
                        "6. Add vehicles.\n" +
                        "7. Add employs.\n" +
                        "8. Add Sales.\n" +
                        "9. Update.\n" +
                        "10.Delete.");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        Manipulation.displayCustomers(connection);
                        break;
                    case 2:
                        Manipulation.displayVehicles(connection);
                        break;
                    case 3:
                        Manipulation.displayEmploys(connection);
                        break;
                    case 4:
                        Manipulation.displaySales(connection);
                        break;
                    case 5:
                        System.out.print("How many customers do you want to add?  : ");
                        count = sc.nextInt();
                        for (int i = 0; i < count; i++) {
                            System.out.print("Enter the name : ");
                            String name = new Scanner(System.in).nextLine();
                            System.out.print("Enter the phone : ");
                            String phone = sc.next();
                            Manipulation.insertIntoCustomers(connection, name, phone);
                        }
                        break;
                    case 6:
                        System.out.print("How many vehicles do you want to add?  : ");
                        count = sc.nextInt();

                        for (int i = 0; i < count; i++) {
                            System.out.print("Enter the vehicle category : ");
                            String category = sc.next();
                            System.out.print("Enter the vehicle name : ");
                            String name = sc.next();
                            System.out.print("Enter the vehicle year : ");
                            Integer year = sc.nextInt();
                            System.out.print("Enter the vehicle price : ");
                            float price = sc.nextFloat();
                            System.out.print("Enter the vehicle quantityInStock : ");
                            Integer quantity = sc.nextInt();
                            Manipulation.addVehicles(connection, category, name, year, price, quantity);
                        }
                        break;
                    case 7:
                        String name = new Scanner(System.in).nextLine();
                        System.out.print("Enter the name : ");
                        String phone = sc.next();
                        System.out.print("Enter the phone : ");
                        String position = sc.next();
                        System.out.print("Enter the postion : ");
                        Manipulation.addEmploy(connection, name, phone, position);
                        break;

                    case 8:
                        System.out.print("Enter the Employ ID : ");
                        Integer em_id = sc.nextInt();
                        System.out.print("Enter the Customer ID : ");
                        Integer c_id = sc.nextInt();
                        System.out.print("Enter the Vehicle ID : ");
                        Integer v_id = sc.nextInt();
                        System.out.println("Enter the Quantity sold : ");
                        Integer quantity = sc.nextInt();
                        System.out.print("Enter the Sale Date  : ");
                        String date = sc.next();
                        System.out.print("Enter the total amount : ");
                        float price = sc.nextFloat();
                        Manipulation.addSale(connection, em_id, c_id, v_id, quantity, date, price);
                        break;
                    case 9:
                        System.out.print("1.Customer\n2.Vehicle\n3.Employ\n4.Sales\nWhat do you want to update : ");
                        choice = sc.nextInt();
                        if (choice == 1) {
                            System.out.print("Enter the ID : ");
                            Integer id = sc.nextInt();

                            //TODO Check if the customer exist in the database

                            //If yes Run below code
                            System.out.print("Enter the Name : ");
                            name = new Scanner(System.in).nextLine();
                            System.out.print("Enter the phone Number : ");
                            phone = sc.next();
                            Manipulation.updateCustomer(connection, id, name, phone);

                        } else if (choice == 2) {
                            System.out.print("Enter the ID : ");
                            Integer id = sc.nextInt();
                            System.out.print("Enter the Category : ");
                            String category = sc.next();
                            System.out.print("Enter the Name : ");
                            name = new Scanner(System.in).nextLine();
                            System.out.print("Enter the year : ");
                            Integer year = sc.nextInt();
                            System.out.print("Enter the price : ");
                            price = sc.nextFloat();
                            System.out.print("Enter the Available Quantity : ");
                            quantity = sc.nextInt();
                            Manipulation.updateVehicle(connection, id, category, name, year, price, quantity);

                        } else if (choice == 3) {
                            System.out.print("Enter the ID : ");
                            Integer id = sc.nextInt();
                            System.out.print("Enter the Name : ");
                            name = new Scanner(System.in).nextLine();
                            System.out.print("Enter the phone Number : ");
                            phone = sc.next();
                            System.out.print("Enter the Position : ");
                            position = sc.next();
                            Manipulation.updateEmploy(connection, id, name, phone, position);


                        } else if (choice == 4) {
                            System.out.print("Enter the Sales ID : ");
                            Integer id = sc.nextInt();
                            System.out.print("Enter the Employ ID : ");
                            em_id = sc.nextInt();
                            System.out.print("Enter the Customer ID : ");
                            c_id = sc.nextInt();
                            System.out.print("Enter the Vehicle ID : ");
                            v_id = sc.nextInt();
                            System.out.println("Enter the Quantity sold : ");
                            quantity = sc.nextInt();
                            System.out.print("Enter the Sale Date  : ");
                            date = sc.next();
                            System.out.print("Enter the total amount : ");
                            price = sc.nextFloat();
                            Manipulation.updateSales(connection, id, em_id, c_id, v_id, quantity, date, price);

                        } else {
                            System.out.println("Invalid Choice!");
                        }
                        break;
                    case 10:
                        System.out.print("1.Customer\n2.Vehicle\n3.Employ\n4.Sales\nWhat do you want to Delete : ");
                        choice = sc.nextInt();
                        if (choice == 1) {
                            System.out.print("Enter the ID : ");
                            Integer id = sc.nextInt();
                            Manipulation.deleteCustomer(connection, id);


                        } else if (choice == 2) {
                            System.out.print("Enter the ID : ");
                            Integer id = sc.nextInt();
                            Manipulation.deleteVehicleByID(connection, id);

                        } else if (choice == 3) {
                            System.out.print("Enter the ID : ");
                            Integer id = sc.nextInt();
                            Manipulation.deleteEmploy(connection, id);


                        } else if (choice == 4) {
                            System.out.print("Enter the Sales ID : ");
                            Integer id = sc.nextInt();
                            Manipulation.deleteSale(connection, id);

                        } else {
                            System.out.println("Invalid Choice!");
                        }
                        break;
                }


            }
            System.out.print("Want to continue? Press(y) : ");
            ch = sc.next();
        } while (ch.equalsIgnoreCase("y"));
    }
}