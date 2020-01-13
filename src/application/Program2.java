package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
    
    public static void main(String[] args) {
        
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        
        System.out.println("TEST DEPARTMENST 1: department insert");
        departmentDao = DaoFactory.createDepartmentDao();
        Department newDepartment = new Department(5, "Tools");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! new id = " + newDepartment.getId());
    }
}
