package com.example.logger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.logger.dto.OrderRequest;
import com.example.logger.dto.OrderResponse;
import com.example.logger.entity.User;
import com.example.logger.repository.CrudRepository;
import com.example.logger.repository.RegistrationRepository;
import com.example.logger.service.RegistrationService;


@RestController
@RequestMapping("/")
public class LoggerController {
	
	@Autowired
	private RegistrationService service;
	
	@Autowired
	private RegistrationRepository repo;
	
	@Autowired
	private CrudRepository productRepository;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins="http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		
		//checking whether credentials are already present in db before saving
		
		//Steps:
		//retrieved emailid from user - user.getEmailId()
		// if emailId is not null or not empty called the method of service which checks this id is already there or nor
		//to check this i have created a method in service - fetchByEmailId
		//inside this fetchByEmailId - called repo method - findByEmailId and declared that in repository
		//I can also call this method directly from repo also but using service to pass is good practise, service acts as mediator
		
		//then id user present - it throws error as exception
		//else saves data to db
		
		
		String tempEmailId = user.getEmailId(); 
		if(tempEmailId !=null && "".equals(tempEmailId)) { 
		 User userobj = service.fecthUserByEmailId(tempEmailId);
		 if(userobj !=null) {
			 throw new Exception("User with this is is already existing");
		 }
		 }
			
		//saving data to db
			
		User userObj = null;
		
		userObj = service.saveUser(user);
		
		return userObj;
		
	}
	
	
	@PostMapping("/login")
	@CrossOrigin(origins="http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String tempPass = user.getPassword();
		
		User userObj = null;
		
		if(tempEmailId != null && tempPass != null) {
			userObj = service.fecthUserByEmailIdAndPassword(tempEmailId, tempPass);
			
		}
		
		if(userObj == null) {
			throw new Exception("Bad Creddentials");
		}
		
		return userObj;
	}
	
	@PostMapping("/createOrder")
	public User createOrder(@RequestBody OrderRequest request) {
		return repo.save(request.getUser());
	}
	
	@GetMapping("/ListAllOrders")
	public List<User> listAllOrders(){
		return repo.findAll();
	}
	
	@GetMapping("/ViewOrders")
	public List<OrderResponse> getJoinInformation(){
		return repo.getJoinInformation();
	}

}
