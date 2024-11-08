package com.example.demo.vaccineCenter.ResponseDtos;

import java.util.List;

import com.example.demo.vaccineCenter.Entity.VaccineCenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitizensVaccineCenterResponse {
	private VaccineCenter vaccineCenter;
	private List<Citizen> citizens;

}
