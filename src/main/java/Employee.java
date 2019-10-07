import java.io.Serializable;

public class Employee implements Serializable {

    private int empId;
    private String empName;
    private String[] hobbies;
    private String dept;

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDept() {
        return dept;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }
}
