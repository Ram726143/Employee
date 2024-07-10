package com.Employee.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Entity.Employee;
import com.Employee.Service.EmployeeService;






@RestController
public class EmployeeController {
	@Autowired
	EmployeeService es;
	@PostMapping (value="/PostEmp")
	public String postemp(@RequestBody Employee e) {
		return es.postemp(e);
	}
	
	@PostMapping (value="/PostEmpAll")
	public String postAll(@RequestBody List<Employee> e) {
		return es.postAll(e);
	}
	
	@GetMapping (value="/GetFindByEmpId/{e}")
	public Optional<Employee> getId(@PathVariable int e) {
		return es.getId(e);
	}
	
	@GetMapping(value="/getEmployee")
	public List<Employee> getemp() {
		return es.getemp();
	}
	
	@DeleteMapping (value="/DeleteIdVal/{s}")
	public String DeleteId(@PathVariable int s) {
		return es.DeleteId(s);
	}
	
	@PutMapping (value="/PutEmpVal/{c}")
	public String PutVal(@PathVariable int c,@RequestBody Employee e) {
		return es.PutVal(c,e);
	}
	
	@GetMapping(value="/getFemaleEmployee")
	public List<Employee> getFemale() {
		return es.getFemale();
	}

	@GetMapping(value="/getIdEmployee/{c}")
	public List<String> getName(@PathVariable int c) {
		return es.getName(c);
	}
	
	@GetMapping(value="/getIdEmployeeMax")
	public Integer getMax() {
		return es.getMax();
	}
	
	@GetMapping(value="/getIdEmployeeMin")
	public Integer getMin() {
		return es.getMin();
	}
	
	@GetMapping(value="/getEmployeeAssend")
	public List<String> getAssen() {
		return es.getAssen();
	}
	
	@GetMapping(value="/getEmployeeAsDetails")
	public List<Employee> getAs() {
		return es.getAs();
	}
	
	@GetMapping(value="/getEmployeeAsDetailsMidel/{c}/{d}")
	public List<Employee> getMidel(@PathVariable int c,@PathVariable int d) {
		return es.getMidel(c,d);
	}
	
	@GetMapping(value="/getEmployeeDetails/{c}")
	public List<Employee> getthis(@PathVariable String c) {
		return es.getthis(c);
	}
	@GetMapping(value="/getEmployeeDetailsFemale")
	public List<Employee> getFemaled() {
		return es.getFemaled();
	}
	
	@GetMapping(value="/getnewval") 
	public Employee postAll() {
		return es.postAll();
	}
}
