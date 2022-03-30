package com.example.application.data.repository;

import com.example.application.data.entity.Contact;
import com.example.application.data.entity.Sale;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SaleRepository extends JpaRepository<Sale, UUID> {
	@Query("select c from Sale c " +
		      "where lower(c.Salesperson.toString()) like lower(concat('%', :searchTerm, '%')) ") 
		    List<Sale> search(@Param("searchTerm") String searchTerm);
}
