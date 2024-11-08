package com.example.demo.vaccineService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.vaccineCenter.Entity.VaccineCenter;
import com.example.demo.vaccineCenter.ResponseDtos.Citizen;
import com.example.demo.vaccineCenter.ResponseDtos.CitizensVaccineCenterResponse;
import com.example.demo.vaccineCenter.Service.VaccinationService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/vaccine")
public class VaccinationCentersController {

	@Autowired
	private VaccinationService vaccinationService;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/addcenter")
	public ResponseEntity<VaccineCenter> addVaccinecenter(@RequestBody VaccineCenter vaccineCenter) {
		VaccineCenter vaccineCenters = vaccinationService.addVaccinationCenter(vaccineCenter);
		String abc = vaccineCenter.getCenterAddress();

		return new ResponseEntity<VaccineCenter>(vaccineCenters, HttpStatus.CREATED);
	}

	@GetMapping("/id/{id}")
	@HystrixCommand(fallbackMethod = "handleCitizenDowntime")
	public ResponseEntity<CitizensVaccineCenterResponse> getAllDatabyCenterId(@PathVariable Long id) {
		CitizensVaccineCenterResponse response = new CitizensVaccineCenterResponse();

		/**
		 * step 1:get vaccine center details
		 */
		VaccineCenter center = vaccinationService.findbyId(id);
		response.setVaccineCenter(center);
		/***
		 * step 2:get citezen's based on vaccine center details
		 */
		// to connect from one service to another service we need RESTTEMPLATE

		List<Citizen> citizens = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/get/" + id, List.class);
		response.setCitizens(citizens);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	public ResponseEntity<CitizensVaccineCenterResponse> handleCitizenDowntime(@PathVariable Long id) {
		CitizensVaccineCenterResponse response = new CitizensVaccineCenterResponse();

		/**
		 * step 1:get vaccine center details
		 */
		VaccineCenter center = vaccinationService.findbyId(id);
		response.setVaccineCenter(center);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}

}
