package com.example.application.data.repository;

import com.example.application.data.entity.Product;
import com.example.application.data.entity.Salesperson;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, UUID> {

	@Query("select c from Product c " +
		      "where lower(c.name) like lower(concat('%', :searchTerm, '%')) ") 
		    List<Product> search(@Param("searchTerm") String searchTerm);
	
}

