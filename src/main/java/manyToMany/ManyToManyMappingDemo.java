package manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ManyToManyMappingDemo {
    public static void main(String[] args) {

        Employee e1=new Employee();
        Employee e2=new Employee();
        Employee e3=new Employee();

        Project p1=new Project();
        Project p2=new Project();
        Project p3=new Project();

        e1.setEmployeeId(101);
        e1.setEmpName("Rushi");

        e2.setEmployeeId(102);
        e2.setEmpName("Yash");

        e3.setEmployeeId(103);
        e3.setEmpName("Kapil");

        p1.setProjectId(1);
        p1.setProjectName("Hospital Management System");

        p2.setProjectId(2);
        p2.setProjectName("Student Management System");

        p3.setProjectId(3);
        p3.setProjectName("AI chatBot");

        List<Employee> employeeList1=new ArrayList<>();
        List<Employee> employeeList2=new ArrayList<>();
        //List<Employee> employeeList3=new ArrayList<>();

        List<Project> projectList1=new ArrayList<>();
        List<Project> projectList2=new ArrayList<>();
        List<Project> projectList3=new ArrayList<>();


        employeeList1.add(e1);
        employeeList1.add(e2);

        employeeList2.add(e2);
        employeeList2.add(e3);



        p1.setEmployeeList(employeeList1);
        p3.setEmployeeList(employeeList2);


        projectList1.add(p1);
        projectList1.add(p2);

        projectList2.add(p2);
        projectList2.add(p3);

        projectList3.add(p3);

        e1.setProjectList(projectList1);
        e2.setProjectList(projectList2);
       // e3.setProjectList(projectList3);

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx=session.beginTransaction();

        session.persist(e1);
        session.persist(e2);
        session.persist(e3);
        session.persist(p1);
        session.persist(p2);
        session.persist(p3);



        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
