package com.example.logger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.logger.dto.OrderResponse;
import com.example.logger.entity.User;

public interface RegistrationRepository extends JpaRepository<User,Integer>{

	public User findByEmailId(String emailId);

	public User findByEmailIdAndPassword(String emailId, String password);

	@Query("SELECT new com.example.logger.dto.OrderResponse(c.emailId, p.productName) FROM User c JOIN c.products p")
	public List<OrderResponse> getJoinInformation();
}
