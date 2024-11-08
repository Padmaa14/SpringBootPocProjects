package com.example.demo.vaccineCenter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.vaccineCenter.Entity.VaccineCenter;
import java.util.List;
import java.util.Optional;


public interface VaccineServiceJpaRepo extends JpaRepository<VaccineCenter, Long> {
	
//	public Optional<VaccineCenter> findById(Long id);

}
