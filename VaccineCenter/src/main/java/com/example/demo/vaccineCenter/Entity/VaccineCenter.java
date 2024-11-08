package com.example.demo.vaccineCenter.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String centerName;
	private String centerAddress;
}
