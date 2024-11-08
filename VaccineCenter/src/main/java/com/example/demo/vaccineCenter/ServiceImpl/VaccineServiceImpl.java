package com.example.demo.vaccineCenter.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.vaccineCenter.Entity.VaccineCenter;
import com.example.demo.vaccineCenter.Repository.VaccineServiceJpaRepo;
import com.example.demo.vaccineCenter.Service.VaccinationService;

@Service
public class VaccineServiceImpl implements VaccinationService {

	@Autowired
	VaccineServiceJpaRepo vaccineRepo;

	@Override
	public VaccineCenter addVaccinationCenter(VaccineCenter vaccineCenter) {
		VaccineCenter center = vaccineRepo.save(vaccineCenter);
		return center;
	}
	@Override
	public VaccineCenter findbyId(Long id) {
		Optional<VaccineCenter> center = vaccineRepo.findById(id);
		if (center.isPresent()) {
			return center.get();
		} else {
			return null;
		}
	}

}
