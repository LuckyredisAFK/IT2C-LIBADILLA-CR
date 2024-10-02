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

        switch (action) {
            case 1:
                CarRental demo = new CarRental();
                demo.addStudents();
                break;
        }

        System.out.println("Continue (yes/no): ");
        response = sc.next();
    } while (response.equals("yes"));

    System.out.println("Thank you, See you soon!");
}
}
