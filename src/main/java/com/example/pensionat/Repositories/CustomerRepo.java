package com.example.pensionat.Repositories;

import com.example.pensionat.Models.customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<customers,Long> {
}
