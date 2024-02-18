/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Mengleap Mol
 */
public class Employee {

    private int id;
    private String name;
    private String gender;
    private int startTime;
    private int endTime;
    private String position;
    private String day;
    private String shift;

    private Employee() {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.startTime = startTime;
        this.endTime = endTime;
        this.position = position;
        this.day = day;
        this.shift = shift;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public String getPosition() {
        return position;
    }

    public String getDay() {
        return day;
    }

    public String getShift() {
        return shift;
    }

    // Setter methods
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public void Input() {
        String shiftChoice;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID         : ");
        id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name       : ");
        name = sc.nextLine();
        System.out.print("Enter Gender     : ");
        gender = sc.next();
        System.out.print("\nStart time: 7:00AM - 5:00PM FULL-TIME");
        System.out.print("\nStart time : 07:00AM - 11:00AM PART-TIME AM");
        System.out.print("\nStart time : 1:00PM - 5:00PM PART-TIME PM");
        sc.nextLine();
        System.out.print("\nEnter Start Time : ");
        startTime = sc.nextInt();
        System.out.print("Enter End Time   : ");
        endTime = sc.nextInt();
        System.out.print("Enter Position   : ");
        position = sc.next();
        System.out.print("Enter Day        : ");
        day = sc.next();
        sc.nextLine();
do {
    System.out.print("Enter Shift (full-time, AM, PM): ");
    shiftChoice = sc.nextLine().toLowerCase();

    switch (shiftChoice) {
        case "full-time":
            shift = "Full-Time";
            break;
        case "am":
            shift = "AM";
            break;
        case "pm":
            shift = "PM";
            break;
        default:
            System.out.println("Invalid shift choice. Please enter 'full-time', 'am', or 'pm'.");
    }
}while(!shiftChoice.equals("full-time") && !shiftChoice.equals("am") && !shiftChoice.equals("pm"));
        
}

    public static void printHeader() {
        System.out.println("\n+========+===========+=========+=========+========+===================================+");
        System.out.println("| ID    | Name      | Gender  | Day   | Start    | End     | POSITION | SHIFT           |");
        System.out.println("|========+===========+=========+=========+========+=====================================+");
    }

    public void Output() {
        System.out.printf("| %-6d | %-10s | %-7s | %-5s | %-5d | %-7d |%-6s | %-7s | %n", id, name, gender, day, startTime, endTime, position, shift);
    }

    public static void Shift(){
        System.out.println("                      SHIFT EMPLOYEE                        ");
        System.out.println(" ");
        System.out.println("                      MONDAY TO SUNDAY                      ");
        System.out.println(" ");
        System.out.println("        MON-SUN     07:00 - 05:00 AM-PM     FULL-TIME       ");
        System.out.println("        MON-SUN     07:00 - 11:00 AM        PART-TIME AM       ");
        System.out.println("        MON-SUN     01:00 - 05:00 PM        PART-TIME PM      ");
        System.out.println("  ");
    }

    public static void main(String[] args) {
        ArrayList<Employee> emp = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Employee.Shift();
        int i, n = 0, choice;

        do {
            System.out.println("\n---Employee Management System---");
            System.out.println("[1]  ADD Employees");
            System.out.println("[2]  Display Employees");
            System.out.println("[3]  SEARCH Employees Information");
            System.out.println("[4]  UPDATE Employees Infomation");
            System.out.println("[5]  DELETE Employees Infomation");
            System.out.println("[6]  Exit");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Number of Employee to add : ");
                    n = sc.nextInt();
                    for (i = 0; i < n; i++) {
                        System.out.println("-----Employees #" + (i + 1) + "-----");
                        Employee obj = new Employee();
                        obj.Input();
                        emp.add(obj);
                    }
                }
                case 2 -> {
                    if (emp.isEmpty()) {
                        System.err.println("Employees not found !");
                    } else {
                        Employee.printHeader();
                        for (i = 0; i < emp.size(); i++) {
                            Employee obj = emp.get(i);
                            obj.Output();
                        }
                    }
                }
                case 3 -> {
                    boolean found = false;
                    System.out.print("Enter ID to search (0 to exit): ");
                    int searchId = sc.nextInt();
                    if (searchId == 0) {
                        break;
                    }
                    for (i = 0; i < emp.size(); i++) {
                        Employee obj = emp.get(i);
                        if (obj.getId() == searchId) {
                            found = true;
                            System.out.println("Employee found:");
                            Employee.printHeader();
                            obj.Output();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Employee with ID " + searchId + " not found.");
                    }
                }
                case 4 -> {
                    int idToUpdate = 0;
                    boolean found = false; // Use boolean for clarity
                    System.out.print("Enter employee ID to update: ");
                    idToUpdate = sc.nextInt();
                    for (Employee employee : emp) { // Enhanced for loop for ArrayList
                        if (employee.getId() == idToUpdate) {
                            found = true;
                            System.out.print("Enter new name (or press Enter to keep the existing name): ");
                            sc.nextLine();
                            String newName = sc.nextLine().trim();

                            if (!newName.isEmpty()) {
                                employee.setName(newName);
                            }
                            System.out.println("Employee details updated successfully.");
                            break;
                        }
                    }
                    if (!found) { // Handle employee not found
                        System.out.println("Employee with ID " + idToUpdate + " not found.");
                    }
                    break;
                }
                case 5 -> {
                    int idToDelete;
                    boolean found = false;
                    System.out.print("Enter employee ID to delete: ");
                    idToDelete = sc.nextInt();
                    Iterator<Employee> it = emp.iterator();
                    while (it.hasNext()) {
                        Employee employee = it.next();
                        if (employee.getId() == idToDelete) {
                            it.remove(); // Remove the matching employee from the ArrayList
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        System.out.println("Employee deleted successfully.");
                    } else {
                        System.out.println("Employee with ID " + idToDelete + " not found.");
                    }
                }
                case 6 -> {
                    System.out.println("Exiting the system.");
                    break;
                }
            }
        } while (choice != 6);
    }
}
