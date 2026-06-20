import java.util.ArrayList;

class Employee {
    private int id;
    private String name;
    private int leaveBalance;
    private ArrayList<LeaveRequest> leaveRequests;

    public Employee(int id, String name, int leaveBalance) {
        this.id = id;
        this.name = name;
        this.leaveBalance = leaveBalance;
        this.leaveRequests = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    public void reduceLeaveBalance(int days) {
        leaveBalance -= days;
    }

    public void addLeaveRequest(LeaveRequest request) {
        leaveRequests.add(request);
    }

    public ArrayList<LeaveRequest> getLeaveRequests() {
        return leaveRequests;
    }
}