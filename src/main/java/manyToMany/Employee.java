package manyToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employee_id")
    private int employeeId;

   private String empName;

   @ManyToMany
   @JoinTable(name ="employee_project")
   private List<Project> projectList;

    public Employee(int employeeId, String empName, List<Project> projectList) {
        this.employeeId = employeeId;
        this.empName = empName;
        this.projectList = projectList;
    }

    public Employee() {
        super();
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
