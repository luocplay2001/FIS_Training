package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeDAOJdbcTest {
    @Test
    public void testGetAll() {
        IEmployeeDAO employeeDAO = new EmployeeDAOJdbc();
        List<Employee> employeeList = employeeDAO.getAll();

        System.out.println(employeeList);
    }

    @Test
    void add() {
        IEmployeeDAO employeeDAO = new EmployeeDAOJdbc();
        Employee employee = new Employee(4, "Nguyen Thanh Nhan", 103.);

        assertTrue(employeeDAO.add(employee));

        //System.out.println(employeeDAO.getAll());
    }

    @Test
    void addAll() {
        EmployeeDAOJdbc employeeDAO = new EmployeeDAOJdbc();
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(RandomGenerator.getDefault().nextLong(100)
                ,"Nguyen Thanh Nhan",RandomGenerator.getDefault().nextDouble(1000.)));

        employeeList.add(new Employee(RandomGenerator.getDefault().nextLong(100)
                ,"Nguyen Thanh",RandomGenerator.getDefault().nextDouble(1000.)));
        
        employeeDAO.addAll(employeeList);


        assertEquals(2,employeeList.size());
    }
}