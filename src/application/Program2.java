package application;

import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        
        System.out.println("TEST DEPARTMENT 1: department insert");
        Department newDepartment = new Department(null, "Tools");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! new id = " + newDepartment.getId());
        
        System.out.println("TEST DEPARTMENT 2: department update");
        newDepartment = departmentDao.findById(5);
        newDepartment.setName("Civil");
        departmentDao.update(newDepartment);
        System.out.println("Update Completed");
        
        System.out.println("TEST DEPARTMENT 3: department deleteById");
        System.out.print("Number: ");
        int a = sc.nextInt();
        departmentDao.deleteById(a);
        System.out.println("Deleted Completed");
        
        System.out.println("TEST DEPARTMENT 4: department findById");
        System.out.print("ID: ");
        a = sc.nextInt();
        newDepartment = departmentDao.findById(a);
        System.out.println("Department: " + newDepartment.getName());
        
        System.out.println("TEST DEPARTMENT 4: department findById");
        List <Department> dep = departmentDao.findAll();
        dep.forEach((d) -> {
            System.out.println(d);
        });
        
    }
}
