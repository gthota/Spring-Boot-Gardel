package com.spring.app.repository.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mongodb.WriteResult;
import com.spring.app.pojo.Employee;

@Service
public class EmployeeRepositoryImp {

	@Autowired(required = true)
	MongoTemplate mongoTemplate;

	/**
	 * Get all trees.
	 */
	public List<Employee> getAllEmployees() {
		return mongoTemplate.findAll(Employee.class);
	}

	/**
	 * Saves a {@link Employee}.
	 */
	public String saveEmployee(Employee employee) {

		String saveStatus = "false";
		try {

			mongoTemplate.insert(employee);
			saveStatus = "true";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveStatus;
	}

	/**
	 * Gets a {@link Employee} for a particular id.
	 */
	public Employee getEmployee(String employeeId) {

		Employee employee = null;

		try {
						
			employee = mongoTemplate.findOne(new Query(Criteria.where("employeeId").is(Integer.parseInt(employeeId))), Employee.class);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employee;

	}

	/**
	 * The method will hit into the DB and check the details with the input
	 * parameters
	 */
	public Employee getEmployeeByEmail(String emailId, String password) {

		Employee employee = null;

		try {
		
			employee = mongoTemplate.findOne(new Query(Criteria.where("emailId").is(emailId)), Employee.class);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employee;
	}

	/**
	 * Delete a {@link Employee} for a particular id.
	 */

	public String deleteEmployee(String employeeId) {

		String deleteStaus = "false";

		try {
			mongoTemplate.remove(new Query(Criteria.where("employeeId").is(Integer.parseInt(employeeId))), Employee.class);

			deleteStaus = "true";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return deleteStaus;

	}

}
