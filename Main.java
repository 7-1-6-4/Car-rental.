import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 class Car{
    String model;
    String make;
    int id;
    double rentalRate;
    boolean isAvailable;
    public Car(String model, String make, int Id, double rentalRate, boolean isAvailable){
        this.model = model;
        this.make = make;
        this.id = id;
        this.rentalRate = rentalRate;
        this.isAvailable = isAvailable;
    }
    public void displayInfo() {
        System.out.println("Make: " + make);
        System.out.println("Model " + model);
        System.out.println("Id: " + id);
        System.out.println("Rental Rate: " + rentalRate);
        System.out.println("Available: " + isAvailable);
       }
       public boolean rentCar(){
        if(isAvailable){
            isAvailable = false;
            return true;
        }
        return false;
       }
       public void returnCar(){
        isAvailable = true;
       }
       public String getModel(){
        return model;
       }
       public void setModel(String model){
         this.model = model;
       }
       public String getMake(){
        return make;
       }
       public void setMake(String make){
        this.make = make;
       }
       public int getId(){
        return id;
       }
       public void setId(int Id){
        this.id = id;
       }
       public double getRentalRate(){
        return rentalRate;
       }
       public void setRental_Rate(double rentalRate){
        this.rentalRate = rentalRate;
       }
       public boolean Is_Available(){
        return isAvailable;
       }
       public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
       }
       @Override
       public String toString(){
        return "Car{" +
                "model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", id=" + id +
                ", rentalRate=" + rentalRate +
                ", isAvailable=" + isAvailable +
                '}';
       }
}
 class Customer{
    String Name;
    String Customer_Id;
    String Address;
    public Customer(String Name, String Customer_Id, String Address){
        this.Name = Name;
        this.Customer_Id = Customer_Id;
        this.Address = Address;
    }
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public String getCustomer_Id(){
        return Customer_Id;
    }
    public void setCustomer_Id(String Customer_Id){
        this.Customer_Id = Customer_Id;
    }
    public String getAddress(){
        return Address;
    }
    public void setAddress(String Address){
        this.Address = Address;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + Name + '\'' +
                ", customerId='" + Customer_Id + '\'' +
                ", address='" + Address + '\'' +
                '}';
    }
}
 class Rental_Agency{
List<Car> cars;
List<Customer> customers;
List<String> rentalTransactions;
public Rental_Agency(){
    cars = new ArrayList<>();
    customers = new ArrayList<>();
    rentalTransactions = new ArrayList<>();
    loadSampleData();
}
public void loadSampleData(){
    cars.add(new Car("Mercedes", "C200", 202, 100.00, true));
    cars.add(new Car("Rolls Royce",  "Phantom Ghost",  0010,  150.00, true));
    cars.add(new Car("Lamborghini", "Urus", 1010, 200.00, true));
    cars.add(new Car("Bugatti", "Chiron", 201, 250.00, true));
}
public void addCustomer(Customer customer){
    customers.add(customer);
}
public void rentCar(String Customer_Id, int id){
    Car car = findCarById(id);
    if (car !=null && car.Is_Available()) {
       car.rentCar();
       rentalTransactions.add("Customer" + Customer_Id + "rented car" + id);
       System.out.println("Car rented successfully. ");
    }else{
        System.out.println("Car is not available.");
    }
}
public void returnCar(int id) {
    Car car = findCarById(id);
    if (car != null && car.Is_Available()) {
        car.returnCar();
        rentalTransactions.add("Car " + id + " returned.");
        System.out.println("Car returned successfully.");
    } else {
        System.out.println("Car is not rented.");
    }
}
private Car findCarById(int id) {
   for (Car car : cars){
    if (car.getId() == id){
        return car;
    }
   }
   return null;
}
public void printCars() {
    for (Car car : cars) {
        System.out.println(car);
    }
}
public void printCustomers() {
    for (Customer customer : customers) {
        System.out.println(customer);
    }
}
public void printTransactions() {
    for (String transaction : rentalTransactions) {
        System.out.println(transaction);
    }
}
}
public class Main{
    public static void main(String[] args) {
        Rental_Agency agency = new Rental_Agency();
        Scanner scanner = new Scanner(System.in); 
        while (true) {
            System.out.println("\n*******************Crissy's rental system*******************");
            System.out.println("1. Add customer: ");
            System.out.println("2. Rent car: ");
            System.out.println("3. Return car: ");
            System.out.println("4. Print car: ");
            System.out.println("5. Print customer: ");
            System.out.println("6. Print transactions: ");
            System.out.println("7. Exit: ");
            System.out.println("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer ID: ");
                    String id = scanner.nextLine();
                    System.out.println("Enter customer address: ");
                    String Address = scanner.nextLine();
                    agency.addCustomer(new Customer(name, id, Address));
                    break;
                case 2:
                    System.out.print("Enter customer ID: ");
                    String Customer_Id = scanner.nextLine();
                    System.out.print("Enter car id: ");
                    int Id = scanner.nextInt();
                    agency.rentCar(Customer_Id, Id);
                    break;
                case 3:
                    System.out.println("Enter the car id: ");
                    int returnCarId = scanner.nextInt();
                    agency.returnCar(returnCarId);
                    break;
                case 4:
                    agency.printCars();
                    break;
                case 5:
                agency.printCustomers();
                break;
                case 6:
                agency.printTransactions();
                case 7:
                System.out.println("Exting system");
                scanner.close();
                return;
                default:
                System.out.println("Invalid choice: ");
                    break;
            }
        }
    }
}