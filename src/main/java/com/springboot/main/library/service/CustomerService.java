package com.springboot.main.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.main.library.exception.InvalidIdException;
import com.springboot.main.library.model.Customer;
import com.springboot.main.library.repository.CustomerRepository;
@Service
public class CustomerService {
	@Autowired
	private CustomerRepository studentRepository;

	public Customer insert(Customer student) {
		
		return studentRepository.save(student);
	}
	public  Customer getOne(int id) throws InvalidIdException {
		Optional<Customer> optional=studentRepository.findById(id);
		if(!optional.isPresent()){
			throw new InvalidIdException("Student ID Invalid");
		}
		return optional.get();
	}
	

	public List<Customer> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return studentRepository.findAll(pageable).getContent();
	}

	public void deleteStudent(Customer student) {
		studentRepository.delete(student);
	}

	public Customer postStudent(Customer student) {
		
		return studentRepository.save(student);
	}
	public Customer getStudent(int sid) throws InvalidIdException {
		Optional<Customer> optional = studentRepository.findById(sid);
		if (!optional.isPresent()) {
			throw new InvalidIdException("Student Id invalid");
		}
		return optional.get();

	}
		
}