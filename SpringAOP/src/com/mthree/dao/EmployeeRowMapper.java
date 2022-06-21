package com.mthree.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mthree.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

         //framework automatically loops or get called depending on list
         @Override
         public Employee mapRow(ResultSet rs, int rowNumber) throws SQLException {
                 System.out.println("Inside map row" + rowNumber);
                 int id = rs.getInt("id");
                 String fname = rs.getString("fname");
                 String lname = rs.getString("lname");
                 Employee e = new Employee(id, fname, lname);
                 return e;
          
         }

}
