/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dto.AccountTypeDto;
import com.sg.cardealership.dto.ContactInformationDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cna
 */
public class ContactInformationDaoImpl implements ContactInformationDao{
    @Autowired
    JdbcTemplate jdbc;
    
    public static final class ContactInformationMapper implements RowMapper<ContactInformationDto> {

        @Override
        public ContactInformationDto mapRow(ResultSet rs, int index) throws SQLException {
            ContactInformationDto Contact = new ContactInformationDto();
            Contact.setId(rs.getInt("id"));
            Contact.setFirstName(rs.getString("firstName"));
            Contact.setLastName(rs.getString("lastName"));
            Contact.setMessage(rs.getString("message"));
            Contact.setEmail(rs.getString("email"));
            Contact.setPhone(rs.getInt("phone"));
            return Contact;
        }
    }    
}
    @Override
        public List<ContactInformation> getAllInformations() {
            final String SELECT_ALL_CONTACTINFORMATIONS = "SELECT * FROM employee";
            return jdbc.query(SELECT_ALL_EMPLOYEES, new EmployeeMapper());
        }

        @Override
        public ContactInformation getEmployeeById(int id) {
            try {
                final String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE id = ?";
                return jdbc.queryForObject(SELECT_EMPLOYEE_BY_ID, new EmployeeMapper(), id);
            } catch(DataAccessException ex) {
                return null;
            }
        }

        @Override
        @Transactional
        public ContactInformation addEmployee(ContactInformation employee) {
            final String INSERT_EMPLOYEE = "INSERT INTO employee(firstName, lastName) "
                    + "VALUES(?,?)";
            jdbc.update(INSERT_EMPLOYEE, 
                    employee.getFirstName(),
                    employee.getLastName());
            int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
            employee.setId(newId);
            return employee;
        }

        @Override
        public void updateEmployee(ContactInformation employee) {
            final String UPDATE_EMPLOYEE = "UPDATE employee SET firstName = ?, lastName = ? "
                    + "WHERE id = ?";
            jdbc.update(UPDATE_EMPLOYEE,
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getId());
        }

        @Override
        @Transactional
        public void deleteEmployeeById(int id) {
            final String DELETE_MEETING_EMPLOYEE = "DELETE FROM meeting_employee "
                    + "WHERE employeeId = ?";
            jdbc.update(DELETE_MEETING_EMPLOYEE, id);

            final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE id = ?";
            jdbc.update(DELETE_EMPLOYEE, id);
        }      
    }