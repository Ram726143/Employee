package com.Employee.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.Employee.Dao.EmployeeDao;
import com.Employee.Entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao ed;
	public String postemp(@RequestBody Employee e) {
		return ed.postepm(e);
	}
	
	public String postAll(@RequestBody List<Employee> e) {
		return ed.postAll(e);
	}
	
	public Optional<Employee> getId(@PathVariable int e) {
		return ed.getId(e);
	}
	
	public List<Employee> getemp() {
		return ed.getemp();
	}
	public String DeleteId(@PathVariable int s) {
		return ed.DeleteId(s);
	}
	
	public String PutVal(int c,Employee e) {
		return ed.PutVal(c,e);
	}
	
	public List<Employee> getFemale() {
		List<Employee> x=ed.getemp();
		List<Employee> flist=x.stream().filter(y-> y.getGender().equals("Female")).collect(Collectors.toList());
		return flist;
	}
	
	public List<String> getName(int c) {
		List<Employee> x=ed.getemp();
		List<String> idval=x.stream().filter(y->y.getId()==c).map(z->z.getName()).collect(Collectors.toList());
		return idval;
	}
	
	public Integer getMax() {
		List<Employee> x=ed.getemp();
		Integer max=x.stream().map(y-> y.getSalary()).max(Comparable::compareTo).get();
		return max;
	}

	public Integer getMin() {
		List<Employee> x=ed.getemp();
		Integer min=x.stream().map(y-> y.getSalary()).min(Comparable::compareTo).get();
		return min;
	}
	
	public List<String> getAssen() {
		List<Employee> x=ed.getemp();
		List<String> assend=x.stream().map(y->y.getName()).sorted().collect(Collectors.toList());
		return assend;
	}
	
	public List<Employee> getAs() {
		List<Employee> x=ed.getemp();
		List<Employee> as=x.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).collect(Collectors.toList());
		return as;
	}
	
	public List<Employee> getMidel(int c,int d) {
		List<Employee> x=ed.getemp();
		List<Employee> ass=x.stream().filter(y->y.getSalary()<c && y.getSalary()>d).collect(Collectors.toList());
		return ass;
	}
	
	public List<Employee> getthis(String a) {
		return ed.getthis(a);
	}
	
	public List<Employee> getFemaled() {
		return ed.getFemaled();
		}
	
	public Employee postAll() {
		List<Employee> xx =ed.getemp();
		Employee minSal = xx.stream().sorted(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Comparator.comparing(Employee::getGender).reversed())).findFirst().get();
		minSal.setSalary(minSal.getSalary()+(minSal.getSalary()*5/100));
		return minSal;
		
	}
}