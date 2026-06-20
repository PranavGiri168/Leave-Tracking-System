import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class LeaveRequest {
    private Employee employee;
    private LeaveType leaveType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    public LeaveRequest(Employee employee, LeaveType leaveType,
                        LocalDate startDate, LocalDate endDate) {
        this.employee = employee;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "Pending";
    }

    public long getTotalDays() {
        return ChronoUnit.DAYS.between(startDate, endDate) + 1;
    }

    public Employee getEmployee() {
        return employee;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public String getStatus() {
        return status;
    }

    public void approve() {
        status = "Approved";
    }

    public void reject() {
        status = "Rejected";
    }

    public void cancel() {
        status = "Cancelled";
    }

    @Override
    public String toString() {
        return "Employee: " + employee.getName() +
                ", Leave Type: " + leaveType +
                ", Days: " + getTotalDays() +
                ", Status: " + status;
    }
}