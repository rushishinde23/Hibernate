package manyToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @Column(name = "project_id")
    private int projectId;

    private String projectName;

    @ManyToMany(mappedBy = "projectList")
    private List<Employee> employeeList;

    public Project() {
        super();
    }

    public Project(int projectId, String projectName, List<Employee> employeeList) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.employeeList = employeeList;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
