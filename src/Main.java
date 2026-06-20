import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LeaveManagementSystem system = new LeaveManagementSystem();

        system.addEmployee(new Employee(1, "Pranav", 20));
        system.addEmployee(new Employee(2, "Rahul", 15));

        while (true) {
            System.out.println("\n--- Leave Tracking System ---");
            System.out.println("1. Apply Leave");
            System.out.println("2. View Requests");
            System.out.println("3. Approve Leave");
            System.out.println("4. Reject Leave");
            System.out.println("5. Cancel Leave");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int empId = sc.nextInt();

                    System.out.println("Leave Type: 1.SICK 2.CASUAL 3.VACATION");
                    int typeChoice = sc.nextInt();

                    LeaveType type = switch (typeChoice) {
                        case 1 -> LeaveType.sick;
                        case 2 -> LeaveType.casual;
                        default -> LeaveType.vacation;
                    };

                    System.out.print("Start Date (YYYY-MM-DD): ");
                    LocalDate start = LocalDate.parse(sc.next());

                    System.out.print("End Date (YYYY-MM-DD): ");
                    LocalDate end = LocalDate.parse(sc.next());

                    system.applyLeave(empId, type, start, end);
                    break;

                case 2:
                    system.viewRequests();
                    break;

                case 3:
                    System.out.print("Enter request index: ");
                    system.approveLeave(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter request index: ");
                    system.rejectLeave(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter request index: ");
                    system.cancelLeave(sc.nextInt());
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}