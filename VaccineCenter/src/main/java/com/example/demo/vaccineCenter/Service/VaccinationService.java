package com.example.demo.vaccineCenter.Service;

import com.example.demo.vaccineCenter.Entity.VaccineCenter;

public interface VaccinationService {
	
	public VaccineCenter addVaccinationCenter(VaccineCenter vaccineCenter);
	public VaccineCenter findbyId(Long id);

}
