package com.example.application.data.repository;

import com.example.application.data.entity.Discount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, UUID> {

}