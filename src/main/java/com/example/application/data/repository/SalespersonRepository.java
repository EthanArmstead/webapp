package com.example.application.data.repository;

import com.example.application.data.entity.Salesperson;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SalespersonRepository extends JpaRepository<Salesperson, UUID> {

	@Query("select c from Salesperson c " +
		      "where lower(c.firstName) like lower(concat('%', :searchTerm, '%')) " +
		      "or lower(c.lastName) like lower(concat('%', :searchTerm, '%'))") 
		    List<Salesperson> search(@Param("searchTerm") String searchTerm);

}