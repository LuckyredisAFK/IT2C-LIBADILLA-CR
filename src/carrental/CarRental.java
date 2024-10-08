package carrental;

import java.util.Scanner;


public class CarRental {
    public void addStudents(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Car Brand: ");
        String fname = sc.next();
        System.out.print("Car Model: ");
        String lname = sc.next();
        System.out.print("Car Year: ");
        String email = sc.next();
        System.out.print("Fuel Type: ");
        String status = sc.next();
        System.out.print("Condition: ");
        String condition = sc.next();
        System.out.print("Availability: ");
        String avail = sc.next();
        System.out.print("Rental Cost Perday: ");
        String rcp = sc.next();
        

        String sql = "INSERT INTO tbl_cars (c_brand, c_model, c_year, c_fueltype,c_condition, c_availability, c_rentalcostperday) VALUES (?,?, ?, ?, ?, ?,?)";


        conf.addRecord(sql,fname, lname, email, status,condition, avail,rcp);


    }
    
    private void viewCars() {
        String cqry = "SELECT * FROM tbl_cars";
        String[] votersHeaders = {"ID", "Brand", "Model", "Year", "Fuel Type", "Condition", "Availability", "Rental Cost Perday"};
        String[] votersColumns = {"c_id", "c_brand", "c_model", "c_year", "c_fueltype", "c_condition", "c_availability", "c_rentalcostperday"};
        config conf = new config();
        conf.viewRecords(cqry, votersHeaders, votersColumns);
    }
    
    private void updateCars(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Car ID ");
        int id = sc.nextInt();
        
        System.out.println("Enter the new Condition");
        String condition = sc.next();
        
        System.out.println("Enter the new availability");
        String availability = sc.next();
        
        System.out.println("Enter the new Rental Cost Perday");
        String rcp = sc.next();
        
        String qry = "UPDATE tbl_cars SET c_condition = ?, c_availability = ?, c_rentalcostperday = ? WHERE c_id = ?";
        
        config conf = new config();
        conf.updateRecord(qry, condition, availability, rcp, id);
    }
    
    private void deleteCars(){
        
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the ID to Delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM tbl_cars WHERE c_id = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);
    
    }

    
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String response;

    do {
        System.out.println("1. Add");
        System.out.println("2. View");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("5. Exit");

        System.out.println("Enter Action: ");
        int action = sc.nextInt();
        CarRental demo = new CarRental();

        switch (action) {
            case 1:              
                demo.addStudents();
                break;
            case 2:              
                demo.viewCars();
                break;
            case 3:
                demo.updateCars();
                break;
            case 4:
                demo.deleteCars();
                break;
        }

        System.out.println("Continue (yes/no): ");
        response = sc.next();
    } while (response.equals("yes"));

    System.out.println("Thank you, See you soon!");
}
}
