import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

class LeaveManagementSystem {
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<LeaveRequest> requests = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee findEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    public void applyLeave(int empId, LeaveType type,
                           LocalDate start, LocalDate end) {
        Employee emp = findEmployee(empId);

        if (emp == null) {
            System.out.println("Employee not found.");
            return;
        }

        LeaveRequest request = new LeaveRequest(emp, type, start, end);

        if (emp.getLeaveBalance() >= request.getTotalDays()) {
            emp.addLeaveRequest(request);
            requests.add(request);
            System.out.println("Leave request submitted.");
        } else {
            System.out.println("Insufficient leave balance.");
        }
    }

    public void viewRequests() {
        for (LeaveRequest request : requests) {
            System.out.println(request);
        }
    }

    public void approveLeave(int index) {
        if (index >= 0 && index < requests.size()) {
            LeaveRequest request = requests.get(index);
            request.approve();
            request.getEmployee().reduceLeaveBalance((int) request.getTotalDays());
            System.out.println("Leave approved.");
        }
    }

    public void rejectLeave(int index) {
        if (index >= 0 && index < requests.size()) {
            requests.get(index).reject();
            System.out.println("Leave rejected.");
        }
    }

    public void cancelLeave(int index) {
        if (index >= 0 && index < requests.size()) {
            requests.get(index).cancel();
            System.out.println("Leave cancelled.");
        }
    }
}