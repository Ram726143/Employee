package com.Employee.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.Employee.Entity.Employee;
import com.Employee.Repository.EmployeeRepository;



@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository er;
	public String postepm(Employee e) {
		er.save(e);
		return "Posted Successfully";
	}
	
	public String postAll(List<Employee> e) {
		er.saveAll(e);
		return "Posted in Successfully";
	}
	public Optional<Employee> getId(@PathVariable int e) {
		return er.findById(e);
	}
	
	public List<Employee> getemp() {
		return er.findAll();
	}
	
	public String DeleteId(@PathVariable int s) {
		er.deleteById(s);
		return "Deleting Successfully";
	}
	
	public String PutVal( int c,Employee e) {
		er.save(e);
		return "Updating Successfullky";
	}
	
	public List<Employee> getthis(String a) {
		return er.getthis(a);
	}
	
	public List<Employee> getFemaled() {
		return er.getFemaled();
	}
}
